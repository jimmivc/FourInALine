/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author Jimmi
 */
public class Tablero {
    private int[][] tablero = new int[6][7];
    private static int p1 = 1;
    private static int p2 = 2;
    private static int vacio = 0;
    
    public Tablero(){
        for (int i = 0; i < tablero.length; i++) {
            for(int j = 0; j < tablero[0].length;j++){
                tablero[i][j] = vacio;
            }
        }
    }
    
    public String mostrarTablero(){
        String tabl = "";
        for (int i = 0; i < tablero.length; i++) {
            tabl += "|";
            for(int j = 0; j < tablero[0].length;j++){
                tabl += tablero[i][j] + "|";
            }
            tabl += "\n";
        }
        return tabl;
    }
    
    public int[][] getTablero(){
        return tablero;
    }

    public void colocarFicha(int iFila, int columna,int player) {
        tablero[iFila][columna] = player;
    }
    
}
