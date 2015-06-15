/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.util.Random;

/**
 *
 * @author Ben (Tad bit to "organized")
 */
public class TurnOrder{
    static int numberOfPlayers = FinalProject.play;
    public static int whoTurn(){
        int result = -1;

        if (FinalProject.Players.get(0).isTurn) result = 1;
            else  if (FinalProject.Players.get(1).isTurn) result = 2;
            else  if (FinalProject.Players.get(2).isTurn) result = 3;
            else  if (FinalProject.Players.get(3).isTurn) result = 4;
            return result;
    }
    public static void NextTurn(){
        FinalProject.turnNumber++;
        if(numberOfPlayers == 2){
             Person player1 =       FinalProject.Players.get(0);
             Person player2 =       FinalProject.Players.get(1);
                 if(player1.isTurn){
                     FinalProject.Players.get(0).isTurn = false;
                     FinalProject.Players.get(1).isTurn = true;
                     City.updateProduction(FinalProject.Players.get(1));
                     UnitType.ResetUnits(whoTurn());
                     if (FinalProject.turnNumber <= 1){
                        Random startPos = new Random();
                        int startX;
                        int startY;
                        do{
                            startX = startPos.nextInt(126);
                            startY = startPos.nextInt(72);
                        }while(Map.grid[startX][startY].tileType == 2);
                        UnitType.CreateUnit(startX, startY, 1,Visual.Units);//make units
                        UnitType.CreateUnit(startX + 1, startY, 2,Visual.Units);
                        int index = UnitType.FindUnit(whoTurn());
                        if (FinalProject.units.get(index).x > Map.x)Map.rightOff = FinalProject.units.get(startX).x - (Map.x/2);
                        else Map.downOff = FinalProject.units.get(startX).x;
                        if (FinalProject.units.get(index).y > Map.y)Map.downOff = FinalProject.units.get(startY).y - (Map.y/2);
                        else Map.rightOff = FinalProject.units.get(startY).y; 
                        Visual.redrawMap();
                        Visual.LoadUnits();
                     }
                 }
            else if(player2.isTurn){  
                     FinalProject.Players.get(0).isTurn = true;
                     FinalProject.Players.get(1).isTurn = false;
                     City.updateProduction(FinalProject.Players.get(0));//Ben, copy this to the other ones
                     UnitType.ResetUnits(whoTurn());
            }
        }
        if(numberOfPlayers == 3){
             Person player1 =       FinalProject.Players.get(0);
             Person player2 =       FinalProject.Players.get(1);
             Person player3 =       FinalProject.Players.get(2);
                 if(player1.isTurn){
                     FinalProject.Players.get(0).isTurn = false;
                     FinalProject.Players.get(1).isTurn = true;
                 }
            else if(player2.isTurn){
                     FinalProject.Players.get(1).isTurn = false;
                     FinalProject.Players.get(2).isTurn = true;
            }
            else if(player3.isTurn){
                     FinalProject.Players.get(2).isTurn = false;
                     FinalProject.Players.get(0).isTurn = true;
            }
        }
        if(numberOfPlayers == 4){
             Person player1 =       FinalProject.Players.get(0);
             Person player2 =       FinalProject.Players.get(1);
             Person player3 =       FinalProject.Players.get(2);
             Person player4 =       FinalProject.Players.get(3);
                 if(player1.isTurn){
                     FinalProject.Players.get(0).isTurn = false;
                     FinalProject.Players.get(1).isTurn = true;
                 }
            else if(player2.isTurn){
                     FinalProject.Players.get(1).isTurn = false;
                     FinalProject.Players.get(2).isTurn = true;
            }
            else if(player3.isTurn){
                     FinalProject.Players.get(2).isTurn = false;
                     FinalProject.Players.get(3).isTurn = true;
            }
            else if(player4.isTurn){
                     FinalProject.Players.get(3).isTurn = false;
                     FinalProject.Players.get(0).isTurn = true;
            }
        }
        int index = UnitType.FindUnit(whoTurn());
        if (FinalProject.units.get(index).x > Map.x)Map.rightOff = FinalProject.units.get(index).x - (Map.x/2);
        else Map.downOff = FinalProject.units.get(index).x;
        if (FinalProject.units.get(index).y > Map.y)Map.downOff = FinalProject.units.get(index).y - (Map.y/2);
        else Map.rightOff = FinalProject.units.get(index).y; 
        Visual.redrawMap();
        Visual.LoadUnits();
    }
    public void StartTurnOrder(){
        FinalProject.Players.get(0).isTurn = true;
    }
}