package minesweeper;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author Lauri
 */
public class MinesweeperLogic {

    private String[][] grid;
    private int korkeus;
    private int leveys;
    private int ruutujenMaara;
    private Scanner lukija;
    private MinesweeperGUI gui;

    public MinesweeperLogic(int korkeus, int leveys) {
        grid = new String[korkeus][leveys];
        this.korkeus = korkeus;
        this.leveys = leveys;
        ruutujenMaara = korkeus * leveys;
        lukija = new Scanner(System.in);

    }

    public void luoGui() {
        gui = new MinesweeperGUI(ruutujenMaara, korkeus, leveys);
    }

    public void fillGui() {
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                gui.setRuutu(i,j, grid[i][j]);
                
            }
        }
    }
    
    public String[][] getGrid() {
            return grid;
    }
    public MinesweeperGUI getGui(){
        return gui;
    }

    public String maaritaNumero(int coord1, int coord2) {
        int laskuri = 0;
        if (grid[coord1][coord2].contains("*")) {
            return ("*");
        } else {
            for (int i = coord1 - 1; i < coord1 + 2; ++i) {
                for (int j = coord2 - 1; j < coord2 + 2; j++) {
                    if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1) {
                        continue;
                    }
                    if (grid[i][j].equals("*")) {
                        laskuri++;
                    }
                }
            }
        }
        if (laskuri == 0) {
            return " ";
        } else {
            String tulos = String.valueOf(laskuri);
            return tulos;
        }
    }

    public void fillGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                String luku = maaritaNumero(i, j);
                setNumber(i, j, luku);

            }
        }
    }

    public void fillWithZeros() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                setNumber(i, j, "0");
            }
        }
    }

    public void setNumber(int coord1, int coord2, String luku) {
        grid[coord1][coord2] = luku;
    }

    public boolean setMine(int coord1, int coord2) {
        if (grid[coord1][coord2].contains("*")) {
            return false;
        } else {
            grid[coord1][coord2] = "*";
            return true;
        }
    }

    public void arvoMiinat(int lukumaara) {
        int laskuri = 0;
        while (lukumaara > ruutujenMaara) {
            System.out.println("Miinoja on liikaa! Anna pienempi luku");
            lukumaara = lukija.nextInt();
        }
        while (laskuri < lukumaara) {
            int coord1 = (int) (korkeus * Math.random());
            int coord2 = (int) (leveys * Math.random());
            if (setMine(coord1, coord2) == false) {
                continue;
            } else {
                laskuri++;
            }
        }
    }

    public String toString() {
        String tulos = "";
        for (int i = 0; i < grid.length; i++) {
            tulos += "\n";
            for (int j = 0; j < grid[i].length; j++) {
                tulos = tulos + "[" + grid[i][j] + "]";

            }
        }
        return tulos;
    }
}