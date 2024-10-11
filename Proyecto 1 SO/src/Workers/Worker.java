/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Workers;

import Enums.WorkerTypeEnum;
import Rules.CompanyRules;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Moises Liota
 */
public abstract class Worker extends Thread{
    
    protected WorkerTypeEnum type;
    private int dayDuration = 1000;  // Duración del día en milisegundos (simulado)
    protected int daysWorked = 0;
    protected float costPerHour;
    protected Semaphore mutex;
    protected CompanyRules companyRules;
    protected boolean hired;
    protected boolean running = true; 
    
    /**
     * Constructor Base para un trabajador
     * @param type WorkerTypeEnum - Tipo de trabajo
     * @param cph float - Costo por hora de trabajo
     * @param m Semaphore - Semáforo para exclusión mutua
     * @param companyRules CompanyRules - Datos de la compañía asociada
     */
    public Worker (WorkerTypeEnum type, float cph, Semaphore m, CompanyRules companyRules){
        this.type = type;
        this.costPerHour = cph;
        this.mutex = m;
        this.companyRules = companyRules;
        this.hired = true;
    }

    /**
     * Método heredado de Thread que se llama al iniciar el hilo con Start().
     */
    @Override
    public abstract void run();

    /**
     * Método de trabajo del Worker, implementado en cada subclase.
     */
    public abstract void Work();
    
    /**
     * Calcula los gastos del trabajador por día o de forma histórica.
     * @param historical boolean - (true) si se desea el costo histórico, (false) para el costo diario.
     * @return float - Costo total del trabajador.
     */
    public float getWorkerCostPerDay(boolean historical) {
        // Cálculo del costo diario basado en el costo por hora y la duración simulada del día
        float dailyCost = costPerHour * 24f;
        return (!historical) ? dailyCost : dailyCost * this.daysWorked;
    }

    /**
     * Verifica si el trabajador está contratado.
     * @return boolean - (true) si está contratado, (false) si no.
     */
    public boolean isHired() {
        return hired;
    }

    /**
     * Define el estado de contratación del trabajador.
     * @param hired boolean - Define si está contratado.
     */
    public void setHired(boolean hired) {
        this.hired = hired;
    }
    
    /**
     * Obtiene la duración del día en la simulación.
     * @return int - Duración del día en milisegundos.
     */
    public int getDayDuration() {
        return dayDuration;
    }

    /**
     * Define la duración del día en la simulación.
     * @param dayDuration int - Nueva duración del día en milisegundos.
     */
    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }
    
    // Método para detener el hilo
    public void stopWorker() {
        this.running = false;
    }

}
