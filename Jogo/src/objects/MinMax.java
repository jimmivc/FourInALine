/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.Arrays;
import java.util.ArrayList;
/**
 *
 * @author Valeria
 */
public class MinMax {
    
    Nodo raiz;
    
    public MinMax(Tablero tab){
         setRaiz(new Nodo(tab));
         
    }
    
    public void insertarRecursivo(Nodo nodo/**raiz del arbol**/, Tablero dato , Tablero padre){
        Nodo nuevo = new Nodo(dato);
        
        //Si el padre es la raiz
        if(Arrays.deepEquals(nodo.getDato().getTablero(),padre.getTablero())){
            nodo.agregarHijos(nuevo);
        }else{
            //Si el padre es alguno de los hijos
            for(int i=0;i<nodo.cantHijos;i++){
                if(Arrays.deepEquals(nodo.hijos.get(i).getDato().getTablero(),padre.getTablero())){
                //Se agrega el hijo
                    nodo.hijos.get(i).agregarHijos(nuevo);
                }else{
                    //busca el padre en los hijos del nodo
                    //llamada recursiva
                    insertarRecursivo(nodo.hijos.get(i),dato,padre);
                }
        }
    }
  }
    private int cantHojas(Nodo nodo){
        int acum=0;
        if(nodo.getCantHijos()==0){
            return 1;
        }else{
            for(int i=0; i<nodo.cantHijos;i++){
                acum+= cantHojas(nodo.hijos.get(i));
            }
            return acum;
        }
    }
    
    public ArrayList<Nodo> getHojas(){
        ArrayList hojas = new ArrayList<Nodo>();
        
        hojas = getHojas(hojas,raiz);
        return hojas;
    }
    
    private ArrayList<Nodo> getHojas(ArrayList<Nodo> hojas,Nodo nodo){
        
        if(nodo.getCantHijos()==0){
            hojas.add(nodo);
            return hojas;
        }else{
            for(int i=0; i<nodo.cantHijos;i++){
                getHojas(hojas,nodo.hijos.get(i));
            }
            return hojas;
        }
    }
    
    
    public int cantHojas(){
        return cantHojas(this.raiz);
    }
    
    public Nodo getRaiz(){
        return this.raiz;
    }
    
    public void setRaiz(Nodo praiz){
        this.raiz = praiz;
    }
    
    public Nodo buscarTablero(Nodo tablero){
        Nodo nodo;
        nodo = getNodo(tablero,raiz);
        return nodo;
    }
    
    private Nodo getNodo(Nodo nodo, Nodo buscando){
        if (nodo != null){
            if(Arrays.deepEquals(nodo.dato.getTablero(), buscando.dato.getTablero())){
                return buscando;
            }else{
                for(int i=0; i<buscando.cantHijos;i++){
                    getNodo(nodo,buscando.hijos.get(i));
                }
            }
        }
        return null;
    }
    
    public void cambiarRaiz(Nodo tableroNuevo){
        Nodo nuevaRaiz = null;
        for(int i = 0;i<raiz.cantHijos;i++){
            if(Arrays.deepEquals(tableroNuevo.dato.getTablero(), raiz.hijos.get(i).dato.getTablero())){
                nuevaRaiz = raiz.hijos.get(i);
                i = raiz.cantHijos;
            }
        }
        if(nuevaRaiz != null)
            setRaiz(nuevaRaiz);
    }
}