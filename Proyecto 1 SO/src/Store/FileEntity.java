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
     // Duración de un día de trabajo en segundos
    private int durationDay;
    
    // Días de plazo (deadline) para ensamblar computadoras
    private int deadLineDays;
    
    // Número de trabajadores en cada área de producción
    private int motherboardWorkers;
    private int cpuWorkers;
    private int ramWorkers;
    private int powerSupplyWorkers;
    private int graphicsCardWorkers;
    
    // Número de ensambladores
    private int assemblers;

    // Otros roles clave en la compañía
    private int projectManagers;
    private int directors;
    
    public FileEntity() {}

    /**
     * Constructor de la entidad para la lectura y escritura de datos desde JSONs.
     * @param durationDay int - Duración en segundos de un día de trabajo.
     * @param deadLineDays int - Número de días hasta el plazo de ensamblaje.
     * @param motherboardWorkers int - Número de trabajadores en la producción de placas base.
     * @param cpuWorkers int - Número de trabajadores en la producción de CPUs.
     * @param ramWorkers int - Número de trabajadores en la producción de RAM.
     * @param powerSupplyWorkers int - Número de trabajadores en la producción de fuentes de alimentación.
     * @param graphicsCardWorkers int - Número de trabajadores en la producción de tarjetas gráficas.
     * @param assemblers int - Número de ensambladores.
     * @param projectManagers int - Número de project managers.
     * @param directors int - Número de directores.
     */
    public FileEntity(int durationDay, int deadLineDays, int motherboardWorkers, int cpuWorkers, int ramWorkers,
                      int powerSupplyWorkers, int graphicsCardWorkers, int assemblers, int projectManagers, int directors) {
        this.durationDay = durationDay;
        this.deadLineDays = deadLineDays;
        this.motherboardWorkers = motherboardWorkers;
        this.cpuWorkers = cpuWorkers;
        this.ramWorkers = ramWorkers;
        this.powerSupplyWorkers = powerSupplyWorkers;
        this.graphicsCardWorkers = graphicsCardWorkers;
        this.assemblers = assemblers;
        this.projectManagers = projectManagers;
        this.directors = directors;
    }

    // Getters y Setters para cada atributo

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

    public int getMotherboardWorkers() {
        return motherboardWorkers;
    }

    public void setMotherboardWorkers(int motherboardWorkers) {
        this.motherboardWorkers = motherboardWorkers;
    }

    public int getCpuWorkers() {
        return cpuWorkers;
    }

    public void setCpuWorkers(int cpuWorkers) {
        this.cpuWorkers = cpuWorkers;
    }

    public int getRamWorkers() {
        return ramWorkers;
    }

    public void setRamWorkers(int ramWorkers) {
        this.ramWorkers = ramWorkers;
    }

    public int getPowerSupplyWorkers() {
        return powerSupplyWorkers;
    }

    public void setPowerSupplyWorkers(int powerSupplyWorkers) {
        this.powerSupplyWorkers = powerSupplyWorkers;
    }

    public int getGraphicsCardWorkers() {
        return graphicsCardWorkers;
    }

    public void setGraphicsCardWorkers(int graphicsCardWorkers) {
        this.graphicsCardWorkers = graphicsCardWorkers;
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
    
}
