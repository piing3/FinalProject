/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Davin
 */
class Map implements KeyListener{
    
    boolean menuOpen = false;
    private JLabel tile; 
    
    static int x,y;
    final int size = 30;
    static  int downOff = 0, rightOff = 0;//Down and Right offsets, used for moving map.
    
    static Tile[][] grid;
    static int[][] tileType;
    
    Map(int fullscreen) throws FileNotFoundException{
        if(fullscreen == 0){
            //visual.setExtendedState(Map.MAXIMIZED_BOTH);
            //super.setUndecorated(true);
        }
        else{
            //super.setSize(1280,720);
        }
        
        x = 25;
        y = 14;
        System.out.println(x+", "+y);
        
        tileType  = new int[128][72];
        grid  = new Tile[128][72];
        
        //Visual.addKeyListener(this);
        Visual.tiles.setLayout(null);
        
        File temp = new File("src\\finalProject\\Map.txt");
        Scanner s = new Scanner(temp);
        for (int j = 0; j <= 71; j++){
            for (int i = 0; i <= 127; i++){
                tileType[i][j] = s.nextInt();
            }
        }
        s.close(); 
        
        for (int i = rightOff; i < 127; i++){
            for (int j = downOff; j < 71; j++){
                grid[i][j] = new Tile(i, j);
                grid[i][j].setTile(tileType[i][j]);
                Visual.tiles.add(grid[i][j]);
                
            }
        }
    }   

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 27){//Fix this & menu later 
            if (menuOpen == false){
                //menu.setVisible(true);
                menuOpen = true;
            }
            else if (menuOpen == true){
                //menu.setVisible(false);
                menuOpen = false;
            }    
        }
        
        if (e.getKeyCode() == 38){//up
            if (downOff != 0){
                downOff--;
            }
            for (int i = 0; i < x; i++){
                for (int j = 0; j < y; j++){
                    grid[i][j].setTile(tileType[i + rightOff][j + downOff]);
                }
            }
        }
        if (e.getKeyCode() == 37){//left
            if (rightOff != 0){
                rightOff--;
            }
            for (int i = 0; i < x; i++){
                for (int j = 0; j < y; j++){
                    grid[i][j].setTile(tileType[i + rightOff][j + downOff]);
                }
            }
        }
        if (e.getKeyCode() == 40){//down
            
            if (downOff != (72-y)){
                downOff++;    
            }
            for (int i = 0; i < x; i++){
                for (int j = 0; j < y; j++){
                    grid[i][j].setTile(tileType[i + rightOff][j + downOff]);
                }
            }
            System.out.println(downOff);
        }
        if (e.getKeyCode() == 39){//right
            
            if (rightOff != (128-x)){
                rightOff++;    
            }
            for (int i = 0; i < x; i++){
                for (int j = 0; j < y; j++){
                    grid[i][j].setTile(tileType[i + rightOff][j + downOff]);

                }
            }
            System.out.println(rightOff);
        }
    }
}
