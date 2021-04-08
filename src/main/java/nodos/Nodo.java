/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

/**
 *
 * @author grifiun
 */
public class Nodo {
    private int id;
    private int factorEquilibrio;
    private Nodo hijoIzquierdo;
    private Nodo hijoDerecho;

    /**
     * Inicializamos los nodos
     * apuntadores y el factor de equilibrio
     * @param id 
     */
    public Nodo(int id) {
        this.id = id;
        this.factorEquilibrio = 0;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }   
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(Nodo hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(Nodo hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public int getFactorEquilibrio() {
        return factorEquilibrio;
    }

    public void setFactorEquilibrio(int factorEquilibrio) {
        this.factorEquilibrio = factorEquilibrio;
    }
    
}
