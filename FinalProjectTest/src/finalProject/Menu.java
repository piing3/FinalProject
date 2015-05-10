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
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
    private JLabel backround;
    
    public Menu(){
        container = this.getContentPane();
        this.setVisible(false);
        btnTest = new JButton("Button");
        btnTest.setBackground(Color.black);
        btnTest.setForeground(Color.white);
        this.setLayout(null);
        btnTest.setBounds(100 ,100, 100, 100);
        this.add(btnTest); 
        this.setTitle("Menu");
        this.setUndecorated(true);
        this.setResizable(false);
        this.setBounds(500, 100, 300, 700);
        
        Icon backPic  = new ImageIcon("C:\\Users\\Davin.DAVIN-PC\\Desktop\\Temp1.png");
        backround = new JLabel(backPic);
        backround.setBounds(this.getBounds());
        container.add(backround);
    }
    public void sout(String text){
        System.out.println(text);
    }

}
