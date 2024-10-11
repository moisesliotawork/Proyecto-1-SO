/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rules;

import Enums.CompanyEnum;

/**
 *
 * @author Moises Liota
 */
public class AppleRules extends CompanyRules{
    /**
     * Genera los datos necesarios que tienen que ver con la compañía Apple.
     */
    public AppleRules() {

        // Elementos necesarios para ensamblar una computadora estándar en Apple
        this.motherboardsNeeded = 2;
        this.cpusNeeded = 1;
        this.ramModulesNeeded = 4;
        this.powerSuppliesNeeded = 4;
        this.gpusNeeded = 2;  // Solo para computadoras con GPU

        // Ingresos por computadora estándar y con GPU
        this.incomeStandard = 100000f;
        this.incomeWithGPU = 150000f;

        // Regla: cada 5 computadoras estándar, se produce una con GPU
        this.computersToComputersWithGPU = 5;

        // Número máximo de empleados
        this.employees = 20;

        this.companyEnum = CompanyEnum.Apple;
    }
}
