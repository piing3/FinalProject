/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.util.ArrayList;
import java.util.Random;

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
    public int startX;
    public int startY;
    
    public Person(String name, int playerNumber, int players) {
        //Random spawn = new Random();
        //startX = spawn.nextInt(126)+1;
        
        UnitType.CreateUnit(14, 9, playerNumber,Visual.Units);
        this.name = name;
        this.PlayerNumber = playerNumber;
        this.players = players;
        buildObjects.add(0);
        buildObjects.add(1);
        buildObjects.add(3);
        buildObjects.add(4);
        buildObjects.add(25);
        buildObjects.add(24);
        buildObjects.add(23);
    }
}
