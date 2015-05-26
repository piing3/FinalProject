/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author d.holmberg
 */
class Visual extends JFrame implements KeyListener{
    
   
    //UserInt userInt = new UserInt();
    
    static Container tiles;
    static Container UI;
    static int width; 
    static int hight; 
    
    public Visual() throws FileNotFoundException {
        
        this.setSize(1280, 720);
        this.setResizable(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        width = this.getX();
        hight = this.getY();
        
        tiles = this.getContentPane();
        UI = this.getContentPane();
        
        this.addKeyListener(this);
        
        int fullscreen = JOptionPane.showConfirmDialog(null, "Would you like to run in fullscreen?","Fullscreen" , JOptionPane.YES_NO_OPTION);
        Map map = new Map(fullscreen);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        /*if (e.getKeyCode() == 27){//Fix this & menu later 
            if (menuOpen == false){
                //menu.setVisible(true);
                menuOpen = true;
            }
            else if (menuOpen == true){
                //menu.setVisible(false);
                menuOpen = false;
            }    
        }*/
        
        if (e.getKeyCode() == 38){//up
            if (Map.downOff != 0){
                Map.downOff--;
            }
            for (int i = 0; i < Map.x; i++){
                for (int j = 0; j < Map.y; j++){
                    Map.grid[i][j].setTile(Map.tileType[i + Map.rightOff][j + Map.downOff]);
                }
            }
        }
        if (e.getKeyCode() == 37){//left
            if (Map.rightOff != 0){
                Map.rightOff--;
            }
            for (int i = 0; i < Map.x; i++){
                for (int j = 0; j < Map.y; j++){
                    Map.grid[i][j].setTile(Map.tileType[i + Map.rightOff][j + Map.downOff]);
                }
            }
        }
        if (e.getKeyCode() == 40){//down
            
            if (Map.downOff != (72-Map.y)){
                Map.downOff++;    
            }
            for (int i = 0; i < Map.x; i++){
                for (int j = 0; j < Map.y; j++){
                    Map.grid[i][j].setTile(Map.tileType[i + Map.rightOff][j + Map.downOff]);
                }
            }
            System.out.println(Map.downOff);
        }
        if (e.getKeyCode() == 39){//right
            
            if (Map.rightOff != (128-Map.x)){
                Map.rightOff++;    
            }
            for (int i = 0; i < Map.x; i++){
                for (int j = 0; j < Map.y; j++){
                    Map.grid[i][j].setTile(Map.tileType[i + Map.rightOff][j + Map.downOff]);

                }
            }
            System.out.println(Map.rightOff);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
