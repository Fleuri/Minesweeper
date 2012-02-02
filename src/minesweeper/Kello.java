package minesweeper;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lauri
 */
public class Kello {
    private long lahtoAika = 0;
    private long loppuAika = 0;
    private boolean kaynnissa = false;
    
    //test
    public void aloita() {
        lahtoAika = System.currentTimeMillis();
        kaynnissa = true;
        
    }
    public void lopeta() {
        loppuAika = System.currentTimeMillis();
        kaynnissa = false;
    }
    public long kuluneitaSekunteja() {
        long kuluneet;
        if (kaynnissa) {
            return (System.currentTimeMillis() - lahtoAika) / 1000;
            }
        else {
            return (lahtoAika - loppuAika) / 1000;
        }
    

    
    }   
}
