/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Container;


/**
 *
 * @author Ben Allen
 */
class UnitType {

    
    public  static void CreateUnit(int x, int y, int type, Container container){
        if (FinalProject.units.isEmpty()){
            Globals.unitGrid  = new int[128][72];
            for (int i = 0; i < Globals.unitGrid.length; i++) {
                for (int j = 0; j < Globals.unitGrid[i].length; j++) {
                    Globals.unitGrid[i][j] = 0;
                }
            }
        }
        if (type == 1){
            int owner = 1;//TurnOrder.whoTurn();
            ResetUnits(owner);
            FinalProject.units.add(new Unit(x, y, type,container, owner));
            Globals.unitGrid[x][y] = type;
            Visual.LoadUnits();
        }
    }
    public static int FindUnit(int x, int y){
        int x2;
        int y2;
        //System.out.println("" + FinalProject.units.size());
        int result = -1;
        if (FinalProject.units.size() <= 0){
            //System.out.println("oo");
        }
        for (int i = 0; i < FinalProject.units.size(); i++) {
            Unit unit = FinalProject.units.get(i);
            if (unit.x == x && unit.y  == y){
                result = i;
            }
        }
        return result;
    } 
    public static int FindUnit(int owner){
        int result = -1;
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
    public static void MoveGround(int index, int newX, int newY){
        Unit unit = FinalProject.units.get(index);
        if (FindUnit(newX, newY) == -1){
            if (Tile.getTileType(Map.grid[newX][newY]) != 2 && Tile.getTileType(Map.grid[newX][newY]) != 3){
                if (unit.movement > 0){
                    Globals.unitGrid[unit.x][unit.y] = 0;
                    Globals.unitGrid[unit.x][unit.y] = unit.type;
                    unit.movement -= 1;
                    unit.x = newX;
                    unit.y = newY;
                    unit.setLocation(newX*50, newY*50);
                    Visual.LoadUnits();                                                                                                                                                                                                                                                                                                                                                                                                                     
                }
            }
        }
    }
    public void Death(int index){
        FinalProject.units.remove(index);
        Visual.LoadUnits();
    }
    public static void ResetUnits(int owner){
        for (int i = 0; i < FinalProject.units.size(); i++) {
           int index = FindUnit(owner);
          // FinalProject.units.get(index).SetMove(FinalProject.units.get(index).type);
        }
    }
    public void AttackMelee(int unitOneIndex, int unitTwoIndex){
        Unit unitOne = FinalProject.units.get(unitOneIndex);
        Unit unitTwo = FinalProject.units.get(unitOneIndex);
        unitTwo.health -= unitOne.Damage;
        
        if (unitTwo.health <= 0) Death(unitTwoIndex);
        else {
            FinalProject.units.get(unitTwoIndex).health = unitTwo.health;
            unitOne.health -= unitTwo.Damage;
            FinalProject.units.get(unitOneIndex).health = unitOne.health;
            if (unitOne.health <= 0) Death(unitOneIndex);
        }
        
    }
    public void AttackRange(int unitTwoIndex){
        Unit unitTwo = FinalProject.units.get(unitTwoIndex);
        unitTwo.health -= unitTwo.Damage;
        if (unitTwo.health <= 0) Death(unitTwoIndex);
        else{
            FinalProject.units.get(unitTwoIndex).health = unitTwo.health;
        }
    }
}
