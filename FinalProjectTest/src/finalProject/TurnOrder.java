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
    int numberOfPlayers = FinalProject.play;
    public void NextTurn(){
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
        public static int whoTurn(){
            if (Globals.player1.isTurn) return 1;
            if (Globals.player2.isTurn) return 2;
            if (Globals.player3.isTurn);
            if (Globals.player4.isTurn);
        }
    }
}
