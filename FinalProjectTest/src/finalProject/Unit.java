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
    int x;
    int y;
    int defaultMove;
    int type;
    
    public Unit(int x, int y, int type){
       // this.setIcon(unitType.image);
        //movement = unitType.movement;
        this.x = x;
        this.y = y;
        this.setSize(50, 50);
        this.setLocation(x*50, y*50);
    }
    public int SetMove(int defaultMove){
        return defaultMove;
    }
}
