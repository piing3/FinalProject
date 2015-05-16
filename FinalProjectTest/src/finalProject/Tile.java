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
        public int occupint;  
        
        public Tile(int i, int j) {
            x = i; y = j;
            this.setSize(50, 50);
            this.setLocation((x * 50), (y * 50));
        }

    public void setTile(int type) {
        if (type == 0 ){
            Icon tile = new ImageIcon("src\\Images\\GrassTile1.png");
            this.setIcon(tile);
        }
        if (type == 1){
            Icon tile = new ImageIcon("src\\Images\\DessertTile1.png");
            this.setIcon(tile);
        }
        if (type == 2){
            Icon tile = new ImageIcon("src\\Images\\WaterTile1.png");
            this.setIcon(tile);
        }
    }
}