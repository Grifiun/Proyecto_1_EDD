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
          Thread.sleep(200);
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
               "\trank=same;\n"+
               "\tnode [shape = box, style=filled, fillcolor = powderblue];\n"+
               "\tconcentrate=true\n"+
                //"\tnode [style=filled, fillcolor = powderblue];\n"+
                getCodigoInterno(raiz)+      
                //getCodigoInternoConexiones(raiz)+
                //generarConexionesColumna(raiz)+//Se activa cuando no se quieren agregar los indices de filas en la siguiente funcion
                getCodigoAlineacionesColumna(raiz)+
                getCodigoAlineacionesFila(raiz)+
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
     *//*
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
    */
    /**
     * Genera el código interior de graphviz, este método tiene la particularidad 
     * de ser recursivo, esto porque recorrer una fila de forma recursiva es bastante 
     * sencillo y reduce el código considerablemente. 
     * @return 
     */
    private String getCodigoInternoColumna(NodoMatrix nodoAux) {
        String codigoInterno = "";
        if(nodoAux.getHex() != 0){//si tiene un valor Hex
            codigoInterno = "\t\tnodo" + nodoAux.getX()+"y"+nodoAux.getY()+" [ label = \"#" + Integer.toHexString(nodoAux.getHex())+ "\" fillcolor=\"#"+Integer.toHexString(nodoAux.getHex())+"\", width = 1.1, group = "+nodoAux.getX()+"];\n";
        }else{
            //codigoInterno += "\t\tnodo" + nodoAux.getX()+"y"+nodoAux.getY()+" [  label = \"<C0> |" + nodoAux.getX()+"y"+nodoAux.getY()+ "| <C1>\"];\n";
            
            if(nodoAux.getX() == 0 && nodoAux.getY() == 0){//indice
                codigoInterno += "\t\tnodo" + nodoAux.getX()+"y"+nodoAux.getY()+" [  label = \"" + "Indice" + "\", width = 1.1, group = "+nodoAux.getX()+"];\n";
            }else{
                int indice = Math.max(nodoAux.getX(), nodoAux.getY());
                codigoInterno += "\t\tnodo" + nodoAux.getX()+"y"+nodoAux.getY()+" [  label = \"" + indice + "\", width=1.1, group = "+nodoAux.getX()+"];\n";
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
        /*
        if(nodoAux.getArriba()!= null){//agregamos punteros a los nodos hacia arriba
            //codigoInterno += "\t\tnodo" +nodoAux.getX()+"y"+nodoAux.getY() + "->nodo"+ nodoAux.getArriba().getX()+"y"+nodoAux.getArriba().getY() + "\n";//agregamos el puntero
            //codigoInterno += "\t\tnodo" +nodoAux.getX()+"y"+nodoAux.getY() + ":C1->nodo"+ nodoAux.getArriba().getX()+"y"+nodoAux.getArriba().getY() + "\n";//agregamos el puntero
        }        
        if(nodoAux.getIzquierda()!= null){//agregamos punteros a los nodos hacia arriba
            codigoInterno += "\t\tnodo" +nodoAux.getX()+"y"+nodoAux.getY() + "->nodo"+ nodoAux.getIzquierda().getX()+"y"+nodoAux.getIzquierda().getY() + " [constraint = false]\n";//agregamos el puntero
            //codigoInterno += "\t\tnodo" +nodoAux.getX()+"y"+nodoAux.getY() + ":C0->nodo"+ nodoAux.getIzquierda().getX()+"y"+nodoAux.getIzquierda().getY() + "\n";//agregamos el puntero
        }
        */
        if(nodoAux.getDerecha()!= null){//agregamos punteros a los nodos hacia arriba
            codigoInterno += "\t\tnodo" +nodoAux.getX()+"y"+nodoAux.getY() + "->nodo"+ nodoAux.getDerecha().getX()+"y"+nodoAux.getDerecha().getY() + " [constraint = false, dir = both, arrowsize=.5]\n";//agregamos el puntero
            //codigoInterno += "\t\tnodo" +nodoAux.getX()+"y"+nodoAux.getY() + ":C1->nodo"+ nodoAux.getDerecha().getX()+"y"+nodoAux.getDerecha().getY() + "\n";//agregamos el puntero
        }
        if(nodoAux.getAbajo() != null){//si existen mas nodos filas, las reocrremos
            //codigoInterno += "\t\tnodo" +nodoAux.getX()+"y"+nodoAux.getY() + "->nodo"+ nodoAux.getAbajo().getX()+"y"+nodoAux.getAbajo().getY() + "\n";//agregamos el puntero
            //codigoInterno += "\t\tnodo" +nodoAux.getX()+"y"+nodoAux.getY() + ":C0->nodo"+ nodoAux.getAbajo().getX()+"y"+nodoAux.getAbajo().getY() + "\n";//agregamos el puntero
            codigoInterno += generarConexionesColumna(nodoAux.getAbajo());
            //codigoInterno += "\t\tnodo" +nodoAux.getX()+"y"+nodoAux.getY() + ":C0->nodo"+ nodoAux.getAbajo().getX()+"y"+nodoAux.getAbajo().getY() + "\n";//agregamos el puntero
        }
        
        return codigoInterno;
    }
        
    
    /**
     * Metodo recursivo que se usa para recorrer todas las filas, recibe el nodo raiz
     * Agregamos las alineaciones de las columnas por fila
     * @param nodoAux
     * @return 
     */
    private String getCodigoAlineacionesFila(NodoMatrix nodoAux){  
        String codigoInterno = "";
        
        if(nodoAux.getArriba() == null){
            //significa que es el nodo raiz
            codigoInterno += "\n\n\t\t//Conexiones de las filas\n";
        }        
        //agregamos las conexiones por cada fila, para que tengan un mejor orden
        codigoInterno += generarAlinacionesFila(nodoAux);
        //recorremos las filas
        if(nodoAux.getAbajo()!= null){
            codigoInterno += getCodigoAlineacionesFila(nodoAux.getAbajo());
        }
        
        return codigoInterno;
    }
    
    /**
     * Metodo recursivo que se usa para recorrer una fila
     * Agregamos las conexiones por columna a una fila
     * @param nodoAux
     * @return 
     */
    private String generarAlinacionesFila(NodoMatrix nodoAux){
        String codigoInterno = "";
        
        /*
        //SIN LOS INDICES DE FILAS
        if(nodoAux.getIzquierda() == null){//significa que es el primer elemento de la fila
            codigoInterno += "\t\trank = same {";//agregamos el inicio
        }else if(nodoAux.getIzquierda().getIzquierda() != null) {//tiene un elemento a la izquierda, por tanto agregamos el punto y coma
             codigoInterno += " -> ";
        }
        
        if(nodoAux != null && nodoAux.getIzquierda() != null){//si el nodo no es nulo, agregamos el nodo
                codigoInterno += "nodo" +nodoAux.getX()+"y"+nodoAux.getY();//agregamos la alineacion
        }        
        */
        
        //CON LOS INDICES DE FILAS
        if(nodoAux.getIzquierda() == null){//significa que es el primer elemento de la fila
            codigoInterno += "\t\trank = same {";//agregamos el inicio
        }        
        else{//tiene un elemento a la izquierda, por tanto agregamos el punto y coma
             codigoInterno += " -> ";
        }
        if(nodoAux != null){//si el nodo no es nulo, agregamos el nodo
                codigoInterno += "nodo" +nodoAux.getX()+"y"+nodoAux.getY();//agregamos la alineacion
        }
        
        
        /**
         * Recorremos hasta no encontrar una derecha
         */
        if(nodoAux.getDerecha() != null){//si tiene un nodo a la derecha lo agregamos
            codigoInterno += generarAlinacionesFila(nodoAux.getDerecha());
        }else{//sino
            //agregamos el cierre 
            codigoInterno += "}\n";
            //codigoInterno = "}\n";
        }
        return codigoInterno;
    }
    
    
    
    /**
     * Metodo recursivo que se usa para recorrer todas las columnas, recibe el nodo raiz
     * Agregamos las alineaciones de las filas por columna
     * @param nodoAux
     * @return 
     */
    private String getCodigoAlineacionesColumna(NodoMatrix nodoAux){  
        String codigoInterno = "";
        if(nodoAux.getIzquierda() == null){
            //significa que es el nodo raiz
            codigoInterno += "\n\n\t\t//Conexiones de las columnas\n";
            codigoInterno += "\t\tedge [dir = both, arrowsize=.5]\n";
        }
        //agregamos las conexiones por cada columna, para que tengan un mejor orden        
        codigoInterno += generarAlinacionesColumna(nodoAux);
        //recorremos las filas
        if(nodoAux.getDerecha()!= null){
            codigoInterno += getCodigoAlineacionesColumna(nodoAux.getDerecha());
        }
        
        return codigoInterno;
    }
    
    /**
     * Metodo recursivo que se usa para recorrer una columna
     * Agregamos las conexiones por fila por columna
     * @param nodoAux
     * @return 
     */
    private String generarAlinacionesColumna(NodoMatrix nodoAux){
        String codigoInterno = "";
        
        if(nodoAux.getArriba() == null){//si es el primer elemento agregamos el salto de linea
            codigoInterno += "\t\t";//agregamos el inicio
        }else{//tiene un elemento arriba, por tanto agregamos el puntero
            codigoInterno += " -> ";
        }
        
        if(nodoAux != null){//si el nodo no es nulo, agregamos el nodo
                codigoInterno += "nodo" +nodoAux.getX()+"y"+nodoAux.getY();//agregamos la alineacion
        }
        
        /**
         * Recorremos hasta no encontrar una abajo
         */
        if(nodoAux.getAbajo() != null){//si tiene un nodo abajo lo agregamos
            codigoInterno += generarAlinacionesColumna(nodoAux.getAbajo());
        }else{//sino
            //agregamos el cierre 
            codigoInterno += ";\n";
        }
        return codigoInterno;
    }
}
