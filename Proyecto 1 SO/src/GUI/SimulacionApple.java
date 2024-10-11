/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Companies.Company;
import Primitivas.Lista;
import Store.Drive;
import Worker.Worker;
import proyecto.pkg1.so.Global;

/**
 *
 * @author Moises Liota
 */
public class SimulacionApple extends Thread {
    private Apple ventanaApple;  // Referencia a la ventana de Apple
    private Company appleCompany;  // Compañía Apple
    private int diasSimulacion = Global.daysBetweenReleases;  // Días de la simulación
    private Worker projectManager;
    private Worker director;

    public SimulacionApple(Apple ventana, Company company) {
        this.ventanaApple = ventana;
        this.appleCompany = company;
    }

    @Override
    public void run() {
        // Identificar los hilos del Project Manager y el Director
        Lista pmLista = appleCompany.getEmployees()[6];  // Posición 6: Project Manager
        Lista directorLista = appleCompany.getEmployees()[7];  // Posición 7: Director
        
        projectManager = (Worker) pmLista.obtenerNodo(0).getData();  // Obtener el PM
        director = (Worker) directorLista.obtenerNodo(0).getData();  // Obtener el Director
        
        // Establecer la duración del día para ambos
        projectManager.setDayDuration((int) Global.daysDuration);
        director.setDayDuration((int) Global.daysDuration);
        
        // Iniciar ambos hilos
        projectManager.start();
        director.start();

        // Imprimir el estado inicial ANTES de iniciar los hilos de los demás trabajadores
        actualizarInterfaz();

        // Iniciar los hilos del resto de los trabajadores solo una vez
        for (int i = 0; i < appleCompany.getEmployees().length; i++) {
            if (i == 6 || i == 7) continue;  // Saltar al PM y Director, ya iniciados

            Lista empleados = appleCompany.getEmployees()[i];
            for (int j = 0; j < empleados.getSize(); j++) {
                Worker worker = (Worker) empleados.obtenerNodo(j).getData();
                worker.setDayDuration((int) Global.daysDuration);  // Establecer la duración del día
                worker.start();  // Iniciar hilo de trabajador
            }
        }

        // Simulación del paso del tiempo en la compañía (30 días)
        for (int day = 1; day <= diasSimulacion; day++) {
            Global.daysBetweenReleases--;
            try {
                Thread.sleep(1000);  // Espera según la duración del día simulada
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Actualizar la interfaz gráfica con los nuevos valores del almacén
            actualizarInterfaz();
        }

        // Finalizar los hilos después de la simulación
        detenerHilos();
    }

    private void actualizarInterfaz() {
        Drive appleDrive = appleCompany.getDrive();

        // Obtener los costos actuales (usando métodos de Drive)
        double costosActuales = appleDrive.calcularCostos();
        
        double costosMotherboards = appleDrive.getMotherboardCost();
        double costosCPUs = appleDrive.getCpuCost();
        double costosRAM = appleDrive.getRamCost();
        double costosPowerSupply = appleDrive.getPowerSupplyCost();
        double costosGPU = appleDrive.getCpus();
        
        // Obtener el estado del PM y Director del almacén
        String estadoPM = appleDrive.getEstadoPM();
        String estadoDirector = appleDrive.getEstadoDirector();
        
        double sueldoDirector = appleDrive.getDirectorCost();
        double sueldoPM = appleDrive.getPmCost();

        // Asegurarse de que la actualización de la GUI se haga en el hilo de eventos de Swing
        javax.swing.SwingUtilities.invokeLater(() -> {
            ventanaApple.actualizarValores(
                appleDrive.getMotherboards(),
                appleDrive.getCpus(),
                appleDrive.getRamModules(),
                appleDrive.getPowerSupplies(),
                appleDrive.getGpus(),
                appleDrive.getStandardComputers(),
                appleDrive.getComputersWithGPU(),
                Global.daysBetweenReleases,   // Días restantes
                costosActuales,   // Costos actuales
                estadoPM,         // Estado del PM
                estadoDirector,   // Estado del Director
                sueldoPM,         // Sueldo acumulado del PM
                sueldoDirector    // Sueldo acumulado del Director
            );
            
            ventanaApple.actualizarCostosComponentes(
                    costosMotherboards,
                    costosCPUs,
                    costosRAM,
                    costosPowerSupply,
                    costosGPU
            );
        });
    }

    public void detenerHilos() {
        // Detener el PM y el Director explícitamente
        projectManager.stopWorker();
        director.stopWorker();

        // Detener los hilos del resto de los trabajadores
        for (int i = 0; i < appleCompany.getEmployees().length; i++) {
            if (i == 6 || i == 7) continue;  // Saltar al PM y Director, ya detenidos

            Lista empleados = appleCompany.getEmployees()[i];
            for (int j = 0; j < empleados.getSize(); j++) {
                Worker worker = (Worker) empleados.obtenerNodo(j).getData();
                worker.stopWorker();  // Detener hilo
            }
        }

        // Esperar a que todos los hilos terminen
        for (int i = 0; i < appleCompany.getEmployees().length; i++) {
            Lista empleados = appleCompany.getEmployees()[i];
            for (int j = 0; j < empleados.getSize(); j++) {
                Worker worker = (Worker) empleados.obtenerNodo(j).getData();
                try {
                    worker.join();  // Esperar a que el hilo termine
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
