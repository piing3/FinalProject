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
    
    int x;
    int y;
    City(Point point) {
        x = point.x/50+Map.rightOff ;
        y = point.y/50+Map.downOff;
        Icon tile = new ImageIcon("src\\Images\\CityTile1.png");
        this.setIcon(tile);
        this.setSize(50, 50);
        this.setLocation(x, y);
        Map.grid[x][y].tile = tile;
        System.out.println("X: "+x+", Y: "+y);
    }
    
}
