/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author d.holmberg
 */
class Visual extends JFrame {
    
   
    //UserInt userInt = new UserInt();
    
    static Container container;
    
    public Visual() throws FileNotFoundException {
        
        this.setSize(1280, 720);
        this.setResizable(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);        
        
        container = this.getContentPane();
        
        int fullscreen = JOptionPane.showConfirmDialog(null, "Would you like to run in fullscreen?","Fullscreen" , JOptionPane.YES_NO_OPTION);
        Map map = new Map(fullscreen);
        this.setVisible(true);
    }
    
}
