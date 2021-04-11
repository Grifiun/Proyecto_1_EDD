/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import arboles.ArbolAVL;
import graphviz.GenerarGraficaArbolAVL;
import graphviz.GenerarGraficaMatrizDispersa;
import java.awt.Color;
import matrix_dispersa.Matrix;
import nodos.Nodo;
import nodos.NodoMatrix;

/**
 *
 * @author grifiun
 */
public class Main {    
    public static void main(String[] args) {
        /*
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
        }*/
        /*
        Matrix matrixDix = new Matrix();
        //matrixDix.insertar(1, 1, 0xFFFFFF);
        matrixDix.insertar(1, 2, 0xe74c3c);
        //matrixDix.insertar(1, 3, 0xEA90fc);
        //matrixDix.insertar(1, 4, 0xEA80fc);
        matrixDix.insertar(2, 1, 0xe1bee7);
        matrixDix.insertar(2, 2, 0xAfb83B);        
        matrixDix.insertar(2, 3, 0x299438);
        matrixDix.insertar(2, 4, 0x93CeEB); 
        
        //matrixDix.insertar(3, 1, 0xe1bee7);
        matrixDix.insertar(3, 2, 0xAfb83B);        
        //matrixDix.insertar(2, 3, 0x299438);
        matrixDix.insertar(3, 4, 0x93CeEB); 
        GenerarGraficaMatrizDispersa graficarMatrix = new GenerarGraficaMatrizDispersa(matrixDix);
        graficarMatrix.graficar("2");
        */
                /*
        String hexString = "e1bee7";
        int hex = Integer.parseInt(hexString, 16);
        Color colorAux = new Color(hex);
        

        System.out.println("VALUE "+hex);
        
        System.out.println("COLOR: "+colorAux.toString());*/
        
        VentanaPrincipal vp = new VentanaPrincipal();
        vp.show();
        
    }
}
