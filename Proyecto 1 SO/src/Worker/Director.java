/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Worker;

import Enums.WorkerTypeEnum;
import Rules.CompanyRules;
import Store.Drive;
import java.util.Random;
import java.util.concurrent.Semaphore;
import proyecto.pkg1.so.Global;


/**
 *
 * @author Moises Liota
 */
public class Director extends Worker{
     private final Drive drive;

    public Director(WorkerTypeEnum wte, float f, Semaphore smphr, CompanyRules cr, Drive drive) {
        super(wte, f, smphr, cr);
        this.drive = drive;
        this.hired = true;
    }

    @Override
    public void run() {
       while (hired && running) {
            double timePassed = 0;
            try {
                // Verifica si es el día del lanzamiento de computadoras ensambladas
                drive.getDaysMutex().acquire();
                if (drive.getDaysUntilRelease() <= 0) {
                    // Calcula las ganancias: venta de computadoras estándar y con GPU
                    drive.getConsumerMutex().acquire();
                    drive.setEarnings(drive.getEarnings() + 
                        (drive.getStandardComputers() * companyRules.getIncomeStandard()) + 
                        (drive.getComputersWithGPU() * companyRules.getIncomeWithGPU()));

                    // Resetea el contador de computadoras
                    drive.setStandardComputers(0);
                    drive.setComputersWithGPU(0);

                    // Reinicia los días hasta el próximo lanzamiento
                    drive.setDaysUntilRelease(Global.daysBetweenReleases);
                    drive.getDaysMutex().release();
                    drive.getConsumerMutex().release();

                    // El Director descansa durante un ciclo de día completo
                    sleep(getDayDuration());
                } else {
                    drive.getDaysMutex().release();

                    // El Director elige una hora del día aleatoriamente para supervisar
                    Random r = new Random();
                    double oneHour = getDayDuration() / 24;  // Un día tiene 24 horas simuladas
                    double checkingHour = r.nextInt(24) * oneHour;  // Elige una hora aleatoria del día para revisar
                    timePassed = (checkingHour + 1) * oneHour;

                    double contador = 0;
                    while (contador < getDayDuration()) {
                        if (contador == checkingHour) {
                            // El Director empieza a supervisar (estado = 0)
                            drive.setDirectorStatus(0);

                            // Dura 25 minutos supervisando
                            double oneMinute = oneHour / 60;
                            sleep(Math.round(25 * oneMinute));

                            // El Director deja de supervisar (estado = 1)
                            drive.setDirectorStatus(1);

                            // Dura 35 minutos descansando
                            sleep(Math.round(35 * oneMinute));
                        }
                        // Avanza una hora simulada
                        sleep(Math.round(oneHour));
                        contador += oneHour;
                    }
                }

                // Cálculo del salario diario del Director
                drive.getCostsMutex().acquire();
                drive.setDirectorCost(drive.getDirectorCost() + costPerHour * 24);  // Salario por 24 horas de trabajo
                drive.getCostsMutex().release();

            } catch (InterruptedException e) {
                System.out.println("Error en Director: " + e.getMessage());
            }
        }
    }

    @Override
    public void Work() {
        // El Director no realiza un trabajo específico, solo supervisa y maneja las ganancias
        throw new UnsupportedOperationException("El Director no tiene un trabajo específico definido.");
    }
}
