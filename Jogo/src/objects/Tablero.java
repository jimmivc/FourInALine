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
    
    public boolean enLineaVertical(int x,int y){
        int aux=0;
        int sum=0;
        int i=x;
        aux=getTablero()[x][y];
        while(i>=0&&sum!=4){
            
            if(aux==getTablero()[i][y]){
                sum+=1;
            }else{
                sum =0;
            }
            aux=getTablero()[i][y];
            i--;
        }
        if(sum==4){
            return true;
        }else{
        return false;
        }
    }
    
    public boolean enLineaHorizontal(int x,int y){
        int aux=0;
        int sum=0;
        int i=x;
        aux=getTablero()[x][y];
        while(i>=0&&sum!=4){
            
            if(aux==getTablero()[x][i]){
                sum+=1;
            }else{
                sum =0;
            }
            aux=getTablero()[x][i];
            i--;
        }
        if(sum==4){
            return true;
        }else{
        return false;
        }
    }
    
    public int ganadorVertical(int x, int y){  	
        int var=0;
	        	 
        if(getTablero()[x][y]==1){
	    if(x-3>=0)
                for(int i=x;i>=0;i--){
                   if(getTablero()[i][0]==1){
                        var+=1;
                    }
	        }
            }else if(getTablero()[x][y]==2){
	        return -1;
            }else{
                return 0;
            }
        
        if(var>=3){
            if(enLineaVertical(x,y)){
	    return 1;
            }
        }
	return 0; 
    }
    
    public int ganadorHorizontal(int x, int y){
	int var=0;
	if(getTablero()[x][y]==1){
	    if(y-3>=0)
	        for(int i=y;i>=0;i--){ 
                    if(getTablero()[x][i]==1){
	        	var+=1;
                    }
	        }
	}else if(getTablero()[x][y]==2){
	    return -1; 
	}else{
            return 0;
        }
	if(var>=3){
            if(enLineaHorizontal(x,y)){
	    return 1;
            }
	}
	return 0;
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
