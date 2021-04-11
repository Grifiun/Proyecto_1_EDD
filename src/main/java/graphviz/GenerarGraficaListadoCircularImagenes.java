/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphviz;

import java.io.FileWriter;
import java.io.PrintWriter;
import nodos.NodoImagen;
import nodos.NodoListaEnlazada;
import graphviz.FuncionGenerarCodigoListaEnlazada;
import nodos.NodoAVLCapa;
import nodos.NodoListaCapa;

/**
 *
 * @author grifiun
 */
public class GenerarGraficaListadoCircularImagenes {
    NodoImagen raiz;
   
    
    public GenerarGraficaListadoCircularImagenes(NodoImagen raiz){
        this.raiz = raiz;
    }
    
    /**
     * Método que genera el gráfico final del árbol binario de búsqueda AVL con graphviz,
     * Se empieza a generar utilizando el nodo raiz
     * @param path Ruta de la imagen que se generará.
     */
    public void graficar(String tipoGrafica) {
        FileWriter fichero = null;
        PrintWriter escritor;
        try
        {
            fichero = new FileWriter("aux_grafico_imagenes.dot");
            escritor = new PrintWriter(fichero);
            System.out.println("Codigo\n\n"+getCodigoGraphviz("Imagenes"));
            escritor.print(getCodigoGraphviz(tipoGrafica));
        } 
        catch (Exception e){
            System.err.println("Error al escribir el archivo aux_grafico_imagenes.dot: "+e.getMessage());
        }finally{
           try {
                if (null != fichero)
                    fichero.close();
           }catch (Exception e2){
               System.err.println("Error al cerrar el archivo aux_grafico_imagenes.dot");
           } 
        }                        
        try{
          Runtime rt = Runtime.getRuntime();
          rt.exec( "dot -Tpng aux_grafico_imagenes.dot -o listado"+tipoGrafica+".png");

          //Esperamos medio segundo para dar tiempo a que la imagen se genere.
          //Para que no sucedan errores en caso de que se decidan graficar varios
          //árboles sucesivamente.
          Thread.sleep(100);
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico_imagenes.dot");
        }            
    }
    
    /**
     * Método que retorna el código que grapviz usará para generar la imagen     
     * del árbol AVL
     * @return 
     */
    private String getCodigoGraphviz(String titulo) {
        return "digraph grafica{\n" +
               "\tlabel=\"Listado de "+titulo+"\""+
               "\trankdir=TB;\n" +
               "\tconcentrate=true;\n" +
               "\tnode [shape = box, style=filled, fillcolor = honeydew2];\n"+
               "\tedge [arrowsize=.5]\n"+//agregamos el inicio
                getCodigoInterno(raiz)+
                getConexionesIndices(raiz)+
                "\t}\n";
    }
    
    
    /**
     * Genera el código interior de graphviz, este método tiene la particularidad 
     * de ser recursivo, esto porque recorrer un árbol de forma recursiva es bastante 
     * sencillo y reduce el código considerablemente. 
     * @return 
     */
    private String getCodigoInterno(NodoListaEnlazada nodoAux) {
        String codigoInterno = "\t\t//Nodo\n";
        
        if(nodoAux != null){
            System.out.println("Nodo "+nodoAux.getId());
            codigoInterno += "\t\tnodo" + nodoAux.getId() + " [ label = \"" + nodoAux.getId() + "\", group="+nodoAux.getId()+"];\n";
            
            codigoInterno += "\t\t//Capas\n";
            
            if(((NodoImagen)nodoAux).getListadoCapas() != null){//si tiene un listadao de capas
                NodoListaCapa nodoRaizAux = (NodoListaCapa) ((NodoImagen)nodoAux).getListadoCapas().getRaiz();
                FuncionGenerarCodigoListaEnlazada generarCodigoLista = new FuncionGenerarCodigoListaEnlazada(nodoRaizAux, nodoAux.getId(), "Capa"); 
                codigoInterno += generarCodigoLista.getCodigoGraphviz();
            }
            
        }else{
            return "";
        }
        
        if(nodoAux.getSiguiente() != null){//si el nodo derecho no es nulo, agregamos su codigo interno
            //codigoInterno += "\t\tnodo" + nodoAux.getId() + " -> nodo" + nodoAux.getSiguiente().getId() + "\n";//agregamos el puntero   al nod siguiente
            if(nodoAux.getSiguiente() != null && nodoAux.getSiguiente() != this.raiz){//si tiene un siguiente y no es el nodo raiz, seguimos graficando
                codigoInterno += getCodigoInterno(nodoAux.getSiguiente());
            }
        }
        
        return codigoInterno;
    } 
    
    private String getConexionesIndices(NodoListaEnlazada nodoAux){
        String codigoInterno = "";
        
        //CON LOS INDICES DE FILAS
        if(nodoAux == this.raiz){//significa que es el primer elemento de la fila
            codigoInterno += "\t\tedge [dir = both, arrowsize=.5]\n";//agregamos el inicio
            codigoInterno += "\t\trank = same {";//agregamos el inicio
        }        
        else{//tiene un elemento a la izquierda, por tanto agregamos el punto y coma
             codigoInterno += " -> ";
        }
        if(nodoAux != null){//si el nodo no es nulo, agregamos el nodo
                codigoInterno += "nodo" +nodoAux.getId();//agregamos la alineacion
        }
        
        
        /**
         * Recorremos hasta no encontrar una sig
         */
        if(nodoAux.getSiguiente() != null && nodoAux.getSiguiente() != this.raiz){//si tiene un nodo a la derecha lo agregamos
            codigoInterno += getConexionesIndices(nodoAux.getSiguiente());
        }else{//sino
            //agregamos el cierre 
            if(nodoAux != this.raiz){
                codigoInterno += "-> nodo"+this.raiz.getId()+"}\n";
            }else{
                codigoInterno += "}\n";
            }
            
            //codigoInterno = "}\n";
        }
        
        return codigoInterno;
    }
    
}
