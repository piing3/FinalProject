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
import org.w3c.dom.events.MouseEvent;

/**
 *
 * @author Davin
 * 
 * A container that will open when the "escape" key is pressed
 */
class Menu extends JFrame{
    
    private JButton btnExit;
    private Container container;
    private JLabel backround;
    private JLabel temp;
    
    public Menu(){
        container = this.getContentPane();
        this.setVisible(false);
        btnExit = new JButton("Exit");
        btnExit.setBackground(Color.red);
        btnExit.setForeground(Color.white);
        this.setLayout(null);
        btnExit.setBounds(100 ,100, 100, 100);
        this.add(btnExit); 
        this.setTitle("Menu");
        this.setUndecorated(true);
        this.setResizable(false);
        this.setBounds(500, 100, 300, 700);
        
        ActionListener exit = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        btnExit.addActionListener(exit);
        
        
    }

}
