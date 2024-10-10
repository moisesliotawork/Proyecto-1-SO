/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Workers;

import Enums.WorkerEnum;
import Rules.CompanyRules;
import Store.Drive;

/**
 *
 * @author Moises Liota
 */
public abstract class Worker extends Thread{
    
    protected WorkerEnum type;  // Tipo de trabajador (ejemplo: CPUProducer, RAMProducer, etc.)
    protected float costPerHour;  // Costo por hora del trabajador
    protected int hoursWorked;  // Horas trabajadas por el trabajador
    protected boolean isWorking;  // Estado del trabajador (contratado o no)
    protected Drive drive;  // Almacén (Drive) al cual se accede para producción o ensamblaje
    protected CompanyRules companyRules;  // Reglas específicas de la compañía (Apple, Dell, etc.)
    protected int dayDuration;  // Duración del día en segundos

    // Constructor
    public Worker(WorkerEnum type, float costPerHour, Drive drive, CompanyRules companyRules) {
        this.type = type;
        this.costPerHour = costPerHour;
        this.hoursWorked = 0;
        this.isWorking = true;
        this.drive = drive;
        this.companyRules = companyRules;
    }

    /**
     *  Metodo heredado de Thread que llama al hacer Start() al Worker
     */
    public abstract void run();

    /**
     * Metodo de trabajo del Worker
     */
    public abstract void work();

    /**
     * Método para calcular el costo total del trabajador por las horas trabajadas.
     * @param historical Si es true, devolverá el costo histórico total. Si es false, solo devolverá el costo diario.
     * @return El costo total del trabajador.
     */
    public float getWorkerCost(boolean historical) {
        return historical ? costPerHour * hoursWorked : costPerHour * 8;
    }

    /**
     * Método para establecer la duración del día
     * @param dayDuration Duración del día en segundos
     */
    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }

    // Getters y setters adicionales si es necesario
    public WorkerEnum getType() {
        return type;
    }

    public float getCostPerHour() {
        return costPerHour;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean isWorking) {
        this.isWorking = isWorking;
    }
    
}
