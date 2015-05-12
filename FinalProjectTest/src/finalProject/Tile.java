/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

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
            Icon temp = new ImageIcon("C:\\Users\\Davin.DAVIN-PC\\Desktop\\Temp2.png");
            this.setIcon(temp);
        }
}
