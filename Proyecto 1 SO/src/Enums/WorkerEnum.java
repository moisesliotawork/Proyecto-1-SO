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
    PlacaBase(0),
    
    /** Productor de CPU */
    Procesador(1),
    
    /** Productor de Memoria RAM */
    MemoriaRAM(2),
    
    /** Productor de Fuente de Alimentación */
    FuenteAlimentacion(3),
    
    /** Productor de Tarjeta Gráfica */
    TarjetaGrafica(4),
    
    /** Ensamblan el computador con componentes del almacén */
    Ensamblador(5),
    
    /** Mantiene registro de los días */
    Manager(6),
    
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
