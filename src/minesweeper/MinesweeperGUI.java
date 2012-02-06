package minesweeper;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 *
 * @author Lauri
 */


public class MinesweeperGUI extends JFrame{
      private JTextField kentta;
       private JButton nappula1;
       private JButton nappula2;
       private Kello kello;
       
    /*
        * Matriisi, joka säilyttää graafiset ruudut
        * 
        * @see Minesweeper.Ruutu
        */
    
    public static Ruutu[][] ruudut;
    
    /*
     * Alustaa graafisen ruudukon, luo Ruutu-oliot
     * 
     * @see Minesweeper.Ruutu;
     */
    
    public MinesweeperGUI(int ruutujenMaara, int korkeus, int leveys) {
        
        ruudut = new Ruutu[korkeus][leveys];
        
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++)
             ruudut[i][j] = (new Ruutu(i,j));
        }
        setLayout(new GridLayout(korkeus, leveys));
         
       for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++)
           add(ruudut[i][j].getTextField());
        }
        setTitle("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    /*
     * Asettaa graafiseen ruudukkoon oikean arvon
     * 
     * @see Minesweeper.Ruutu#setArvo
     */
    
    public void setRuutu(int i,int j, String numero) {
           ruudut[i][j].setArvo(numero);
   }
    public void luoKello() {
        kello = new Kello();
        }
    public void kelloTaulu() {
    kentta = new JTextField("Kentta");
    nappula1 = new JButton("Aloita");
    nappula2 = new JButton ("Lopeta");
    
    add("North", nappula1);
    add("North", nappula2);
    add("North", kentta);
    
    setVisible(true);
    kentta.setEditable(false);
    kentta.setText("" + kello.kuluneitaSekunteja());
   // nappula1.addMouseListener(mouseClicked());
    }
}