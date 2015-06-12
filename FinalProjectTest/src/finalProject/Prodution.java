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
    int productionChange = 0;
    int goldChange = 0;
    int number;
    int unitType;
    Boolean rebuildable = true;
    Boolean isUnit = false;
    Prodution(int object){
        number = object;
        if (object == 0){
            name = "Warrior";
            productionCost = 6;
            icon = new ImageIcon("src\\Images\\WarriorIconMed.png");
            discription = "The basic melee unit. Avalable from the start.";
            rebuildable = true;
            isUnit = true;
            unitType = 1;
        }
        if (object == 1){
            name = "Archer";
            productionCost = 24;
            icon = new ImageIcon("src\\Images\\WarriorIconMed.png");
            discription = "The basic Ragned unit. Avalable once Barracks is built.";
            rebuildable = true;
            isUnit = true;
            unitType = 3;
        }
        if (object == 2){
            name = "Settler";
            productionCost = 7;
            icon = new ImageIcon("src\\Images\\WarriorIconMed.png");
            discription = "Basic unit. able to settle new citys.";
            rebuildable = true;
            isUnit = true;
            unitType = 2;
        }
        if (object == 3){
            name = "Boat";
            productionCost = 15;
            icon = new ImageIcon("src\\Images\\WarriorIconMed.png");
            discription = "The basic Naval Unit. Avalable once a Harbor is built.";
            rebuildable = true;
            isUnit = true;
            unitType = 4;
        }
        if (object == 4){
            name = "Worker";
            productionCost = 10;
            icon = new ImageIcon("src\\Images\\WarriorIconMed.png");
            discription = "Able to work and improve tiles";
            rebuildable = false;
        }
        //End of units, add more above if you want to add more units.
        if (object == 25){
            name = "Barracks";
            productionCost = 10;
            icon = new ImageIcon("src\\Images\\WarriorIconMed.png");
            discription = "Building Required to build Ground Units.";
            rebuildable = false;
        }
        if (object == 24){
            name = "Farm";
            productionCost = 20;
            icon = new ImageIcon("src\\Images\\WarriorIconMed.png");
            discription = "Building that provides Bonus food production.";
            rebuildable = false;
        }
        if (object == 23){
            name = "Harbor";
            productionCost = 15;
            icon = new ImageIcon("src\\Images\\WarriorIconMed.png");
            discription = "Building Required to build Navel Units.";
            rebuildable = false;
        }
        if (object == 22){
            name = "WorkShop";
            productionCost = 3;
            productionChange = 5;
            icon = new ImageIcon("src\\Images\\WarriorIconMed.png");
            discription = "+5 Production";
            rebuildable = false;
        }
        //End of Buildings, add more above if you want to add more buildings.
    }
}
