/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojecttest;

import javax.swing.JOptionPane;

/**
 *
 * @author Davin
 */
public class FinalProjectTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String players = JOptionPane.showInputDialog("How many people are playing");
        int play = Integer.parseInt(players);
        for (int i = 0; i < play; i++) {
            String name = JOptionPane.showInputDialog("What is your name?");
            Person player = new Person(name, play);
            play--;
        }
        int fullscreen = JOptionPane.showConfirmDialog(null, "Would you like to run in fullscreen?","Fullscreen" , JOptionPane.YES_NO_OPTION);
        Map map = new Map(fullscreen);
    }
    
}
