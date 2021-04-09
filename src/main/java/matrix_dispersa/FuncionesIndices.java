/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix_dispersa;

import nodos.NodoMatrix;

/**
 *
 * @author grifiun
 */
public class FuncionesIndices {
    /**
     * Metodo recursivo que inserta auna nueva fila a partir de un indice
     * @param raiz
     * @param filaNum
     * @return 
     */
    public NodoMatrix insertarFila(NodoMatrix raiz, int filaNum){
        NodoMatrix indiceFila = raiz.getAbajo();//Obtenemos la siguiente fila (Y)
        NodoMatrix nuevoNodo = new NodoMatrix(0, filaNum);//X, Y
        
        if(indiceFila == null){//si no hay filas creamos uno nuevo
            //creamos un nuevo indice de fila (Y abajo)
            raiz.setAbajo(nuevoNodo);
            //Agregamos el apuntador hacia el nodo raiz
            nuevoNodo.setArriba(raiz);                        
        }else{//recorremos las filas 
            if(indiceFila.getY() > filaNum){//si la fila siguiente al index es mayor a la nueva fila
                //entonces agregamos la nueva fila entre ambas filas
                nuevoNodo.setAbajo(indiceFila);//agregamos el apuntador a la fila de abajo
                nuevoNodo.setArriba(raiz);//agregamos el apuntador hacia el indce arriba
                indiceFila.setArriba(nuevoNodo);
                raiz.setAbajo(nuevoNodo);
            }else{//sino, recorremos todo   
                //insertarFila(RAIZ, Numero de fila)
                //para la siguiente iteracion nuestro nuevo raiz sera la fila actual     
                //y el nujmero de fila se mantiene
                return insertarFila(indiceFila, filaNum);
            }
        
        }   
        
        //retornamos
        return nuevoNodo;    
    }
    
    /**
     * Metodo recursivo que inserta an nodo en una fila
     * a partir de un indice dado
     * @param raiz
     * @param filaNum
     * @return 
     */
    public NodoMatrix insertarFila(NodoMatrix raiz, NodoMatrix nuevoNodo){
        int filaNum = nuevoNodo.getY();
        NodoMatrix indiceFila = raiz.getAbajo();//Obtenemos la siguiente fila (Y)
        
        if(indiceFila == null){//si no hay filas creamos uno nuevo
            //creamos un nuevo indice de fila (Y abajo)
            raiz.setAbajo(nuevoNodo);
            //Agregamos el apuntador hacia el nodo raiz
            nuevoNodo.setArriba(raiz);                        
        }else{//recorremos las filas 
            if(indiceFila.getY() > filaNum){//si la fila siguiente al index es mayor a la nueva fila
                //entonces agregamos la nueva fila entre ambas filas
                nuevoNodo.setAbajo(indiceFila);//agregamos el apuntador a la fila de abajo
                nuevoNodo.setArriba(raiz);//agregamos el apuntador hacia el indce arriba
                indiceFila.setArriba(nuevoNodo);
                raiz.setAbajo(nuevoNodo);
            }else{//sino, recorremos todo   
                //insertarFila(RAIZ, Numero de fila)
                //para la siguiente iteracion nuestro nuevo raiz sera la fila actual     
                //y el nujmero de fila se mantiene
                return insertarFila(indiceFila, nuevoNodo);
            }
        
        }   
        
        //retornamos
        return nuevoNodo;    
    }
    
    /**
     * Metodo recursivo para insertar una nueva columna, una nueva columna, entre columnas o al inicio
     * @param raiz
     * @param columnaNum
     * @return 
     */
    public NodoMatrix insertarColumna(NodoMatrix raiz, int columnaNum){
        NodoMatrix indiceColumna = raiz.getDerecha();//Obtenemos la siguiente fila (X+)
        NodoMatrix nuevoNodo = new NodoMatrix(columnaNum, 0);//X, Y
        
        if(indiceColumna == null){//si no hay columnas creamos uno nuevo
            //creamos un nuevo indice de columna (X derecha)
            raiz.setDerecha(nuevoNodo);
            //Agregamos el apuntador hacia el nodo raiz
            nuevoNodo.setIzquierda(raiz);                        
        }else{//sino esta vacio, recorremos las columnas 
            if(indiceColumna.getX() > columnaNum){//si la columna siguiente al index es mayor a la nueva fila
                //entonces agregamos la nueva columna entre ambas columnas
                nuevoNodo.setDerecha(indiceColumna); //apuntamos a la columna de la der               
                nuevoNodo.setIzquierda(raiz);//apuntamos al indice izq
                indiceColumna.setIzquierda(nuevoNodo);
                raiz.setDerecha(nuevoNodo);
            }else{//sino, recorremos todo con recursividad
                //insertarColumna(RAIZ, Numero de columna)
                //para la siguiente iteracion nuestro nuevo raiz sera la columna actual     
                //y el nujmero de columna se mantiene
                return insertarColumna(indiceColumna, columnaNum);
            }
        
        }   
        
        //retornamos
        return nuevoNodo;    
    }
    
    /**
     * Metodo recursivo para insertar un nuevo nodo
     * dentro de la columna con indice dado
     * @param raiz
     * @param columnaNum
     * @return 
     */
    public NodoMatrix insertarColumna(NodoMatrix raiz, NodoMatrix nuevoNodo){
        int columnaNum = nuevoNodo.getX();
        NodoMatrix indiceColumna = raiz.getDerecha();//Obtenemos la siguiente fila (X+)
        
        if(indiceColumna == null){//si no hay columnas creamos uno nuevo
            //creamos un nuevo indice de columna (X derecha)
            raiz.setDerecha(nuevoNodo);
            //Agregamos el apuntador hacia el nodo raiz
            nuevoNodo.setIzquierda(raiz);                        
        }else{//sino esta vacio, recorremos las columnas 
            if(indiceColumna.getX() > columnaNum){//si la columna siguiente al index es mayor a la nueva fila
                //entonces agregamos la nueva columna entre ambas columnas
                nuevoNodo.setDerecha(indiceColumna); //apuntamos a la columna de la der               
                nuevoNodo.setIzquierda(raiz);//apuntamos al indice izq
                indiceColumna.setIzquierda(nuevoNodo);
                raiz.setDerecha(nuevoNodo);
            }else{//sino, recorremos todo con recursividad
                //insertarColumna(RAIZ, Numero de columna)
                //para la siguiente iteracion nuestro nuevo raiz sera la columna actual     
                //y el nujmero de columna se mantiene
                return insertarColumna(indiceColumna, nuevoNodo);
            }        
        }   
        
        //retornamos
        return nuevoNodo;    
    }
}
