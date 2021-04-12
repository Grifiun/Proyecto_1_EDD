/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import graphviz.GenerarGraficaMatrizDispersa;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import matrix_dispersa.Matrix;
import nodos.Nodo;
import nodos.NodoAVLCapa;
import nodos.NodoMatrix;

/**
 *
 * @author grifiun
 */
public class ArbolAVLCapa extends ArbolAVL{
    int cantidadColumnasMax = 0;
    int cantidadFilasMax = 0;
    /**
     * Metodo que principal para insertar nuevos nodos
     * @param id 
     */
    public void insertar(int id, Matrix matrizCapa){
        Nodo nuevoNodo = new NodoAVLCapa(id, matrizCapa);//instanciamos un nuevo nodo
        if(raiz == null){//entonces la lista esta vacia, ingresamos uno nuevo
            raiz = nuevoNodo;
            System.out.println("NUEVA RAIZ");
        }else{
            //insertamos en el arbol AVL
            raiz = insertarNodoAVL (nuevoNodo, raiz);
        }
        
        int col = ((NodoAVLCapa)nuevoNodo).getMatrizCapa().obtenerLongitudRealColumnas();
        int fil = ((NodoAVLCapa)nuevoNodo).getMatrizCapa().obtenerLongitudRealFilas();
        
        cantidadColumnasMax = Math.max(cantidadColumnasMax, col);
        cantidadFilasMax = Math.max(cantidadFilasMax, fil);
    }
    
    /**
     * Metodo que principal para insertar nuevos nodos
     * @param id 
     */
    public void insertar(NodoAVLCapa nodoCapa){
        Nodo nuevoNodo = nodoCapa;//instanciamos un nuevo nodo
        if(raiz == null){//entonces la lista esta vacia, ingresamos uno nuevo
            raiz = nuevoNodo;
            System.out.println("NUEVA RAIZ");
        }else{
            //insertamos en el arbol AVL
            raiz = insertarNodoAVL (nuevoNodo, raiz);
        }
        
        int col = ((NodoAVLCapa)nuevoNodo).getMatrizCapa().obtenerLongitudRealColumnas();
        int fil = ((NodoAVLCapa)nuevoNodo).getMatrizCapa().obtenerLongitudRealFilas();
        
        cantidadColumnasMax = Math.max(cantidadColumnasMax, col);
        cantidadFilasMax = Math.max(cantidadFilasMax, fil);
    }
    
    public NodoAVLCapa buscar(int id){
        return (NodoAVLCapa)(buscarNodo(id, raiz));//parseamos
    }    
    
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
    }
    
    /**
     * Recorremos el nodo inOrden (izq, padre, der)
     * @param nodoAux 
     */
    public void graficarInOrden(Nodo nodoAux, JPanel panel){
        NodoAVLCapa nodoAVLCapaAux = (NodoAVLCapa) nodoAux;
        if(nodoAux != null){
            graficarInOrden(nodoAux.getHijoIzquierdo(), panel);//llamanos primero al izq
            System.out.println(nodoAux.getId()+", ");//imprimimos los id
            //Graficamos la matrix
            nodoAVLCapaAux.getMatrizCapa().graficarMatrixDix(panel, cantidadFilasMax, cantidadColumnasMax);
            
            graficarInOrden(nodoAux.getHijoDerecho(), panel);//llamamos al final el der
        }
    }
    
    /**
     * Recorremos el nodo preOrden (padre, izq, der)
     * @param nodoAux 
     */
    public void graficarPreOrden(Nodo nodoAux, JPanel panel){
        NodoAVLCapa nodoAVLCapaAux = (NodoAVLCapa) nodoAux;
        if(nodoAux != null){            
            System.out.println(nodoAux.getId()+", ");//imprimimos los id
            //Graficamos la matrix
            nodoAVLCapaAux.getMatrizCapa().graficarMatrixDix(panel, cantidadFilasMax, cantidadColumnasMax);
            graficarPreOrden(nodoAux.getHijoIzquierdo(), panel);//llamanos de segundo al izq
            graficarPreOrden(nodoAux.getHijoDerecho(), panel);//llamamos al final el der
        }
    }
    
    /**
     * Recorremos el nodo postOrden (izq, der, padre)
     * @param nodoAux 
     */
    public void graficarPostOrden(Nodo nodoAux, JPanel panel){
        NodoAVLCapa nodoAVLCapaAux = (NodoAVLCapa) nodoAux;
        if(nodoAux != null){                        
            graficarPostOrden(nodoAux.getHijoIzquierdo(), panel);//llamanos primero al izq
            graficarPostOrden(nodoAux.getHijoDerecho(), panel);//llamamos de segundo el der
            System.out.println(nodoAux.getId()+", ");//imprimimos los id
            //Graficamos la matrix
            nodoAVLCapaAux.getMatrizCapa().graficarMatrixDix(panel, cantidadFilasMax, cantidadColumnasMax);
        }
    }
    
    /**
     * Recorremos el nodo postOrden (izq, der, padre)
     * @param nodoAux 
     */
    public void graficarCapaId(int idCapa, JPanel panel){
        
        NodoAVLCapa nodoAVLCapaAux = (NodoAVLCapa) buscar(idCapa);
        System.out.println("DIMENS: "+cantidadColumnasMax+", "+cantidadFilasMax);
        if(nodoAVLCapaAux != null){                        
            //Graficamos la matrix
            // nodoAVLCapaAux.getMatrizCapa().graficarMatrixDix(panel, nodoAVLCapaAux.getMatrizCapa().obtenerLongitudRealColumnas(), nodoAVLCapaAux.getMatrizCapa().obtenerLongitudRealFilas());
            nodoAVLCapaAux.getMatrizCapa().graficarMatrixDix(panel,-1, -1);//dibujamos segun tamano de capa
        }else{
            System.out.println("Capa con id "+idCapa+" no hallada");
        }
    }

    /**
     * Recorremos el nodo inOrden (izq, padre, der)
     * @param nodoAux 
     */
    public void calcularDimensiones(Nodo nodoAux){
        NodoAVLCapa nodoAVLCapaAux = (NodoAVLCapa) nodoAux;
        if(nodoAux != null){
            calcularDimensiones(nodoAux.getHijoIzquierdo());//llamanos primero al izq
            System.out.println(nodoAux.getId()+", ");//imprimimos los id
            //agregamos al cbox
            int col = nodoAVLCapaAux.getMatrizCapa().obtenerLongitudRealColumnas();
            int fil = nodoAVLCapaAux.getMatrizCapa().obtenerLongitudRealFilas();

            cantidadColumnasMax = Math.max(cantidadColumnasMax, col);
            cantidadFilasMax = Math.max(cantidadFilasMax, fil);
            System.out.println("NUEVA DIM: "+cantidadColumnasMax+" , "+cantidadFilasMax);
            
            calcularDimensiones(nodoAux.getHijoDerecho());//llamamos al final el der
        }
    }
    
    /**
     * Buscamos un nodo por el id
     * @param nuevoNodo 
     */
    public void agregarCapasComboBox(JComboBox comboBox){
        agregarCapasComboBox(raiz, comboBox);//buscamos
    }
    
    /**
     * Recorremos el nodo inOrden (izq, padre, der)
     * @param nodoAux 
     */
    public void agregarCapasComboBox(Nodo nodoAux, JComboBox comboBox){
        NodoAVLCapa nodoAVLCapaAux = (NodoAVLCapa) nodoAux;
        if(nodoAux != null){
            agregarCapasComboBox(nodoAux.getHijoIzquierdo(), comboBox);//llamanos primero al izq
            System.out.println(nodoAux.getId()+", ");//imprimimos los id
            //agregamos al cbox
            comboBox.addItem(""+nodoAVLCapaAux.getId());
            
            agregarCapasComboBox(nodoAux.getHijoDerecho(), comboBox);//llamamos al final el der
        }
    }
    
    public int getCantidadColumnasMax() {
        return cantidadColumnasMax;
    }

    public void setCantidadColumnasMax(int cantidadColumnasMax) {
        this.cantidadColumnasMax = cantidadColumnasMax;
    }

    public int getCantidadFilasMax() {
        return cantidadFilasMax;
    }

    public void setCantidadFilasMax(int cantidadFilasMax) {
        this.cantidadFilasMax = cantidadFilasMax;
    }
    
    
}
