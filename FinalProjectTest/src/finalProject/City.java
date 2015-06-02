/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Point;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Davin
 */
class City extends JLabel{
    
    public int x;
    public int y;
    City(int x, int y) {
        this.x = x;
        this.y = y;
        if(Tile.getTileType(Map.grid[x][y]) != 2 && Tile.getTileType(Map.grid[x][y]) != 3){
            Icon tile = new ImageIcon("src\\Images\\CityTile1.png");
            this.setIcon(tile);
            this.setSize(50, 50);
            this.setLocation(x*50, y*50);
            Map.grid[x][y].setTile(100);
            Map.tileType[x][y] = 100;
            Visual.redrawMap();
        }
    }    
}
