/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

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
        if(numberOfPlayers == 2){
             Person player1 =       FinalProject.Players.get(0);
             Person player2 =       FinalProject.Players.get(1);
                 if(player1.isTurn){
                     FinalProject.Players.get(0).isTurn = false;
                     FinalProject.Players.get(1).isTurn = true;
                     City.updateProduction(FinalProject.Players.get(1));
                     UnitType.ResetUnits(1);
                 }
            else if(player2.isTurn){
                     FinalProject.Players.get(0).isTurn = true;
                     FinalProject.Players.get(1).isTurn = false;
                     City.updateProduction(FinalProject.Players.get(0));//Ben, copy this to the other ones
                    UnitType.ResetUnits(0);
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
    }
    public void StartTurnOrder(){
        FinalProject.Players.get(0).isTurn = true;
    }
    public void StarNextTurn(){
        int player = whoTurn();
        UnitType.ResetUnits(player);
        //Davin add the rest of stuff for production and stuff.

    }
    
}