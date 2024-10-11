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
public class WorkerFactory {

    /**
     * Metodo que instancia un Worker dependiendo del tipo.
     *
     * @param workerType WorkerTypeEnum - Tipo de Worker
     * @param drive Drive - Almacen que tendrá el Worker
     * @param mutex Semaphore - Semaforo que tendrá el Worker
     * @param companyRules - Reglas y datos de la compañía asociada al Worker
     * @return Worker - instancia de un Worker
     */
    public Worker makeWorker(WorkerTypeEnum workerType, Drive drive, Semaphore mutex, CompanyRules companyRules) {

        switch (workerType) {
            case MotherboardProducer -> {
                return new ComponentProducer(workerType, companyRules.getMotherboardProductionPerDay(), companyRules.getMotherboardCost(), drive, mutex, companyRules);
            }
            case CPUProducer -> {
                return new ComponentProducer(workerType, companyRules.getCpuProductionPerDay(), companyRules.getCpuCost(), drive, mutex, companyRules);
            }
            case RAMProducer -> {
                return new ComponentProducer(workerType, companyRules.getRamProductionPerDay(), companyRules.getRamCost(), drive, mutex, companyRules);
            }
            case PowerSupplyProducer -> {
                return new ComponentProducer(workerType, companyRules.getPowerSupplyProductionPerDay(), companyRules.getPowerSupplyCost(), drive, mutex, companyRules);
            }
            case GPUProducer -> {
                return new ComponentProducer(workerType, companyRules.getGpuProductionPerDay(), companyRules.getGpuCost(), drive, mutex, companyRules);
            }
            case Assembler -> {
                // Cambiamos getGamesToGamesDLC() por getComputersToComputersWithGPU() y getIntegratorCost() por getAssemblerCost()
                return new Assembler(workerType, companyRules.getComputersToComputersWithGPU(), companyRules.getAssemblerCost(), drive, mutex, companyRules);
            }
            case ProjectManager -> {
                return new ProjectManager(workerType, companyRules.getPmCost(), mutex, companyRules, drive);
            }
            case Director -> {
                return new Director(workerType, companyRules.getDirectorCost(), mutex, companyRules, drive);
            }
            default -> {
                return null;  // Si no se encuentra un tipo válido, retorna null
            }
        }
    }
}
