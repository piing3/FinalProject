/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import static finalProject.Visual.menuOpen;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.w3c.dom.events.MouseEvent;

/**
 *
 * @author Davin
 * 
 * A container that will open when the "escape" key is pressed
 */
class Menu extends JFrame implements KeyListener{
    
    private JButton btnExit;
    private Container container;
    private JButton close;
    
    public Menu(){
        container = this.getContentPane();
        this.setVisible(false);
        this.getContentPane().setBackground(new Color(148, 65, 167, 255));
        this.setAlwaysOnTop(true);
        btnExit = new JButton("Exit");
        btnExit.setBackground(Color.red);
        btnExit.setForeground(Color.white);
        this.setLayout(null);
        btnExit.setSize(100, 50);
        btnExit.setLocation(100, 100);
        container.add(btnExit); 
        this.setTitle("Menu");
        this.setUndecorated(true);
        this.setResizable(false);
        this.setBounds(500, 25, 300, 600);
        
        close = new JButton("Close");
        close.setSize(100, 50);
        close.setLocation(100, 500);
        close.setBackground(Color.gray);
        close.setForeground(Color.black);
        container.add(close);
        
        ActionListener exit = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        btnExit.addActionListener(exit);
        
        ActionListener closeMenu = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Visual.menu.setVisible(false);
                Visual.menuOpen = false;
            }
        };
        close.addActionListener(closeMenu);
        
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (e.getKeyCode() == 27){
            Visual.menu.setVisible(false);
            menuOpen = false; 
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
