/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Store;

import Enums.WorkerTypeEnum;
import static Enums.WorkerTypeEnum.CPUProducer;
import static Enums.WorkerTypeEnum.GPUProducer;
import static Enums.WorkerTypeEnum.MotherboardProducer;
import static Enums.WorkerTypeEnum.PowerSupplyProducer;
import static Enums.WorkerTypeEnum.RAMProducer;
import java.util.concurrent.Semaphore;


/**
 *
 * @author Moises Liota
 */
public class Drive {
     // Elementos para computadoras
    private int motherboards;
    private int cpus;
    private int ramModules;
    private int powerSupplies;
    private int gpus;
    
    // Computadoras ensambladas
    private int standardComputers;
    private int computersWithGPU;
        
    // Ganancias y costos operativos
    private float utility;
    
    // Máximos de almacenamiento
    private final int maxMotherboards = 25;
    private final int maxCPUs = 20;
    private final int maxRAMModules = 55;
    private final int maxPowerSupplies = 35;
    private final int maxGPUs = 10;

    // Semáforos para la exclusión mutua
    private Semaphore producerMutex = new Semaphore(1);
    private Semaphore consumerMutex = new Semaphore(1);
    
    // Días restantes para la entrega
    private int daysUntilRelease;
    private Semaphore daysMutex = new Semaphore(1);
    
    // Estado del director: 0 = vigilando, 1 = trabajando
    private int directorStatus = 1;
    
    // Estado del PM: 0  = trabajando, 1 = viendo anime
    private int pmStatus = 0;
    private int faltas = 0;
    private int salaryDiscount = 0;
    
    // Costos de empleados
    private Semaphore costsMutex = new Semaphore(1);
    
    private float motherboardCost = 0;
    private float cpuCost = 0;
    private float ramCost = 0;
    private float powerSupplyCost = 0;
    private float gpuCost = 0;
    private float assemblerCost = 0;
    private float pmCost = 0;
    private float directorCost = 0;
    
    private float earnings = 0;
    
    
    private int computersAssembledSinceLastGPU = 0;
    
    /**
     * Constructor que inicializa los elementos para ensamblar computadoras.
     * @param motherboards int - Número de placas base
     * @param cpus int - Número de CPUs
     * @param ramModules int - Número de módulos de RAM
     * @param powerSupplies int - Número de fuentes de poder
     * @param gpus int - Número de GPUs
     */
    public Drive(int motherboards, int cpus, int ramModules, int powerSupplies, int gpus) {
        this.motherboards = motherboards;
        this.cpus = cpus;
        this.ramModules = ramModules;
        this.powerSupplies = powerSupplies;
        this.gpus = gpus;
    }
    
    /**
     * Constructor que inicializa el almacén vacío.
     */
    public Drive() {
        this.motherboards = 0;
        this.cpus = 0;
        this.ramModules = 0;
        this.powerSupplies = 0;
        this.gpus = 0;
    }
    
    /**
     * Agrega un producto al almacén, asegurándose de no superar la capacidad máxima.
     * @param productQty int - Cantidad de productos a agregar
     * @param type WorkerTypeEnum - Tipo de producto a agregar
     */
    public void addProduct(int productQty, WorkerTypeEnum type){
        switch(type) {
            case MotherboardProducer -> motherboards = Math.min(motherboards + productQty, maxMotherboards);
            case CPUProducer -> cpus = Math.min(cpus + productQty, maxCPUs);
            case RAMProducer -> ramModules = Math.min(ramModules + productQty, maxRAMModules);
            case PowerSupplyProducer -> powerSupplies = Math.min(powerSupplies + productQty, maxPowerSupplies);
            case GPUProducer -> gpus = Math.min(gpus + productQty, maxGPUs);
            default -> {
            }
        }
    }

    // Getters y Setters adaptados
    public int getMotherboards() {
        return motherboards;
    }

    public void setMotherboards(int motherboards) {
        this.motherboards = motherboards;
    }

    public int getCpus() {
        return cpus;
    }

    public void setCpus(int cpus) {
        this.cpus = cpus;
    }

    public int getRamModules() {
        return ramModules;
    }

    public void setRamModules(int ramModules) {
        this.ramModules = ramModules;
    }

    public int getPowerSupplies() {
        return powerSupplies;
    }

    public void setPowerSupplies(int powerSupplies) {
        this.powerSupplies = powerSupplies;
    }

    public int getGpus() {
        return gpus;
    }

    public void setGpus(int gpus) {
        this.gpus = gpus;
    }

    public int getMaxMotherboards() {
        return maxMotherboards;
    }

    public int getMaxCPUs() {
        return maxCPUs;
    }

    public int getMaxRAMModules() {
        return maxRAMModules;
    }

    public int getMaxPowerSupplies() {
        return maxPowerSupplies;
    }

    public int getMaxGPUs() {
        return maxGPUs;
    }

    public int getStandardComputers() {
        return standardComputers;
    }

    public void setStandardComputers(int standardComputers) {
        this.standardComputers = standardComputers;
    }
    
    public int getComputersWithGPU() {
        return computersWithGPU;
    }

    public void setComputersWithGPU(int computersWithGPU) {
        this.computersWithGPU = computersWithGPU;
    }

    public float getUtility() {
        return utility;
    }
    
    public void setUtility(float utility) {
        this.utility = utility;
    }

    public Semaphore getProducerMutex() {
        return producerMutex;
    }

    public void setProducerMutex(Semaphore producerMutex) {
        this.producerMutex = producerMutex;
    }

    public Semaphore getConsumerMutex() {
        return consumerMutex;
    }

    public void setConsumerMutex(Semaphore consumerMutex) {
        this.consumerMutex = consumerMutex;
    }

    public int getDaysUntilRelease() {
        return daysUntilRelease;
    }

    public void setDaysUntilRelease(int daysUntilRelease) {
        this.daysUntilRelease = daysUntilRelease;
    }

    public Semaphore getDaysMutex() {
        return daysMutex;
    }

    public void setDaysMutex(Semaphore daysMutex) {
        this.daysMutex = daysMutex;
    }

    public int getDirectorStatus() {
        return directorStatus;
    }

    public void setDirectorStatus(int directorStatus) {
        this.directorStatus = directorStatus;
    }

    public int getPmStatus() {
        return pmStatus;
    }

    public void setPmStatus(int pmStatus) {
        this.pmStatus = pmStatus;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public int getSalaryDiscount() {
        return salaryDiscount;
    }

    public void setSalaryDiscount(int salaryDiscount) {
        this.salaryDiscount = salaryDiscount;
    }

    public Semaphore getCostsMutex() {
        return costsMutex;
    }

    public void setCostsMutex(Semaphore costsMutex) {
        this.costsMutex = costsMutex;
    }

    public float getMotherboardCost() {
        return motherboardCost;
    }

    public void setMotherboardCost(float motherboardCost) {
        this.motherboardCost = motherboardCost;
    }

    public float getCpuCost() {
        return cpuCost;
    }

    public void setCpuCost(float cpuCost) {
        this.cpuCost = cpuCost;
    }

    public float getRamCost() {
        return ramCost;
    }

    public void setRamCost(float ramCost) {
        this.ramCost = ramCost;
    }

    public float getPowerSupplyCost() {
        return powerSupplyCost;
    }

    public void setPowerSupplyCost(float powerSupplyCost) {
        this.powerSupplyCost = powerSupplyCost;
    }

    public float getGpuCost() {
        return gpuCost;
    }

    public void setGpuCost(float gpuCost) {
        this.gpuCost = gpuCost;
    }

    public float getAssemblerCost() {
        return assemblerCost;
    }

    public void setAssemblerCost(float assemblerCost) {
        this.assemblerCost = assemblerCost;
    }

    public float getPmCost() {
        return pmCost;
    }

    public void setPmCost(float pmCost) {
        this.pmCost = pmCost;
    }

    public float getDirectorCost() {
        return directorCost;
    }

    public void setDirectorCost(float directorCost) {
        this.directorCost = directorCost;
    }

    public float getEarnings() {
        return earnings;
    }

    public void setEarnings(float earnings) {
        this.earnings = earnings;
    }

    public int getComputersAssembledSinceLastGPU() {
        return computersAssembledSinceLastGPU;
    }

    public void setComputersAssembledSinceLastGPU(int computersAssembledSinceLastGPU) {
        this.computersAssembledSinceLastGPU = computersAssembledSinceLastGPU;
    }
    
    /**
     * Método para calcular los costos totales en base a los componentes y sueldos
     * @return float - Costos actuales
     */
    public float calcularCostos() {
        try {
            costsMutex.acquire();
            
            // Suma de los costos de componentes y sueldos
            float totalCostos = motherboardCost * motherboards 
                              + cpuCost * cpus
                              + ramCost * ramModules
                              + powerSupplyCost * powerSupplies
                              + gpuCost * gpus
                              + assemblerCost * standardComputers 
                              + pmCost + directorCost;
            
            return totalCostos;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            costsMutex.release();
        }
        return 0;
    }

    /**
     * Método para obtener el estado del PM
     * @return String - Estado actual del PM
     */
    public String getEstadoPM() {
        return pmStatus == 0 ? "Trabajando" : "Viendo Anime";
    }

    /**
     * Método para obtener el estado del Director
     * @return String - Estado actual del Director
     */
    public String getEstadoDirector() {
        return directorStatus == 0 ? "Vigilando" : "Trabajando";
    }
    
    // Método para calcular los ingresos
    public double calcularIngresos() {
        // Precios de venta (puedes ajustar estos valores según tu lógica)
        double precioCompEstandar = 1000.0;
        double precioCompConGPU = 1500.0;

        // Calcula los ingresos
        return (getStandardComputers() * precioCompEstandar) +
               (getComputersWithGPU() * precioCompConGPU);
    }

}
