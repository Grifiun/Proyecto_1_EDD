/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

import java.awt.Color;

/**
 *
 * @author grifiun
 */
public class NodoMatrix {
    int x;
    int y;
    Color color;
    int hex;
    NodoMatrix derecha;
    NodoMatrix izquierda;
    NodoMatrix arriba;
    NodoMatrix abajo;    
    
    /**
     * Este nodo pertenece a un nodo de una capa, es decir un pixel de cierta forma
     * con lo cual es necesario indicar su color en hex
     * @param x 
     * @param y
     * @param hexColor 
     */
    public NodoMatrix(int x, int y, int hexColor){
        //indices
        this.x = x;
        this.y = y;
        //hexColor = 0xe7423;
        this.hex = hexColor;
        this.color = new Color(hexColor);//Agregamos el color a traves del codigo en hex
        //Inicializamos puntieros;
        this.derecha = null;
        this.izquierda = null;
        this.arriba = null;
        this.abajo = null;
    }
    
    /**
     * El primer constructor pertenece a un nodo sin color, osease, un indice
     * 
     * @param x indica su pos x 
     * @param y indica su pos y
     */
    public NodoMatrix(int x, int y){
        //indices
        this.x = x;
        this.y = y;
        //hexColor = 0xe7423;
        this.color = null;
        //Inicializamos puntieros;
        this.derecha = null;
        this.izquierda = null;
        this.arriba = null;
        this.abajo = null;
    }

    public NodoMatrix getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoMatrix derecha) {
        this.derecha = derecha;
    }

    public NodoMatrix getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoMatrix izquierda) {
        this.izquierda = izquierda;
    }

    public NodoMatrix getArriba() {
        return arriba;
    }

    public void setArriba(NodoMatrix arriba) {
        this.arriba = arriba;
    }

    public NodoMatrix getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoMatrix abajo) {
        this.abajo = abajo;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public void imprimirConsola(){
        System.out.println("NODO: ("+x+", "+y+")");
        System.out.println("COLOR HEX: "+color.toString().replaceAll("java.awt.Color", "").replaceAll("\"", ""));
    }

    public int getHex() {
        return hex;
    }

    public void setHex(int hex) {
        this.hex = hex;
    }

    
    
    
}
