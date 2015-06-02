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
        }
        if (type == 1){
           // int owner = TurnOrder.whoTurn();
            //ResetUnits(owner);
            FinalProject.units.add(new Unit(x, y, type,container));
            LoadUnits();
        }
        
        
    }
    public static int FindUnit(int x, int y){
        int x2;
        int y2;
        //System.out.println("" + FinalProject.units.size());
        int result = -2;
        if (FinalProject.units.size() <= 0){
            //System.out.println("oo");
        }
        for (int i = 0; i < FinalProject.units.size(); i++) {
            Unit unit = FinalProject.units.get(i);
            if (unit.x == x && unit.y  == y){
                result = i;
            }
            else {
                result = -1;
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
        int speed = FinalProject.units.get(index).movement;
        if (FindUnit(newX, newY) == -1){
            if (Tile.getTileType(Map.grid[newX][newY]) != 2 && Tile.getTileType(Map.grid[newX][newY]) != 3){
                System.out.println("gggg");
                Unit unit = FinalProject.units.get(index);
                System.out.println("gggg");
                if (unit.movement == 0){
                    unit.movement -= 1;
                    unit.x = newX;
                    unit.y = newY;
                    unit.setLocation(newX*50, newY*50);
                }
            }
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
    public static void LoadUnits(){
        for (int j = 0; j <= 71; j++){
            for (int i = 0; i <= 127; i++){
                if (FindUnit(i,j) >= 0){
                    System.out.println("test");
                    int index = FindUnit(i, j);
                    Globals.unitGrid[i][j] = FinalProject.units.get(index).type;
                    FinalProject.units.get(index).setLocation(500, 500);
                }
            }
        }
    }
}
