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

    public static Icon image;
    public int unitGrid[][];
    
    public  static void CreateUnit(int x, int y, int type){
        if (type == 0){
            image = new ImageIcon("src\\Images\\WarriorUnit1.png");
            int movement = 2;
            FinalProject.units.add(new Unit(x, y, type, movement));
        } 
        
    }
    public static int FindUnit(int x, int y){
        //System.out.println("" + FinalProject.units.size());
        int result = -2;
        if (FinalProject.units.size() <= 0){
            //System.out.println("oo");
        }
        for (int i = 0; i < FinalProject.units.size(); i++) {
            if (FinalProject.units.get(i).x == x && FinalProject.units.get(i).y == y){
                result = i;
            }
            else {
                result = -1;
            }
        }
        return result;
    }
    public void Move(int index, int newX, int newY){
        int speed = FinalProject.units.get(index).movement;
        if (FindUnit(newX, newY) == -1){
            
        }
    }
    public void Death(int index){
        FinalProject.units.remove(index);
    }
    
    
}
