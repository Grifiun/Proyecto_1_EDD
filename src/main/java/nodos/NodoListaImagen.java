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
public class NodoListaImagen extends NodoListaEnlazada{
    private NodoImagen nodoImagen;

    public NodoListaImagen(int id, NodoImagen nodoImagen) {
        super(id);
        this.nodoImagen = nodoImagen;
    }

    public NodoImagen getNodoImagen() {
        return nodoImagen;
    }

    public void setNodoImagen(NodoImagen nodoImagen) {
        this.nodoImagen = nodoImagen;
    }

    
    
}

