/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojecttest;

import javax.swing.JFrame;

/**
 *
 * @author Davin
 */
class Map extends JFrame{
    
    Map(int fullscreen){
        if(fullscreen == 0){
            this.setExtendedState(this.MAXIMIZED_BOTH);
            this.setUndecorated(true);
        }
        else{
            this.setSize(1280,720);
        }
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }    
}
