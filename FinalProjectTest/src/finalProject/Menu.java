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

/**
 *
 * @author Davin
 * 
 * A container that will open when the "escape" key is pressed
 */
class Menu extends Container{
    
    private JButton btnTest;

    
    Menu(){
        this.setVisible(false);
        btnTest = new JButton();
        this.setLayout(null);
        btnTest.setBounds(100 ,100, 100, 100);
        this.add(btnTest); 
        this.setBackground(Color.red);
        this.setBounds(400, 700, 500, 100);
    }
    public void sout(String text){
        System.out.println(text);
    }

}
