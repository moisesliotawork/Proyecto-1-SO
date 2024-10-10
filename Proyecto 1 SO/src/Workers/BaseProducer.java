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
public class BaseProducer extends Worker {
    private final float baseProductionRate; // Cantidad de placas base que produce por día.

    /**
     * Constructor de la clase BaseProducer.
     * 
     * @param drive Almacén (Drive) donde se almacenarán las placas base producidas.
     * @param companyRules Reglas específicas de la compañía.
     * @param costPerHour Costo por hora del trabajador.
     */
    public BaseProducer(Drive drive, CompanyRules companyRules, float costPerHour) {
        super(WorkerEnum.BaseProducer, costPerHour, drive, companyRules); // Inicializa la clase abstracta Worker
        this.baseProductionRate = companyRules.getMotherboardProductionPerDay(); // Obtiene la cantidad de placas base producidas por día de CompanyRules
    }

    /**
     * Método implementado de Worker para realizar el trabajo del productor de placas base.
     * Produce una cantidad de placas base cada día y las agrega al Drive (almacén).
     */
    @Override
    public void work() {
        try {
            // Adquirimos el semáforo para evitar condiciones de carrera al agregar productos
            drive.getWarehouse().getMotherboardSemaphore().acquire();

            // Agregar las placas base producidas al Warehouse a través de Drive
            //System.out.println("El productor de placas base está trabajando...");
            drive.getWarehouse().addProduct(baseProductionRate, WorkerEnum.BaseProducer);
            //System.out.println("El productor de placas base ha producido " + baseProductionRate + " placas base.");

            // Aumentar las horas trabajadas por este trabajador
            hoursWorked += 24; // Suponiendo que el trabajador trabaja 8 horas al día.
            
            // Actualizar el costo acumulado del trabajador
            updateCost(24); // Actualiza el costo del trabajador basado en las horas trabajadas

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            //System.out.println("El productor de placas base fue interrumpido.");
        } finally {
            // Liberamos el semáforo al terminar la producción.
            drive.getWarehouse().getMotherboardSemaphore().release();
        }
    }

    /**
     * Método que se ejecuta cuando se inicia el hilo del trabajador.
     * Controla el ciclo de trabajo diario del productor de placas base.
     */
    @Override
    public void run() {
        while (isWorking) {
            try {
                // Realiza el trabajo de producción de placas base
                work();

                // Simula la duración de un día de trabajo
                Thread.sleep(drive.getDayDuration() * 1000); // Convertimos la duración del día a milisegundos

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                //System.out.println("El productor de placas base fue interrumpido durante su ciclo de trabajo.");
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
