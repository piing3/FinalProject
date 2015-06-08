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
public static ArrayList<City> cities = new ArrayList<City>();
public static ArrayList<Person> Players = new ArrayList<Person>();
public static int play;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException { //LOOK DAVIN I FIXED MAIN! xD
        play = Integer.parseInt(JOptionPane.showInputDialog("How many people are playing"));
        if (play < 2)JOptionPane.showMessageDialog(null, "you cant play alone."); //Please dont change, will cause choas with players. Program will crash
        else if (play > 4) JOptionPane.showMessageDialog(null, "You can only have up to 4 players");
        else {
        for (int i = 0; i < play; i++) {
            String name = JOptionPane.showInputDialog("What is your name?");
                 if(i == 0) FinalProject.Players.add(new Person(name, i+1, play));
            else if(i == 1) FinalProject.Players.add(new Person(name, i+1, play));
            else if(i == 2) FinalProject.Players.add(new Person(name, i+1, play));
            else if(i == 3) FinalProject.Players.add(new Person(name, i+1, play));
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

            @Override
            public void mouseDragged(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        TurnOrder turnorder = new TurnOrder();
        turnorder.StartTurnOrder();
        UnitType.CreateUnit(15, 9, 1,Visual.Units);
        UnitType.CreateUnit(15, 15, 1,Visual.Units);
        visual.setVisible(true);
        }
    }
}