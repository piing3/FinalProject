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
        System.out.println("Poop");
        
        nextTurn = new JButton("Next Turn");
        
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TurnOrder.NextTurn();
                System.out.println("Next Turn");
            }
        };
        nextTurn.addActionListener(actionListener);
        
        nextTurn.setSize(200, 25);
        nextTurn.setLocation(Visual.width - 200, Visual.hight - 175);
        nextTurn.setBackground(Color.gray);
        nextTurn.setVisible(true);
        nextTurn.setFocusable(false);
        Visual.UI.add(nextTurn);
    }
}
