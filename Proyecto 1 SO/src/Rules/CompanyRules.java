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
public abstract class CompanyRules {
    // Elementos necesarios para ensamblar una computadora
    protected int motherboardsNeedIt;
    protected int cpusNeedIt;
    protected int ramNeedIt;
    protected int powerSupplyNeedIt;
    protected int graphicsCardNeedIt;

    // Ganancias por computadora
    protected float incomeStandard;
    protected float incomeGraphicsCard;

    // Intervalo para ensamblar computadoras con tarjeta gráfica
    protected int computersToGraphicsCard;
    
    // Intervalo predeterminado entre lanzamientos de productos
    protected int daysBetweenReleases = 30;  // Valor por defecto

    // Producción por día de los diferentes componentes (común para todas las compañías)
    protected final float motherboardProductionPerDay = 0.25f;
    protected final float cpuProductionPerDay = 0.25f;
    protected final float ramProductionPerDay = 1f;
    protected final float powerSupplyProductionPerDay = 5f;
    protected final float graphicsCardProductionPerDay = 0.5f;
    
    private float cpuProducerCost = 10f;
    private float ramProducerCost = 8f;
    private float powerSupplyProducerCost = 9f;
    private float graphicsCardProducerCost = 15f;
    private float baseProducerCost = 12f;
    private float assemblerCost = 20f;
    private float pmCost = 25f;
    private float directorCost = 30f;
    
    
    //Numero máximo de empleados
    protected int employees;
    
    // Identificador de la compañía
    protected CompanyEnum companyEnum;

    /**
     * Verifica si se puede ensamblar una computadora estándar con los componentes disponibles.
     * @param motherboards Número de placas base disponibles
     * @param cpus Número de CPUs disponibles
     * @param ram Número de módulos de RAM disponibles
     * @param powerSupplies Número de fuentes de alimentación disponibles
     * @return booleano, si es posible ensamblar una computadora estándar
     */
    public boolean canMakeStandardComputer(int motherboards, int cpus, int ram, int powerSupplies) {
        return (motherboards >= this.motherboardsNeedIt && cpus >= this.cpusNeedIt && ram >= this.ramNeedIt && powerSupplies >= this.powerSupplyNeedIt);
    }

    /**
     * Verifica si se puede ensamblar una computadora con tarjeta gráfica con los componentes disponibles.
     * @param motherboards Número de placas base disponibles
     * @param cpus Número de CPUs disponibles
     * @param ram Número de módulos de RAM disponibles
     * @param powerSupplies Número de fuentes de alimentación disponibles
     * @param graphicsCards Número de tarjetas gráficas disponibles
     * @return booleano, si es posible ensamblar una computadora con tarjeta gráfica
     */
    public boolean canMakeGraphicsCardComputer(int motherboards, int cpus, int ram, int powerSupplies, int graphicsCards) {
        return (motherboards >= this.motherboardsNeedIt && cpus >= this.cpusNeedIt && ram >= this.ramNeedIt && powerSupplies >= this.powerSupplyNeedIt && graphicsCards >= this.graphicsCardNeedIt);
    }

    // Getters y Setters comunes

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

    public float getGraphicsCardProductionPerDay() {
        return graphicsCardProductionPerDay;
    }

    public CompanyEnum getCompanyEnum() {
        return companyEnum;
    }

    public float getIncomeStandard() {
        return incomeStandard;
    }

    public void setIncomeStandard(float incomeStandard) {
        this.incomeStandard = incomeStandard;
    }

    public float getIncomeGraphicsCard() {
        return incomeGraphicsCard;
    }

    public void setIncomeGraphicsCard(float incomeGraphicsCard) {
        this.incomeGraphicsCard = incomeGraphicsCard;
    }

    public int getComputersToGraphicsCard() {
        return computersToGraphicsCard;
    }

    public void setComputersToGraphicsCard(int computersToGraphicsCard) {
        this.computersToGraphicsCard = computersToGraphicsCard;
    }

    public int getDaysBetweenReleases() {
        return daysBetweenReleases;
    }

    public void setDaysBetweenReleases(int daysBetweenReleases) {
        this.daysBetweenReleases = daysBetweenReleases;
    }

    public int getMotherboardsNeedIt() {
        return motherboardsNeedIt;
    }

    public void setMotherboardsNeedIt(int motherboardsNeedIt) {
        this.motherboardsNeedIt = motherboardsNeedIt;
    }

    public int getCpusNeedIt() {
        return cpusNeedIt;
    }

    public void setCpusNeedIt(int cpusNeedIt) {
        this.cpusNeedIt = cpusNeedIt;
    }

    public int getRamNeedIt() {
        return ramNeedIt;
    }

    public void setRamNeedIt(int ramNeedIt) {
        this.ramNeedIt = ramNeedIt;
    }

    public int getPowerSupplyNeedIt() {
        return powerSupplyNeedIt;
    }

    public void setPowerSupplyNeedIt(int powerSupplyNeedIt) {
        this.powerSupplyNeedIt = powerSupplyNeedIt;
    }

    public int getGraphicsCardNeedIt() {
        return graphicsCardNeedIt;
    }

    public void setGraphicsCardNeedIt(int graphicsCardNeedIt) {
        this.graphicsCardNeedIt = graphicsCardNeedIt;
    }

    public float getCpuProducerCost() {
        return cpuProducerCost;
    }

    public void setCpuProducerCost(float cpuProducerCost) {
        this.cpuProducerCost = cpuProducerCost;
    }

    public float getRamProducerCost() {
        return ramProducerCost;
    }

    public void setRamProducerCost(float ramProducerCost) {
        this.ramProducerCost = ramProducerCost;
    }

    public float getPowerSupplyProducerCost() {
        return powerSupplyProducerCost;
    }

    public void setPowerSupplyProducerCost(float powerSupplyProducerCost) {
        this.powerSupplyProducerCost = powerSupplyProducerCost;
    }

    public float getGraphicsCardProducerCost() {
        return graphicsCardProducerCost;
    }

    public void setGraphicsCardProducerCost(float graphicsCardProducerCost) {
        this.graphicsCardProducerCost = graphicsCardProducerCost;
    }

    public float getBaseProducerCost() {
        return baseProducerCost;
    }

    public void setBaseProducerCost(float baseProducerCost) {
        this.baseProducerCost = baseProducerCost;
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

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }
}
