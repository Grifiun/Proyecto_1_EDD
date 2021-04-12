/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import javax.swing.JPanel;
import nodos.NodoListaCapa;
import nodos.NodoListaEnlazada;

/**
 *
 * @author grifiun
 */
public class FuncionesGenerarImagenesListaCapasImagen {
    int cantidadColumnasMax = 0;
    int cantidadFilasMax = 0;
    
    public void graficar(JPanel panel, NodoListaEnlazada raiz){
        obtenerDimensiones(raiz);
        System.out.println("Dimensiones: "+cantidadColumnasMax+", "+cantidadFilasMax);
        graficarInOrden(raiz, panel);
    }    
    
    /**
     * Recorremos el nodo inOrden (izq, padre, der)
     * @param nodoAux 
     */
    public void graficarInOrden(NodoListaEnlazada nodoAux, JPanel panel){
        NodoListaCapa nodoCapaAux = (NodoListaCapa) nodoAux;
        if(nodoAux != null){
            //Graficamos la matrix
            //nodoCapaAux.getNodoCapa().getMatrizCapa().graficarMatrixDix(panel, cantidadFilasMax, cantidadColumnasMax);   
            nodoCapaAux.getNodoCapa().getMatrizCapa().graficarMatrixDix(panel, cantidadColumnasMax, cantidadFilasMax);   
            graficarInOrden(nodoAux.getSiguiente(), panel);//llamamos al final el der
        }
    }
    
    /**
     * Recorremos el nodo inOrden (izq, padre, der)
     * @param nodoAux 
     */
    public void obtenerDimensiones(NodoListaEnlazada nodoAux){
        NodoListaCapa nodoCapaAux = (NodoListaCapa) nodoAux;
        if(nodoAux != null){
            //Graficamos la matrix
            cantidadColumnasMax = Math.max(cantidadColumnasMax, nodoCapaAux.getNodoCapa().getMatrizCapa().obtenerLongitudRealColumnas());
            cantidadFilasMax = Math.max(cantidadFilasMax, nodoCapaAux.getNodoCapa().getMatrizCapa().obtenerLongitudRealFilas());
            
            obtenerDimensiones(nodoAux.getSiguiente());//llamamos al final el der
        }
    }
}
