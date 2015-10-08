/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegazo;

import objects.Tablero;

/**
 *
 * @author Jimmi
 */
public class Juegazo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        System.out.print(tablero.mostrarTablero());
        
        IUJuegazo juego = new IUJuegazo();
        juego.setVisible(true);
    }
    
}
