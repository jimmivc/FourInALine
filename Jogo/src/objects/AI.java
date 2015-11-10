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
        
        
        
        
        for(int i = 0; i<tablero.getTablero().length; i++){
            Tablero tab = new Tablero(true);
            tab.colocarFicha(1,i);
            arbolito.insertarRecursivo(arbolito.raiz, tab, arbolito.raiz.dato);
        }
        System.out.println(arbolito.cantHojas());
        System.out.println(arbolito.cantHojas());
        
        for(int i = 0; i<tablero.getTablero().length; i++){
            System.out.println("hijos de la raiz"+ arbolito.raiz.hijos[i].dato.mostrarTablero());
        }
        
        return 0;
    }
}
