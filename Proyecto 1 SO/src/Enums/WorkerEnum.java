/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enums;

/**
 * Permite identificar a los tipos de trabajadores
 * @author vickysaldivia
 */
public enum WorkerEnum {
    /** Productor de Placa Base */
    BaseProducer(0),
    
    /** Productor de CPU */
    CPUProducer(1),
    
    /** Productor de Memoria RAM */
    RAMProducer(2),
    
    /** Productor de Fuente de Alimentación */
    PowerSupplyProducer(3),
    
    /** Productor de Tarjeta Gráfica */
    GraphicsCardProducer(4),
    
    /** Ensamblan el computador con componentes del almacén */
    Assembler(5),
    
    /** Mantiene registro de los días */
    ProjectManager(6),
    
    /** Conoce el deadline y entrega los productos */
    Director(7);
    
    private final int id;
    
    /** Permite conocer el id de los tipos de trabajadores*/
    private WorkerEnum(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
}
