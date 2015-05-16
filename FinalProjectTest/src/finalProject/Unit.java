/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author Deborah
 */
public class Unit extends JLabel{

    int player;
    int movement;
    
    public Unit(int x, int y, UnitType unitType){
        this.setIcon(unitType.image);
        movement = unitType.movement;
        this.setSize(50, 50);
        this.setLocation(x*50, y*50);
    }
}
