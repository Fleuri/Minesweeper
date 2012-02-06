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
/*
     * Luo oikean kokoisen ristikon ja tallentaa mittasuhteet muuta käyttöä varten.
     * @param   korkeus Ristikon korkeus
     * "param   leveys Ristikon leveys
     */
    public MinesweeperLogic(int korkeus, int leveys) {
        grid = new String[korkeus][leveys];
        this.korkeus = korkeus;
        this.leveys = leveys;
        ruutujenMaara = korkeus * leveys;
        lukija = new Scanner(System.in);

    }
/*
     * Luo graafisen käyttöliittymän
     */
    public void luoGui() {
        gui = new MinesweeperGUI(ruutujenMaara, korkeus, leveys);
    }
/*
     * Antaa Ruutu-luokan olioille oikeat arvot gridistä
     * 
     * @see Minesweeper.MinesweeperGUI#setRuutu
     * @see Minesweeper.Ruutu
     */
    public void fillGui() {
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                gui.setRuutu(i,j, grid[i][j]);
                
            }
        }
    }
    /*
     * Palauttaa ruudukon
     * 
     * @return grid
     */
    public String[][] getGrid() {
            return grid;
            
    }
    /*
     * Palauttaa GUIn
     * 
     * @return gui;
     */
    public MinesweeperGUI getGui(){
        return gui;
    }
    /*
     * Määrittää numeron koordinaateilla määritettyyn lokeroon gridissa lokeroita
     * ympäröivien miinojen perusteella.
     * 
     * @param coord1    y-koordinaatti
     * @param coord2    x-koordinaatti
     * @param laskuri   Tallentaa ympäröivien miinojen määrän.
     * 
     * @return tulos    Palauttaa ympäröivien miinojen määrän.
     */
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
    /*
     * Täyttää ruudukon numeroilla.
     * 
     * @see Minesweeper.MinesweeperLogic#maaritaNumero
     * @see Minesweeper.MinesweeperLogic#setNumber
     */

    public void fillGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                String luku = maaritaNumero(i, j);
                setNumber(i, j, luku);

            }
        }
    }
    /*
     * Täyttää ruudukon nollilla, sillä NULL-arvoisia ruutuja ei voi käsitellä.
     *
     * @see Minesweeper.MinesweeperLogic#setNumber
     */

    public void fillWithZeros() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                setNumber(i, j, "0");
            }
        }
    }
    
    /*
     * Asettaa koordinaateilla määriteltyyn ruutuun annetun luvun.
     */

    public void setNumber(int coord1, int coord2, String luku) {
        grid[coord1][coord2] = luku;
    }
    /*
     * Asettaa koordinaateilla määriteltyyn ruutuun miinan. Palauttaa true, jos 
     * asettaminen onnistui, muuten false.
     * 
     * @return true     Jos miinan asettaminen onnistui.
     * @return false    Jos miinan asettaminen epäonnistui.
     */

    public boolean setMine(int coord1, int coord2) {
        if (grid[coord1][coord2].contains("*")) {
            return false;
        } else {
            grid[coord1][coord2] = "*";
            return true;
        }
    }
    
    /*
     * Arpoo vähintään lukumäärän verran koordinaatteja ja asettaa ruudukkoon miinat.
     * Mikäli arvotussa koordinaatissa oli jo miina, arpoo uuden. Mikäli miinojen
     * lukumäärä on suurempi kuin ruutujen, pyytää antamaan uuden lukumäärän.
     * 
     * @param lukumaara     Miinojen lukumäärä.
     * @param laskuri       Säilyttää jo asettetujen miinojen määrän.
     * @param coord1        y-koordinaatti
     * @param coord2        x-koordinaatti
     * 
     * @see Minesweeper.MinesweeperLogic#setMine
     */

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
    
    /* 
     * Palauttaa ruudukosta merkkijonoesityksen.
     * 
     * @return tulos       Palauttaa merkkijonoesityksen.
     */

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