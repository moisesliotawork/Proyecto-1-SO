/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Store;

/**
 *
 * @author Moises Liota
 */
public class FileEntity {
    private int durationDay;  // Duración en segundos de un día en la simulación
    private int deadLineDays;  // Número de días antes de la entrega de computadoras
    private int motherboardProducers;
    private int cpuProducers;
    private int ramProducers;
    private int powerSupplyProducers;
    private int gpuProducers;
    private int assemblers;  // Integradores
    private int projectManagers;
    private int directors;
    
    public FileEntity(){}

    /**
     * Constructor de la entidad para lectura y escritura de JSONs
     * @param durationDay int - Duración en segundos de un día en la simulación
     * @param deadLineDays int - Tiempo en días antes de la entrega de computadoras
     * @param motherboardProducers int - Número de productores de placas base
     * @param cpuProducers int - Número de productores de CPUs
     * @param ramProducers int - Número de productores de RAM
     * @param powerSupplyProducers int - Número de productores de fuentes de alimentación
     * @param gpuProducers int - Número de productores de tarjetas gráficas
     * @param assemblers int - Número de ensambladores de computadoras
     * @param projectManagers int - Número de Project Managers
     * @param directors int - Número de Directores
     */
    public FileEntity(int durationDay, int deadLineDays, int motherboardProducers, int cpuProducers, int ramProducers, int powerSupplyProducers, int gpuProducers, int assemblers, int projectManagers, int directors) {
    
        this.durationDay = durationDay;
        this.deadLineDays = deadLineDays;
        this.motherboardProducers = motherboardProducers;
        this.cpuProducers = cpuProducers;
        this.ramProducers = ramProducers;
        this.powerSupplyProducers = powerSupplyProducers;
        this.gpuProducers = gpuProducers;
        this.assemblers = assemblers;
        this.projectManagers = projectManagers;
        this.directors = directors;
    }

    // GETTERS y SETTERS adaptados a los nuevos tipos de trabajadores

    public int getMotherboardProducers() {
        return motherboardProducers;
    }

    public void setMotherboardProducers(int motherboardProducers) {
        this.motherboardProducers = motherboardProducers;
    }

    public int getCpuProducers() {
        return cpuProducers;
    }

    public void setCpuProducers(int cpuProducers) {
        this.cpuProducers = cpuProducers;
    }

    public int getRamProducers() {
        return ramProducers;
    }

    public void setRamProducers(int ramProducers) {
        this.ramProducers = ramProducers;
    }

    public int getPowerSupplyProducers() {
        return powerSupplyProducers;
    }

    public void setPowerSupplyProducers(int powerSupplyProducers) {
        this.powerSupplyProducers = powerSupplyProducers;
    }

    public int getGpuProducers() {
        return gpuProducers;
    }

    public void setGpuProducers(int gpuProducers) {
        this.gpuProducers = gpuProducers;
    }

    public int getAssemblers() {
        return assemblers;
    }

    public void setAssemblers(int assemblers) {
        this.assemblers = assemblers;
    }

    public int getProjectManagers() {
        return projectManagers;
    }

    public void setProjectManagers(int projectManagers) {
        this.projectManagers = projectManagers;
    }

    public int getDirectors() {
        return directors;
    }

    public void setDirectors(int directors) {
        this.directors = directors;
    }

    public int getDurationDay() {
        return durationDay;
    }

    public void setDurationDay(int durationDay) {
        this.durationDay = durationDay;
    }

    public int getDeadLineDays() {
        return deadLineDays;
    }

    public void setDeadLineDays(int deadLineDays) {
        this.deadLineDays = deadLineDays;
    }
}