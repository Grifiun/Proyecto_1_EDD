/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import javax.swing.JComboBox;
import listas.ListaDoblementeEnlazada;
import nodos.Nodo;
import nodos.NodoAVLUsuario;

/**
 *
 * @author grifiun
 */
public class ArbolAVLUsuario extends ArbolAVL{
    /**
     * Metodo que principal para insertar nuevos nodos
     * @param id 
     */
    public void insertar(int id, ListaDoblementeEnlazada listadoImagenes){
        Nodo nuevoNodo = new NodoAVLUsuario(id, listadoImagenes);//instanciamos un nuevo nodo
        if(raiz == null){//entonces la lista esta vacia, ingresamos uno nuevo
            raiz = nuevoNodo;
            System.out.println("NUEVA RAIZ");
        }else{
            //insertamos en el arbol AVL
            raiz = insertarNodoAVL (nuevoNodo, raiz);
        }
    }
    
    /**
     * Metodo que principal para insertar nuevos nodos
     * @param id 
     */
    public void insertar(NodoAVLUsuario nodoUsr){
        Nodo nuevoNodo = nodoUsr;//instanciamos un nuevo nodo
        if(raiz == null){//entonces la lista esta vacia, ingresamos uno nuevo
            raiz = nuevoNodo;
            System.out.println("NUEVA RAIZ");
        }else{
            //insertamos en el arbol AVL
            raiz = insertarNodoAVL (nuevoNodo, raiz);
        }
    }
    
    /**
     * Buscamos un nodo por el id
     * @param nuevoNodo 
     */
    public void agregarUsuariosComboBox(JComboBox comboBox){
        agregarUsuariosComboBox(raiz, comboBox);//buscamos
    }
    
    /**
     * Recorremos el nodo inOrden (izq, padre, der)
     * @param nodoAux 
     */
    public void agregarUsuariosComboBox(Nodo nodoAux, JComboBox comboBox){
        if(nodoAux != null){
            agregarUsuariosComboBox(nodoAux.getHijoIzquierdo(), comboBox);//llamanos primero al izq           
            System.out.println(nodoAux.getId()+", ");//imprimimos los id
            //agregamos al cbox
            comboBox.addItem(""+nodoAux.getId());
            agregarUsuariosComboBox(nodoAux.getHijoDerecho(), comboBox);//llamamos al final el der
            
            
        }
    }
    
    public NodoAVLUsuario buscar(int id){
        return (NodoAVLUsuario)(buscarNodo(id, raiz));//parseamos
    }    
    /*
    public void generarGraficasMatrices(Nodo nodoAux){
        NodoAVLCapa nodoAVLCapaAux = (NodoAVLCapa) nodoAux;
        if(nodoAux != null){                        
            generarGraficasMatrices(nodoAux.getHijoIzquierdo());//llamanos primero al izq
            generarGraficasMatrices(nodoAux.getHijoDerecho());//llamamos de segundo el der
            //generamos la grafica
            GenerarGraficaMatrizDispersa graficarMatrix = new GenerarGraficaMatrizDispersa(nodoAVLCapaAux.getMatrizCapa());
            graficarMatrix.graficar(""+nodoAux.getId());
            //System.out.println(nodoAux.getId()+", ");//imprimimos los id
        }
    }*/
    
}
