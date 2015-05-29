/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
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
abstract class Visual extends JFrame implements KeyListener, MouseMotionListener, MouseListener  {
    
   
    //UserInt userInt = new UserInt();
    
    static Container tiles;
    static Container UI;
    static int width; 
    static int hight;
    
    Boolean menuOpen = false;
    Menu menu = new Menu();
    
    int mouseX1;
    int mouseX2;
    int mouseY1;
    int mouseY2;
    
    public Visual() throws FileNotFoundException {
        int fullscreen = JOptionPane.showConfirmDialog(null, "Would you like to run in fullscreen?","Fullscreen" , JOptionPane.YES_NO_OPTION);
        if(fullscreen == 0){
            this.setExtendedState(this.MAXIMIZED_BOTH);
        }
        else{
            this.setSize(1280, 720);    
        }
        
        this.setResizable(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        width = this.getWidth();
        hight = this.getHeight();
        
        tiles = this.getContentPane();
        UI = this.getContentPane();
        
        this.addKeyListener(this);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        
        UserInt userInt = new UserInt();
        Map map = new Map();
        
//        
//        this.addMouseListener(new MouseAdapter() { 
////            public void mousePressed(MouseEvent e) {
////                mouseDown(e);
////            }        
////            public void mouseReleased(MouseEvent e) {
////                mouseUp(e);
////            }
//            public void mouseDragged(MouseEvent e) {
//                mouseDrag(e);
//            }            
//        });
        
        
        this.setVisible(true);
    }
    
//    private void mouseDown(MouseEvent e)  {
//        System.out.println("down");
//    }
//    
//    private void mouseUp(MouseEvent e)  {
//        System.out.println("up");
//    }
//    
//    private void mouseDrag(MouseEvent e)  {
//        System.out.println("drag");
//    }
//    
//}


    
    
    
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

//    /*@Override
//    public void mouseDragged(MouseEvent e) {
//        mouseY1 = 0;
//        mouseY2 = 0;
//        
//        int rawPos = getMousePosition().x;
//        double intpos = ((double)rawPos)/50;
//        int pos = (int)intpos;
//        mouseX2 = pos;
//        
////        mouseX2 = getMousePosition().x/50;
//        //mouseY2 = getMousePosition().y/50;
//        if ((mouseX2 - mouseX1) > 0/*||Map.rightOff != (128-Map.x)*/) Map.rightOff++;
//        if ((mouseX2 - mouseX1) < 0/*||Map.rightOff != 0*/) Map.rightOff--;
//        if ((mouseY2 - mouseY1) > 0/*||Map.downOff != (72-Map.y)*/) Map.downOff++;
//        if ((mouseY2 - mouseY1) < 0/*||Map.downOff != 0*/) Map.downOff--;
//        System.out.println("right = "+Map.rightOff+", down = "+Map.downOff);
//        
//        for (int i = 0; i < Map.x; i++){
//                for (int j = 0; j < Map.y; j++){
//                    Map.grid[i][j].setTile(Map.tileType[i + Map.rightOff][j + Map.downOff]);
//
//                }
//            }
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//        
//        int rawPos = getMousePosition().x;
//        double intpos = ((double)rawPos)/50;
//        int pos = (int)intpos;
//        mouseX1 = pos;
//        
////        mouseX1 = getMousePosition().x/50;
//        //mouseY1 = getMousePosition().y/50;
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//            
//        int rawPos = getMousePosition().x;
//        double intpos = ((double)rawPos)/50;
//        int pos = (int)intpos;
//        mouseX1 = pos;
//        
//    }
//    
//     @Override
//    public void mouseReleased(MouseEvent e) {
//         int rawPos = getMousePosition().x;
//        double intpos = ((double)rawPos)/50;
//        int pos = (int)intpos;
//        mouseX1 = pos;
//    }

     
     
    
}


