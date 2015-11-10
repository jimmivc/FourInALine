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
public class MinMax {
    
    Nodo raiz;
    
    public MinMax(Tablero tab){
         setRaiz(new Nodo(tab));
    }
    
    public void insertarRecursivo(Nodo nodo/**raiz del arbol**/, Tablero dato , Tablero padre){
        Nodo nuevo = new Nodo(dato);
        
        //Si el padre es la raiz
        if(nodo.getDato()==padre){
            nodo.agregarHijos(nuevo);
        }else{
            //Si el padre es alguno de los hijos
            for(int i=0;i<nodo.cantHijos;i++){
                if(nodo.hijos[i].getDato()==padre){
                //Se agrega el hijo
                    nodo.hijos[i].agregarHijos(nuevo);
                }else{
                    //busca el padre en los hijos del nodo
                    //llamada recursiva
                    insertarRecursivo(nodo.hijos[i],dato,padre);
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
                acum+= cantHojas(nodo.hijos[i]);
            }
            return acum;
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
    
    
}