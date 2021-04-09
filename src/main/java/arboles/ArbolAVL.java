/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import nodos.*;
/**
 *
 * @author grifiun
 */
public class ArbolAVL {
    private Nodo raiz;
    private RotacionesArbolAVL r;
    
    public ArbolAVL(){
        raiz = null;//inicializamos el nodo raiz
        r  = new RotacionesArbolAVL();//inicializamos el objeto de las rotaciones
    }
    
    public Nodo buscar(int id){
        return buscarNodo(id, raiz);
    }
    
    /**
     * Buscamos el nodo
     * @param id
     * @param nodoAux
     * @return 
     */
    private Nodo buscarNodo(int id, Nodo nodoAux){
        if(raiz == null){
            return null;
        }else if(nodoAux.getId() == id){ //Encontramos el nodo por el id
            return nodoAux;
        }else if(id < nodoAux.getId()){//Si el id dado es menor entonces buscamos por el hijo izquierdo
            return buscarNodo(id, nodoAux.getHijoIzquierdo());
        }else{//si es mayor entonces, buscamos por el nodo derecho
            return buscarNodo(id, nodoAux.getHijoDerecho());
        }
    }
    
    /**
     * Metodo que principal para insertar nuevos nodos
     * @param id 
     */
    public void insertar(int id){
        Nodo nuevoNodo = new Nodo(id);//instanciamos un nuevo nodo
        if(raiz == null){//entonces la lista esta vacia, ingresamos uno nuevo
            raiz = nuevoNodo;
        }else{            
            //insertamos en el arbol AVL
            raiz = insertarNodoAVL (nuevoNodo, raiz);
        }
    }
    
    /**
     * Funcion dedicada a insertar nodos, utiliza las rotaciones en los arboles
     * @param nodoAux
     * @return 
     */
    private Nodo insertarNodoAVL(Nodo nuevoNodo, Nodo nodoPadre){
        //Nodo nodoNuevoPadre = nodoPadre;
        if(nuevoNodo.getId() < nodoPadre.getId()){//insertamos por el nodo izquierdo
            //si no tiene hijos el nodo padre por la izquierda, lo agregamos directamente
            if(nodoPadre.getHijoIzquierdo() == null){
                nodoPadre.setHijoIzquierdo(nuevoNodo);//le agregamos el nuevo nodo
            }else{//sino, si tiene hijos e insertamos dentro del hijo izquierdo
                nodoPadre.setHijoIzquierdo(insertarNodoAVL(nuevoNodo, nodoPadre.getHijoIzquierdo()));
                
                //Revisamos el factor de equilibrio = fe.izquierdo - fe.derecho
                int factorEquilibrio = r.calcularFactorEquilibrioNodo(nodoPadre.getHijoIzquierdo()) - r.calcularFactorEquilibrioNodo(nodoPadre.getHijoDerecho());
                if(factorEquilibrio == 2){//++
                    if(nuevoNodo.getId() < nodoPadre.getHijoIzquierdo().getId()){
                        //++, rotacion por la izq        
                        nodoPadre = r.realizarRotacionSimpleIzquierda(nodoPadre);
                    }else{//sino, hacemos una rotacion doble a la izquierda (derecha izq)
                        nodoPadre = r.realizarRotacionDobleIzquierda(nodoPadre);
                    }
                }
            }        
        }else if(nuevoNodo.getId() > nodoPadre.getId()){//si es mayor, insertamos el la parte derecha
            //si no tiene hijos el nodo padre por la derecha, lo agregamos directamente
            if(nodoPadre.getHijoDerecho()== null){
                nodoPadre.setHijoDerecho(nuevoNodo);//le agregamos el nuevo nodo
            }else{//insertamos en el hijo derecho
                nodoPadre.setHijoDerecho(insertarNodoAVL(nuevoNodo, nodoPadre.getHijoDerecho()));
                
                //Revisamos el factor de equilibrio = fe.izquierdo - fe.derecho
                int factorEquilibrio = r.calcularFactorEquilibrioNodo(nodoPadre.getHijoIzquierdo()) - r.calcularFactorEquilibrioNodo(nodoPadre.getHijoDerecho());
                if(factorEquilibrio == -2){//--,
                    if(nuevoNodo.getId() > nodoPadre.getHijoDerecho().getId()){
                        // rotacion por la derecha  
                        nodoPadre = r.realizarRotacionSimpleDerecha(nodoPadre);
                    }else{//sino, hacemos una rotacion doble a la derecha (izq der)
                        nodoPadre = r.realizarRotacionDobleDerecha(nodoPadre);
                    }
                }
                
            }        
        }else{
            System.out.println("No se inserta el nuevo nodo, porque tiene un ID duplicado dentro del arbol AVL");
        }
        //Calculamos el nuevo factor de equilibrio
        if((nodoPadre.getHijoIzquierdo() == null) && (nodoPadre.getHijoDerecho() != null)){//solo tiene hijos por la der
            nodoPadre.setFactorEquilibrio(nodoPadre.getHijoDerecho().getFactorEquilibrio() + 1);//le agregamos la altura del hijo + 1
        }else if((nodoPadre.getHijoIzquierdo() != null) && (nodoPadre.getHijoDerecho() == null)){//solo tiene hijos por la izq
            nodoPadre.setFactorEquilibrio(nodoPadre.getHijoIzquierdo().getFactorEquilibrio() + 1);//le agregamos la altura del hijo + 1
        }else{//calculamos la altura mas alta de ambos hijos
            int nuevoFE = Math.max(r.calcularFactorEquilibrioNodo(nodoPadre.getHijoIzquierdo()), r.calcularFactorEquilibrioNodo(nodoPadre.getHijoDerecho()));
            nodoPadre.setFactorEquilibrio(nuevoFE + 1);//le sumamos 1 por la diferencia entre la altura y el FE
        }
        
        return nodoPadre;
    }
    
    
     /**
     * Borramos el nodo con el id dado
     * @param val
     */
    public void borrar(int id) {
        raiz = borrarNodo(raiz, id);
    }

    /**
     * Removemos tel nodo con el id dado, del subarbol dado
     * subtree.
     * 
     * @param nodoAux
     * @param id 
     * @return 
     */
    private Nodo borrarNodo(Nodo nodoAux, int id) {
        if (id < nodoAux.getId()) {//buscamos por la izquierda
            nodoAux.setHijoIzquierdo(borrarNodo(nodoAux.getHijoIzquierdo(), id));
        }
        else if (id > nodoAux.getId()) {//buscamos por la derecha
            nodoAux.setHijoDerecho(borrarNodo(nodoAux.getHijoDerecho(), id));
        }
        else {//encontramos el nodo
            if (nodoAux.getHijoIzquierdo() == null) {//si su hijo izquierdo no existe, entonces retornamos el derecho
                return nodoAux.getHijoDerecho();
            }
            else if (nodoAux.getHijoDerecho() == null) {//si el derecho es nulo, retornamos el nodo izquierdo
                return nodoAux.getHijoIzquierdo();
            }
            else {///si tiene ambos hijos, entonces creamos un auxiliar
                Nodo nodoAux2 = nodoAux;//segundo auxiliar
                nodoAux = nodoMinimo(nodoAux2.getHijoDerecho());//Calculamos el nodo minimo
                nodoAux.setHijoDerecho(borrarNodoMinimo(nodoAux2.getHijoDerecho()));
                nodoAux.setHijoIzquierdo(nodoAux2.getHijoIzquierdo());
            }
        }
        
        //Calculamos el nuevo factor de equilibrio
        if((nodoAux.getHijoIzquierdo() == null) && (nodoAux.getHijoDerecho() != null)){//solo tiene hijos por la der
            nodoAux.setFactorEquilibrio(nodoAux.getHijoDerecho().getFactorEquilibrio() + 1);//le agregamos la altura del hijo + 1
        }else if((nodoAux.getHijoIzquierdo() != null) && (nodoAux.getHijoDerecho() == null)){//solo tiene hijos por la izq
            nodoAux.setFactorEquilibrio(nodoAux.getHijoIzquierdo().getFactorEquilibrio() + 1);//le agregamos la altura del hijo + 1
        }else{//calculamos la altura mas alta de ambos hijos
            int nuevoFE = Math.max(r.calcularFactorEquilibrioNodo(nodoAux.getHijoIzquierdo()), r.calcularFactorEquilibrioNodo(nodoAux.getHijoDerecho()));
            nodoAux.setFactorEquilibrio(nuevoFE + 1);//le sumamos 1 por la diferencia entre la altura y el FE
        }
        
        return balancearArbolAVL(nodoAux);
    }
    
    /**
     * Removemos el nodo dado, y retornamos un nuevo subarbol sin el nodo a borrar
     * 
     * @param nodoAux
     * @return
     */
    private Nodo borrarNodoMinimo(Nodo nodoAux) {
        if (nodoAux.getHijoIzquierdo() == null) 
            return nodoAux.getHijoDerecho();//si solo existe el nodo derecho, entonces lo retornamos
        else{//sino
            //Comprobamos los valores del hijo izquierdo
            nodoAux.setHijoIzquierdo(borrarNodoMinimo(nodoAux.getHijoIzquierdo()));
            //Calculamos el nuevo factor de equilibrio
            if((nodoAux.getHijoIzquierdo() == null) && (nodoAux.getHijoDerecho() != null)){//solo tiene hijos por la der
                nodoAux.setFactorEquilibrio(nodoAux.getHijoDerecho().getFactorEquilibrio() + 1);//le agregamos la altura del hijo + 1
            }else if((nodoAux.getHijoIzquierdo() != null) && (nodoAux.getHijoDerecho() == null)){//solo tiene hijos por la izq
                nodoAux.setFactorEquilibrio(nodoAux.getHijoIzquierdo().getFactorEquilibrio() + 1);//le agregamos la altura del hijo + 1
            }else{//calculamos la altura mas alta de ambos hijos
                int nuevoFE = Math.max(r.calcularFactorEquilibrioNodo(nodoAux.getHijoIzquierdo()), r.calcularFactorEquilibrioNodo(nodoAux.getHijoDerecho()));
                nodoAux.setFactorEquilibrio(nuevoFE + 1);//le sumamos 1 por la diferencia entre la altura y el FE
            }
            
            //Balanceamos el nuevo arbol
            return balancearArbolAVL(nodoAux);
        }
        
    }
      
    /**
     * Retornamos el nodo minimo del subarbol dado
     * 
     * @param nodoAux
     * @return
     */
    private Nodo nodoMinimo(Nodo nodoAux) {
        if (nodoAux.getHijoIzquierdo() == null) //si no existe hijo izquierdo, retornamos el mismo nodo
            return nodoAux;
        else//sino, entonces buscamos dentro del hijo izquierdo su nodo minimo
            return nodoMinimo(nodoAux.getHijoIzquierdo());
    }
    
     /**
     * Despues de eliminar, balanceamos el arbol
     * 
     * @param nodoAux 
     * @return 
     */
    private Nodo balancearArbolAVL(Nodo nodoAux) {
        if (obtenerFactorEquilibrioHijosNodo(nodoAux) == -2) {
            if (obtenerFactorEquilibrioHijosNodo(nodoAux.getHijoDerecho()) > 0) {//si hay mas nodos en el lado izquierdo, hacemos rotaciones
                //Hacemos una rotacion por la derecha si es necesario hacer una antes 
                nodoAux.setHijoDerecho(r.realizarRotacionSimpleDerecha(nodoAux.getHijoDerecho()));
            }            
            nodoAux = r.realizarRotacionSimpleIzquierda(nodoAux);
        }
        else if (obtenerFactorEquilibrioHijosNodo(nodoAux) == 2) {
            if (obtenerFactorEquilibrioHijosNodo(nodoAux.getHijoIzquierdo()) < 0) {//si hay mas nodos en el lado derecho, hacemos rotaciones
                //Hacemos una rotacion por la izquierda si es necesario hacer una antes 
                nodoAux.setHijoIzquierdo(r.realizarRotacionSimpleIzquierda(nodoAux.getHijoIzquierdo()));
            }            
            nodoAux = r.realizarRotacionSimpleDerecha(nodoAux);
        }
        return nodoAux;
    }
    
    /**
     * Se calcula el factor de equilibrio de los hijos de un nodo
     */
    private int obtenerFactorEquilibrioHijosNodo(Nodo nodoAux){
        return r.calcularFactorEquilibrioNodo(nodoAux.getHijoIzquierdo()) - r.calcularFactorEquilibrioNodo(nodoAux.getHijoDerecho());  
    }
    
    
    /**
     * Recorremos el nodo inOrden (izq, padre, der)
     * @param nodoAux 
     */
    public void inOrden(Nodo nodoAux){
        if(nodoAux != null){
            inOrden(nodoAux.getHijoIzquierdo());//llamanos primero al izq
            System.out.println(nodoAux.getId()+", ");//imprimimos los id
            inOrden(nodoAux.getHijoDerecho());//llamamos al final el der
        }
    }
    
    /**
     * Recorremos el nodo preOrden (padre, izq, der)
     * @param nodoAux 
     */
    public void preOrden(Nodo nodoAux){
        if(nodoAux != null){            
            System.out.println(nodoAux.getId()+", ");//imprimimos los id
            preOrden(nodoAux.getHijoIzquierdo());//llamanos de segundo al izq
            preOrden(nodoAux.getHijoDerecho());//llamamos al final el der
        }
    }
    
    /**
     * Recorremos el nodo postOrden (izq, der, padre)
     * @param nodoAux 
     */
    public void postOrden(Nodo nodoAux){
        if(nodoAux != null){                        
            postOrden(nodoAux.getHijoIzquierdo());//llamanos primero al izq
            postOrden(nodoAux.getHijoDerecho());//llamamos de segundo el der
            System.out.println(nodoAux.getId()+", ");//imprimimos los id
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }
    
    
}
