/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.pkg1.so;

import Companies.Company;
import GUI.Menu;
import Primitivas.Lista;
import Rules.DellRules;
import Store.Drive;
import Worker.Worker;

/**
 *
 * @author vickysaldivia
 */
public class Proyecto1SO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu interfaz = new Menu();
        interfaz.setResizable(false);
        interfaz.setLocationRelativeTo(null);  
        interfaz.setVisible(true);
        // Inicializa las reglas específicas de Dell
//        DellRules dellRules = new DellRules();
//
//        // Inicializa el almacenamiento (Drive) de la compañía con todos los componentes en 0
//        Drive dellDrive = new Drive(0, 0, 0, 0, 0);  // Se inicializa el drive con 0 en cada componente
//
//        // Número de empleados para cada tipo de trabajador en Dell
//        int numMotherboardProducers = 2;
//        int numCPUProducers = 10;
//        int numRAMProducers = 3;
//        int numPowerSupplyProducers = 1;
//        int numGPUProducers = 1;
//        int numAssemblers = 1;
//
//        // Crear la compañía Dell con los empleados especificados
//        Company dell = new Company(
//                numMotherboardProducers,
//                numCPUProducers,
//                numRAMProducers,
//                numPowerSupplyProducers,
//                numGPUProducers,
//                numAssemblers,
//                dellDrive,
//                dellRules
//        );
//
//        // Define la duración del día en la simulación (por ejemplo, 1 segundo por día simulado)
//        Global.daysDuartion = 1000; // Un día simulado es 1 segundo real
//
//        // Imprimir el estado inicial ANTES de iniciar los hilos de los trabajadores
//        System.out.println("Componentes iniciales en el almacén de Dell:");
//        printDriveStatus(dellDrive);
//
//        // Iniciar todos los hilos de los trabajadores UNA sola vez
//        for (int i = 0; i < dell.getEmployees().length; i++) {
//            Lista empleados = dell.getEmployees()[i];
//            for (int j = 0; j < empleados.getSize(); j++) {
//                Worker worker = (Worker) empleados.obtenerNodo(j).getData();
//                worker.setDayDuration((int) Global.daysDuartion); // Asegurarse de que los trabajadores usen la misma duración del día
//                worker.start();  // Iniciar el hilo solo una vez
//            }
//        }
//
//        // Simulación del paso del tiempo en la compañía
//        // Simulamos 30 días
//        for (int day = 1; day <= 30; day++) {
//            System.out.println("Día " + day + ": Simulando...");
//
//            // Esperar un tiempo simulado antes de pasar al siguiente día
//            try {
//                Thread.sleep((long) Global.daysDuartion);  // Espera según la duración del día simulada
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            // Verificar el estado del Drive (almacenamiento)
//            printDriveStatus(dellDrive);
//        }
//
//        // Aquí, detenemos todos los hilos de los trabajadores
//        for (int i = 0; i < dell.getEmployees().length; i++) {
//            Lista empleados = dell.getEmployees()[i];
//            for (int j = 0; j < empleados.getSize(); j++) {
//                Worker worker = (Worker) empleados.obtenerNodo(j).getData();
//                worker.stopWorker();  // Detiene el hilo
//            }
//        }
//
//        // Luego, esperamos que terminen los hilos
//        for (int i = 0; i < dell.getEmployees().length; i++) {
//            Lista empleados = dell.getEmployees()[i];
//            for (int j = 0; j < empleados.getSize(); j++) {
//                Worker worker = (Worker) empleados.obtenerNodo(j).getData();
//                try {
//                    worker.join();  // Espera a que el hilo termine
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        System.out.println("Simulación de la compañía Dell terminada.");
//    }
//
//    // Método para imprimir el estado del almacén
//    private static void printDriveStatus(Drive drive) {
//        System.out.println("Motherboards: " + drive.getMotherboards());
//        System.out.println("CPUs: " + drive.getCpus());
//        System.out.println("RAM Modules: " + drive.getRamModules());
//        System.out.println("Power Supplies: " + drive.getPowerSupplies());
//        System.out.println("GPUs: " + drive.getGpus());
//        System.out.println("Computadoras ensambladas: " + drive.getStandardComputers());
//        System.out.println("Computadoras con GPU ensambladas: " + drive.getComputersWithGPU());
    }

}
