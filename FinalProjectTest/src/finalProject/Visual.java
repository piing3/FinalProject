/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.JOptionPane;

/**
 *
 * @author d.holmberg
 */
abstract class Visual extends JFrame implements KeyListener, MouseMotionListener, MouseListener{
    
   
    //UserInt userInt = new UserInt();
    
    static Container tiles;
    static Container UI;
    static int width; 
    static int hight;
    
    Boolean menuOpen = false;
    Menu menu = new Menu();
    
    Point mousePos1;
    Point mousePos2;
    
    public Visual() throws FileNotFoundException {
        
        this.setSize(1280, 720);
        this.setResizable(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        width = this.getX();
        hight = this.getY();
        
        tiles = this.getContentPane();
        UI = this.getContentPane();
        
        this.addKeyListener(this);
        this.addMouseMotionListener(this);
        
        int fullscreen = JOptionPane.showConfirmDialog(null, "Would you like to run in fullscreen?","Fullscreen" , JOptionPane.YES_NO_OPTION);
        Map map = new Map(fullscreen);
        this.setVisible(true);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 27){
            if (menuOpen == false){
                menu.setVisible(true);
                menuOpen = true;
            }
            else if (menuOpen == true){
                menu.setVisible(false);
                menuOpen = false;
            }    
        }
        
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
    public void mouseDragged(MouseEvent e) {
        mousePos2 = getMousePosition();
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mousePos1 = getMousePosition();
    }

    
}
