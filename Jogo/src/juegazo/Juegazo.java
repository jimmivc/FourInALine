/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegazo;


/**
 *
 * @author Jimmi
 */
public class Juegazo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Tablero tablero = new Tablero(true);
        //System.out.print(tablero.mostrarTablero());
        boolean iniciaPlayer1 = true;
        int nivel = 2;
        IUJuegazo juego = new IUJuegazo(iniciaPlayer1,nivel);
        juego.setVisible(true);
    }
    
}
