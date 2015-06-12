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
    public int production = 1;
    public int gold = 0;
    public int population = 1;
    public int food = 1;
    public int science = 0;
    public int Health;
    public int Damage = 20;
    public String name = "";
    public Person owner;
    public int productionLeft;
    public Prodution productionItem = new Prodution(-1);
    public ArrayList<Integer> cityBuildObjects = new ArrayList<Integer>();
    
    City(int x, int y, int Owner) {
        this.Health = 100;
        this.x = x;
        this.y = y;
        this.owner = FinalProject.Players.get(Owner);
        cityBuildObjects = new ArrayList<Integer>();
        if(Tile.getTileType(Map.grid[x][y]) != 2 && Tile.getTileType(Map.grid[x][y]) != 3){
            Icon tile = new ImageIcon("src\\Images\\CityTile1.png");
            this.setIcon(tile);
            this.setSize(50, 50);
            this.setSize(50, 50);
            this.setLocation(x*50, y*50);
            Map.grid[x][y].setTile(100);
            Map.tileType[x][y] = 100;
            Visual.redrawMap();
            name = JOptionPane.showInputDialog("Name this city");
        } 
        for (int i = 0; i < this.owner.buildObjects.size(); i++) {//Outputs lots of errors if FinalProject.play = 0
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
    
    public static void updateProduction(Person owner){
        for (int i = 0; i < FinalProject.cities.size(); i++) {
            City city = FinalProject.cities.get(i);
            if (city.owner == owner){
                city.productionLeft -= city.production; 
                if (city.productionLeft <= 0) {
                    city.gold += city.productionItem.goldChange;
                    city.production += city.productionItem.productionChange;
                    if (!city.productionItem.rebuildable) {
                        for (int j = 0; j < city.cityBuildObjects.size(); j++) {
                            if (city.cityBuildObjects.get(j) == city.productionItem.number)  city.cityBuildObjects.remove(j);
                        }
                    }
                    if (city.productionItem.isUnit) UnitType.CreateUnit(city.x, city.y, city.productionItem.unitType, Visual.Units);
                    city.productionItem = new Prodution(-1);
                    Alert alert = new Alert(city.productionItem.name, 0); 
                }
            }
        }
    }
}
