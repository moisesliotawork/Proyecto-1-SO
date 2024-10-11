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

public class Lista<T>{
    // Atributos
    // Se establece la cabeza y longitud, en casos el último
    private Nodo pFirst; // Cabeza
    private int size; // Longitud
    
    // ----- CONSTRUCTOR -----
    public Lista(){ // Siempre se empieza una lista vacía
        this.pFirst = null;
        this.size = 0; // Todavía no contiene nodos
    }
    // ----- CONSTRUCTOR -----
    
    
    // ----- GETTERS Y SETTERS -----
    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    // ----- GETTERS Y SETTERS -----
    
    
    // ------- PRIMITIVAS -------
    // Verificar si está vacío. Devuelve booleano (boolean)
    public boolean esVacio(){
        return this.pFirst == null;
    }
    
    // Vaciar la lista. No devuelve nada (void)
    public void vaciarLista(){
        this.pFirst = null;
        this.size = 0;
    }
    
    // Insertar un nodo al inicio. Poseo la información que va a contener
    public Nodo insertarInicio(T data){
        // Creamos un nuevo nodo
        Nodo newNode = new Nodo(data);
        
        // Verificar si la lista está vacía
        if(esVacio()){
            this.pFirst = newNode; // Establezco el nuevo nodo como primero de la lista
        }else{
            newNode.setpNext(pFirst); // Establezco el siguiente de newNode como pFirst
            this.pFirst = newNode; // Establezco el nuevo nodo como primero de la lista
        }
        
        this.size++; // incremento el tamaño
        return newNode;
    }
    
    // Insertar nodo al final. Poseo la información que va a contener
    public Nodo insertarFinal(T data){
        Nodo newNode = new Nodo(data);
        
        // Verificar si la lista está vacía
        if(esVacio()){
            this.pFirst = newNode; // El primer nodo será el nuevo
        }else{
            Nodo aux = this.pFirst; // Creamos un nodo auxiliar que tome el valor de pFirst
            while(aux.getpNext() != null){ // Mientras que el siguiente de mi auxiliar NO sea null:
                aux = aux.getpNext(); // Le asigno a mi aux el siguiente
            }
            aux.setpNext(newNode); // Setteo el next del último el nuevo
        }
        
        this.size ++;
        return newNode;
    }
    
    // Insertar nodo por posición. Conozco la info del nodo y la posición en la que se quiere insertar
    public Nodo insertarPorPosicion(int posicion, T data){

        // Evaluamos si la posición insertada es válida
        if (posicion <= this.size && posicion > 0){ 
            Nodo newNode = new Nodo(data);
            
            if(posicion == 0){ // Evaluamos si se quiere insertar al principio
                newNode = this.insertarInicio(data);
                
            }else if (posicion == (this.size -1)){ // Evaluamos si se quiere insertar al final
                newNode = this.insertarFinal(data);
                
            }else{
                Nodo aux = this.pFirst; // Creo un auxiliar que tome el valor del pFirst
                // Busco posicionarme en el nodo anterior a la posición indicada
                for (int i = 0; i < (posicion-1); i++) {
                    aux = aux.getpNext();
                }
                
                Nodo newNext = aux.getpNext(); // Guardo el siguiente al auxiliar
                aux.setpNext(newNode); // Establezco el siguiente del auxiliar como el nuevo
                newNode.setpNext(newNext); // Establexco el siguiente del nuevo como newNext
            }
            this.size++;
            return newNode;
        }
        return null; // Devuelvo null si es inválida la posición
    }
    
    // Insertar nodo por referencia (informacion del nodo)
    public Nodo insertarPorReferencia(T ref, T data){
        if(!esVacio()){ // Si no está vacía
            Nodo nodoRef = this.buscarNodoRef(ref); // Busco si existe el nodo
            
            if(nodoRef != null){
                Nodo newNode = new Nodo(data);
                Nodo nodoSiguiente = nodoRef.getpNext();
                
                nodoRef.setpNext(newNode);
                newNode.setpNext(nodoSiguiente);
                return newNode;
                
            }else{
                return null;
            }
        }
        return null;
    }
    
    // Transformar una lista en string
    public String listaAString(){
        if(!esVacio()){
            
            Nodo aux = this.pFirst;
            String string = "";
            
            for (int i = 0; i < this.size; i++) {
                string += aux.getData().toString() + "\n"; // Concateno al string la info y un salto de línea
                aux = aux.getpNext();
            }
            return string;
        }else{
            return "Lista vacía";
        }
    }
    
    // Eliminar el primer elemento de la lista
    public void eliminarInicio(){
        if(!esVacio()){
            if(this.size == 1){
                this.vaciarLista();
            }else{
                this.pFirst = this.pFirst.getpNext(); // Asigno el siguiente del primero como la cabeza
                size --; // Disminuyo el tamaño
            }
        }
    }
    
    // Eliminar el último elemento de la lista
    public boolean eliminarFinal(){
        if(!esVacio()){
            if(this.size == 1){ // Si nada mas había un elemento, vaciamos
                this.vaciarLista();
            }else{
                Nodo aux = this.pFirst; // Nodo auxiliar
                while(aux.getpNext().getpNext() != null){ // Se ejectua hasta el penultimo. (Penultimo)->(Ultimo)->Null
                    aux = aux.getpNext();
                }
                aux.setpNext(null);
            }
            return true;
        }
        return false;
    }
    
    // Eliminar un nodo por referencia
    public void eliminarPorReferencia(T data){
        if(buscarNodoRef2(data)){ // Si existe el nodo:
            Nodo aux = this.pFirst;
            
            if(aux.getData() == data){
                this.eliminarInicio();
            }else{
                while(aux.getpNext().getData() != data){ // Mientras que no AUX -> (NODO CON DATA)
                    aux = aux.getpNext();                   
                }
                Nodo siguiente = aux.getpNext().getpNext();
                aux.setpNext(siguiente); // Le asigno el siguiente del siguiente
            }
            size--;
        }
    }
    
    // Eliminar por posicion
    public void eliminarPorPosicion(int posicion){
        if(!esVacio() && posicion >= 0 && posicion < this.size){
            if(posicion == 0){
                this.eliminarInicio();
            }else if(posicion == this.size){
                this.eliminarFinal();
            }else{
                Nodo aux = this.pFirst;
                for (int i = 0; i < posicion-1; i++) {
                    aux = aux.getpNext();
                }
                Nodo siguiente = aux.getpNext().getpNext();
                aux.setpNext(siguiente); // Le asigno el siguiente del siguiente
            }
            size--;
        }
    }
    
    // Editar contenido por Referencia
    public Nodo editarPorReferencia(T data, T new_data){
        if(!esVacio()){
            Nodo aux = this.buscarNodoRef(data);
            if(aux!= null){
                aux.setData(new_data);
                return aux;
            }
            return null;
        }
        return null;
    }
    
    // Editar contenido por posicion
    public Nodo editarPorPosicion(int posicion, T new_data){
        if(!esVacio()){
            Nodo aux = this.buscarNodoPos(posicion);
            if(aux != null){
                aux.setData(aux);
                return aux;
            }
            return null;
        }
        return null;
    }
    
    // Buscar un nodo por su referencia
    public Nodo buscarNodoRef(T data){
        if(!esVacio()){
            Nodo aux = this.pFirst; // Nodo auxiliar
            
            for (int i = 0; i < (this.size-1); i++) { // Voy a recorrer toda la lista
                if(aux.getData() == data){
                    return aux; // Si encuentra coincidencia, devuelve
                }else{
                    aux = aux.getpNext(); // Si no pasa al siguiente
                }
            }
            return null; // En caso de que no haya coincidencia y se acabó, devuelve nulo
        }
        return null;
    }
    
    // Buscar un nodo por su referencia. Devuelve bool
    public boolean buscarNodoRef2(T data){
        if(!esVacio()){
            Nodo aux = this.pFirst; // Nodo auxiliar
            
            for (int i = 0; i < (this.size-1); i++) { // Voy a recorrer toda la lista
                if(aux.getData() == data){
                    return true; // Si encuentra coincidencia, devuelve
                }else{
                    aux = aux.getpNext(); // Si no pasa al siguiente
                }
            }
            return false; // En caso de que no haya coincidencia y se acabó, devuelve nulo
        }
        return false;
    }
    
    // Buscar un nodo por su posicion
    public Nodo buscarNodoPos(int posicion){
        if(!esVacio() && posicion >= 0 && posicion < this.size){
            Nodo aux = this.pFirst;
            
            int contador = 0;
            
            while(contador < posicion){
                aux = aux.getpNext();
                contador++;
            }
            return aux;
        }
        return null;
    }
    
    // Obtener el valor de un nodo con su posicion
    public T obtenerValor(int posicion){
        if(posicion >= 0 && posicion< this.size){
            if (posicion == 0){
                return (T)this.pFirst.getData();
            }else{
                Nodo aux = this.pFirst;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getpNext();
                }
                return (T)aux.getData();
            }
        }
        return null;
    }
    
    // Obtener un nodo con su posicion
    public Nodo obtenerNodo(int posicion){
        if(posicion >= 0 && posicion< this.size){
            if (posicion == 0){
                return this.pFirst;
            }else{
                Nodo aux = this.pFirst;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getpNext();
                }
                return aux;
            }
        }
        return null;
    }
    
    // Obtener la posicion de un Nodo
    public int obtenerPosicionNodo(Nodo nodo){
        if(!esVacio()){
            Nodo aux = this.pFirst;
            int contador = 0;
            while(aux != null){
                if (nodo.getData() == aux.getData()){
                    return contador;
                }
                contador ++;
                aux = aux.getpNext();
            }
            return -1;
        }
        return -1;
    }
    
    public int obtenerPosicionReferencia(T referencia){
        if(!esVacio()){
             Nodo aux = this.pFirst;
             int contador = 0;
             
             while(aux != null || aux.getData() != referencia){
                 aux = aux.getpNext();
                 contador++;
             }
             if(aux == null){
                 return -1;
             }else{
                 return contador;
             }
             
        }return -1;
    }
}
