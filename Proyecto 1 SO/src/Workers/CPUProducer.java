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
public class CPUProducer extends Worker{
    private final float cpuProductionRate;  // Cantidad de CPUs que produce por día.

    /**
     * Constructor de la clase CPUProducer.
     * 
     * @param drive Almacén (Drive) donde se almacenarán las CPUs producidas.
     * @param companyRules Reglas específicas de la compañía (Apple, Dell, etc.).
     * @param costPerHour Costo por hora del trabajador.
     */
    public CPUProducer(Drive drive, CompanyRules companyRules, float costPerHour) {
        super(WorkerEnum.CPUProducer, costPerHour, drive, companyRules);  // Inicializa la clase padre Worker
        this.cpuProductionRate = companyRules.getCpuProductionPerDay();  // Obtiene la cantidad de CPUs producida por día de CompanyRules
    }

    /**
     * Método implementado de Worker para realizar el trabajo del productor de CPUs.
     * Produce una cantidad de CPUs cada día y las agrega al Drive (almacén).
     */
    @Override
    public void work() {
        try {
            // Adquirimos el semáforo para evitar condiciones de carrera al agregar productos
            drive.getWarehouse().getProducerSemaphore().acquire();

            // Agregar las CPUs producidas al Drive
            //System.out.println("El productor de CPUs está trabajando...");
            drive.getWarehouse().addProduct(cpuProductionRate, WorkerEnum.CPUProducer);
            //System.out.println("El productor de CPUs ha producido " + cpuProductionRate + " CPUs.");

            // Aumentar las horas trabajadas por este trabajador
            hoursWorked += 24;  // Suponiendo que el trabajador trabaja 8 horas al día.

            // Actualizar el costo acumulado del trabajador
            updateCost(25); 

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            //System.out.println("El productor de CPUs fue interrumpido.");
        } finally {
            // Liberamos el semáforo al terminar la producción.
            drive.getWarehouse().getProducerSemaphore().release();
        }
    }

    /**
     * Método que se ejecuta cuando se inicia el hilo del trabajador.
     * Controla el ciclo de trabajo diario del productor de CPUs.
     */
    @Override
    public void run() {
        while (isWorking) {
            try {
                // Realiza el trabajo de producción de CPUs
                work();

                // Simula la duración de un día de trabajo
                Thread.sleep(drive.getDayDuration() * 1000);  // Convertimos la duración del día a milisegundos

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                //System.out.println("El productor de CPUs fue interrumpido durante su ciclo de trabajo.");
            }
        }
    }
    
    /**
     * Método para actualizar el costo del trabajador en función de las horas trabajadas.
     * @param hours Horas trabajadas en el ciclo.
     */
    private void updateCost(int hours) {
        float totalCost = costPerHour * hours;
        //System.out.println("El costo de producción para " + hours + " horas es: $" + totalCost);
    }
}
