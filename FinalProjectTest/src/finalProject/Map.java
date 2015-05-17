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
class Map extends JFrame implements KeyListener{
    
    private final Container container;
    private Menu menu = new Menu();
    private JButton btnExit;
    boolean menuOpen = false;
    private JLabel tile; 
    
    int x = 30,y = 30;
    public int downOff = 0, rightOff = 0;//Down and Right offsets, used for moving map.
    
    public Tile[][] grid = new Tile[x][y];
    
    int[][] tileType = new int[x][y];
    
    public Map(int fullscreen) throws FileNotFoundException{
        if(fullscreen == 0){
            this.setExtendedState(Map.MAXIMIZED_BOTH);
            this.setUndecorated(true);
        }
        else{
            this.setSize(1280,720);
        }
        
        
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        container = getContentPane();
        container.setLayout(null);
        this.addKeyListener(this);
        
        File temp = new File("src\\finalProject\\Map.txt");
        Scanner s = new Scanner(temp);
        for (int j = 0; j < y; j++){
            for (int i = 0; i < x; i++){
                tileType[i][j] = s.nextInt();
            }
        }
        s.close(); 
        
        for (int i = rightOff; i < x; i++){
            for (int j = downOff; j < y; j++){
                grid[i][j] = new Tile(i, j);
                grid[i][j].setTile(tileType[i][j]);
                container.add(grid[i][j]);
                
            }
        }
        
        
        UnitType Warrior = new UnitType(0, 2);
        
        
        
        btnExit = new JButton("X");
        btnExit.setBounds(0, 0, 50, 50);
        btnExit.setBackground(Color.red);
        btnExit.setForeground(Color.white);
        btnExit.setFocusable(false);
        container.add(btnExit);
        ActionListener Exit = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        btnExit.addActionListener(Exit);
        this.setVisible(true);
        
    }    

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyChar() +" "+ e.getKeyCode());
        if (e.getKeyCode() == 27){//Fix this & menu later 
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
            
            if (downOff != y){
                downOff++;    
            }
            for (int i = 0; i < x; i++){
                for (int j = 0; j < y; j++){
                    grid[i][j].setTile(tileType[i + rightOff][j + downOff]);
                }
            }
        }
        if (e.getKeyCode() == 39){//right
            
            if (rightOff != x){
                rightOff++;    
            }
            for (int i = 0; i < x; i++){
                for (int j = 0; j < y; j++){
                    grid[i][j].setTile(tileType[i + rightOff][j + downOff]);

                }
            }
        }
    }
}
