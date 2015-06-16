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
 * Used to store the info about each city
 * and does most of the city logic
 *
 * @author Davin
 */
class City extends JLabel{
    
    public int x;//location
    public int y;
    
    public int production = 1;//city info 
    public int gold = 0;
    public int population = 3;
    public int food = 0;
    
    public int growthLeft;//used for adding population
    public int productionLeft;//used for building things
    public Prodution productionItem = new Prodution(-1);//the item being built
    
    public int Health = 100;//city combat numbers, unused
    public int Damage = 20;
    
    public String name = "";//city name
    public Person owner;//city owner
    
    public ArrayList<Integer> cityBuildObjects = new ArrayList<Integer>();//can be built objects 
    public ArrayList<Integer> BuiltObjects = new ArrayList<Integer>();//built objects 
    
    City(int x, int y, int Owner) {
        this.x = x;//stores location
        this.y = y;
        this.owner = FinalProject.Players.get(Owner);//stores owner
        
        Map.tileType[x][y] = 100;//sets the grid location to a city...
        Visual.redrawMap();//... and redraws the map
        
        name = JOptionPane.showInputDialog("Name this city");//name the city
            
        for (int i = 0; i < this.owner.buildObjects.size(); i++) {
            this.cityBuildObjects.add(this.owner.buildObjects.get(i));
        }
        for (int i = -2; i < 3; i++) {
            for (int j = -2; j < 3; j++) {
                Tile tile = Map.grid[this.x + i][this.y + j];
                //this.production += tile.production;
                //this.food += tile.food;
                Map.borderGrid[this.x + i][this.y + j].setBorder(1);
                Map.borderType[this.x + i][this.y + j] = TurnOrder.whoTurn();
                Visual.redrawMap();
            }
        }
        //this.food /= 2;
        //this.production /= 2;
    }
    City() {
    }
    
    
    
    public void setGold(City city, int newGold){
        city.gold = newGold;
    }  
    public void setProduction(City city, int newProduction){
        city.production = newProduction;
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
    public int getPopulation(City city){
        return city.population;
    }  
    public int getFood(City city){
        return city.food;
    }  
    
    public static void updateProduction(Person owner){
        for (int i = 0; i < FinalProject.cities.size(); i++) {
            City city = FinalProject.cities.get(i);
            if (city.owner == owner){
                city.productionLeft -= city.production; 
                if (city.productionLeft <= 0) {
                    if (!city.productionItem.rebuildable) {
                        for (int j = 0; j < city.cityBuildObjects.size(); j++) {
                            if (city.cityBuildObjects.get(j) == city.productionItem.number)  city.cityBuildObjects.remove(j);
                        }
                    }
                    if (city.productionItem.isUnit) UnitType.CreateUnit(city.x, city.y, city.productionItem.unitType, Visual.Units);
                    city.BuiltObjects.add(city.productionItem.number);
                    city.productionItem = new Prodution(-1);
                }
                city.growthLeft -= city.food;
                if (city.growthLeft <= 0) {
                    city.population++;
                    city.growthLeft = city.population*3;
                }
                
                city.production = 1;
                city.food = 0;
                
                for (int j = 0; j < city.BuiltObjects.size(); j++) {
                    city.gold += new Prodution(city.BuiltObjects.get(j)).goldChange;
                    city.production += new Prodution(city.BuiltObjects.get(j)).productionChange;
                    System.out.println(new Prodution(city.BuiltObjects.get(j)).name);
                }
                for (int j = -2; j < 3; j++) {
                    for (int k = -2; k < 3; k++) {
                        Tile tile = Map.grid[city.x + j][city.y + k];
                        city.production += tile.production;
                        city.food += tile.food;
                    }
                }
                city.food -= city.population;
                city.production += city.population/2;
            }
        }
    }
}
