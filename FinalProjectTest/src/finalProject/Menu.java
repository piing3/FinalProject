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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Davin
 * 
 * A container that will open when the "escape" key is pressed
 */
class Menu extends JFrame{
    
    private JButton btnTest;
    private Container container;
    private 

    
    public Menu(){
        container = this.getContentPane();
        this.setSize(400, 700);
        this.setLocation(600, 100);
        this.setVisible(false);
        btnTest = new JButton();
        this.setLayout(null);
        btnTest.setBounds(100 ,100, 100, 100);
        this.add(btnTest); 
        this.setAlwaysOnTop(true);
        this.setTitle("Menu");
        this.setUndecorated(true);
        this.setResizable(false);
        this.setBackground(Color.red);
        this.setBounds(400, 700, 500, 100);
    }
    public void sout(String text){
        System.out.println(text);
    }

}
