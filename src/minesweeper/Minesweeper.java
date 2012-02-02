package minesweeper;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Lauri
 */
public class Minesweeper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MinesweeperLogic m = new MinesweeperLogic(10,10);
        m.fillWithZeros();
        m.luoGui();
        //m.getGui().luoKello();
        //m.getGui().kelloTaulu();
        m.arvoMiinat(20);
        m.fillGrid();
        m.fillGui(); 
        System.out.println(m); 
    }
}
