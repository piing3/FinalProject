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
                     if (FinalProject.turnNumber == 1){
                        TurnOrder.spawnStart();
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
                     if (FinalProject.turnNumber == 1){
                        TurnOrder.spawnStart();
                     }
                 }
            else if(player2.isTurn){
                     FinalProject.Players.get(1).isTurn = false;
                     FinalProject.Players.get(2).isTurn = true;
                     if (FinalProject.turnNumber == 2){
                        TurnOrder.spawnStart();
                     }
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
                     if (FinalProject.turnNumber == 1){
                        TurnOrder.spawnStart();
                     }
                 }
            else if(player2.isTurn){
                     FinalProject.Players.get(1).isTurn = false;
                     FinalProject.Players.get(2).isTurn = true;
                     if (FinalProject.turnNumber == 2){
                        TurnOrder.spawnStart();
                     }
            }
            else if(player3.isTurn){
                     FinalProject.Players.get(2).isTurn = false;
                     FinalProject.Players.get(3).isTurn = true;
                     if (FinalProject.turnNumber == 3){
                        TurnOrder.spawnStart();
                     }
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

    public static void spawnStart() {
        Random startPos = new Random();
        int startX;
        int startY;
        boolean loopPass = false;
        do{
            startX = startPos.nextInt(126);
            startY = startPos.nextInt(70);
            loopPass = true; 
            if (Map.grid[startX][startY].tileType == 2) loopPass = false;
            if (13 > startX || startX > 115) loopPass = false;
            if (7 > startY || startY > 65) loopPass = false;
            for (int i = -5; i < 5; i++) {
                for (int j = -5; j < 5; j++) {
                    if(UnitType.FindUnit(startX + i, startY + j) != -1) loopPass = false; 
                }
            }
        }while(loopPass == false);
        UnitType.CreateUnit(startX, startY, 1,Visual.Units);//make units
        UnitType.CreateUnit(startX + 1, startY, 2,Visual.Units);
        if (startX > Map.x)Map.rightOff = startX - (Map.x/2);
        else {Map.rightOff = 0;}
        if (startY > Map.y)Map.downOff = startY - (Map.y/2);
        else{ Map.downOff = 0;}
        Visual.redrawMap();
        Visual.LoadUnits();
    }
    public void StartTurnOrder(){
        FinalProject.Players.get(0).isTurn = true;
    }
}