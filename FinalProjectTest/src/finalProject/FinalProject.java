/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Davin & Ben
 */
public class FinalProject {
public static ArrayList<Unit> units = new ArrayList<Unit>();
public static int play;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        String players = JOptionPane.showInputDialog("How many people are playing");
        play = Integer.parseInt(players);
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
        Visual visual = new Visual() {

            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
}
