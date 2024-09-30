/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Primitivas;

/**
 *
 * @author vickysaldivia
 * @param <T>
 */

public class Nodo<T> {
    private T data; // Atributo que almacenará la información. 
                    // T establece que la variable es de cualquier tipo
    private Nodo pNext; // Recursivo. Aqui se guarda el siguiente nodo
    
    // ----- CONSTRUCTORES -----
    // Creamos tres Constructores
    
    // Para crear un Nodo sin información
    public Nodo(){ // No se le pasa nada por parámetro
        this.data = null;
        this.pNext = null;   
    }
    
    // Para crear un Nodo con información pero sin enlazarlo
    public Nodo(T data){
        this.data = data;
        this.pNext = null;
    }
    
    // Para crear un Nodo con toda la información
    public Nodo(T data, Nodo nodo){
        this.data = data;
        this.pNext = nodo;
    }
    // ----- CONSTRUCTORES -----
    
    
    // ----- GETTERS Y SETTERS -----
    // Para acceder y modificar los atributoss
    
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Nodo getpNext() {
        return pNext;
    }

    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    } 
    
    // ----- GETTERS Y SETTERS -----
}
