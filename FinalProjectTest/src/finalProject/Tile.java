/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import javax.swing.JLabel;

/**
 *
 * @author Davin
 */
class Tile extends JLabel{//wasn't working in a seperate class, fix later
        public int x;
        public int y;
        public int tileType;
        public int owner;
        public int improvement;
        public int occupint;  
        
        public Tile() {
        }
}
