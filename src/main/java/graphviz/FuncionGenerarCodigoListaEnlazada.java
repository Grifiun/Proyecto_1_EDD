/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphviz;

import nodos.NodoAVLCapa;
import nodos.NodoListaEnlazada;

/**
 *
 * @author grifiun
 */
public class FuncionGenerarCodigoListaEnlazada {
    NodoListaEnlazada raiz;
    int grupo;
    String nombreLista;
    public FuncionGenerarCodigoListaEnlazada(NodoListaEnlazada raiz, int grupo, String nombreLista){
        this.raiz = raiz;
        this.grupo = grupo;
        this.nombreLista = nombreLista;
    }
    
    public String getCodigoGraphviz(){
        return getCodigoInterno(raiz)+
                getConexionesIndices(raiz);
    }
    
    public String getCodigoInterno(NodoListaEnlazada nodoAux){
        String codigoInterno = "";
        if(nodoAux == null){//terminamos el ciclo
            return codigoInterno;
        }else{
            codigoInterno += "\t\tnodo" + nombreLista + nodoAux.getId()+"Grupo"+grupo + " [ label = \" "+nombreLista + " " + nodoAux.getId() + "\", group="+grupo+"];\n";
        }
        
        if(nodoAux.getAnterior() == null){//significa que es el primer elemento
           // codigoInterno += "\t\tnodo"+grupo+" -> "+nodoAux.getId()+"\n";//agregamos la conexion
        }
        
        if(nodoAux.getSiguiente() != null){//si el nodo derecho no es nulo, agregamos su codigo interno
           // codigoInterno += "\t\tnodoCap" + nodoAux.getId() + " -> tnodoCap" + nodoAux.getSiguiente().getId() + "\n";//agregamos el puntero   al nod siguiente
            if(nodoAux.getSiguiente() != null && nodoAux.getSiguiente() != this.raiz){//si tiene un siguiente y no es el nodo raiz, seguimos graficando
                codigoInterno += getCodigoInterno(nodoAux.getSiguiente());
            }
        }
        
        return codigoInterno;
    
    }
    
    public String getConexionesIndices(NodoListaEnlazada nodoAux){
        String codigoInterno = "";
        
        if(nodoAux.getAnterior() == null){//si es el primer elemento agregamos el salto de linea
            if(nodoAux != null){
               codigoInterno += "\t\tnodo"+grupo+" -> ";//agregamos el inicio
            }else
                codigoInterno += "\t\t";//agregamos el inicio
        }else{//tiene un elemento arriba, por tanto agregamos el puntero
            codigoInterno += " -> ";
        }
        
        if(nodoAux != null){//si el nodo no es nulo, agregamos el nodo
                codigoInterno += "nodo" + nombreLista + nodoAux.getId()+"Grupo"+grupo;//agregamos la alineacion
        }
        
        /**
         * Recorremos hasta no encontrar una abajo
         */
        if(nodoAux.getSiguiente()!= null){//si tiene un nodo abajo lo agregamos
            codigoInterno += getConexionesIndices(nodoAux.getSiguiente());
        }else{//sino
            //agregamos el cierre 
            codigoInterno += ";\n";
        }
        return codigoInterno;
    }
}
