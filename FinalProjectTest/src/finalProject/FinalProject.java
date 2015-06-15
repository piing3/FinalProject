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
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Davin & Ben
 */
public class FinalProject {
public static ArrayList<Unit> units = new ArrayList<Unit>();//list of all units
public static ArrayList<City> cities = new ArrayList<City>();//list of all cities
public static ArrayList<Person> Players = new ArrayList<Person>();//list of players
public static int play;

public static int turnNumber = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        
        play = Integer.parseInt(JOptionPane.showInputDialog("How many people are playing"));//gets the number of players
        TurnOrder turnorder = new TurnOrder();
        if (play < 2)JOptionPane.showMessageDialog(null, "you cant play alone."); //Check vailid input
        else if (play > 4) JOptionPane.showMessageDialog(null, "You can only have up to 4 players");
        else {
        for (int i = 0; i < play; i++) {//makes players
            String name = JOptionPane.showInputDialog("What is your name?");
                 if(i == 0) FinalProject.Players.add(new Person(name, i+1, play));
            else if(i == 1) FinalProject.Players.add(new Person(name, i+1, play));
            else if(i == 2) FinalProject.Players.add(new Person(name, i+1, play));
            else if(i == 3) FinalProject.Players.add(new Person(name, i+1, play));
        }
        turnorder.StartTurnOrder();//begin turns
       Visual visual = new Visual() {
        
            @Override//extra key events here to make visual neater
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
        visual.setVisible(true);//make display visable
        Random startPos = new Random();
        int startX;
        int startY;
        do{
            startX = startPos.nextInt(126);
            startY = startPos.nextInt(72);
        }while(Map.grid[startX][startY].tileType == 2);
        UnitType.CreateUnit(startX, startY, 1,Visual.Units);//make units
        UnitType.CreateUnit(startX + 1, startY, 2,Visual.Units);
        if (FinalProject.units.get(index).x > Map.x)Map.rightOff = FinalProject.units.get(startX).x - (Map.x/2);
        else Map.downOff = FinalProject.units.get(startX).x;
        if (FinalProject.units.get(index).y > Map.y)Map.downOff = FinalProject.units.get(startY).y - (Map.y/2);
        else Map.rightOff = FinalProject.units.get(startY).y; 
        Visual.redrawMap();
        Visual.LoadUnits();

        
        }
    }
}