/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphviz;

import nodos.Nodo;
import nodos.NodoAVLUsuario;
import nodos.NodoImagen;
import nodos.NodoListaEnlazada;
import nodos.NodoListaImagen;

/**
 *
 * @author grifiun
 */
public class GenerarGraficaArbolAVLUsuario extends GenerarGraficaArbolAVL{

    public GenerarGraficaArbolAVLUsuario(Nodo raiz) {
        super(raiz);
    }
    /**
     * Método que retorna el código que grapviz usará para generar la imagen     
     * del árbol AVL
     * @return 
     */
    public String getCodigoGraphviz(String titulo) {
        return "digraph grafica{\n" +
               "\tlabel=\"Arbol de "+titulo+"\""+
               "\trankdir=TB;\n" +
               "\tnode [shape = record, style=filled, fillcolor = honeydew2];\n"+
                getCodigoInterno(raiz)+
                "\t//IMAGENES?\n"+
                getListadoImagenes((NodoListaEnlazada) raiz)+
                "\t}\n";
    }
    
    private String getListadoImagenes(NodoListaEnlazada nodoAux){
        String codigoInterno = "";
        if(nodoAux != null){
            System.out.println("Nodo Usuario"+nodoAux.getId());
            codigoInterno += "\t\tnodo" + nodoAux.getId() + " [ label = \"" + nodoAux.getId() + "\", group="+nodoAux.getId()+"];\n";
            
            codigoInterno += "\t\t//Imagenes\n";
            
            if(((NodoAVLUsuario)nodoAux).getListadoImagenesUsuario()!= null && ((NodoAVLUsuario)nodoAux).getListadoImagenesUsuario().getRaiz() != null){//si tiene un listadao de imagenes
                NodoListaImagen nodoRaizAux = (NodoListaImagen) ((NodoAVLUsuario)nodoAux).getListadoImagenesUsuario().getRaiz();
                FuncionGenerarCodigoListaEnlazada generarCodigoLista = new FuncionGenerarCodigoListaEnlazada(nodoRaizAux, nodoAux.getId(), "Imagen");
                codigoInterno += generarCodigoLista.getCodigoGraphviz();
            }
            
        }else{
            return "";
        }
        
        if(nodoAux.getSiguiente()!= null){//si el nodo derecho no es nulo, agregamos su codigo interno
            //codigoInterno += "\t\tnodo" + nodoAux.getId() + " -> nodo" + nodoAux.getSiguiente().getId() + "\n";//agregamos el puntero   al nod siguiente
            if(nodoAux.getSiguiente() != null && nodoAux.getSiguiente() != this.raiz){//si tiene un siguiente y no es el nodo raiz, seguimos graficando
                codigoInterno += getCodigoInterno(nodoAux.getSiguiente());
            }
        }
        
        return codigoInterno;
    }
}
