/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import javax.swing.JComboBox;
import nodos.NodoImagen;
import nodos.NodoListaEnlazada;

/**
 *
 * @author grifiun
 */
public class ListaDoblementeEnlazada {
    NodoListaEnlazada raiz;
    
    public ListaDoblementeEnlazada(){
        this.raiz = null;
    }
    
    /**
     * Insertamos un nuevoNodo
     * @param nuevoNodo 
     */
    public void insertarNodo(NodoListaEnlazada nuevoNodo){        
        insertarNodo(raiz, nuevoNodo);//insertamos
    }
    
    /** 
     * Metodo recursivo para insertar nuevos nodos
     * @param nodoAux
     * @param nuevoNodo 
     */
    private void insertarNodo(NodoListaEnlazada nodoAux, NodoListaEnlazada nuevoNodo){
        if(this.raiz == null){//si no existe una el nodoAuxiliar, en este caso seria el primer ingreso, se crea una nueva raiz
            this.raiz = nuevoNodo;
            return;
        }else{//si hay nodos, recorremos hasta el ultimo
            //insertamos a la derecha
            if(nodoAux.getSiguiente() != null){
                //insertamos el siguiente
                //insertarNodo(nodoAux.getSiguiente(), nuevoNodo);
                    insertarNodo(nodoAux.getSiguiente(), nuevoNodo);//parseamos
            }else{
                //llegamos al final
                //Agregamos puntero de ultimo nodo de la fila, hacia el nuevo nodo
                nodoAux.setSiguiente(nuevoNodo);
                nuevoNodo.setAnterior(nodoAux);
                return;
            }
        }
    }
    
    
    
    /**
     * Buscamos un nodo por el id
     * @param nuevoNodo 
     */
    public NodoListaEnlazada buscarNodo(int id){
        return buscarNodo(raiz, id);//buscamos
    }
    
    /** 
     * Metodo recursivo para buscar un nodo por el id
     * @param nodoAux
     * @param nuevoNodo 
     */
    private NodoListaEnlazada buscarNodo(NodoListaEnlazada nodoAux, int id){
        if(nodoAux == null){//si no existe una el nodoAuxiliar, en este caso seria el primer nodo, e indica que la lista esta vacia
            System.out.println("No hay nodos en la lista");
        }else{//si hay nodos, recorremos hasta encontrar al nodo requerrido ultimo
            if(nodoAux.getId() == id){//enontramos el nodo                
                return nodoAux;//retornamos el nodo
            }else{
                if(nodoAux.getSiguiente() != null && nodoAux.getSiguiente() != this.raiz){//verificamos que no sea la raiz, sino nunca termina el ciclo
                //recorremos el siguiente nodo
                    return buscarNodo(nodoAux.getSiguiente(), id);
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
        NodoListaEnlazada nodoAux = buscarNodo(id);
        if(nodoAux != null){
             //punteros
            NodoListaEnlazada nodoAnterior = nodoAux.getAnterior();
            NodoListaEnlazada nodoSiguiente = nodoAux.getSiguiente();

            //areglampos los punteros
            if(nodoSiguiente != null){
                nodoSiguiente.setAnterior(nodoAnterior);
            }

            if(nodoAnterior != null){
                nodoAnterior.setSiguiente(nodoAnterior);
            }
            //anulamos valores
            nodoAux.setSiguiente(null);
            nodoAux.setAnterior(null);
            nodoAux = null;        
        }else{
            System.out.println("Nodo inexistente con el id dado: "+id);
        }     
    }

    public NodoListaEnlazada getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoListaEnlazada raiz) {
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
    private void agregarImagenesComboBox(NodoListaEnlazada nodoAux, JComboBox comboBox){
        if(nodoAux == null){//si no existe una el nodoAuxiliar, en este caso seria el primer nodo, e indica que la lista esta vacia
            System.out.println("No hay nodos en la lista");
        }else{//si hay nodos, recorremos hasta que ya no haya ninguno    
                //agregamos al cobox
                comboBox.addItem(nodoAux.getId()+"");
                if(nodoAux.getSiguiente() != null && nodoAux.getSiguiente() != this.raiz){//verificamos que no sea la raiz, sino nunca termina el ciclo
                //recorremos el siguiente nodo
                    agregarImagenesComboBox((NodoImagen) nodoAux.getSiguiente(), comboBox);//parseamos
                    //return buscarNodo(nodoAux.getSiguiente(), id);
                }
            }
        
    }
    
}
