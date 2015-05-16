/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

/**
 *
 * @author Davin & Ben
 */
public class FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        String players = JOptionPane.showInputDialog("How many people are playing");
        int play = Integer.parseInt(players);
        if (play <= -1)//set to two when not testing to see if it runs the menu
        {
            JOptionPane.showMessageDialog(null, "you cant play alone.");
        }
        
        for (int i = 0; i < play; i++) {
            String name = JOptionPane.showInputDialog("What is your name?");
            if(i == 0)
            {
                Person player1 = new Person(name, i++, play);
            }
            if(i == 1)
            {
                Person player2 = new Person(name, i++, play);
            }
            if(i == 2)
            {
                Person player3 = new Person(name, i++, play);
            }
            if(i == 3)
            {
                Person player4 = new Person(name, i++, play);
            }
        }
        int fullscreen = JOptionPane.showConfirmDialog(null, "Would you like to run in fullscreen?","Fullscreen" , JOptionPane.YES_NO_OPTION);
        Map map = new Map(fullscreen);
    }
    
}
