package minesweeper;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import minesweeper.MinesweeperLogic;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lauri
 */
public class MinesweeperLogicTest {

    MinesweeperLogic m;

    public MinesweeperLogicTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        m = new MinesweeperLogic(10, 10);
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void tayttaaNollilla() {
        m.fillWithZeros();
        MinesweeperLogic h = new MinesweeperLogic(10, 10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                h.setNumber(i, j, "0");
            }
        }
        assertEquals(h.toString(), m.toString());
    }

    @Test
    public void maaritaNumeroToimii() {
        m.fillWithZeros();
        m.setMine(3, 4);
        m.setMine(2, 3);
        m.setMine(4, 3);

        assertEquals("3", m.maaritaNumero(3, 3));
        assertEquals(" ", m.maaritaNumero(5, 6));
        assertEquals("1", m.maaritaNumero(1, 2));
    }

    @Test
    public void setMineToimii() {
        m.fillWithZeros();
        assertEquals(true, m.setMine(1, 1));
        assertEquals(false, m.setMine(1, 1));
    }

    @Test
    public void toStringToimii() {
        m.fillWithZeros();
        m.arvoMiinat(30);
        m.fillGrid();
        assertEquals(310, m.toString().length());
    }

    @Test
    public void luodaanOikein10x10() {
        String[][] grid = m.getGrid();
        assertEquals(10, grid.length);
        assertEquals(10, grid[3].length);
    }

    @Test
    public void luodaanOikein9x11() {
        MinesweeperLogic l = new MinesweeperLogic(9, 11);
        String[][] grid = l.getGrid();
        assertEquals(9, grid.length);
        assertEquals(11, grid[3].length);
}
    public void luodaanOikein11x9() {
        MinesweeperLogic l = new MinesweeperLogic(11, 9);
        String[][] grid = l.getGrid();
        assertEquals(11, grid.length);
        assertEquals(9, grid[3].length);
    }
    
    @Test
    public void arpooTarpeeksiMiinoja() {
        m.fillWithZeros();
        m.arvoMiinat(35);
        String[][] grid = m.getGrid();
        int miinat = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].equalsIgnoreCase("*")) {
                    miinat++;
                }
            }
        }
        assertEquals(35, miinat);
    }

    @Test
    public void fillGridToimii() {
        m.fillWithZeros();
        m.arvoMiinat(35);
        m.fillGrid();
        String[][] grid = m.getGrid();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].equalsIgnoreCase("0")) {
                    fail("Ruudukko ei täyttynyt oikein");
                }
            }
        }
   }
   
    public void luoGuiToimii() {
        
    }
}