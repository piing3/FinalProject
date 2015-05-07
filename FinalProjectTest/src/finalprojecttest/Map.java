/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojecttest;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Davin
 */
class Map extends JFrame{
    
    private final Container container;
    
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
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        container = getContentPane();
        KeyListener keylistener = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("poop");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        container.addKeyListener(keylistener);
    }    
}
