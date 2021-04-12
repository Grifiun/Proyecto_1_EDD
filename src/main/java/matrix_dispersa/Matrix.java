/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix_dispersa;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import nodos.NodoMatrix;

/**
 *
 * @author grifiun
 */
public class Matrix {    
    private int cantidadNodos;
    private int numeroUltimaFila;
    private int numeroUltimaColumna;
    private int cantidadColumnasMax;
    private int cantidadFilasMax;
    private NodoMatrix raiz;
    
    private FuncionesIndices findices;
    
    /**
     * Inicializamos la matriz dispersa
     * inicalizamos el nodo raiz y todos los contadores
     */
    public Matrix(){
        this.raiz =  new NodoMatrix(0, 0);//Raiz, no mandamos color
        //inicializamos contadores
        this.cantidadNodos = 0;
        this.numeroUltimaFila = 0;
        this.numeroUltimaColumna = 0;
        this.findices = new FuncionesIndices();
    }
    
    /**
     * Funcion publica, sera la principal porque aca recibiremos los parametros necesarios
     * para crear un nuevo nodo, ejecuta el metodo para insertar nodos
     * @param columna
     * @param fila
     * @param hex 
     */
    public void insertar(int columna, int fila, int hex){
        //creamos un nuevo nodo
        NodoMatrix nuevoNodo = new NodoMatrix(columna, fila, hex);
        insertar(nuevoNodo);
    
    }
    
    /**
     * Metodo para insertar nodos dentro de la matrix dix
     * @param nuevoNodo 
     */
    public void insertar(NodoMatrix nuevoNodo){
        NodoMatrix nuevoAux = nuevoNodo;
        //obtenemos la posicion
        int fila = nuevoNodo.getY();
        int columna = nuevoNodo.getX();
        
        //Obtenemos los inicios ded filas y columnas
        NodoMatrix inicioFila = obtenerFila(fila, true);
        NodoMatrix inicioColumna = obtenerColumna(columna, true);
        
        //Insercion en columnas        
        nuevoAux = findices.insertarFila(inicioColumna, nuevoAux);
        //Insercion en filas
        nuevoAux = findices.insertarColumna(inicioFila, nuevoAux);
        //aumentamos la cantidad de nodos en 1
        cantidadNodos++;
    }
    
    /**
     * Funcion encargada de buscar el nodo de la matriz, que coincida con el numero
     * de columna y fila dados
     * @param columna
     * @param fila
     * @return 
     */
    public NodoMatrix buscarNodoMatrix(int columna, int fila){
        //en este caso el booleano es false, porque en la busqueda
        //no se deben de crear los indices de forma automatica
        NodoMatrix nodoColumna = obtenerColumna(columna, false);
        //Buscamos el nodo empezando en el indice del nodo columna encontrado anteriormetne
        NodoMatrix nodoAux = obtenerFila(nodoColumna, fila);
        //retornamos el nodo hallado (o nulo)
        return nodoAux;
    }
    
    /**
     * Funcion que retorna el indice de fila, si el parametro booleano es verdadero
     * se crea un nuevo indice en caso de que este no existiera
     * @param fila
     * @param crearSiNoExiste
     * @return 
     */
    private NodoMatrix obtenerFila(int fila, boolean crearSiNoExiste){        
        NodoMatrix auxFila = raiz.getAbajo();//obtenemos el primero de la raiz hacia abajo
        
        NodoMatrix aux =  obtenerFila(auxFila, fila);        
        if(aux == null && crearSiNoExiste){//si no existe la fila pero esta activo lo de crear si no existe
            return insertarFila(fila);
        }else{
            return aux;
        }
    }
    
    /**
     * Funcion recursiva que compara el indice fila (Y), y retorna
     * el indice hasta que lo haga conicidir
     * @param auxFila
     * @param fila
     * @return 
     */
    private NodoMatrix obtenerFila(NodoMatrix auxFila, int fila){        
        if(auxFila != null){//si existen filas
            if(auxFila.getY() == fila){
                return auxFila;
            }else{
                //sino, recorremos recursivamente
                return obtenerFila(auxFila.getAbajo(), fila);
            }        
        }
        //si no se retorna nada entonces no existe esa fila
        return null;
    }
    
    /**
     * Se obtiene una columna, a partir de un numero de columna
     * si la var boleana es verdadera, se crea un nuevo indice en caso de no existir
     * @param columna
     * @param crearSiNoExiste
     * @return 
     */
    private NodoMatrix obtenerColumna(int columna, boolean crearSiNoExiste){        
        NodoMatrix auxColumna = raiz.getDerecha();//obtenemos el primero de la raiz hacia la derecha
        
        NodoMatrix aux =  obtenerColumna(auxColumna, columna);        
        if(aux == null && crearSiNoExiste){//si no existe la fila pero esta activo lo de crear si no existe
            return insertarColumna(columna);
        }else{
            return aux;
        }
    }
    
    /**
     * Funcion recursiva que obtiene el indice de una columna hasta que 
     * el numero de indice dado coincida con algun elemento de la lista
     * @param auxColumna
     * @param columna
     * @return 
     */
    private NodoMatrix obtenerColumna(NodoMatrix auxColumna, int columna){        
        if(auxColumna != null){//si existen filas
            if(auxColumna.getX() == columna){
                return auxColumna;
            }else{
                //sino, recorremos recursivamente
                return obtenerColumna(auxColumna.getDerecha(), columna);
            }        
        }
        //si no se retorna nada entonces no existe esa columna
        return null;
    }
    
    
    /**
     * Metodo que utiliza el metodo recursivo de los indices, en este caso solo recibimos el numero de fila
     * @param filaNum
     * @return 
     */
    private NodoMatrix insertarFila(int filaNum){
        NodoMatrix aux = findices.insertarFila(raiz, filaNum);//auxiliar, obtiene el valor             
        //miramos si la fila es la mas grande
        if(filaNum > numeroUltimaFila){
            this.numeroUltimaFila = filaNum;//agregamos el numero de la ultima fila
        }         
        return aux;
    }
    
    /**
     * Metodo que utiliza el metodo recursivo de los indices, en este caso solo recibimos el numero de columna
     * @param raiz
     * @param columnaNum
     * @return 
     */
    private NodoMatrix insertarColumna(int columnaNum){
        NodoMatrix aux = findices.insertarColumna(raiz, columnaNum);//auxiliar, obtiene el valor      
        //miramos si la columna es la mas grande
        if(columnaNum > numeroUltimaColumna){
            this.numeroUltimaColumna = columnaNum;//agregamos el numero de la ultima columna
        }  
        return aux;
    }
    
    /**
     * Se obtiene la longitud real de las filas, por ejemplo si solo se tienen las filas 
     * 5, 6, 8 y 10, la longitud real deberia de ser 5, ya que el rango es de 5 a 10
     * @return 
     */
    public int obtenerLongitudRealFilas(){
        if(numeroUltimaFila > 0){
            //ecuacion = cantidad max - primera fila
            // long = 10 - 6 = 4
            System.out.println("Filas: "+numeroUltimaFila);
            return numeroUltimaFila;
        }else
            return 0;
    }
    
    /**
     * Se obtiene la longitud real de las columnas, por ejemplo si solo se tienen las columnas 
     * 5, 6, 8 y 10, la longitud real deberia de ser 5, ya que el rango es de 5 a 10
     * @return 
     */
    public int obtenerLongitudRealColumnas(){
        if(numeroUltimaColumna > 0){
            //ecuacion = cantidad max - primera columna
            // long = 10 - 6 = 4
            System.out.println("Columnas: "+numeroUltimaColumna);
            return numeroUltimaColumna;
        }else
            return 0;
    }

    public NodoMatrix getRaiz() {
        return raiz;
    }
    
    public void graficarMatrixDix(JPanel panel, int cantidadColumnasMax, int cantidadFilasMax){
        if(cantidadColumnasMax == -1 && cantidadFilasMax == -1){//valores por default para cada capa
            this.cantidadColumnasMax = obtenerLongitudRealColumnas();
            this.cantidadFilasMax = obtenerLongitudRealFilas();
        }else{
            this.cantidadColumnasMax = cantidadColumnasMax;
            this.cantidadFilasMax = cantidadFilasMax;
        }
        
        
        graficarFilas(panel, raiz);
    }
    
    public void graficarFilas(JPanel panel, NodoMatrix nodo){
        graficarColumnaPorFila(panel, nodo);
        if(nodo.getAbajo() != null){//hay mas filas
            graficarFilas(panel, nodo.getAbajo());//nos movemos a la otra fila
        }
    }
    
    public void graficarColumnaPorFila(JPanel panel, NodoMatrix nodo){
        //int widthPixel = 840 / (numeroUltimaColumna + 1);//sumamos 1 por los indicadores de indice
        //int heightPixel = 840 / (numeroUltimaFila + 1);
        int max = Math.max(cantidadColumnasMax, cantidadFilasMax);
        int widthPixel = 840 / (max + 1);//sumamos 1 por los indicadores de indice
        int heightPixel = 840 / (max + 1);
        
        if(nodo != null){   
            JPanel panelPixel = new JPanel();
            panelPixel.setLayout(new BorderLayout());
            Color colorPixel = nodo.getColor();
            
            if(colorPixel == null || nodo.getHex() == 0){//si no tiene color es un indice
                //System.out.println("Es un indice");
                colorPixel = new Color(0xffffff);//color blanco, para los indices
                JLabel indice = new JLabel("Indice: "+Math.max(nodo.getX(), nodo.getY()));
                panelPixel.add(indice, BorderLayout.CENTER);
            }
            
            panelPixel.setBackground(colorPixel);
            //System.out.println("Pixel: x: "+widthPixel * nodo.getX()+" y: "+widthPixel * nodo.getY());
            
            panelPixel.setBounds(widthPixel * nodo.getX(), widthPixel * nodo.getY(), widthPixel, heightPixel);
            panel.add(panelPixel);
        }
        
        if(nodo.getDerecha() != null){//recorremos a la derecha
            graficarColumnaPorFila(panel, nodo.getDerecha());
        }
    }
    
    
    
}
