/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.plaf.basic.BasicOptionPaneUI;

/**
 *
 * @author Davin
 */
class UserInt {
    
        public JButton nextTurn;
        static public JButton cityTest = new JButton();
        static public City city = new City();
        static public JLabel cityLeft;
        static public JLabel cityGold;
        static public JLabel cityFood;
        static public JLabel cityScience;
        static public JLabel cityProduction;
        static public JLabel cityName;
    
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
        cityTest.setSize(100,50);
        cityTest.setLocation(0,0);
        cityTest.setVisible(false);
        cityTest.setFocusable(false);
        ActionListener test = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                city.gold = 10;
                System.out.println(city.getGold(city));
                updateGold();
                
            }
        };
        cityTest.addActionListener(test);
        Visual.CityUI.add(cityTest);
        
        Icon leftBack = new ImageIcon("src\\Images\\CityLeft.png");
        cityLeft = new JLabel(leftBack);
        cityLeft.setSize(394,734);
        cityLeft.setLocation(0,0);
        cityLeft.setVisible(false);
        cityLeft.setFocusable(false);
        Visual.CityUI.add(cityLeft);
        
        cityFood = new JLabel();
        cityFood.setSize(100,20);
        cityFood.setLocation(350,55);
        cityFood.setFont(new Font(null, Font.PLAIN, 20));
        cityFood.setForeground(Color.green);
        cityFood.setText(city.getFood(city)+"");
        cityFood.setVisible(false);
        cityFood.setFocusable(false);
        Visual.CityUI.add(cityFood, 0);
        
        cityProduction = new JLabel();
        cityProduction.setSize(100,20);
        cityProduction.setLocation(350,90);
        cityProduction.setFont(new Font(null, Font.PLAIN, 20));
        cityProduction.setForeground(Color.orange);
        cityProduction.setText(city.getProduction(city)+"");
        cityProduction.setVisible(false);
        cityProduction.setFocusable(false);
        Visual.CityUI.add(cityProduction, 0);
        
        cityScience = new JLabel();
        cityScience.setSize(100,20);
        cityScience.setLocation(350,120);
        cityScience.setFont(new Font(null, Font.PLAIN, 20));
        cityScience.setForeground(Color.blue);
        cityScience.setText(city.getScience(city)+"");
        cityScience.setVisible(false);
        cityScience.setFocusable(false);
        Visual.CityUI.add(cityScience, 0);
        
        cityGold = new JLabel();
        cityGold.setSize(100,20);
        cityGold.setLocation(350,155);
        cityGold.setFont(new Font(null, Font.PLAIN, 20));
        cityGold.setForeground(Color.yellow);
        cityGold.setText(city.getGold(city)+"");
        cityGold.setVisible(false);
        cityGold.setFocusable(false);
        Visual.CityUI.add(cityGold, 0);
        
        cityName = new JLabel();
        cityName.setSize(384,40);
        cityName.setLocation(0,10);
        cityName.setFont(new Font(null, Font.PLAIN, 40));
        cityName.setForeground(Color.BLACK);
        cityName.setText(city.name);
        cityName.setVisible(false);
        cityName.setFocusable(false);
        cityName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Visual.CityUI.add(cityName, 0);
        
        }
    public static void CityUI(City newCity)
    {        
        cityTest.setVisible(true);
        cityLeft.setVisible(true);
        cityFood.setVisible(true);
        cityGold.setVisible(true);
        cityProduction.setVisible(true);
        cityScience.setVisible(true);
        cityName.setVisible(true);
        city = newCity;
        
        updateFood();
        updateGold();
        updateProduction();
        updateScience();
        cityName.setText(city.name);
        
        
    }
    public static void UnitUI(Unit newUnit)
    {        
        cityTest.setVisible(false);
        cityLeft.setVisible(false);
         cityFood.setVisible(false);
        cityGold.setVisible(false);
        cityProduction.setVisible(false);
        cityScience.setVisible(false);
        cityName.setVisible(false);
    }
    public static void NormalUI()
    {        
        cityTest.setVisible(false);
        cityLeft.setVisible(false);
         cityFood.setVisible(false);
        cityGold.setVisible(false);
        cityProduction.setVisible(false);
        cityScience.setVisible(false);
        cityName.setVisible(false);
    }
    
    public static void updateGold() {cityGold.setText(city.gold+"");}
    public static void updateScience() {cityScience.setText(city.science+"");}
    public static void updateFood() {cityFood.setText(city.food+"");}
    public static void updateProduction() {cityProduction.setText(city.production+"");}

}
