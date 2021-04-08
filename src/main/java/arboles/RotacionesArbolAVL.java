/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import nodos.Nodo;

/**
 * Clase especializada en las rotaciones
 * @author grifiun
 */
public class RotacionesArbolAVL {
    
    
    /**
     * Obtenemos el factor equilibrio de un nodo
     * @param nodoAux
     * @return 
     */
    public int calcularFactorEquilibrioNodo(Nodo nodoAux){
        if(nodoAux == null){
            return -1;//retornamos -1 porque significa que no existe el nodo
        }else{
            return nodoAux.getFactorEquilibrio();
        }
    }
    
    /**
     * Realizamos una rotacion simple a la derecha
     * @param nodoPadreAntiguo
     * @return 
     */
    public Nodo realizarRotacionSimpleIzquierda(Nodo nodoPadreAntiguo){
        Nodo nodoNuevoPadre = nodoPadreAntiguo.getHijoIzquierdo();//le agregamos el hijo izq como el neuvo padre
        nodoPadreAntiguo.setHijoIzquierdo(nodoNuevoPadre.getHijoDerecho());//Le agregamos el hijo derecho como el nuevo hijo izquierdo al antiguo nodo padre
        nodoNuevoPadre.setHijoDerecho(nodoPadreAntiguo);
        
        //Obtenemos el factor de equilibrio maximo (del antiguo padre)
        int nuevoFactorEquilibrioPadre = Math.max(calcularFactorEquilibrioNodo(nodoPadreAntiguo.getHijoIzquierdo()), //comparamos entre el fe del hijo izquierdo y el hijo derecho
                            calcularFactorEquilibrioNodo(nodoPadreAntiguo.getHijoDerecho()));//obtenemos el numero maximo de la fe de ambos hijos        
        nodoPadreAntiguo.setFactorEquilibrio(nuevoFactorEquilibrioPadre + 1);//Le sumamos 1 porque es el verdadero fe
        
        //agregamos el factor de equilibrio al nuevo padre
        int nuevoFactorEquilibrioNuevoPadre = Math.max(calcularFactorEquilibrioNodo(nodoNuevoPadre.getHijoIzquierdo()), //comparamos entre el fe del hijo izquierdo y el hijo derecho
                            calcularFactorEquilibrioNodo(nodoNuevoPadre.getHijoDerecho()));//obtenemos el numero maximo de la fe de ambos hijos        
        nodoNuevoPadre.setFactorEquilibrio(nuevoFactorEquilibrioNuevoPadre + 1);//Le sumamos 1 porque es el verdadero fe
        
        //retornamos el nuevo nodo padre
        return nodoNuevoPadre;
    }
    
    /**
     * Realizamos una rotacion simple a la izquierda
     * @param nodoPadreAntiguo
     * @return 
     */
    public Nodo realizarRotacionSimpleDerecha(Nodo nodoPadreAntiguo){
        Nodo nodoNuevoPadre = nodoPadreAntiguo.getHijoDerecho();//le agregamos el hijo derecho como el neuvo padre
        nodoPadreAntiguo.setHijoDerecho(nodoNuevoPadre.getHijoIzquierdo());//Le agregamos el hijo izquierdo como el nuevo hijo derecho al antiguo nodo padre
        nodoNuevoPadre.setHijoIzquierdo(nodoPadreAntiguo);
        
        //Obtenemos el factor de equilibrio maximo (del antiguo padre)
        int nuevoFactorEquilibrioPadre = Math.max(calcularFactorEquilibrioNodo(nodoPadreAntiguo.getHijoIzquierdo()), //comparamos entre el fe del hijo izquierdo y el hijo derecho
                            calcularFactorEquilibrioNodo(nodoPadreAntiguo.getHijoDerecho()));//obtenemos el numero maximo de la fe de ambos hijos        
        nodoPadreAntiguo.setFactorEquilibrio(nuevoFactorEquilibrioPadre + 1);//Le sumamos 1 porque es el verdadero fe
        
        //agregamos el factor de equilibrio al nuevo padre
        int nuevoFactorEquilibrioNuevoPadre = Math.max(calcularFactorEquilibrioNodo(nodoNuevoPadre.getHijoIzquierdo()), //comparamos entre el fe del hijo izquierdo y el hijo derecho
                            calcularFactorEquilibrioNodo(nodoNuevoPadre.getHijoDerecho()));//obtenemos el numero maximo de la fe de ambos hijos        
        nodoNuevoPadre.setFactorEquilibrio(nuevoFactorEquilibrioNuevoPadre + 1);//Le sumamos 1 porque es el verdadero fe
        
        //retornamos el nuevo nodo padre
        return nodoNuevoPadre;
    }
    
    /**
     * Realizamos la rotacion doble a la izquierda
     * (rotacion derecha y rotacion izquierda)
     * @param nodoPadreAntiguo
     * @return 
     */
    public Nodo realizarRotacionDobleIzquierda(Nodo nodoPadreAntiguo){
        Nodo nodoNuevoPadre;
        //realizamos una rotacion simple a la derecha
        nodoPadreAntiguo.setHijoIzquierdo(realizarRotacionSimpleDerecha(nodoPadreAntiguo.getHijoIzquierdo()));
        //realizamos la rotacion izquierda final
        nodoNuevoPadre = realizarRotacionSimpleIzquierda(nodoPadreAntiguo);
        //retornamos
        return nodoNuevoPadre;
    }
    
    /**
     * Realizamos la rotacion doble a la derecha
     * (rotacion izquierda y rotacion derecha)
     * @param nodoPadreAntiguo
     * @return 
     */
    public Nodo realizarRotacionDobleDerecha(Nodo nodoPadreAntiguo){
        Nodo nodoNuevoPadre;
        //realizamos una rotacion simple a la izquierda
        nodoPadreAntiguo.setHijoDerecho(realizarRotacionSimpleIzquierda(nodoPadreAntiguo.getHijoDerecho()));
        //realizamos la rotacion final
        nodoNuevoPadre = realizarRotacionSimpleDerecha(nodoPadreAntiguo);
        //retornamos
        return nodoNuevoPadre;
    }
}
