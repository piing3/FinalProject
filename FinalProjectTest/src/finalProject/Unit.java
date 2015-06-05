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
    public int  movement;
    int x;
    int y;
    int defaultMove;
    int type;
    int health;
    Icon image; 
    public int Damage;
    
    Unit(int x, int y, int type, Container container, int owner) {
        container.add(this,0);
        this.x = x;
        this.y = y;
        this.setSize(50, 50);
        this.setLocation(x*50, y*50);
        if (type == 1){
            image = new ImageIcon("src\\Images\\WarriorUnit1.png");
            this.setIcon(image);
            this.setVisible(true);
            this.defaultMove = 2;
            movement = SetMove(defaultMove);
            UnitType.LoadUnits();
        }
    }
    public int SetMove(int defaultMove){
        return defaultMove;
    }
    public void Load(int newX, int newY){
        this.setLocation(newX, newY);
    }
}
