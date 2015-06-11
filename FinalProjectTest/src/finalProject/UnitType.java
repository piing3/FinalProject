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
    final static int WATER = 2;
    final static int CITY = 100;
    final static int EMPTY = -1;
    final static int YLENGTH = 128;
    final static int XWIDTH = 72;
    final static int BORDER = 3;

     public  static void CreateUnit(int x, int y, int type, Container container){
        if (FinalProject.units.isEmpty()){
            Globals.unitGrid  = new int[YLENGTH][XWIDTH];
            for (int i = 0; i < Globals.unitGrid.length; i++) {
                for (int j = 0; j < Globals.unitGrid[i].length; j++) {
                    Globals.unitGrid[i][j] = 0;
                }
            }
        }
            int owner = TurnOrder.whoTurn();
            FinalProject.units.add(new Unit(x, y, type,container, owner));
            Globals.unitGrid[x][y] = type;
            Visual.LoadUnits();
        
   
    }
    public static int FindUnit(int x, int y){
        int result = EMPTY;
        if (FinalProject.units.size() <= 0){
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
        int result = EMPTY;
        for (int i = 0; i < FinalProject.units.size(); i++) {
            if (FinalProject.units.get(i).player == owner){
                result = i;
            }
        }
        return result;
        
    }
    public static void MoveGround(int index, int newX, int newY){
    Unit unit = FinalProject.units.get(index);
    if (FindUnit(newX, newY) == EMPTY){
        if (Tile.getTileType(Map.grid[newX][newY]) != WATER && Tile.getTileType(Map.grid[newX][newY]) != BORDER){
            if (unit.movement > 0){
                if (unit.x + 1 == newX || unit.x -1 == newX || unit.x == newX){
                     if (unit.y + 1 == newY || unit.y -1 ==newY || unit.y == newY){
                        Globals.unitGrid[unit.x][unit.y] = 0;
                        Globals.unitGrid[newX][newY] = unit.type;
                        FinalProject.units.get(index).movement--;
                        FinalProject.units.get(index).x = newX;
                        FinalProject.units.get(index).y = newY;
                        FinalProject.units.get(index).setLocation(newX*50, newY*50);
                        Visual.LoadUnits(); 
                        }                      
                    }                                                                                                                                                                                                                                                                                                                                                                                             
                }
            }
        }
    }
    public static void MoveWater(int index, int newX, int newY){
        Unit unit = FinalProject.units.get(index);
        if (FindUnit(newX, newY) == EMPTY){
            if (Tile.getTileType(Map.grid[newX][newY]) == WATER || Tile.getTileType(Map.grid[newX][newY]) == CITY) {
                if (unit.movement > 0){
                    if (unit.x + 1 == newX || unit.x -1 == newX || unit.x == newX){
                        if (unit.y + 1 == newY || unit.y -1 ==newY || unit.y == newY) {
                            Globals.unitGrid[unit.x][unit.y] = 0;
                            Globals.unitGrid[newX][newY] = unit.type;
                            FinalProject.units.get(index).movement -= 1;
                            FinalProject.units.get(index).x = newX;
                            FinalProject.units.get(index).y = newY;
                            FinalProject.units.get(index).setLocation(newX*50, newY*50);
                            Visual.LoadUnits(); 
                        } 
                    }
                }
            }
    }
    }
    public static void Death(int index){
        Unit unit =/*>:(*/ FinalProject.units.get(index);
        Globals.unitGrid[unit.x][unit.y] = -1;
        unit.setUnit(Globals.unitGrid[unit.x][unit.y]);
        FinalProject.units.remove(index);
        Visual.LoadUnits();
    }
    public static void ResetUnits(int owner){
        for (int i = 0; i < FinalProject.units.size(); i++) {
            if (FinalProject.units.get(i).player == owner) FinalProject.units.get(i).SetMove(); 
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
    public void AttackCity(){
        
    }
}
