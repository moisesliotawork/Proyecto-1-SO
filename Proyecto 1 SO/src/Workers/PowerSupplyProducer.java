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
public class PowerSupplyProducer extends Worker{
    private final float powerSupplyProductionRate; // Cantidad de fuentes de alimentación que produce por día.

    /**
     * Constructor de la clase PowerSupplyProducer.
     * 
     * @param drive Almacén (Drive) donde se almacenarán las fuentes de alimentación producidas.
     * @param companyRules Reglas específicas de la compañía.
     * @param costPerHour Costo por hora del trabajador.
     */
    public PowerSupplyProducer(Drive drive, CompanyRules companyRules, float costPerHour) {
        super(WorkerEnum.PowerSupplyProducer, costPerHour, drive, companyRules); // Inicializa la clase abstracta Worker
        this.powerSupplyProductionRate = companyRules.getPowerSupplyProductionPerDay(); // Obtiene la cantidad de fuentes de alimentación producidas por día de CompanyRules
    }

    /**
     * Método implementado de Worker para realizar el trabajo del productor de fuentes de alimentación.
     * Produce una cantidad de fuentes de alimentación cada día y las agrega al Drive (almacén).
     */
    @Override
    public void work() {
        try {
            // Adquirimos el semáforo para evitar condiciones de carrera al agregar productos
            drive.getWarehouse().getProducerSemaphore().acquire();

            // Agregar las fuentes de alimentación producidas al Warehouse a través de Drive
            //System.out.println("El productor de fuentes de alimentación está trabajando...");
            drive.getWarehouse().addProduct(powerSupplyProductionRate, WorkerEnum.PowerSupplyProducer);
            //System.out.println("El productor de fuentes de alimentación ha producido " + powerSupplyProductionRate + " fuentes de alimentación.");

            // Aumentar las horas trabajadas por este trabajador
            hoursWorked += 24; // Suponiendo que el trabajador trabaja 8 horas al día.
            
            // Actualizar el costo acumulado del trabajador
            updateCost(24); // Actualiza el costo del trabajador basado en las horas trabajadas

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            //System.out.println("El productor de fuentes de alimentación fue interrumpido.");
        } finally {
            // Liberamos el semáforo al terminar la producción.
            drive.getWarehouse().getProducerSemaphore().release();
        }
    }

    /**
     * Método que se ejecuta cuando se inicia el hilo del trabajador.
     * Controla el ciclo de trabajo diario del productor de fuentes de alimentación.
     */
    @Override
    public void run() {
        while (isWorking) {
            try {
                // Realiza el trabajo de producción de fuentes de alimentación
                work();

                // Simula la duración de un día de trabajo
                Thread.sleep(drive.getDayDuration() * 1000); // Convertimos la duración del día a milisegundos

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                //System.out.println("El productor de fuentes de alimentación fue interrumpido durante su ciclo de trabajo.");
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
