/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Davin
 */
class Alert{
    
    public int x;
    public int y;
    public Alert(String Text, int type) {
        if (type == 0) {
            JPanel panel = new JPanel(null);
            UserInt.alerts.add(panel);
            panel.setSize(50, 50);
            panel.setBackground(Color.BLACK);
        }
    }
    
}
