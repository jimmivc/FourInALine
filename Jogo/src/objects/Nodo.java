/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;

/**
 *
 * @author Valeria
 */
public class Nodo {
    Tablero dato;
    int cantHijos;
    ArrayList<Nodo> hijos;
    int valor;
    //un arreglo temporal
    Nodo hijosT[];
    Nodo(Tablero pdato){
        setDato(pdato);
        setHijos(new ArrayList<Nodo>());
    }

    public void setDato(Tablero dato) {
        this.dato = dato;
    }

    public void setCantHijos(int cantHijos) {
        this.cantHijos = cantHijos;
    }

    public void setHijos(ArrayList<Nodo> hijos) {
        this.hijos = hijos;
    }

    public Tablero getDato() {
        return dato;
    }

    public int getCantHijos() {
        return cantHijos;
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }
    
    public void agregarHijos(Nodo nodo){
        hijos.add(nodo);
        setCantHijos(getCantHijos()+1);
    }
    
}
