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
public class DellRules extends CompanyRules{
    /**
     * Genera los datos necesarios que tienen que ver con la compañía Dell.
     */
    public DellRules() {

        // Elementos necesarios para ensamblar una computadora estándar en Dell
        this.motherboardsNeeded = 1;
        this.cpusNeeded = 5;
        this.ramModulesNeeded = 6;
        this.powerSuppliesNeeded = 5;
        this.gpusNeeded = 1;  // Solo para computadoras con GPU

        // Ingresos por computadora estándar y con GPU
        this.incomeStandard = 80000f;
        this.incomeWithGPU = 120000f;

        // Regla: cada 3 computadoras estándar, se produce una con GPU
        this.computersToComputersWithGPU = 3;

        // Número máximo de empleados
        this.employees = 18;

        this.companyEnum = CompanyEnum.Dell;
    }
}
