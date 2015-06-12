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
class Border extends JLabel{

    
        public int x;
        public int y;
        public int borderType;
        public Icon icon;
        
        public Border(int i, int j) {
            x = i; y = j;
            this.setSize(50, 50);
            this.setLocation((x * 50), (y * 50));
        }
   
   public void setBorder(int type){
       if (type == 0){
           this.setIcon(null);
       }
       if (type == 1){
           icon = new ImageIcon("src\\Images\\PinkBorder.png");
           this.setIcon(icon);
           System.out.println("");
       }
       if (type == 2){
           icon = new ImageIcon("src\\Images\\RedBorder.png");
           this.setIcon(icon);
       }
       if (type == 3){
           icon = new ImageIcon("src\\Images\\GreenBorder.png");
           this.setIcon(icon);
       }
       if (type == 4){
           icon = new ImageIcon("src\\Images\\BlueBorder.png");
           this.setIcon(icon);
       }
   } 
}
