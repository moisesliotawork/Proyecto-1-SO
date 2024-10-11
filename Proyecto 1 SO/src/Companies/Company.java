/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Companies;

import Enums.WorkerTypeEnum;
import Primitivas.Lista;
import Primitivas.Nodo;
import Rules.CompanyRules;
import Store.Drive;
import Worker.Worker;
import Worker.WorkerFactory;
import javax.swing.JOptionPane;
import proyecto.pkg1.so.Global;

/**
 *
 * @author Moises Liota
 */
public class Company {

    private CompanyRules rules;
    private Drive drive;

    /*
    employees[0] => MotherboardProducer
    employees[1] => CPUProducer
    employees[2] => RAMProducer
    employees[3] => PowerSupplyProducer
    employees[4] => GPUProducer
    employees[5] => Assembler
    employees[6] => Project Manager (PM)
    employees[7] => Director
     */
    private Lista[] employees = new Lista[8];
    private int amountOfEmployees;
    private int vacancy;

    /**
     * Constructor de la compañía.
     *
     * @param numberOfMotherboardProducers int - número de productores de placas
     * base
     * @param numberOfCPUProducers int - número de productores de CPUs
     * @param numberOfRAMProducers int - número de productores de RAM
     * @param numberOfPowerSupplyProducers int - número de productores de
     * fuentes de poder
     * @param numberOfGPUProducers int - número de productores de GPUs
     * @param numberOfAssemblers int - número de ensambladores por default
     * @param drive Drive - Almacén de componentes de la compañía
     * @param rules CompanyRules - Reglas de la compañía
     *
     */
    public Company(int numberOfMotherboardProducers, int numberOfCPUProducers, int numberOfRAMProducers, int numberOfPowerSupplyProducers, int numberOfGPUProducers, int numberOfAssemblers, Drive drive, CompanyRules rules) {
        WorkerFactory workerFactory = new WorkerFactory();

        // Inicializo las listas de empleados
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Lista();
        }

        // Creo los Motherboard Producers
        for (int i = 0; i < numberOfMotherboardProducers; i++) {
            Worker motherboardWorker = workerFactory.makeWorker(WorkerTypeEnum.MotherboardProducer, drive, drive.getProducerMutex(), rules);
            employees[0].insertarFinal(motherboardWorker);
        }

        // Creo los CPU Producers
        for (int i = 0; i < numberOfCPUProducers; i++) {
            Worker cpuWorker = workerFactory.makeWorker(WorkerTypeEnum.CPUProducer, drive, drive.getProducerMutex(), rules);
            employees[1].insertarFinal(cpuWorker);
        }

        // Creo los RAM Producers
        for (int i = 0; i < numberOfRAMProducers; i++) {
            Worker ramWorker = workerFactory.makeWorker(WorkerTypeEnum.RAMProducer, drive, drive.getProducerMutex(), rules);
            employees[2].insertarFinal(ramWorker);
        }

        // Creo los Power Supply Producers
        for (int i = 0; i < numberOfPowerSupplyProducers; i++) {
            Worker powerSupplyWorker = workerFactory.makeWorker(WorkerTypeEnum.PowerSupplyProducer, drive, drive.getProducerMutex(), rules);
            employees[3].insertarFinal(powerSupplyWorker);
        }

        // Creo los GPU Producers
        for (int i = 0; i < numberOfGPUProducers; i++) {
            Worker gpuWorker = workerFactory.makeWorker(WorkerTypeEnum.GPUProducer, drive, drive.getProducerMutex(), rules);
            employees[4].insertarFinal(gpuWorker);
        }

        // Creo los Assembler
        for (int i = 0; i < numberOfAssemblers; i++) {
            Worker assemblerWorker = workerFactory.makeWorker(WorkerTypeEnum.Assembler, drive, drive.getProducerMutex(), rules);
            employees[5].insertarFinal(assemblerWorker);
        }

        // Creo al Project Manager (PM)
        Worker PM = workerFactory.makeWorker(WorkerTypeEnum.ProjectManager, drive, drive.getProducerMutex(), rules);
        employees[6].insertarFinal(PM);

        // Creo al Director
        Worker director = workerFactory.makeWorker(WorkerTypeEnum.Director, drive, drive.getProducerMutex(), rules);
        employees[7].insertarFinal(director);

        // Actualizo la cantidad total de empleados y las vacantes
        this.amountOfEmployees = numberOfMotherboardProducers + numberOfCPUProducers + numberOfRAMProducers + numberOfPowerSupplyProducers + numberOfGPUProducers + numberOfAssemblers;
        this.vacancy = rules.getEmployees() - amountOfEmployees;

        this.drive = drive;
        this.rules = rules;
    }

    /**
     * Despide a un empleado
     *
     * @param type int - tipo de empleado que se va a despedir
     */
    public void fireEmployee(int type) {
        if (amountOfEmployees > 0) {
            boolean eliminado = employees[type].eliminarFinal();
            if (eliminado) {
                amountOfEmployees--;
                vacancy++;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay más empleados para despedir");
        }
    }

    /**
     * Contrata a un empleado
     *
     * @param type int - tipo de empleado que se va a contratar
     */
    public void hireEmployee(int type) {
        if (vacancy > 0) {
            WorkerFactory workerFactory = new WorkerFactory();
            switch (type) {
                case 0:
                    Worker motherboardWorker = workerFactory.makeWorker(WorkerTypeEnum.MotherboardProducer, drive, drive.getProducerMutex(), rules);
                    employees[0].insertarFinal(motherboardWorker);
                    break;
                case 1:
                    Worker cpuWorker = workerFactory.makeWorker(WorkerTypeEnum.CPUProducer, drive, drive.getProducerMutex(), rules);
                    employees[1].insertarFinal(cpuWorker);
                    break;
                case 2:
                    Worker ramWorker = workerFactory.makeWorker(WorkerTypeEnum.RAMProducer, drive, drive.getProducerMutex(), rules);
                    employees[2].insertarFinal(ramWorker);
                    break;
                case 3:
                    Worker powerSupplyWorker = workerFactory.makeWorker(WorkerTypeEnum.PowerSupplyProducer, drive, drive.getProducerMutex(), rules);
                    employees[3].insertarFinal(powerSupplyWorker);
                    break;
                case 4:
                    Worker gpuWorker = workerFactory.makeWorker(WorkerTypeEnum.GPUProducer, drive, drive.getProducerMutex(), rules);
                    employees[4].insertarFinal(gpuWorker);
                    break;
                case 5:
                    Worker assemblerWorker = workerFactory.makeWorker(WorkerTypeEnum.Assembler, drive, drive.getProducerMutex(), rules);
                    employees[5].insertarFinal(assemblerWorker);
                    break;
            }
            vacancy--;
            amountOfEmployees++;
        } else {
            JOptionPane.showMessageDialog(null, "No hay presupuesto para contratar más personal.");
        }
    }

    /**
     * Despide a todos los empleados en caso de quiebra
     */
    public void bankrupcy() {
        for (Lista employee : employees) {
            int size = employee.getSize();
            for (int j = 0; j < size; j++) {
                employee.eliminarFinal();
                System.out.println("Empleado despedido: " + j);
            }
        }
    }

    /**
     * Actualiza el tiempo de trabajo de todos los empleados
     */
    public void updateTimes() {
        for (Lista employeeList : employees) {
            for (int j = 0; j < employeeList.getSize(); j++) {
                Nodo temp = employeeList.obtenerNodo(j);
                if (temp != null) {
                    Worker worker = (Worker) temp.getData();
                    worker.setDayDuration((int) Global.daysDuration);
                }
            }
        }
    }

    // Getters y Setters
    public CompanyRules getRules() {
        return rules;
    }

    public void setRules(CompanyRules rules) {
        this.rules = rules;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public Lista[] getEmployees() {
        return employees;
    }

    public void setEmployees(Lista[] employees) {
        this.employees = employees;
    }

    public int getAmountOfEmployees() {
        return amountOfEmployees;
    }

    public void setAmountOfEmployees(int amountOfEmployees) {
        this.amountOfEmployees = amountOfEmployees;
    }

    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }
}
