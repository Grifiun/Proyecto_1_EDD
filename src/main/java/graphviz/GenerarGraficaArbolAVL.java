/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphviz;

import java.io.FileWriter;
import java.io.PrintWriter;
import nodos.Nodo;

/**
 *
 * @author grifiun
 */
public class GenerarGraficaArbolAVL {
    Nodo raiz;
    
    public GenerarGraficaArbolAVL(Nodo raiz){
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
            fichero = new FileWriter("aux_grafico.dot");
            escritor = new PrintWriter(fichero);
            escritor.print(getCodigoGraphviz());
        } 
        catch (Exception e){
            System.err.println("Error al escribir el archivo aux_grafico.dot");
        }finally{
           try {
                if (null != fichero)
                    fichero.close();
           }catch (Exception e2){
               System.err.println("Error al cerrar el archivo aux_grafico.dot");
           } 
        }                        
        try{
          Runtime rt = Runtime.getRuntime();
          rt.exec( "dot -Tpng aux_grafico.dot -o graficas"+tipoGrafica+".png");

          //Esperamos medio segundo para dar tiempo a que la imagen se genere.
          //Para que no sucedan errores en caso de que se decidan graficar varios
          //árboles sucesivamente.
          Thread.sleep(1000);
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
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
               "\tnode [shape = record, style=filled, fillcolor = honeydew2];\n"+
                getCodigoInterno(raiz)+
                "\t}\n";
    }
    
    
    /**
     * Genera el código interior de graphviz, este método tiene la particularidad 
     * de ser recursivo, esto porque recorrer un árbol de forma recursiva es bastante 
     * sencillo y reduce el código considerablemente. 
     * @return 
     */
    private String getCodigoInterno(Nodo nodoAux) {
        String codigoInterno;
        if(nodoAux.getHijoIzquierdo() == null && nodoAux.getHijoDerecho() == null){//si no se tienen hijos
            codigoInterno = "\t\tnodo" + nodoAux.getId() + " [ label = \"" + nodoAux.getId() + "\"];\n";
        }else{
            codigoInterno = "\t\tnodo" + nodoAux.getId() + " [ label = \"<C0> |" + nodoAux.getId() + "| <C1>\"];\n";
        }
        if(nodoAux.getHijoIzquierdo() != null){//si el hijo izquierdo no es nulo, generamos su codigo
            codigoInterno += getCodigoInterno(nodoAux.getHijoIzquierdo()) +
               "\t\tnodo" + nodoAux.getId() + ":C0->nodo"+ nodoAux.getHijoIzquierdo().getId() + "\n";//agregamos el puntero
        }
        if(nodoAux.getHijoDerecho() != null){//si el hijo derecho no es nulo, agregamos su codigo interno
            codigoInterno += getCodigoInterno(nodoAux.getHijoDerecho()) +
               "\t\tnodo" + nodoAux.getId() + ":C1->nodo" + nodoAux.getHijoDerecho().getId() + "\n";//agregamos el puntero                   
        }
        return codigoInterno;
    }  
}
