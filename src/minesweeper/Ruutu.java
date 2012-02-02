/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

/**
 *
 * @author Lauri
 */
public class Ruutu extends JLabel implements MouseListener {
    
    private boolean klikattu = false;
    private JTextField ruutu;
    private String arvo;
    private int xkoord;
    private int ykoord;

    public Ruutu(int xkoord, int ykoord) {
        this.xkoord = xkoord;
        this.ykoord = ykoord;
        ruutu = new JTextField();
        ruutu.setEditable(false);
        ruutu.setVisible(true);
        ruutu.addMouseListener(this);
    }

    public int getXKoord() {
        return xkoord;
    }

    public int getYKoord() {
        return ykoord;
    }

    public JTextField getTextField() {
        return ruutu;
    }

    public void setArvo(String arvo) {
        this.arvo = arvo;

    }
    public boolean getKlikattu(){
        return klikattu;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ruutu.setText(arvo);
        ruutu.setBackground(Color.cyan);
        klikattu = true;
        if (arvo.equals(" ")) {
            for (int i = xkoord - 1; i < xkoord + 2; ++i) {
                for (int j = ykoord - 1; j < ykoord + 2; j++) {
                    if (i < 0 || i > MinesweeperGUI.ruudut.length - 1 || j < 0 || j > MinesweeperGUI.ruudut[i].length - 1 || MinesweeperGUI.ruudut[i][j].getKlikattu() == true) {
                        continue;
                    } else {
                        MinesweeperGUI.ruudut[i][j].mouseClicked(e);
                        
                    
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
