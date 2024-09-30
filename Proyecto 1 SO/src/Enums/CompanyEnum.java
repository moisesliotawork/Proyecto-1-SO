/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enums;

/**
 * Permite identificar a cada compañía
 * @author vickysaldivia
 */
public enum CompanyEnum {
    Apple(0),
    Dell(1);
    
    private final int id;
    
    private CompanyEnum(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
}
