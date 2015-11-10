/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author Valeria
 */
public class Nodo {
    int dato;
    int cantHijos;
    Nodo hijos[];
    //un arreglo temporal
    Nodo hijosT[];
    Nodo(int pdato){
        setDato(pdato);
        setHijos(this.hijos);
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setCantHijos(int cantHijos) {
        this.cantHijos = cantHijos;
    }

    public void setHijos(Nodo[] hijos) {
        this.hijos = hijos;
    }

    public int getDato() {
        return dato;
    }

    public int getCantHijos() {
        return cantHijos;
    }

    public Nodo[] getHijos() {
        return hijos;
    }
    
    public void copiarHijos(){
        //Aumenta el tamanio del arreglo
        hijosT= new Nodo[getCantHijos() +1];
        for(int i =0;i<getCantHijos();i++){
            hijosT[i] = hijos[i];
        }
    }
    
    public void agregarHijos(Nodo nodo){
        copiarHijos();//Primero aumento el tamanio del arreglo
        hijosT[getCantHijos()]=nodo;
        hijos= hijosT;
        setCantHijos(getCantHijos()+1);
    }
    
}
