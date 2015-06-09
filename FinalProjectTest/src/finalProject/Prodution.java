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
    String discription;
    Prodution(int object){
        if (object == 0){
            name = "Warrior";
            productionCost = 1;
            goldCost = 1;
            icon = new ImageIcon("src\\Images\\WarriorIcon.png");
            discription = "The basic melee unit. Avalable from the start.";
        }
        if (object == 1){
            name = "Archer";
            productionCost = 1;
            goldCost = 1;
            icon = new ImageIcon("src\\Images\\WarriorIcon.png");
            discription = "The basic Ragned unit. Avalable once Barracks is built.";
        }
        if (object == 2){
            name = "Settler";
            productionCost = 1;
            goldCost = 1;
            icon = new ImageIcon("src\\Images\\WarriorIcon.png");
            discription = "Basic unit. able to settle new citys.";
        }
        if (object == 3){
            name = "Boat";
            productionCost = 1;
            goldCost = 1;
            icon = new ImageIcon("src\\Images\\WarriorIcon.png");
            discription = "The basic Naval Unit. Avalable once a Harbor is built.";
        }
        //End of units, add more above if you want to add more units.
        if (object == 25){
            name = "Barracks";
            productionCost = 1;
            goldCost = 1;
            icon = new ImageIcon("src\\Images\\WarriorIcon.png");
            discription = "Building Required to build Ground Units.";
        }
        if (object == 24){
            name = "Farm";
            productionCost = 1;
            goldCost = 1;
            icon = new ImageIcon("src\\Images\\WarriorIcon.png");
            discription = "Building that provides Bonus food production.";
        }
        if (object == 23){
            name = "Harbor";
            productionCost = 1;
            goldCost = 1;
            icon = new ImageIcon("src\\Images\\WarriorIcon.png");
            discription = "Building Required to build Navel Units.";
        }
        //End of Buildings, add more above if you want to add more buildings.
    }
}
