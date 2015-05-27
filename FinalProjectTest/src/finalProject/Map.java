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
class Map {
    
    boolean menuOpen = false;
    private JLabel tile; 
    
    static int x,y;
    final int size = 30;
    static  int downOff = 0, rightOff = 0;//Down and Right offsets, used for moving map.
    
    static Tile[][] grid;
    static int[][] tileType;
    
    Map() throws FileNotFoundException{
        
        x = Visual.width/50;//25;
        y = Visual.hight/50;//14;
        System.out.println(x+", "+y);
        
        tileType  = new int[128][72];
        grid  = new Tile[128][72];
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
}
