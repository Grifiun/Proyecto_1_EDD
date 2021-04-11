/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

import listas.ListaDoblementeEnlazada;

/**
 *
 * @author grifiun
 */
public class NodoListaEnlazada extends Nodo{
    private NodoListaEnlazada siguiente;
    private NodoListaEnlazada anterior;
    
    public NodoListaEnlazada(int id){
        super(id);
        //inicializamos apuntadores
        this.siguiente = null;
        this.anterior = null; 
    }

    public NodoListaEnlazada getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaEnlazada siguiente) {
        this.siguiente = siguiente;
    }

    public NodoListaEnlazada getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoListaEnlazada anterior) {
        this.anterior = anterior;
    }
}
