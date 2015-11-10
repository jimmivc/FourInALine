/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

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
    
    public int minimax(int depth,int turn){
        System.out.println(arbolito.cantHojas());
        
        for(int i = 0; i<7; i++){
            Tablero tab;
            int matriz[][] = new int[7][7];

            for (int k = 0; k < 7; k++) {
                for(int j = 0;j<7;j++){
                    matriz[k][j] = arbolito.raiz.dato.getTablero()[k][j];
                }
            }
            tab = new Tablero(matriz);
            tab.colocarFicha(1,i);
            arbolito.insertarRecursivo(arbolito.raiz, tab, arbolito.raiz.dato);
        }
        
        for(int i = 0; i<7; i++){
            Tablero tab;
            int matriz[][] = new int[7][7];

            for (int l = 0; l < 7; l++) {
                
            for (int k = 0; k < 7; k++) {
                for(int j = 0;j<7;j++){
                    matriz[k][j] = arbolito.raiz.hijos[i].dato.getTablero()[k][j];
                }
            }
            tab = new Tablero(matriz);
            tab.colocarFicha(2,l);
            
            
            arbolito.insertarRecursivo(arbolito.raiz, tab, arbolito.raiz.hijos[l].dato);   
            }
        }
        
        
        System.out.println(arbolito.cantHojas());
        //System.out.println(arbolito.raiz.dato.mostrarTablero());
        
        for(int i = 0; i<tablero.getTablero().length; i++){
            System.out.println("hijos de la raiz"+ arbolito.raiz.hijos[i].dato.mostrarTablero());
        }
        
        for(int i = 0; i<tablero.getTablero().length; i++){
            for (int j = 0; j < arbolito.raiz.hijos[i].hijos.length; j++) {
                System.out.println("hijos de la raiz"+ arbolito.raiz.hijos[i].hijos[j].dato.mostrarTablero());   
            }
        }
        
        //System.out.println(arbolito.raiz.dato.mostrarTablero());
        
        return 0;
    }
}
