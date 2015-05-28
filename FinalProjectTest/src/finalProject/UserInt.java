/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicOptionPaneUI;

/**
 *
 * @author Davin
 */
class UserInt {
    
        public JButton nextTurn;
    
    UserInt() throws FileNotFoundException{
        
        nextTurn = new JButton("Next Turn");
        
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TurnOrder.NextTurn();
            }
        };
        nextTurn.addActionListener(actionListener);
        
        nextTurn.setSize(100, 50);
        nextTurn.setLocation(100, 100);
        nextTurn.setBackground(Color.pink);
        nextTurn.setVisible(true);
        Visual.UI.add(nextTurn);
    }
}
