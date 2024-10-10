/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Warehouse;

import Enums.WorkerEnum;
import static Enums.WorkerEnum.BaseProducer;
import static Enums.WorkerEnum.CPUProducer;
import static Enums.WorkerEnum.GraphicsCardProducer;
import static Enums.WorkerEnum.PowerSupplyProducer;
import static Enums.WorkerEnum.RAMProducer;
import java.util.concurrent.Semaphore;

/**
 *
 * @author vickysaldivia
 */
public class Warehouse {
     // Componentes disponibles
    private float motherboards;
    private float cpus;
    private float ram;
    private float powerSupplies;
    private float graphicsCards;

    // Capacidades máximas de almacenamiento de cada componente
    private final float maxMotherboards = 25.0f;
    private final float maxCpus = 20.0f;
    private final float maxRam = 55.0f;
    private final float maxPowerSupplies = 35.0f;
    private final float maxGraphicsCards = 10.0f;

    // Semáforos para controlar la concurrencia
    private final Semaphore producerSemaphore = new Semaphore(1); // Control de acceso para la producción
    private final Semaphore consumerSemaphore = new Semaphore(1); // Control de acceso para el consumo
    
     // Semáforos por cada tipo de componente
    private final Semaphore motherboardSemaphore = new Semaphore(1);
    private final Semaphore cpuSemaphore = new Semaphore(1);
    private final Semaphore ramSemaphore = new Semaphore(1);
    private final Semaphore powerSupplySemaphore = new Semaphore(1);
    private final Semaphore graphicsCardSemaphore = new Semaphore(1);
    
    // Métodos para obtener cada semáforo individualmente
    public Semaphore getMotherboardSemaphore() {
        return motherboardSemaphore;
    }
    
    public Semaphore getCpuSemaphore() {
        return cpuSemaphore;
    }

    public Semaphore getRamSemaphore() {
        return ramSemaphore;
    }

    public Semaphore getPowerSupplySemaphore() {
        return powerSupplySemaphore;
    }

    public Semaphore getGraphicsCardSemaphore() {
        return graphicsCardSemaphore;
    }

    /**
     * Constructor que inicializa los recursos.
     */
    public Warehouse() {
        this.motherboards = 0.0f;
        this.cpus = 0.0f;
        this.ram = 0.0f;
        this.powerSupplies = 0.0f;
        this.graphicsCards = 0.0f;
    }
    
    

    /**
     * Método para agregar componentes al almacén utilizando semáforos.
     * @param productQty Cantidad de productos a agregar.
     * @param workerType Tipo de trabajador que está produciendo los componentes.
     */
    public void addProduct(float productQty, WorkerEnum workerType) {
    try {
        producerSemaphore.acquire();  // Adquiere permiso para acceder a los recursos.
        System.out.println("El semáforo ha sido adquirido por el productor " + workerType);

        switch (workerType) {
            case BaseProducer:
                //motherboardSemaphore.acquire();
                //System.out.println("Añadiendo " + productQty + " placas base.");
                motherboards = Math.min(motherboards + productQty, maxMotherboards);
                //System.out.println("Total de placas base: " + motherboards);
                //motherboardSemaphore.release();
                break;
            case CPUProducer:
                //cpuSemaphore.acquire();
                //System.out.println("Añadiendo " + productQty + " CPUs.");
                cpus = Math.min(cpus + productQty, maxCpus);
                //System.out.println("Total de CPUs: " + cpus);
                //cpuSemaphore.release();
                break;
            case RAMProducer:
                //ramSemaphore.acquire();
                //System.out.println("Añadiendo " + productQty + " de RAM.");
                ram = Math.min(ram + productQty, maxRam);
                //System.out.println("Total de RAM: " + ram);
                //ramSemaphore.release();
                break;
            case PowerSupplyProducer:
                //powerSupplySemaphore.acquire();
                //System.out.println("Añadiendo " + productQty + " fuentes de alimentación.");
                powerSupplies = Math.min(powerSupplies + productQty, maxPowerSupplies);
                //System.out.println("Total de fuentes de alimentación: " + powerSupplies);
               // powerSupplySemaphore.release();
                break;
            case GraphicsCardProducer:
               // graphicsCardSemaphore.acquire();
                //System.out.println("Añadiendo " + productQty + " tarjetas gráficas.");
                graphicsCards = Math.min(graphicsCards + productQty, maxGraphicsCards);
                //System.out.println("Total de tarjetas gráficas: " + graphicsCards);
               // graphicsCardSemaphore.release();
                break;
            default:
                throw new IllegalArgumentException("Tipo de trabajador desconocido.");
        }
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("El productor fue interrumpido.");
    } finally {
        producerSemaphore.release();  // Libera el permiso una vez finalizado el acceso a los recursos.
        System.out.println("El semáforo ha sido liberado por el productor " + workerType);
    }
}


    /**
     * Ensambla una computadora estándar.
     * @return true si se ensambló la computadora, false si no hay suficientes componentes.
     */
    public boolean assembleStandardComputer() {
    try {
        consumerSemaphore.acquire();  // Adquiere permiso para acceder a los recursos.
          // Mostrar cuántos componentes están disponibles antes de ensamblar
        System.out.println("Componentes disponibles antes de ensamblar:");
        System.out.println("Placas base: " + motherboards);
        System.out.println("CPUs: " + cpus);
        System.out.println("RAM: " + ram);
        System.out.println("Fuentes de alimentación: " + powerSupplies);
        if (motherboards >= 2.0f && cpus >= 1.0f && ram >= 4.0f && powerSupplies >= 4.0f) {
            motherboards -= 2.0f;
            cpus -= 1.0f;
            ram -= 4.0f;
            powerSupplies -= 4.0f;
            System.out.println("Computadora ensamblada");
            return true;  // Se ensambló una computadora estándar.
        } else {
            System.out.println("No hay suficientes componentes para ensamblar una computadora estándar.");
            return false;  // No hay suficientes componentes.
        }
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return false;
    } finally {
        consumerSemaphore.release();  // Libera el permiso.
    }
}

    /**
     * Ensambla una computadora con tarjeta gráfica.
     * @return true si se ensambló la computadora, false si no hay suficientes componentes.
     */
    public boolean assembleGraphicsCardComputer() {
        try {
            consumerSemaphore.acquire();  // Adquiere permiso para acceder a los recursos.

            if (motherboards >= 1.0f && cpus >= 1.0f && ram >= 4.0f && powerSupplies >= 4.0f && graphicsCards >= 1.0f) {
                motherboards -= 1.0f;
                cpus -= 1.0f;
                ram -= 4.0f;
                powerSupplies -= 4.0f;
                graphicsCards -= 1.0f;
                return true;  // Se ensambló una computadora con tarjeta gráfica.
            } else {
                return false;  // No hay suficientes componentes.
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        } finally {
            consumerSemaphore.release();  // Libera el permiso.
        }
    }

    // Getters para los componentes (puedes añadir setters si es necesario)
    public float getMotherboards() {
        return motherboards;
    }

    public float getCpus() {
        return cpus;
    }

    public float getRam() {
        return ram;
    }

    public float getPowerSupplies() {
        return powerSupplies;
    }

    public float getGraphicsCards() {
        return graphicsCards;
    }

    public Semaphore getConsumerSemaphore() {
        return consumerSemaphore;
    }

    public Semaphore getProducerSemaphore() {
        return producerSemaphore;
    }
}
