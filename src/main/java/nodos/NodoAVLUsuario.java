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
public class NodoAVLUsuario extends NodoListaEnlazada{
   
    //Listado imagenes
    public ListaDoblementeEnlazada listadoImagenesUsuario;

    /**
     * Constructor
     * @param listadoImagenesUsuario
     * @param id 
     */
    public NodoAVLUsuario(int id, ListaDoblementeEnlazada listadoImagenesUsuario) {
        super(id);
        this.listadoImagenesUsuario = listadoImagenesUsuario;
    }

    public ListaDoblementeEnlazada getListadoImagenesUsuario() {
        return listadoImagenesUsuario;
    }

    public void setListadoImagenesUsuario(ListaDoblementeEnlazada listadoImagenesUsuario) {
        this.listadoImagenesUsuario = listadoImagenesUsuario;
    }
    
    
   
}
