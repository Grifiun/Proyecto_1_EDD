/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import javax.swing.JComboBox;
import nodos.NodoImagen;

/**
 *
 * @author grifiun
 */
public class ListaCircularImagenes {
    NodoImagen raiz;
    
    public ListaCircularImagenes(){
        this.raiz = null;
    }
    
    /**
     * Insertamos un nuevoNodo
     * @param nuevoNodo 
     */
    public void insertarNodo(NodoImagen nuevoNodo){
        insertarNodo(raiz, nuevoNodo);//insertamos
    }
    
    /** 
     * Metodo recursivo para insertar nuevos nodos
     * @param nodoAux
     * @param nuevoNodo 
     */
    private void insertarNodo(NodoImagen nodoAux, NodoImagen nuevoNodo){
        if(this.raiz == null){//si no existe una el nodoAuxiliar, en este caso seria el primer ingreso, se crea una nueva raiz
            this.raiz = nuevoNodo;
        }else{//si hay nodos, recorremos hasta el ultimo
            //insertamos a la derecha
            if(nodoAux.getSiguiente() != null && nodoAux.getSiguiente() != this.raiz){
                //insertamos el siguiente
                insertarNodo((NodoImagen) nodoAux.getSiguiente(), nuevoNodo);//parseamos
            }else{
                //llegamos al final
                //Agregamos puntero de ultimo nodo de la fila, hacia el nuevo nodo
                nodoAux.setSiguiente(nuevoNodo);
                //Agregamos puntero del nodo raiz hacia el nuevo nodo (hacia atras)
                this.raiz.setAnterior(nuevoNodo);
                //Agregamos apuntadores del nuevo nodo
                nuevoNodo.setSiguiente(this.raiz);//su siguiente es el nodo raiz
                nuevoNodo.setAnterior(nodoAux);
            }
        }
    }
    
    
    
    /**
     * Buscamos un nodo por el id
     * @param nuevoNodo 
     */
    public NodoImagen buscarNodo(int id){
        return buscarNodo(raiz, id);//buscamos
    }
    
    /** 
     * Metodo recursivo para buscar un nodo por el id
     * @param nodoAux
     * @param nuevoNodo 
     */
    private NodoImagen buscarNodo(NodoImagen nodoAux, int id){
        if(nodoAux == null){//si no existe una el nodoAuxiliar, en este caso seria el primer nodo, e indica que la lista esta vacia
            System.out.println("No hay nodos en la lista");
        }else{//si hay nodos, recorremos hasta encontrar al nodo requerrido ultimo
            if(nodoAux.getId() == id){//enontramos el nodo                
                return nodoAux;//retornamos el nodo
            }else{
                if(nodoAux.getSiguiente() != null && nodoAux.getSiguiente() != this.raiz){//verificamos que no sea la raiz, sino nunca termina el ciclo
                //recorremos el siguiente nodo
                    return buscarNodo((NodoImagen) nodoAux.getSiguiente(), id);//parseamos
                    //return buscarNodo(nodoAux.getSiguiente(), id);
                }else{
                    //llegamos al final sin exito
                    System.out.println("No existe ese nodo dentro de la lista");
                }
            }     
        }
        return null;//retornamos null si no se encuentra ningun nodo que coincida con el id dado
    }
    
    /**
     * Eliminamos un nuevoNodo por id
     * @param nuevoNodo 
     */
    public void eliminarNodo(int id){     
        NodoImagen nodoAux = buscarNodo(id);
        System.out.println("Nodo encontrado");
        try{
            if(nodoAux != null){
                //punteros
               NodoImagen nodoAnterior = (NodoImagen) nodoAux.getAnterior();
               NodoImagen nodoSiguiente = (NodoImagen) nodoAux.getSiguiente();

               //areglampos los punteros
               if(nodoAnterior != null){
                   nodoAnterior.setSiguiente(nodoSiguiente);
               }
               
               if(nodoSiguiente != null){
                   nodoSiguiente.setAnterior(nodoAux.getAnterior());
               }

               
               //anulamos valores
               nodoAux.setSiguiente(null);
               nodoAux.setAnterior(null);
               nodoAux = null;        
           }else{
               System.out.println("Nodo inexistente con el id dado: "+id);
           }   
        }catch(Exception ex){
            System.out.println("ERROR\n\n\n\n\n");
            ex.printStackTrace();
        }
          
    }
    
    
    /**
     * Eliminamos un nuevoNodo
     * @param nuevoNodo 
     */
    public void eliminarNodo(NodoImagen nuevoNodo){        
        elminarNodo(raiz, nuevoNodo);//insertamos
    }
    
    /** 
     * Metodo recursivo para eliminar nuevos nodos
     * @param nodoAux
     * @param nuevoNodo 
     */
    private void elminarNodo(NodoImagen nodoAux, NodoImagen nuevoNodo){
        if(raiz == null){//si no existe una el nodoAuxiliar, en este caso seria el primer nodo, e indica que la lista esta vacia
            System.out.println("No hay nodos en la lista");
        }else{//si hay nodos, recorremos hasta encontrar al nodo requerrido ultimo
            if(nodoAux == nuevoNodo){//enontramos el nodo a eliminar
                //corregimos punteros
                //Agregamos puntero de ultimo nodo de la fila, hacia el nuevo nodo
                nodoAux.setSiguiente(nuevoNodo.getSiguiente());
                //Agregamos apuntadores del nuevo nodo
                nuevoNodo.getSiguiente().setAnterior(nodoAux);
                
                //anulamos apuntadores
                nuevoNodo.setSiguiente(null);
                nuevoNodo.setAnterior(null);
                return;//terminamos el ciclo
            }else{
                if(nodoAux.getSiguiente() != null && nodoAux.getSiguiente() != this.raiz){//verificamos que no sea la raiz, sino nunca termina el ciclo
                //recorremos el siguiente nodo
                    elminarNodo((NodoImagen) nodoAux.getSiguiente(), nuevoNodo);
                }else{
                    //llegamos al final sin exito
                    System.out.println("No existe ese nodo dentro de la lista");
                }
            }
            
            
        }
    }
    
    public NodoImagen getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoImagen raiz) {
        this.raiz = raiz;
    }
    
    /**
     * Buscamos un nodo por el id
     * @param nuevoNodo 
     */
    public void agregarImagenesComboBox(JComboBox comboBox){
        agregarImagenesComboBox(raiz, comboBox);//buscamos
    }
    
    /** 
     * Metodo recursivo para agregar un nodo al cobox
     * @param nodoAux
     * @param nuevoNodo 
     */
    private void agregarImagenesComboBox(NodoImagen nodoAux, JComboBox comboBox){
        if(nodoAux == null){//si no existe una el nodoAuxiliar, en este caso seria el primer nodo, e indica que la lista esta vacia
            System.out.println("No hay nodos en la lista");
        }else{//si hay nodos, recorremos hasta que ya no haya ninguno    
                //agregamos al cobox
                try{
                     comboBox.addItem(nodoAux.getId()+"");
                }catch(Exception ex){
                    ex.printStackTrace();
                }
               
                if(nodoAux.getSiguiente() != null && nodoAux.getSiguiente() != this.raiz){//verificamos que no sea la raiz, sino nunca termina el ciclo
                //recorremos el siguiente nodo
                    agregarImagenesComboBox((NodoImagen) nodoAux.getSiguiente(), comboBox);//parseamos
                    //return buscarNodo(nodoAux.getSiguiente(), id);
                }
            }
        
    }
}
