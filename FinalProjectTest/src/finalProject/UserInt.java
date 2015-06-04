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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.plaf.basic.BasicOptionPaneUI;

/**
 *
 * @author Davin
 */
class UserInt {
    
        public JButton nextTurn;
        static public JButton cityTest = new JButton();
        static public City city;
        static public JLabel cityLeft;
    
    UserInt() throws FileNotFoundException{
        System.out.println("Poop");
        
        nextTurn = new JButton("Next Turn");
        
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TurnOrder.NextTurn();
                
            }
        };
        nextTurn.addActionListener(actionListener);
        
        nextTurn.setSize(200, 25);
        nextTurn.setLocation(Visual.width - 200, Visual.hight - 175);
        nextTurn.setBackground(Color.gray);
        nextTurn.setVisible(true);
        nextTurn.setFocusable(false);
        Visual.UI.add(nextTurn);
        
        cityTest.setText("Test");
        cityTest.setSize(500,500);
        cityTest.setLocation(0,0);
        cityTest.setVisible(true);
        cityTest.setFocusable(false);
        ActionListener test = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city.setGold(city, 10);
                System.out.println(city.getGold(city));
                
            }
        };
        cityTest.addActionListener(test);
        Visual.CityUI.add(cityTest);
        
//        Icon leftBack = new ImageIcon("src\\Images\\CityLeft.png");
        
        
        //getClass().getResource("/Images/CityTile1.png")
        Icon leftBack = new ImageIcon(getClass().getResource("/Images/CityTile1.png"));
        
        cityTest.setIcon(leftBack);
        
        cityLeft = new JLabel(leftBack);
        cityLeft.setSize(481,906);
        cityLeft.setLocation(0,0);
        cityLeft.setVisible(false);
        cityLeft.setFocusable(true);
        Visual.CityUI.add(cityLeft);
        System.out.println(leftBack.getIconWidth()+" X "+leftBack.getIconHeight());
    }
    
    public static void CityUI(City newCity)
    {        
        cityTest.setVisible(true);
        cityLeft.setVisible(true);
        city = newCity; 
        System.out.println(cityLeft.isVisible());
        
    }
    public static void NormalUI()
    {        
        cityTest.setVisible(false);
        cityLeft.setVisible(false);
    }
}
