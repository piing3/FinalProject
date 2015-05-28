/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import static finalProject.Map.grid;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Deborah
 */
class UnitType {

    public static Icon image;
    
    public  static void CreateUnit(int x, int y, int type){
        if (FinalProject.units.isEmpty()){
            Globals.unitGrid  = new int[128][72];
        }
        if (type == 1){
            int owner = TurnOrder.whoTurn();
            image = new ImageIcon("src\\Images\\WarriorUnit1.png");
            ResetUnits(owner);
            FinalProject.units.add(new Unit(x, y, type));
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
    public static int FindUnit(int owner){
        int result = -2;
        for (int i = 0; i < FinalProject.units.size(); i++) {
            if (FinalProject.units.get(i).player == owner){
                result = i;
            }
            else{
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
    public static void ResetUnits(int owner){
        for (int i = 0; i < FinalProject.units.size(); i++) {
           int index = FindUnit(owner);
           FinalProject.units.get(index).SetMove(FinalProject.units.get(index).type);
        }
    }
    
    
}
