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
    Icon Unit; 
    Icon unitIcon; 
    String name;
    public int Damage;
    
    Unit(int x, int y, int type, Container container, int owner) {
        container.add(this,0);
        this.x = x;
        this.y = y;
        this.setSize(50, 50);
        this.setLocation(x*50, y*50);
        this.player = owner;
        Visual.LoadUnits();
        
        this.setVisible(true);
        if (type == 1){
            this.name = "Warrior";
                 if (owner == 1) this.unitIcon = new ImageIcon("src\\Images\\UnitIcons\\SettlerPink.png");
            else if (owner == 3) this.unitIcon = new ImageIcon("src\\Images\\UnitIcons\\WarriorRed.png");
            else if (owner == 3) this.unitIcon = new ImageIcon("src\\Images\\UnitIcons\\WarriorGreen.png");
            else if (owner == 4) this.unitIcon = new ImageIcon("src\\Images\\UnitIcons\\WarriorBlue.png");
            this.defaultMove = 2;
            this.health = 60;
            this.Damage = 10;
            System.out.println("warrioir");
        }
        if (type == 2){
            this.name = "Settler";
                 if (owner == 1) this.unitIcon = new ImageIcon("src\\Images\\UnitIcons\\SettlerPink.png");
            else if (owner == 3) this.unitIcon = new ImageIcon("src\\Images\\UnitIcons\\SettlerRed.png");
            else if (owner == 3) this.unitIcon = new ImageIcon("src\\Images\\UnitIcons\\SettlerGreen.png");
            else if (owner == 4) this.unitIcon = new ImageIcon("src\\Images\\UnitIcons\\SettlerBlue.png");
            this.defaultMove = 2;
            this.health = 40;
            this.Damage = 0;
            System.out.println("set");
        }
        if (type == 3){
            this.name = "Archer";
                 if (owner == 1) this.unitIcon = new ImageIcon("src\\Images\\UnitIcons\\ArcherPink.png");
            else if (owner == 3) this.unitIcon = new ImageIcon("src\\Images\\UnitIcons\\ArcherRed.png");
            else if (owner == 3) this.unitIcon = new ImageIcon("src\\Images\\UnitIcons\\ArcherGreen.png");
            else if (owner == 4) this.unitIcon = new ImageIcon("src\\Images\\UnitIcons\\ArcherBlue.png");
            this.defaultMove = 2;
            this.health = 50;
            this.Damage = 15;
            System.out.println("arch");
        }
        movement = defaultMove;
    }
    public int SetMove(){return this.defaultMove;}
    public void Load(int newX, int newY){this.setLocation(newX, newY);}
    public  void setUnit(int type) {
        this.type = type;
        if (type == -1){
            Unit = null;
            this.setIcon(Unit);
        }

        if (type == 1){
                 if (this.player == 1) Unit = new ImageIcon("src\\Images\\UnitIcons\\WarriorPink.png");
            else if (this.player == 3) Unit = new ImageIcon("src\\Images\\UnitIcons\\WarriorRed.png");
            else if (this.player == 3) Unit = new ImageIcon("src\\Images\\UnitIcons\\WarriorGreen.png");
            else if (this.player == 4) Unit = new ImageIcon("src\\Images\\UnitIcons\\WarriorBlue.png");
            this.setIcon(Unit);
        }
        if (type == 2) {
                 if (this.player == 1) Unit = new ImageIcon("src\\Images\\UnitIcons\\SettlerPink.png");
            else if (this.player == 3) Unit = new ImageIcon("src\\Images\\UnitIcons\\SettlerRed.png");
            else if (this.player == 3) Unit = new ImageIcon("src\\Images\\UnitIcons\\SettlerGreen.png");
            else if (this.player == 4) Unit = new ImageIcon("src\\Images\\UnitIcons\\SettlerBlue.png");
            this.setIcon(Unit);
        }
        if (type == 3) {
                 if (this.player == 1) Unit = new ImageIcon("src\\Images\\UnitIcons\\ArcherPink.png");
            else if (this.player == 3) Unit = new ImageIcon("src\\Images\\UnitIcons\\ArcherRed.png");
            else if (this.player == 3) Unit = new ImageIcon("src\\Images\\UnitIcons\\ArcherGreen.png");
            else if (this.player == 4) Unit = new ImageIcon("src\\Images\\UnitIcons\\ArcherBlue.png");
            this.setIcon(Unit);
        }
    }
}
