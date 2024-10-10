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
    public DellRules() {
        // Elementos necesarios para ensamblar una computadora
        this.motherboardsNeedIt = 1;
        this.cpusNeedIt = 5;
        this.ramNeedIt = 6;
        this.powerSupplyNeedIt = 5;
        this.graphicsCardNeedIt = 1; // Para computadoras con tarjeta gráfica

        // Ganancias
        this.incomeStandard = 80000f;
        this.incomeGraphicsCard = 120000f;

        // Intervalo para ensamblar computadoras con tarjeta gráfica
        this.computersToGraphicsCard = 3;  // Después de ensamblar 3 computadoras estándar, la siguiente tendrá 1 tarjeta gráfica

        // Identificador de la compañía
        this.companyEnum = CompanyEnum.Dell;
    }
}
