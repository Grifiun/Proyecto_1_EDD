/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphviz;

import java.io.FileWriter;
import java.io.PrintWriter;
import matrix_dispersa.Matrix;
import nodos.Nodo;
import nodos.NodoMatrix;

/**
 *
 * @author grifiun
 */
public class GenerarGraficaMatrizDispersa {
    NodoMatrix raiz;
    
    /**
     * Contructor, recibe la matriz a graficar
     * aunque solo nos interesa el nodo indice
     * @param matrix 
     */
    public GenerarGraficaMatrizDispersa(Matrix matrix){
        raiz = matrix.getRaiz();        
    }
    
    /**
     * Método que genera el gráfico final de la matriz dispersa con Graphviz
     * Se empieza a generar utilizando el nodo raiz
     * @param path Ruta de la imagen que se generará.
     */
    public void graficar(String idCapa) {
        FileWriter fichero = null;
        PrintWriter escritor;
        try
        {
            fichero = new FileWriter("matriz_capa_"+idCapa+".dot");
            escritor = new PrintWriter(fichero);
            escritor.print(getCodigoGraphviz());
        } 
        catch (Exception e){
            System.err.println("Error al escribir el archivo matriz_capa_#.dot");
        }finally{
           try {
                if (null != fichero)
                    fichero.close();
           }catch (Exception e2){
               System.err.println("Error al cerrar el archivo matriz_capa_#.dot");
           } 
        }                        
        try{
          Runtime rt = Runtime.getRuntime();
          rt.exec( "dot -Tpng matriz_capa_"+idCapa+".dot -o matriz_capa_"+idCapa+".png");

          //Esperamos medio segundo para dar tiempo a que la imagen se genere.
          //Para que no sucedan errores en caso de que se decidan graficar varias
          //matrices sucesivamente.
          Thread.sleep(500);
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo matriz_capa_#.dot");
        }            
    }
    
    /**
     * Método que retorna el código que grapviz usará para generar la imagen     
     * del árbol AVL
     * @return 
     */
    private String getCodigoGraphviz() {
        return "digraph grafica{\n" +
               "\trankdir=TB;\n" +
               "\tnode [shape = box, style=filled, fillcolor = powderblue];\n"+
               "\tconcentrate=true\n"+
                //"\tnode [style=filled, fillcolor = powderblue];\n"+
                getCodigoInterno(raiz)+      
                getCodigoInternoConexiones(raiz)+
                "\t}\n";
    }
    
    /**
     * Funcion con la cual generamos el codigo de todas las columnas
     * @param nodoAux
     * @return 
     */
    private String getCodigoInterno(NodoMatrix nodoAux){
        String codigoInterno = "subgraph cluster_"+nodoAux.getX()+" {\n";
        //generamos la priemra parte del codigo, el codigo de una columna
        codigoInterno += getCodigoInternoColumna(nodoAux);
        codigoInterno += "\n\t\tcolor=white;\n}\n";       
        
        //codigoInterno += generarConexionesColumna(nodoAux);
        //recorremos las filas
        if(nodoAux.getDerecha() != null){
            codigoInterno += getCodigoInterno(nodoAux.getDerecha());
        }
        
        return codigoInterno;
    }
    
    /**
     * Funcion con la cual generamos el codigo de todas las conexiones de todas las col
     * @param nodoAux
     * @return 
     */
    private String getCodigoInternoConexiones(NodoMatrix nodoAux){
        String codigoInterno;
        //generamos la priemra parte del codigo, el codigo de una columna
        codigoInterno = generarConexionesColumna(nodoAux);
        //recorremos las filas
        if(nodoAux.getDerecha() != null){
            codigoInterno += getCodigoInternoConexiones(nodoAux.getDerecha());
        }
        
        return codigoInterno;
    }
    
    /**
     * Genera el código interior de graphviz, este método tiene la particularidad 
     * de ser recursivo, esto porque recorrer una fila de forma recursiva es bastante 
     * sencillo y reduce el código considerablemente. 
     * @return 
     */
    private String getCodigoInternoColumna(NodoMatrix nodoAux) {
        String codigoInterno = "";
        if(nodoAux.getHex() != 0){//si tiene un valor Hex
            codigoInterno = "\t\tnodo" + nodoAux.getX()+"y"+nodoAux.getY()+" [ label = \"#" + Integer.toHexString(nodoAux.getHex())+ "\" fillcolor=\"#"+Integer.toHexString(nodoAux.getHex())+"\"];\n";
        }else{
            //codigoInterno += "\t\tnodo" + nodoAux.getX()+"y"+nodoAux.getY()+" [  label = \"<C0> |" + nodoAux.getX()+"y"+nodoAux.getY()+ "| <C1>\"];\n";
            
            if(nodoAux.getX() == 0 && nodoAux.getY() == 0){//indice
                codigoInterno += "\t\tnodo" + nodoAux.getX()+"y"+nodoAux.getY()+" [  label = \"" + "Indice" + "\"];\n";
            }else{
                int indice = Math.max(nodoAux.getX(), nodoAux.getY());
                codigoInterno += "\t\tnodo" + nodoAux.getX()+"y"+nodoAux.getY()+" [  label = \"" + indice + "\"];\n";
            }                
        }        
        
        if(nodoAux.getAbajo() != null){//si existen mas nodos filas, las reocrremos
            codigoInterno += getCodigoInternoColumna(nodoAux.getAbajo());              
        }
        
        return codigoInterno;
    } 
    
    /**
     * Meteodo recursivo encargado de generar todas las conexiones de una columna
     * @param nodoAux
     * @return 
     */
    private String generarConexionesColumna(NodoMatrix nodoAux){
        String codigoInterno = "";
        
        if(nodoAux.getArriba()!= null){//agregamos punteros a los nodos hacia arriba
            codigoInterno += "\t\tnodo" +nodoAux.getX()+"y"+nodoAux.getY() + "->nodo"+ nodoAux.getArriba().getX()+"y"+nodoAux.getArriba().getY() + "\n";//agregamos el puntero
            //codigoInterno += "\t\tnodo" +nodoAux.getX()+"y"+nodoAux.getY() + ":C1->nodo"+ nodoAux.getArriba().getX()+"y"+nodoAux.getArriba().getY() + "\n";//agregamos el puntero
        }        
        if(nodoAux.getIzquierda()!= null){//agregamos punteros a los nodos hacia arriba
            codigoInterno += "\t\tnodo" +nodoAux.getX()+"y"+nodoAux.getY() + "->nodo"+ nodoAux.getIzquierda().getX()+"y"+nodoAux.getIzquierda().getY() + " [constraint = false]\n";//agregamos el puntero
            //codigoInterno += "\t\tnodo" +nodoAux.getX()+"y"+nodoAux.getY() + ":C0->nodo"+ nodoAux.getIzquierda().getX()+"y"+nodoAux.getIzquierda().getY() + "\n";//agregamos el puntero
        }
        
        if(nodoAux.getDerecha()!= null){//agregamos punteros a los nodos hacia arriba
            codigoInterno += "\t\tnodo" +nodoAux.getX()+"y"+nodoAux.getY() + "->nodo"+ nodoAux.getDerecha().getX()+"y"+nodoAux.getDerecha().getY() + " [constraint = false]\n";//agregamos el puntero
            //codigoInterno += "\t\tnodo" +nodoAux.getX()+"y"+nodoAux.getY() + ":C1->nodo"+ nodoAux.getDerecha().getX()+"y"+nodoAux.getDerecha().getY() + "\n";//agregamos el puntero
        }
        if(nodoAux.getAbajo() != null){//si existen mas nodos filas, las reocrremos
            codigoInterno += "\t\tnodo" +nodoAux.getX()+"y"+nodoAux.getY() + "->nodo"+ nodoAux.getAbajo().getX()+"y"+nodoAux.getAbajo().getY() + "\n";//agregamos el puntero
            //codigoInterno += "\t\tnodo" +nodoAux.getX()+"y"+nodoAux.getY() + ":C0->nodo"+ nodoAux.getAbajo().getX()+"y"+nodoAux.getAbajo().getY() + "\n";//agregamos el puntero
            codigoInterno += generarConexionesColumna(nodoAux.getAbajo());
            //codigoInterno += "\t\tnodo" +nodoAux.getX()+"y"+nodoAux.getY() + ":C0->nodo"+ nodoAux.getAbajo().getX()+"y"+nodoAux.getAbajo().getY() + "\n";//agregamos el puntero
        }
        
        return codigoInterno;
    }
    
    
}
