/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

/**
 *
 * @author Ben
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
    
    public static Person Player(int number){
        Person           result = FinalProject.Players.get(0); 
        if (number == 1) result = FinalProject.Players.get(0);
        if (number == 2) result = FinalProject.Players.get(1);
        if (number == 3) result = FinalProject.Players.get(2);
        if (number == 4) result = FinalProject.Players.get(3);
        return result;
    }
    
    public static void NextTurn(){
        if(numberOfPlayers == 2){
             Person player1 =       FinalProject.Players.get(0);
             Person player2 =       FinalProject.Players.get(1);
                 if(player1.isTurn) FinalProject.Players.get(0).isTurn = true;
            else if(player2.isTurn) FinalProject.Players.get(1).isTurn = true;
        }
        if(numberOfPlayers == 3){
             Person player1 =       FinalProject.Players.get(0);
             Person player2 =       FinalProject.Players.get(1);
             Person player3 =       FinalProject.Players.get(2);
                 if(player1.isTurn) FinalProject.Players.get(0).isTurn = true;
            else if(player2.isTurn) FinalProject.Players.get(1).isTurn = true;
            else if(player3.isTurn) FinalProject.Players.get(2).isTurn = true;
        }
        if(numberOfPlayers == 4){
             Person player1 =       FinalProject.Players.get(0);
             Person player2 =       FinalProject.Players.get(1);
             Person player3 =       FinalProject.Players.get(2);
             Person player4 =       FinalProject.Players.get(3);
                 if(player1.isTurn) FinalProject.Players.get(0).isTurn = true;
            else if(player2.isTurn) FinalProject.Players.get(1).isTurn = true;
            else if(player3.isTurn) FinalProject.Players.get(2).isTurn = true;
            else if(player4.isTurn) FinalProject.Players.get(3).isTurn = true;
        }
    }
    public void StartTurns(){
        FinalProject.Players.get(0).isTurn = true;
    }
}