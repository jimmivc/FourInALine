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

    public int minimax(int pdepth,boolean turno,Nodo nodo){
        System.out.println(arbolito.cantHojas());
        
        if(pdepth == 0){
            return 0;
        }else{
            for(int i = 0; i<7; i++){
                Tablero tab;
                int matriz[][] = new int[7][7];

                for (int k = 0; k < 7; k++) {
                    System.arraycopy(nodo.dato.getTablero()[k], 0, matriz[k], 0, 7);
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
        
        return 0;
    }
    
    public void minimax(){
        minimax(depth,tablero.isTurno(), arbolito.getRaiz()); // false:genera el arbol desde el turno del jugador
    }
    
    public int hacerJugada(){
        int jugada = 1;
        if(!tablero.isTurno()){
            arbolito.cambiarRaiz(new Nodo(tablero));
            actualizarMinMax();
            jugada = columnaMejorJugada();
            tablero.colocarFicha(jugada);
            arbolito.cambiarRaiz(new Nodo(tablero));
            actualizarMinMax();
            System.out.println("Raiz Actual!!! \n"+arbolito.raiz.dato.mostrarTablero());
        }
        return jugada;
    }

    
    private void actualizarMinMax(){
        ArrayList<Nodo> hojas = arbolito.getHojas();
        boolean turno;
        if(depth%2 == 0){
            turno = !tablero.isTurno();
        }else{
            turno = tablero.isTurno();
        }
        
        for (int o = 0; o < hojas.size(); o++) {
            
            for(int i = 0; i<7; i++) {
                    Tablero tab;
                    int matriz[][] = new int[7][7];

                    for (int k = 0; k < 7; k++) {
                        for(int j = 0;j<7;j++){
                            matriz[k][j] = hojas.get(o).dato.getTablero()[k][j];
                        }
                    }
                    tab = new Tablero(matriz);
                    tab.colocarFicha(turno?1:2,i);
                    arbolito.insertarRecursivo(arbolito.raiz, tab, hojas.get(o).dato);
//                    System.out.println(hojas.get(o).cantHijos);
            }

        }
//        hojas = arbolito.getHojas();
//        for(int i = 0; i<hojas.size(); i++){
//            System.out.println(hojas.get(i).dato.mostrarTablero());
//        }
    }
    
    private int columnaMejorJugada() {
        ArrayList<Nodo> hojas = arbolito.getHojas();
        ArrayList<Integer> valores = new ArrayList<>();
        int columna= -1;
        int posicionNodo = -1;
        
        for (int i = 0; i < hojas.size(); i++) {
            valores.add(hojas.get(i).dato.valorTablero());
            System.out.print(valores.get(i));
        }
        //valor minimo
        for (int i = 0; i < valores.size(); i++) {
            if(valores.get(i)<0){
                posicionNodo = i;
            }
        }
        
        int cantHojas = hojas.size();
        int profundidad = depth;
        int contador = 0;
        
        if(posicionNodo != -1){
            for (int i = 0; i < profundidad; i++) {
                for (int k = 0; k < 7; k++) {
                    for (int j = 0; j < cantHojas; j++) {
                        if (contador==posicionNodo) {
                            posicionNodo = k;
                            cantHojas /=7;
                        }else{
                            contador++;
                        }
                    }
                }
            }
            return posicionNodo;
        }else{
            return (int)(Math.floor((Math.random() * 6)+0));
        }
        
    }
}
