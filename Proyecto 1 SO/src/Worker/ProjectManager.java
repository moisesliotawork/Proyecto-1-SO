/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Worker;

import Enums.WorkerTypeEnum;
import Rules.CompanyRules;
import Store.Drive;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Moises Liota
 */
public class ProjectManager extends Worker{
    private final Drive drive;

    public ProjectManager(WorkerTypeEnum type, float cph, Semaphore m, CompanyRules gameRules, Drive drive) {
        super(type, cph, m, gameRules);
        this.drive = drive;
        this.hired = true;
    }

    @Override
    public void run() {
       while (hired && running) {
            try {
                // Media hora simulada = duración de un día dividido por 48
                double halfHour = getDayDuration() / 48;
                int counter = 0;

                // PM trabaja 16 horas por día (simulación)
                while (counter < 16) {
                     
                    // El PM está supervisando la producción (estado de trabajo)
                    drive.setPmStatus(0);

                    // Si el Director lo está vigilando y el PM no está supervisando bien
                    if (drive.getDirectorStatus() == 0) {
                        // Se le registra una falta y un descuento salarial
                        drive.setFaltas(drive.getFaltas() + 1);
                        drive.setSalaryDiscount(drive.getSalaryDiscount() + 50); // Se registra una multa

                        // Descuento del salario por la falta
                        drive.getCostsMutex().acquire();
                        
                        drive.setPmCost(drive.getPmCost() - 50);  // Descuento de $50 por la falta
                        
                        drive.getCostsMutex().release();
                    }

                    // El PM supervisa durante media hora simulada
                    sleep(Math.round(halfHour));

                    // El PM "toma un descanso" (cambia el estado)
                    drive.setPmStatus(1);
                    sleep(Math.round(halfHour));

                    // Aumenta el contador de horas trabajadas
                    counter++;
                }

                // El PM vuelve al estado de trabajo (0)
                drive.setPmStatus(0);

                // Descansa el resto del día (8 horas = 16 medias horas)
                sleep(Math.round(halfHour * 16));

                // Reduce los días restantes hasta la entrega de productos
                drive.getDaysMutex().acquire();
                drive.setDaysUntilRelease(drive.getDaysUntilRelease() - 1);
                drive.getDaysMutex().release();

                // Cálculo del salario por el día de trabajo completo (24 horas)
                drive.getCostsMutex().acquire();
                drive.setPmCost(drive.getPmCost() + costPerHour * 24);  // Se le paga el salario diario completo
                drive.getCostsMutex().release();

            } catch (InterruptedException e) {
                System.out.println("Error en ProjectManager: " + e.getMessage());
            }
        }
    }

    @Override
    public void Work() {
        // El Project Manager no realiza un trabajo específico, solo supervisa la producción
        throw new UnsupportedOperationException("El Project Manager no tiene un trabajo específico que realizar.");
    }
}
