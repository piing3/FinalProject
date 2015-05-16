/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Deborah
 */
class UnitType {
    Icon image;
    int movement;
    
    public UnitType(int type, int move){
        if (type == 0){
            image = new ImageIcon("src\\Images\\WarriorUnit1.png");
        }
        movement = move;
    }
    
}
