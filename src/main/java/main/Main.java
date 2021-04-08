/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import arboles.ArbolAVL;
import graphviz.GenerarGraficaArbolAVL;
import nodos.Nodo;

/**
 *
 * @author grifiun
 */
public class Main {    
    public static void main(String[] args) {
        GenerarGraficaArbolAVL graficador; 
        ArbolAVL arbolAVL = new ArbolAVL();
        //ingresamos
        arbolAVL.insertar(10);
        graficador = new GenerarGraficaArbolAVL(arbolAVL.getRaiz());
        arbolAVL.insertar(5);
        arbolAVL.insertar(13);
        arbolAVL.insertar(1);
        arbolAVL.insertar(6);
        arbolAVL.insertar(17);
        System.out.println("INICIAL:");
        graficador.graficar("1");
        arbolAVL.inOrden(arbolAVL.getRaiz());//imprimimos en orden
        System.out.println("CON 16:");
        arbolAVL.insertar(16);
        graficador.graficar("2");
        arbolAVL.inOrden(arbolAVL.getRaiz());//imprimimos en orden
        System.out.println("16 BORRADO:");
        arbolAVL.borrar(16);//borramos el nodo 16
        arbolAVL.inOrden(arbolAVL.getRaiz());//imprimimos en orden
        
                        
        graficador.graficar("3");
        System.out.println("NODO ENCONTRADO");
        
        Nodo aux = arbolAVL.buscar(17);
        if(aux == null){
            System.out.println("El arbol esta vacio");
        }else{
            System.out.println("ID DEL NODO: "+aux.getId());
        }
        
    }
}
