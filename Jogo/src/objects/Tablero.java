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

    public boolean fourInRow(int sum){
        if(sum>=3){
            return true;
        }else{
        return false;
        }
    }
    public boolean enLinea(int x, int y,int pos){
        int aux=0;
        int sum=0;
        int i=0;
        int cont=0;
        aux=getTablero()[x][y];
        if(pos==1||pos==3){
            i=x;   
            cont =y;
        }else if(pos==2){
            i=y;
        }
        while(i>=0&&sum!=4){
            if(pos==1){
                if(aux==getTablero()[i][y] || getTablero()[i][y]==1){
                    sum+=1;
                }else{
                    sum=0;
                }
                 aux=getTablero()[i][y];
                  i--;
            }else if(pos==2){
                if(aux==getTablero()[x][i]|| getTablero()[x][i]==1){
                    sum+=1;
                }else{
                    sum=0;
                }
                aux=getTablero()[x][i];
                 i--;
            }else if(pos==3){
                if(aux==getTablero()[i][cont] ||getTablero()[i][cont]==1){
                        sum+=1;
                    }else{
                    sum=0;
                }
                    aux=getTablero()[i][cont];
                    cont--;
                     i--;
            }else if(pos==4){
                if(i<6){
                    i=-1;
                }else{
                if(aux==getTablero()[i][cont]||getTablero()[i][cont]==1){
                    sum+=1;
                }else{
                    sum=0;
                }
                    aux=getTablero()[i][cont];
                    cont++;
                    i++;
                }
            }
           
        }
        return fourInRow(sum);
    }
    public boolean enLineaCompu(int x, int y,int pos){
        int aux=0;
        int sum=0;
        int i=0;
        int cont=0;
        aux=getTablero()[x][y];
        if(pos==1||pos==3){
            i=x;   
            cont =y;
        }else if(pos==2){
            i=y;
        }
        while(i>=0&&sum!=4){
            if(pos==1){
                if(aux==getTablero()[i][y] || getTablero()[i][y]==2){
                    sum+=1;
                }else{
                    sum=0;
                }
                 aux=getTablero()[i][y];
                  i--;
            }else if(pos==2){
                if(aux==getTablero()[x][i]|| getTablero()[x][i]==2){
                    sum+=1;
                }else{
                    sum=0;
                }
                aux=getTablero()[x][i];
                 i--;
            }else if(pos==3){
                if(aux==getTablero()[i][cont] ||getTablero()[i][cont]==2){
                        sum+=1;
                    }else{
                    sum=0;
                }
                    aux=getTablero()[i][cont];
                    cont--;
                     i--;
            }else if(pos==4){
                if(i<6){
                    i=-1;
                }else{
                if(aux==getTablero()[i][cont]||getTablero()[i][cont]==2){
                    sum+=1;
                }else{
                    sum=0;
                }
                    aux=getTablero()[i][cont];
                    cont++;
                    i++;
                }
            }
           
        }
        return fourInRow(sum);
    }
    
    
    public int ganadorVertical(int x, int y){  	
        int var=0;
	int var2=0;        	 
        if(getTablero()[x][y]==1){
	    if(x-3>=0)
                for(int i=x;i>=0;i--){
                   if(getTablero()[i][0]==1){
                        var+=1;
                    }else if(getTablero()[i][0]==2){
                        var2+=1;
                    }
	        }
            }else if(getTablero()[x][y]==2){
                for(int i=x;i>=0;i--){
                   if(getTablero()[i][0]==1){
                        var+=1;
                    }else if(getTablero()[i][0]==2){
                         var2+=1;
                    }
	        }
	       // return -1;
            }else{
                return 0;
            }
        
        if(var>=3){
            if(enLinea(x,y,1)){
	    return 1;
            }
        }
        if(var2>=3){
            if(enLineaCompu(x,y,1)){
            return -1;
            }
        }
	return 0; 
    }
    
    public int ganadorHorizontal(int x, int y){
	int var=0;
        int var2=0;
	if(getTablero()[x][y]==1){
	    if(y-3>=0)
	        for(int i=y;i>=0;i--){ 
                    if(getTablero()[x][i]==1){
	        	var+=1;
                    }else if(getTablero()[x][i]==2){
	        	var2+=1;
                    }
	        }
	}else if(getTablero()[x][y]==2){
            for(int i=y;i>=0;i--){ 
                    if(getTablero()[x][i]==1){
	        	var+=1;
                    }else if(getTablero()[x][i]==2){
	        	var2+=1;
                    }
	   // return -1; 
            }
	}else{
            return 0;
        }
	if(var>=3){
            if(enLinea(x,y,2)){
	    return 1;
            }
	}
        if(var2>=3){
            if(enLineaCompu(x,y,2)){
                return -1;
            }
        }
	return 0;
    }
    
    public int ganadorDiagonalDerIzq(int x ,int y){
	int var=0;
	int cont=y;
        int var2=0;
	if(getTablero()[x][y]==1){
            if((y-3)>=0 && (x-3)>=0){
                for(int i=x;i>=0;i--){
                    if(getTablero()[i][cont]==1){
                        var+=1;
                    }else if(getTablero()[i][cont]==2){
                        var2+=1;
                    }
                    cont--;
	        }
            }
        }else if(getTablero()[x][y]==2){
            for(int i=y;i>=0;i--){ 
                if(getTablero()[i][cont]==1){
                    var+=1;
                }else if(getTablero()[i][cont]==2){
                        var2+=1;
                    }
	        //return -1; 
                cont--;
                    
            }
        }
           
	if(var>=3){
            if(enLinea(x,y,3)){
                return 1;
            }
	}
        if(var2>=3){
            if(enLineaCompu(x,y,3)){
                return -1;
            }
        }
        return 0;
         
    }
    
    public int ganadorDiagonalIzqDer(int x ,int y){
	int var=0;
	int cont=y;
        int var2=0;
	if(getTablero()[x][y]==1){
            if((y+3)<=7 && (x+3)<=7){
                for(int i=x;i<=6;i++){
                    if(getTablero()[i][cont]==1){
                        var+=1;
                    }else if(getTablero()[i][cont]==2){
                        var2+=1;
                    }
                    cont++;
	        }
            }
        }else if(getTablero()[x][y]==2){
            if((y+3)<=7 && (x+3)<=7){
                 for(int i=x;i<=6;i++){ 
                    if(getTablero()[i][cont]==1){
                        var+=1;
                    }else if(getTablero()[i][cont]==2){
                        var2+=1;
                    }
	        //return -1; 
                    cont++;           
                }
            }
        }    
	if(var>=3){
            if(enLinea(x,y,4)){
                return 1;
            }
	}
        if(var>=3){
            if(enLineaCompu(x,y,4)){
                return -1;
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
    
    private boolean ganaHumano(int x,int y){
        if(ganadorVertical(x,y)==1||ganadorHorizontal(x,y)==1||ganadorDiagonalIzqDer(x,y)==1||ganadorDiagonalDerIzq(x,y)==1){
            return true;
        }else{
            return false;
        }
    }
    
        private boolean ganaCompu(int x,int y){
        if(ganadorVertical(x,y)==-1||ganadorHorizontal(x,y)==-1||ganadorDiagonalIzqDer(x,y)==-1||ganadorDiagonalDerIzq(x,y)==-1){
            return true;
        }else{
            return false;
        }
    }
    
}
