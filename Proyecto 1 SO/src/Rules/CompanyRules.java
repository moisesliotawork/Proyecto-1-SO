/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rules;

import Enums.CompanyEnum;

/**
 *
 * @author Moises Liota
 */
public class CompanyRules {
     // Elementos necesarios para ensamblar una computadora estándar
    protected int motherboardsNeeded;
    protected int cpusNeeded;
    protected int ramModulesNeeded;
    protected int powerSuppliesNeeded;
    protected int gpusNeeded;

    // Ingresos por computadora
    protected float incomeStandard;
    protected float incomeWithGPU;

    // Intervalo de computadoras estándar para producir una con tarjeta gráfica
    protected int computersToComputersWithGPU;

    // Número máximo de empleados
    protected int employees;

    // Costo por hora por tipo de trabajo
    private float motherboardCost = 20f;
    private float cpuCost = 26f;
    private float ramCost = 40f;
    private float powerSupplyCost = 16f;
    private float gpuCost = 34f;
    private float assemblerCost = 50f;
    private float pmCost = 40f;
    private float directorCost = 60f;

    // Producción por día de cada componente (común a ambas compañías)
    protected final float motherboardProductionPerDay = 0.25f;  // 1 cada 4 días
    protected final float cpuProductionPerDay = 0.25f;          // 1 cada 4 días
    protected final float ramProductionPerDay = 1f;             // 1 por día
    protected final float powerSupplyProductionPerDay = 5f;     // 5 por día
    protected final float gpuProductionPerDay = 0.5f;           // 1 cada 2 días

    
    protected CompanyEnum companyEnum;

    // Getters

    public float getIncomeStandard() {
        return incomeStandard;
    }

    public float getIncomeWithGPU() {
        return incomeWithGPU;
    }

    public int getMotherboardsNeeded() {
        return motherboardsNeeded;
    }

    public int getCpusNeeded() {
        return cpusNeeded;
    }

    public int getRamModulesNeeded() {
        return ramModulesNeeded;
    }

    public int getPowerSuppliesNeeded() {
        return powerSuppliesNeeded;
    }

    public int getGpusNeeded() {
        return gpusNeeded;
    }

    public int getEmployees() {
        return employees;
    }

    public float getMotherboardCost() {
        return motherboardCost;
    }

    public float getCpuCost() {
        return cpuCost;
    }

    public float getRamCost() {
        return ramCost;
    }

    public float getPowerSupplyCost() {
        return powerSupplyCost;
    }

    public float getGpuCost() {
        return gpuCost;
    }

    public float getAssemblerCost() {
        return assemblerCost;
    }

    public float getMotherboardProductionPerDay() {
        return motherboardProductionPerDay;
    }

    public float getCpuProductionPerDay() {
        return cpuProductionPerDay;
    }

    public float getRamProductionPerDay() {
        return ramProductionPerDay;
    }

    public float getPowerSupplyProductionPerDay() {
        return powerSupplyProductionPerDay;
    }

    public float getGpuProductionPerDay() {
        return gpuProductionPerDay;
    }

    public int getComputersToComputersWithGPU() {
        return computersToComputersWithGPU;
    }

    public float getPmCost() {
        return pmCost;
    }

    public float getDirectorCost() {
        return directorCost;
    }

    public CompanyEnum getCompanyEnum() {
        return companyEnum;
    }

    public void setCompanyEnum(CompanyEnum companyEnum) {
        this.companyEnum = companyEnum;
    }
    
    // Método para verificar si se puede ensamblar una computadora estándar
    public boolean canAssembleStandardComputer(int motherboards, int cpus, int ramModules, int powerSupplies) {
        return (motherboards >= this.getMotherboardsNeeded() && 
                cpus >= this.getCpusNeeded() && 
                ramModules >= this.getRamModulesNeeded() && 
                powerSupplies >= this.getPowerSuppliesNeeded());
    }

    // Método para verificar si se puede ensamblar una computadora con GPU
    public boolean canAssembleComputerWithGPU(int motherboards, int cpus, int ramModules, int powerSupplies, int gpus) {
        return (motherboards >= this.getMotherboardsNeeded() && 
                cpus >= this.getCpusNeeded() && 
                ramModules >= this.getRamModulesNeeded() && 
                powerSupplies >= this.getPowerSuppliesNeeded() && 
                gpus >= this.getGpusNeeded());
    }
}
