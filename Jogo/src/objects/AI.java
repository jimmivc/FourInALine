/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;
import java.util.Arrays;
import org.omg.CORBA.INTERNAL;

/**
 *
 * @author Jimmi
 */
public class AI {
    private Tablero tablero;
    private int depth;
    private MinMax arbolito;
    
    public AI(Tablero tab,int pnivel){
        setTablero(tab);
        setDepth(pnivel);
        arbolito = new MinMax(new Tablero());
        minimax();
    }

    /**
     * @return the tablero
     */
    public Tablero getTablero() {
        return tablero;
    }

    /**
     * @param tablero the tablero to set
     */
    private void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    /**
     * @return the depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * @param depth the depth to set
     */
    private void setDepth(int depth) {
        this.depth = depth;
    }
    
    public int getScore(){
        //ganador por columna
        boolean ganaste = true;
        for(int i = 0;i<tablero.getTablero()[0].length;i++){
            if(tablero.getTablero()[5][i] == 1){
                for(int j = 5; j>2;j--){
                    if(tablero.getTablero()[j][i] != 1){
                        ganaste = false;
                    }
                }
                if(ganaste)
                        return 100;
                ganaste = true;
            }
        }
        return 0;
    }
    
//    public int minimax(int depth,int turn){
//        System.out.println(arbolito.cantHojas());
//        
//        for(int i = 0; i<7; i++){
//            Tablero tab;
//            int matriz[][] = new int[7][7];
//
//            for (int k = 0; k < 7; k++) {
//                for(int j = 0;j<7;j++){
//                    matriz[k][j] = arbolito.raiz.dato.getTablero()[k][j];
//                }
//            }
//            tab = new Tablero(matriz);
//            tab.colocarFicha(1,i);
//            arbolito.insertarRecursivo(arbolito.raiz, tab, arbolito.raiz.dato);
//        }
//        
//        
//        for(int i = 0; i<7; i++){
//            Tablero tab;
//            for (int l = 0; l < 7; l++) {
//                
//                int matriz[][] = new int[7][7];
//
//                for (int k = 0; k < 7; k++) {
//                    for(int j = 0;j<7;j++){
//                    matriz[k][j] = arbolito.raiz.hijos[l].dato.getTablero()[k][j];
//                    }
//                }
//                
//            tab = new Tablero(matriz);
//            tab.colocarFicha(2,i);
//            arbolito.insertarRecursivo(arbolito.raiz, tab, arbolito.raiz.hijos[l].dato);   
//            }
//        }
//        
//        
//        System.out.println(arbolito.cantHojas());
//        //System.out.println(arbolito.raiz.dato.mostrarTablero());
//        
//        for(int i = 0; i<tablero.getTablero().length; i++){
//            System.out.println("hijos de la raiz"+ arbolito.raiz.hijos[i].dato.mostrarTablero());
//        }
//        
//        for(int i = 0; i<tablero.getTablero().length; i++){
//            for (int j = 0; j < arbolito.raiz.hijos[i].hijos.length; j++) {
//                System.out.println("hijos de la raiz"+ arbolito.raiz.hijos[i].hijos[j].dato.mostrarTablero());   
//            }
//        }
//        
//        System.out.println(arbolito.raiz.cantHijos);
//        System.out.println(arbolito.raiz.hijos[0].cantHijos);
//        System.out.println(arbolito.raiz.hijos[1].cantHijos);
//        System.out.println(arbolito.raiz.hijos[2].cantHijos);
//        System.out.println(arbolito.raiz.hijos[3].cantHijos);
//        System.out.println(arbolito.raiz.hijos[4].cantHijos);
//        System.out.println(arbolito.raiz.hijos[5].cantHijos);
//        System.out.println(arbolito.raiz.hijos[6].cantHijos);
//        
//        return 0;
//    }
    
    public int minimax(int pdepth,boolean turno,Nodo nodo){
        System.out.println(arbolito.cantHojas());
        
        if(pdepth == 0){
            return 0;
        }else{
            for(int i = 0; i<7; i++){
                Tablero tab;
                int matriz[][] = new int[7][7];

                for (int k = 0; k < 7; k++) {
                    for(int j = 0;j<7;j++){
                        matriz[k][j] = nodo.dato.getTablero()[k][j];
                    }
                }
                tab = new Tablero(matriz);
                tab.colocarFicha(turno?1:2,i);
                arbolito.insertarRecursivo(arbolito.raiz, tab, nodo.dato);
            }
            if(turno)
                turno = false;
            else
                turno = true;
            for (int i = 0; i < nodo.cantHijos; i++) {
                
                minimax(pdepth-1,turno, nodo.hijos.get(i));    
                
            }
            
        }
        
        
        
        //System.out.println(arbolito.cantHojas());
        //System.out.println(arbolito.raiz.dato.mostrarTablero());
        
        
        //System.out.println(nodo.cantHijos);
        //System.out.println(arbolito.raiz.hijos[0].cantHijos);
        //System.out.println(arbolito.raiz.hijos[1].cantHijos);
        //System.out.println(arbolito.raiz.hijos[2].cantHijos);
        //System.out.println(arbolito.raiz.hijos[3].cantHijos);
        //System.out.println(arbolito.raiz.hijos[4].cantHijos);
        //System.out.println(arbolito.raiz.hijos[5].cantHijos);
        //System.out.println(arbolito.raiz.hijos[6].cantHijos);
        
        return 0;
    }
    
    public void minimax(){
        minimax(depth,tablero.isTurno(), arbolito.getRaiz()); // false:genera el arbol desde el turno del jugador
        ArrayList<Nodo> hojas = arbolito.getHojas();
        //for(int i = 0; i<hojas.size(); i++){
        //    System.out.println(hojas.get(i).dato.mostrarTablero());
        //}
    }
    
    public int hacerJugada(){
        int jugada = 1;
        if(!tablero.isTurno()){
            arbolito.cambiarRaiz(new Nodo(tablero));
            tablero.colocarFicha(jugada);
            System.out.println(arbolito.raiz.dato.mostrarTablero());
        }
        return jugada;
    }
    
    private void actualizarMinMax(){
        ArrayList<Nodo> primerNivel = arbolito.raiz.hijos;
        System.out.println(tablero.mostrarTablero());
        arbolito.buscarTablero(primerNivel.get(0)).dato.mostrarTablero();
        System.out.println(arbolito.raiz.dato.mostrarTablero());
    }

    private int columnaMejorJugada() {
        int columna = recorrerMinMax();
        return 0;
    }

    private int recorrerMinMax() {
        return 1;
    }
    
}
