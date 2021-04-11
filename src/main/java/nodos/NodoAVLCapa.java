/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

import graphviz.GenerarGraficaMatrizDispersa;
import matrix_dispersa.Matrix;

/**
 *
 * @author grifiun
 */
public class NodoAVLCapa extends NodoListaEnlazada{
    Matrix matrizCapa;
    
    public NodoAVLCapa(int id, Matrix matrizCapa) {       
        super(id);
        this.matrizCapa = matrizCapa;
    }

    public Matrix getMatrizCapa() {
        return matrizCapa;
    }

    public void setMatrizCapa(Matrix matrizCapa) {
        this.matrizCapa = matrizCapa;
    }
        
    
}
