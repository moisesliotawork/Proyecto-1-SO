/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Store;

import Warehouse.Warehouse;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Moises Liota
 */
public class Drive {
      // Computadoras ensambladas
    private int computers;
    private int computersWithGraphicsCards;

    // Ganancias y costos operativos
    private float utility;

    // Duración del día en segundos
    private int dayDuration;

    // Almacén de componentes
    private final Warehouse warehouse;

    // Estado del Project Manager: 0 = trabajando, 1 = distraído
    private int pmStatus;

    // Estado del Director: 0 = vigilando, 1 = no vigilando
    private int directorStatus;

    // Faltas del Project Manager
    private int faltas;

    // Descuento de salario del Project Manager
    private float salaryDiscount;

    // Costos asociados al Project Manager
    private float pmCost;

    // Costos asociados al Director
    private float directorCost;

    // Días restantes hasta la entrega del proyecto
    private int daysUntilRelease;
    private final Semaphore daysMutex = new Semaphore(1);

    // Semáforo para gestionar costos
    private final Semaphore costsMutex = new Semaphore(1);

    /**
     * Constructor que inicializa el Drive y el almacén.
     *
     * @param warehouse La instancia de Warehouse que gestiona los componentes.
     * @param dayDuration Duración del día en segundos.
     */
    public Drive(Warehouse warehouse, int dayDuration) {
        this.computers = 0;
        this.computersWithGraphicsCards = 0;
        this.warehouse = warehouse;
        this.dayDuration = dayDuration;
        this.pmStatus = 0;
        this.directorStatus = 1;  // Por defecto el director no está vigilando
        this.faltas = 0;
        this.salaryDiscount = 0;
        this.pmCost = 0;
        this.directorCost = 0;
        this.daysUntilRelease = 30;  // Por ejemplo, un valor inicial de 30 días hasta la entrega
    }

    // Métodos para ensamblar computadoras y verificar si se necesita una con tarjeta gráfica

    /**
     * Ensambla una computadora de acuerdo a la política de la empresa.
     *
     * @param isGraphicsCardComputer True si se ensambla una computadora con tarjeta gráfica.
     * @return true si se ensambló la computadora, false si no.
     */
    public boolean assembleComputer(boolean isGraphicsCardComputer) {
        // Ahora, la gestión de semáforos para la producción/consumo la maneja Warehouse
        return isGraphicsCardComputer
                ? warehouse.assembleGraphicsCardComputer()
                : warehouse.assembleStandardComputer();
    }

    /**
     * Método para verificar si es necesario ensamblar una computadora con tarjeta gráfica.
     *
     * @param computersAssembled Número de computadoras ensambladas.
     * @param computersToGraphicsCard Política de ensamblaje de computadoras con tarjeta gráfica.
     * @return True si es necesario ensamblar una computadora con tarjeta gráfica.
     */
    public boolean shouldAssembleGraphicsCardComputer(int computersAssembled, int computersToGraphicsCard) {
        return (computersAssembled + 1) % computersToGraphicsCard == 0;
    }

    // Métodos para manejar el costo acumulado

    /**
     * Método para actualizar el costo acumulado del Project Manager.
     *
     * @param additionalCost Costo adicional a agregar.
     */
    public void updatePmCost(float additionalCost) {
        try {
            costsMutex.acquire();  // Protección contra concurrencia
            pmCost += additionalCost;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            costsMutex.release();
        }
    }

    /**
     * Método para actualizar el costo acumulado del Director.
     *
     * @param additionalCost Costo adicional a agregar.
     */
    public void updateDirectorCost(float additionalCost) {
        try {
            costsMutex.acquire();  // Protección contra concurrencia
            directorCost += additionalCost;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            costsMutex.release();
        }
    }

    // Getters y Setters

    public int getComputers() {
        return computers;
    }

    public void setComputers(int computers) {
        this.computers = computers;
    }

    public int getComputersWithGraphicsCards() {
        return computersWithGraphicsCards;
    }

    public void setComputersWithGraphicsCards(int computersWithGraphicsCards) {
        this.computersWithGraphicsCards = computersWithGraphicsCards;
    }

    public float getUtility() {
        return utility;
    }

    public void setUtility(float utility) {
        this.utility = utility;
    }

    public int getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public int getPmStatus() {
        return pmStatus;
    }

    public void setPmStatus(int pmStatus) {
        this.pmStatus = pmStatus;
    }

    public int getDirectorStatus() {
        return directorStatus;
    }

    public void setDirectorStatus(int directorStatus) {
        this.directorStatus = directorStatus;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public float getSalaryDiscount() {
        return salaryDiscount;
    }

    public void setSalaryDiscount(float salaryDiscount) {
        this.salaryDiscount = salaryDiscount;
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

    public int getDaysUntilRelease() {
        return daysUntilRelease;
    }

    public void setDaysUntilRelease(int daysUntilRelease) {
        this.daysUntilRelease = daysUntilRelease;
    }

    public Semaphore getDaysMutex() {
        return daysMutex;
    }

    public Semaphore getCostsMutex() {
        return costsMutex;
    }
    
    public Semaphore getConsumerMutex(){
        return warehouse.getConsumerSemaphore();
    }
}
