/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enums;

/**
 * Permite identificar a los tipos de trabajadores
 * @author vickysaldivia
 */
public enum WorkerTypeEnum {
     /**Productor de placas base*/
    MotherboardProducer(0),
    /**Productor de CPUs*/
    CPUProducer(1),
    /**Productor de Memoria RAM*/
    RAMProducer(2),
    /**Productor de fuentes de alimentación*/
    PowerSupplyProducer(3),
    /**Productor de tarjetas gráficas*/
    GPUProducer(4),
    /**Ensamblador de computadoras*/
    Assembler(5),
    /**Es el que registra el paso de los días*/
    ProjectManager(6),
    /**Revisa la DEADLINE y envía los equipos*/
    Director(7);

    private final int id;

    /**
     * Constructor oculto para no crear sino solo ver tipos de trabajos
     * @param id int - identificador único del tipo de trabajo
     */
    private WorkerTypeEnum(int id) {
        this.id = id;
    }

    // Getter para obtener el identificador único del tipo de trabajo
    public int getId() {
        return id;
    }
}
