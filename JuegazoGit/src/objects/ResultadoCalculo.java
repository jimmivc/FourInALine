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
public class ResultadoCalculo {
    private int[][] tab;
    private int score;
    private int depth;
    
    public ResultadoCalculo(int[][] ptablero, int pscore, int pdepth){
        setTab(ptablero);
        setScore(pscore);
        setDepth(pdepth);
    }
    
    public void actualizarTablero(int[][] ptab){
        setTab(ptab);
    }
    
    //public int get

    /**
     * @return the tab
     */
    public int[][] getTab() {
        return tab;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @return the depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * @param tab the tab to set
     */
    private void setTab(int[][] tab) {
        this.tab = tab;
    }

    /**
     * @param score the score to set
     */
    private void setScore(int score) {
        this.score = score;
    }

    /**
     * @param depth the depth to set
     */
    private void setDepth(int depth) {
        this.depth = depth;
    }
    
    
}
