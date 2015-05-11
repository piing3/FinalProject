/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicTreeUI;

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
    
    Map(int fullscreen){
        if(fullscreen == 0){
            this.setExtendedState(Map.MAXIMIZED_BOTH);
            this.setUndecorated(true);
        }
        else{
            this.setSize(1280,720);
        }
        
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        container = getContentPane();
        container.setLayout(null);
        this.addKeyListener(this);
        
        
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
        
        Tile[][] grid = new Tile[10][10];
        
        for (int i = 0; i < 10; i++){
            for (int j = 0; j > 10; j++){
                grid[i][j]  = new Tile();
                int type = grid[i][j].tileType;
                container.add(grid[i][j]);
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
    }

    private static class Tile extends JLabel{//wasn't working in a seperate class, fix later
        public int x;
        public int y;
        public int tileType;
        public int owner;
        public int improvement;
        public int occupint;  
        
        public Tile() {
        }
        
    }
}
