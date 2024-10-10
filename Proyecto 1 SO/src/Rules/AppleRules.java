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
    public AppleRules() {
        // Elementos necesarios para ensamblar una computadora
        this.motherboardsNeedIt = 2;
        this.cpusNeedIt = 1;
        this.ramNeedIt = 4;
        this.powerSupplyNeedIt = 4;
        this.graphicsCardNeedIt = 2; // Para computadoras con tarjeta gráfica

        // Ganancias
        this.incomeStandard = 100000f;
        this.incomeGraphicsCard = 150000f;

        // Intervalo para ensamblar computadoras con tarjeta gráfica
        this.computersToGraphicsCard = 5;  // Después de ensamblar 5 computadoras estándar, la siguiente tendrá 2 tarjetas gráficas

        // Identificador de la compañía
        this.companyEnum = CompanyEnum.Apple;
    }
}
