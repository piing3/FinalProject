/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Davin
 */
class City extends JLabel{
    
    public int x;
    public int y;
    public int production = 0;
    public int gold = 0;
    public int population = 0;
    public int food = 0;
    public int science = 0;
    public String name = "";
    public Person owner;
    public ArrayList<Integer> cityBuildObjects = new ArrayList<Integer>();
    
    City(int x, int y, int owner) {
        this.x = x;
        this.y = y;
        this.owner = TurnOrder.player(owner);
        if(Tile.getTileType(Map.grid[x][y]) != 2 && Tile.getTileType(Map.grid[x][y]) != 3){
            Icon tile = new ImageIcon("src\\Images\\CityTile1.png");
            this.setIcon(tile);
            this.setSize(50, 50);
            this.setLocation(x*50, y*50);
            Map.grid[x][y].setTile(100);
            Map.tileType[x][y] = 100;
            Visual.redrawMap();
            name = JOptionPane.showInputDialog("Name this city");
        } 
        for (int i = 0; i < this.owner.buildObjects.size(); i++) {
            this.cityBuildObjects.add(this.owner.buildObjects.get(i));
        }
    }
    City() {
    }
    
    
    
    public void setGold(City city, int newGold){
        city.gold = newGold;
    }  
    public void setProduction(City city, int newProduction){
        city.production = newProduction;
    }  
    public void setScience(City city, int newScience){
        city.science = newScience;
    }  
    public void setPopulation(City city, int newPopulation){
        city.population = newPopulation;
    }  
    public void setFood(City city, int newFood){
        city.food = newFood;
    }  
    
    public int getGold(City city){
        return city.gold;
    }  
    public int getProduction(City city){
        return city.production;
    }  
    public int getScience(City city){
        return city.science;
    }  
    public int getPopulation(City city){
        return city.population;
    }  
    public int getFood(City city){
        return city.food;
    }  
}
