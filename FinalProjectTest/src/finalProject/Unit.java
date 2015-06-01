/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Container;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
    Icon image; 
    
    public Unit(int x, int y, int type, Container container){
        container.add(this);
        this.x = x;
        this.y = y;
        this.setSize(50, 50);
        this.setLocation(x*50, y*50);     
        if (type == 1){
            image = new ImageIcon("src\\Images\\WarriorUnit1.png");
            this.setIcon(image);
            this.setVisible(true);
            UnitType.LoadUnits();
        }
    }
    public int SetMove(int defaultMove){
        return defaultMove;
    }
}
