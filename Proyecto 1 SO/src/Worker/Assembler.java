/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Worker;

import Enums.WorkerTypeEnum;
import static Enums.WorkerTypeEnum.CPUProducer;
import static Enums.WorkerTypeEnum.GPUProducer;
import static Enums.WorkerTypeEnum.MotherboardProducer;
import static Enums.WorkerTypeEnum.PowerSupplyProducer;
import static Enums.WorkerTypeEnum.RAMProducer;
import Rules.CompanyRules;
import Store.Drive;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Moises Liota
 */
public class Assembler extends Worker {

    private final Drive drive;
    private boolean assemblingComputer;
    private int computersToComputerWithGPU;

    /**
     * Constructor del Assembler.
     *
     * @param type WorkerTypeEnum - Tipo de trabajo (Assembler)
     * @param computersToComputerWithGPU int - Cantidad de computadoras estándar
     * antes de ensamblar una con GPU
     * @param cph float - Costo por hora de trabajo
     * @param drive Drive - Almacén donde se guardan los componentes creados
     * @param m Semaphore - Semáforo
     * @param companyRules CompanyRules - Reglas específicas de la compañía
     * asociada
     */
    public Assembler(WorkerTypeEnum type, int computersToComputerWithGPU, float cph, Drive drive, Semaphore m, CompanyRules companyRules) {
        super(type, cph, m, companyRules);
        this.drive = drive;
        this.assemblingComputer = false;
        this.computersToComputerWithGPU = computersToComputerWithGPU;
    }

    @Override
    public void run() {
        while (hired && running) {
            try {
                Work();

                // Si está ensamblando una computadora espera 2 días, sino 1 día
                if (assemblingComputer) {
                    sleep(2 * getDayDuration());
                    drive.getCostsMutex().acquire();
                    drive.setAssemblerCost(drive.getAssemblerCost() + costPerHour * 48);  // Costo de 2 días
                    drive.getCostsMutex().release();
                } else {
                    sleep(getDayDuration());
                    drive.getCostsMutex().acquire();
                    drive.setAssemblerCost(drive.getAssemblerCost() + costPerHour * 24);  // Costo de 1 día
                    drive.getCostsMutex().release();
                }

                this.assemblingComputer = false;

            } catch (InterruptedException ex) {
                System.out.println("Error en Assembler: " + ex.getMessage());
            }
        }
    }

    @Override
    public void Work() {
        this.daysWorked++;
        try {
            // Asegura la exclusión mutua al trabajar con el almacén de componentes
            drive.getProducerMutex().acquire();

            // Verifica si se puede ensamblar una computadora estándar o con GPU
            boolean canAssemble = (drive.getComputersAssembledSinceLastGPU() == computersToComputerWithGPU)
                    ? companyRules.canAssembleComputerWithGPU(drive.getMotherboards(), drive.getCpus(), drive.getRamModules(), drive.getPowerSupplies(), drive.getGpus())
                    : companyRules.canAssembleStandardComputer(drive.getMotherboards(), drive.getCpus(), drive.getRamModules(), drive.getPowerSupplies());

            System.out.println("Condiciones de ensamblaje - Motherboards: " + drive.getMotherboards()
                    + ", CPUs: " + drive.getCpus()
                    + ", RAM: " + drive.getRamModules()
                    + ", Power Supplies: " + drive.getPowerSupplies()
                    + ", GPUs: " + drive.getGpus());
            System.out.println("¿Se puede ensamblar?: " + canAssemble);

            if (canAssemble) {
                // Quita los componentes del almacén necesarios para ensamblar una computadora
                drive.setMotherboards(drive.getMotherboards() - companyRules.getMotherboardsNeeded());
                drive.setCpus(drive.getCpus() - companyRules.getCpusNeeded());
                drive.setRamModules(drive.getRamModules() - companyRules.getRamModulesNeeded());
                drive.setPowerSupplies(drive.getPowerSupplies() - companyRules.getPowerSuppliesNeeded());

                // Si es el turno de ensamblar una computadora con GPU
                if (drive.getComputersAssembledSinceLastGPU() == computersToComputerWithGPU) {
                    drive.setGpus(drive.getGpus() - companyRules.getGpusNeeded()); // Usa GPUs
                    drive.setComputersWithGPU(drive.getComputersWithGPU() + 1); // Aumenta el contador de computadoras con GPU
                    drive.setComputersAssembledSinceLastGPU(0); // Reinicia el contador
                     //System.out.println("Compu con GPU");
                } else {
                    // Ensambla una computadora estándar
                    drive.setStandardComputers(drive.getStandardComputers() + 1); // Aumenta el contador de computadoras estándar
                    drive.setComputersAssembledSinceLastGPU(drive.getComputersAssembledSinceLastGPU() + 1); // Aumenta el contador para el ensamblaje de la siguiente con GPU
                }

                System.out.println("Computadora ensamblada correctamente.");
            }

            // Libera el semáforo para que otros procesos puedan acceder al almacén
            drive.getProducerMutex().release();

        } catch (InterruptedException ex) {
            System.out.println("Error en Assembler: " + ex.getMessage());
        }
    }

}
