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
            if (Globals.player1.isTurn) result = 1;
            if (Globals.player2.isTurn) result = 2;
            if (Globals.player3.isTurn) result = 3;
            if (Globals.player4.isTurn) result = 4;
            return result;
    }
    
    public static Person player(int number){
        Person result = FinalProject.player1; 
        if (Globals.player1.isTurn) result = FinalProject.player1;
        if (Globals.player2.isTurn) result = FinalProject.player2;
        if (Globals.player3.isTurn) result = FinalProject.player3;
        if (Globals.player4.isTurn) result = FinalProject.player4;
        return result;
    }
    
    public static void NextTurn(){
        if(numberOfPlayers == 2){
            if(Globals.player1.isTurn)
            {
                
            }
            if(Globals.player2.isTurn)
            {
                
            }
        }
        if(numberOfPlayers == 3){
            if(Globals.player1.isTurn)
            {
                
            }
            if(Globals.player2.isTurn)
            {
                
            }
            if(Globals.player3.isTurn)
            {
                
            }
        }
        if(numberOfPlayers == 4){
            if(Globals.player1.isTurn)
            {
                
            }
            if(Globals.player2.isTurn)
            {
                
            }
            if(Globals.player3.isTurn)
            {
                
            }
            if(Globals.player1.isTurn)
            {
                
            }
        }
        
        }
    }
