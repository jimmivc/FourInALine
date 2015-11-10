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
    private int[][] tablero = new int[7][7];
    private boolean gameOver;
    private static int p1 = 1;
    private static int p2 = 2;
    private static boolean turno ;
    
    public Tablero(boolean primeraJugada){
        for (int i = 0; i < tablero.length; i++) {
            for(int j = 0; j < tablero[0].length;j++){
             
            	tablero[i][j] = 0;
            }
        }
        turno = primeraJugada;
        gameOver = false;
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

    public void colocarFicha(int iFila, int columna) {
    	if(!gameOver){
            int player;
            if(turno)
                    player = p1;
            else{
                    player = p2;
            }
            if(turno){
                    tablero[iFila][columna] = player;
                    turno = false;
            }else{
                    tablero[iFila][columna] = player;
                    turno = true;
            }
            //gameOver = ganaAlguien();
        }
    }

    public boolean isTurno() {
        return turno;
    }
    
    public boolean isGameOver(){
        return gameOver;
    }
    
    private boolean ganaAlguien(){
        boolean gana = false;
        int pGanador;
        
        return true;
    }
    
}
