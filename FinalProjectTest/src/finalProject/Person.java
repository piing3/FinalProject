/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.util.ArrayList;

/**
 *
 * @author Ben
 */
class Person {
    String name;
    public int PlayerNumber;
    public boolean isTurn;
    public int players;
    public ArrayList<Integer> buildObjects = new ArrayList<Integer>();
    
    public Person(String name, int playerNumber, int players) {
        this.name = name;
        this.PlayerNumber = playerNumber;
        this.players = players;
        //TurnOrder TurnOrder = new TurnOrder();
        buildObjects.add(0);
    }
    public boolean startTurn()
    {
        //if (playerTurn == PlayerNumber){
        return true;
        
    }

    
    

}
