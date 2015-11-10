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
public class Tablero{
    private int[][] tablero;
    private boolean gameOver;
    private static int p1 = 1;
    private static int p2 = 2;
    private static boolean turno ;
    
    public Tablero(boolean primeraJugada){
        tablero = new int[7][7];
        for (int i = 0; i < tablero.length; i++) {
            for(int j = 0; j < tablero[0].length;j++){
             
            	tablero[i][j] = 0;
            }
        }
        turno = primeraJugada;
        gameOver = false;
    }

    public Tablero() {
        tablero = new int[7][7];
        for (int i = 0; i < tablero.length; i++) {
            for(int j = 0; j < tablero[0].length;j++){
             
            	tablero[i][j] = 0;
            }
        }
    }
    public Tablero(int[][] clon) {
        this.tablero = clon;
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
    
    public void setTablero(int[][] tab){
        tablero = tab;
    }

    public void colocarFicha(int player, int columna) {
    	if(!gameOver){
            int iFila = tablero.length-1;
            boolean colocada = false;

            while(iFila>-1 && !colocada){
                if(tablero[iFila][columna]==0){
                    tablero[iFila][columna] = player;
                    colocada = true;
                }
                iFila--;
            }   
            //gameOver = ganaAlguien();
        }
    }
    
    public void colocarFicha(int columna){
        if(!gameOver){
            int iFila = tablero.length-1;
            boolean colocada = false;

            while(iFila>-1 && !colocada){
                if(tablero[iFila][columna]==0){
                    if(isTurno()){
                            tablero[iFila][columna] = 1;
                            turno = false;
                    }else{
                            tablero[iFila][columna] = 2;
                            turno = true;
                    }
                    colocada = true;
                }
                iFila--;
            }
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
