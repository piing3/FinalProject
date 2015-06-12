/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Davin
 */
class Tile extends JLabel{

    
        public int x;
        public int y;
        public int tileType;
        public int owner;
        public int improvement;
        public int movement;
        public Icon tile;
        public int production;
        public int food;
        
        public Tile(int i, int j) {
            x = i; y = j;
            this.setSize(50, 50);
            this.setLocation((x * 50), (y * 50));
        }

    public void setTile(int type) {
        tileType = type;
        if (type == 0 ){
            tile = new ImageIcon("src\\Images\\GrassTile1.png");
            this.setIcon(tile);
            movement = 1;
            production = 1;
            food = 2;
        }
        if (type == 1){
            tile = new ImageIcon("src\\Images\\DessertTile1.png");
            this.setIcon(tile);
            movement = 1;
            production = 0;
            food = 0;
        }
        if (type == 2){
            tile = new ImageIcon("src\\Images\\WaterTile1.png");
            this.setIcon(tile);
            movement = 1;
            production = 1;
            food = 1;
        }
        if (type == 3){
            tile = new ImageIcon("src\\Images\\BorderTile1.png");
            this.setIcon(tile);
            production = -1000;
            food = -1000;
        }
        if (type == 50){
            tile = new ImageIcon("src\\Images\\FarmTile1.png");
            this.setIcon(tile);
            production = 0;
            food = 4;
        }
        if (type == 51){
            tile = new ImageIcon("src\\Images\\MineTile1.png");
            this.setIcon(tile);
            production = 4;
            food = 0;
        }
        if (type == 52){
            tile = new ImageIcon("src\\Images\\BorderTile1.png");
            this.setIcon(tile);
            production = -1000;
            food = -1000;
        }
        if (type == 53){
            tile = new ImageIcon("src\\Images\\BorderTile1.png");
            this.setIcon(tile);
            production = -1000;
            food = -1000;
        }
        if (type == 100){
            tile = new ImageIcon("src\\Images\\CityTile1.png");
            this.setIcon(tile);
        }
    }
   static int getTileType(Tile tile) {
      return tile.tileType;
   }
}
