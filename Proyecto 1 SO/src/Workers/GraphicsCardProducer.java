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
public class GraphicsCardProducer extends Worker{
    
    private final float graphicsCardProductionRate;
    /**
     * Constructor de la clase GraphicsCardProducer.
     * 
     * @param drive Almacén (Drive) donde se almacenarán las tarjetas gráficas producidas.
     * @param companyRules Reglas específicas de la compañía.
     * @param costPerHour Costo por hora del trabajador.
     */
    public GraphicsCardProducer(Drive drive, CompanyRules companyRules, float costPerHour) {
        super(WorkerEnum.GraphicsCardProducer, costPerHour, drive, companyRules);
        this.graphicsCardProductionRate = companyRules.getGraphicsCardProductionPerDay();
    }

    /**
     * Método implementado de Worker para realizar el trabajo del productor de tarjetas gráficas.
     */
    @Override
    public void work() {
        try {
            drive.getWarehouse().getProducerSemaphore().acquire();

            drive.getWarehouse().addProduct(graphicsCardProductionRate, WorkerEnum.GraphicsCardProducer);
            hoursWorked += 24;

            updateCost(24); // Actualiza el costo acumulado del trabajador

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            drive.getWarehouse().getProducerSemaphore().release();
        }
    }

    /**
     * Método que se ejecuta cuando se inicia el hilo del trabajador.
     */
    @Override
    public void run() {
        while (isWorking) {
            try {
                work();
                Thread.sleep(drive.getDayDuration() * 1000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
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
