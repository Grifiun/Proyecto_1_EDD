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
public class NodoImagen extends NodoListaEnlazada{
    ListaDoblementeEnlazada listadoCapas;
    
    public NodoImagen(int id){
        super(id);
        //inicializamos el lsitado de capas
        this.listadoCapas = null;        
    }
    
    public NodoImagen(int id, ListaDoblementeEnlazada listadoCapas){
        //agregamos id
        super(id);
        //inicializamos el lsitado de capas
        this.listadoCapas = listadoCapas;
    }

    public ListaDoblementeEnlazada getListadoCapas() {
        return listadoCapas;
    }

    public void setListadoCapas(ListaDoblementeEnlazada listadoCapas) {
        this.listadoCapas = listadoCapas;
    }
    
    
}
