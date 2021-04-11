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
public class NodoListaCapa extends NodoListaEnlazada{
    private NodoAVLCapa nodoCapa;

    public NodoListaCapa(int id, NodoAVLCapa nodoCapa) {
        super(id);
        this.nodoCapa = nodoCapa;
    }

    public NodoAVLCapa getNodoCapa() {
        return nodoCapa;
    }

    public void setNodoCapa(NodoAVLCapa nodoCapa) {
        this.nodoCapa = nodoCapa;
    }
    
    
}
