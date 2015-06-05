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
 * @author Davin
 */
class Prodution {
    int goldCost;
    int productionCost;
    String name;
    Icon icon;
    Prodution(int object){
        if (object == 0){
            name = "warrior";
            productionCost = 1;
            goldCost = 1;
            icon = new ImageIcon("src\\Images\\WarriorIcon.png");
        }
    }
}
