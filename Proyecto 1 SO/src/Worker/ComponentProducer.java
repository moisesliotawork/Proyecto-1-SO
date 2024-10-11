/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Worker;

import Enums.WorkerTypeEnum;
import Rules.CompanyRules;
import Store.Drive;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Moises Liota
 */
public class ComponentProducer extends Worker{
    private float productionPerDay;  // Producción diaria del componente
    private float acc = 0;           // Acumulador para manejar la producción fraccionada
    private Drive drive;
    
    /**
     * Constructor del ComponentProducer que inicializa las variables base del Worker y las propias de esta clase.
     * @param type WorkerTypeEnum - Tipo de trabajo (MotherboardProducer, CPUProducer, etc.)
     * @param pp float - Producción por día del trabajador
     * @param cph float - Costo por hora de trabajo
     * @param drive Drive - Almacén donde se guardan los componentes producidos
     * @param m Semaphore - Semáforo para la exclusión mutua
     * @param companyRules CompanyRules - Reglas específicas de la compañía asociada
     */
    public ComponentProducer(WorkerTypeEnum type, float pp, float cph, Drive drive, Semaphore m, CompanyRules companyRules) {
        super(type, cph, m, companyRules);
        this.productionPerDay = pp;
        this.drive = drive;
    }

    @Override
    public void run() {
        while (hired && running) {
            try {
                Work();
                sleep(getDayDuration());  // Simula el paso de un día
            } catch (InterruptedException ex) {
                // Logger to handle exception if needed
            }
        }
    }

    @Override
    public void Work() {
        this.acc += this.productionPerDay;  // Incrementa el acumulador con la producción diaria
        this.daysWorked++;

        try {
            while (this.acc >= 1) {
                this.mutex.acquire();  // Bloquea el acceso al recurso compartido (almacén)
                
                // Agrega el producto al almacén
                this.drive.addProduct(1, type);
                
                this.acc -= 1;  // Descuenta una unidad de producción
                if (this.acc < 1) {
                    this.acc = 0;
                }
                
                this.mutex.release();  // Libera el semáforo
            }
           
            // Aplica los costos
            drive.getCostsMutex().acquire();  // Bloquea el acceso al costo total
            
            switch(this.type) {
                case MotherboardProducer -> drive.setMotherboardCost(drive.getMotherboardCost() + this.costPerHour * 24);
                case CPUProducer -> drive.setCpuCost(drive.getCpuCost() + this.costPerHour * 24);
                case RAMProducer -> drive.setRamCost(drive.getRamCost() + this.costPerHour * 24);
                case PowerSupplyProducer -> drive.setPowerSupplyCost(drive.getPowerSupplyCost() + this.costPerHour * 24);
                case GPUProducer -> drive.setGpuCost(drive.getGpuCost() + this.costPerHour * 24);
                default -> {
                }
            }
            
            drive.getCostsMutex().release();  // Libera el semáforo de costos
            
        } catch (InterruptedException ex) {
            // Logger to handle exception if needed
        }
    }

    public float getProductionPerDay() {
        return productionPerDay;
    }

    public void setProductionPerDay(float productionPerDay) {
        this.productionPerDay = productionPerDay;
    }

    public float getAcc() {
        return acc;
    }

    public void setAcc(float acc) {
        this.acc = acc;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }
    
    
}
