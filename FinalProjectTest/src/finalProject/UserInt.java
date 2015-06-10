/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Davin
 */
class UserInt {
    
        public JButton nextTurn;
        static public JButton cityTest = new JButton();
        static public City city = new City();
        static public Unit unit;
        static public JLabel cityLeft;
        static public JLabel cityGold;
        static public JLabel cityFood;
        static public JLabel cityScience;
        static public JLabel cityProduction;
        static public JLabel cityName; 
        static public JPanel productionBackrounds = new JPanel();
        static public JPanel productionInfo = new JPanel();
        static public JScrollPane jsp = new JScrollPane();
        
        static public JLabel unitBack;
        static public JLabel unitHealth; 
        static public JLabel unitStrength; 
        static public JLabel unitMoves; 
        static public JLabel unitName; 
        static public JButton unitMove;
        static public JButton unitSettle;
        static public JLabel unitIcon;
        
        static public ArrayList<JLabel> productionList = new ArrayList<JLabel>();
    
    UserInt() throws FileNotFoundException{
        
        nextTurn = new JButton("Next Turn");
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TurnOrder.NextTurn();
                
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
        //Visual.CityUI.add(cityTest);
        
        MakeCityUI();
        MakeUnitUI();

        }
    public static void CityUI(City newCity){        
        city = newCity;
        
        updateProductionList();
        visableCityUI(true);
        visableUnitUI(false);
        
        updateFood();
        updateGold();
        updateProduction();
        updateScience();
        cityName.setText(city.name);
        
    }
    public static void UnitUI(Unit newUnit){   
        unit = newUnit;
        
        visableCityUI(false);        
        visableUnitUI(true);
        
        updateHealth();
        updateStength();
        updateMoves();
        updateIcon();
        unitName.setText(unit.name);
    }
    public static void NormalUI(){        
        visableCityUI(false);
        visableUnitUI(false);
        
    }
    
    public static void updateGold() {cityGold.setText(city.gold+"");}
    public static void updateScience() {cityScience.setText(city.science+"");}
    public static void updateFood() {cityFood.setText(city.food+"");}
    public static void updateProduction() {cityProduction.setText(city.production+"");}
    
    public static void updateHealth() {unitHealth.setText(unit.health+"");}
    public static void updateStength(){unitStrength.setText(unit.Damage+"");}
    public static void updateMoves(){unitMoves.setText(unit.movement+"");}
    public static void updateIcon(){unitIcon.setIcon(unit.unitIcon);}

    public void MakeCityUI(){
        
        Icon leftBack = new ImageIcon("src\\Images\\CityLeft.png");
        cityLeft = new JLabel(leftBack);
        cityLeft.setSize(394,734);
        cityLeft.setLocation(-5,0);
        cityLeft.setVisible(false);
        cityLeft.setFocusable(false);
        Visual.CityUI.add(cityLeft,0);
        
        cityFood = new JLabel();
        cityFood.setSize(100,20);
        cityFood.setLocation(350,55);
        cityFood.setFont(new Font(null, Font.PLAIN, 20));
        cityFood.setForeground(Color.green);
        cityFood.setVisible(false);
        cityFood.setFocusable(false);
        Visual.CityUI.add(cityFood, 0);
        
        cityProduction = new JLabel();
        cityProduction.setSize(100,20);
        cityProduction.setLocation(350,90);
        cityProduction.setFont(new Font(null, Font.PLAIN, 20));
        cityProduction.setForeground(Color.orange);
        cityProduction.setVisible(false);
        cityProduction.setFocusable(false);
        Visual.CityUI.add(cityProduction, 0);
        
        cityScience = new JLabel();
        cityScience.setSize(100,20);
        cityScience.setLocation(350,120);
        cityScience.setFont(new Font(null, Font.PLAIN, 20));
        cityScience.setForeground(Color.blue);
        cityScience.setVisible(false);
        cityScience.setFocusable(false);
        Visual.CityUI.add(cityScience, 0);
        
        cityGold = new JLabel();
        cityGold.setSize(100,20);
        cityGold.setLocation(350,155);
        cityGold.setFont(new Font(null, Font.PLAIN, 20));
        cityGold.setForeground(Color.yellow);
        cityGold.setVisible(false);
        cityGold.setFocusable(false);
        Visual.CityUI.add(cityGold, 0);
        
        cityName = new JLabel();
        cityName.setSize(384,40);
        cityName.setLocation(0,10);
        cityName.setFont(new Font(null, Font.PLAIN, 40));
        cityName.setForeground(Color.BLACK);
        cityName.setVisible(false);
        cityName.setFocusable(false);
        cityName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Visual.CityUI.add(cityName, 0);
        MakeProductionUI();
    }
    public void MakeUnitUI(){
        Icon unitBackround = new ImageIcon("src\\Images\\UnitBackround.png");
        unitBack = new JLabel(unitBackround);
        unitBack.setSize(600,220);
        unitBack.setLocation(0, 490);
        unitBack.setVisible(false);
        unitBack.setFocusable(false);
        Visual.UnitUI.add(unitBack);
        
        unitIcon = new JLabel();
        unitIcon.setSize(200,200);
        unitIcon.setLocation(20, 500);
        unitIcon.setVisible(false);
        unitIcon.setFocusable(false);
        Visual.UnitUI.add(unitIcon,0);
        
        unitHealth = new JLabel();
        unitHealth.setSize(100, 20);
        unitHealth.setLocation(450, 540);
        unitHealth.setVisible(false);
        unitHealth.setFocusable(false);
        unitHealth.setFont(new Font(null, Font.PLAIN, 20));
        Visual.UnitUI.add(unitHealth,0);
        
        unitStrength = new JLabel();
        unitStrength.setSize(100, 20);
        unitStrength.setLocation(450, 575);
        unitStrength.setVisible(false);
        unitStrength.setFocusable(false);
        unitStrength.setFont(new Font(null, Font.PLAIN, 20));
        Visual.UnitUI.add(unitStrength,0);
        
        unitMoves = new JLabel();
        unitMoves.setSize(100, 20);
        unitMoves.setLocation(450, 610);
        unitMoves.setVisible(false);
        unitMoves.setFocusable(false);
        unitMoves.setFont(new Font(null, Font.PLAIN, 20));
        Visual.UnitUI.add(unitMoves,0);
        
        unitName = new JLabel();
        unitName.setSize(390, 30);
        unitName.setLocation(210, 500);
        unitName.setVisible(false);
        unitName.setFocusable(false);
        unitName.setFont(new Font(null, Font.PLAIN, 30));
        unitName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Visual.UnitUI.add(unitName,0);
        
        Icon imgMove = new ImageIcon("src\\Images\\unitMove.png");
        unitMove = new JButton(imgMove);
        ActionListener move = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Icon imgMove = new ImageIcon("src\\Images\\unitMove.png");
                Icon imgMoveSelected = new ImageIcon("src\\Images\\unitMoveSelected.png");
                if (!Visual.movingUnit){Visual.movingUnit = true; unitMove.setIcon(imgMoveSelected);}
                else {Visual.movingUnit = false; unitMove.setIcon(imgMove);}
                
            }
        };
        unitMove.addActionListener(move);
        unitMove.setSize(50, 50);
        unitMove.setLocation(0, 440);
        unitMove.setVisible(false);
        unitMove.setFocusable(false);
        Visual.UnitUI.add(unitMove);
           
        Icon imgSettle = new ImageIcon("src\\Images\\unitSettle.png");
        unitSettle = new JButton(imgSettle);
        ActionListener settle = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int index = Visual.FindCity(unit.x, unit.y);
                if (index == -1)
                {
                    FinalProject.cities.add(new City(unit.x, unit.y, TurnOrder.whoTurn()));
                    int UnitIndex = UnitType.FindUnit(unit.x, unit.y);
                    UnitType.Death(UnitIndex);
                } 
                
            }
        };
        unitSettle.addActionListener(settle);
        unitSettle.setSize(50, 50);
        unitSettle.setLocation(0, 380);
        unitSettle.setVisible(false);
        unitSettle.setFocusable(false);
        Visual.UnitUI.add(unitSettle);
    }
    public void MakeProductionUI() {
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp.setSize(new Dimension(384, 500));
        jsp.setLocation(0, 200);
        jsp.setViewportView(productionBackrounds);
        Visual.CityUI.add(jsp,0);
        jsp.setVisible(false);
        productionBackrounds.setBackground(Color.BLACK);
        productionBackrounds.setLayout(new BoxLayout(productionBackrounds, BoxLayout.Y_AXIS));
        
        productionInfo.setSize(384, 500);
        productionInfo.setLocation(0, 200);
    }
    
    public static void visableCityUI(boolean visable){
        cityTest.setVisible(visable);
        cityLeft.setVisible(visable);
        cityFood.setVisible(visable);
        cityGold.setVisible(visable);
        cityProduction.setVisible(visable);
        cityScience.setVisible(visable);
        cityName.setVisible(visable);
        jsp.setVisible(visable);
        for (int i = 0; i < productionList.size(); i++) {
            productionList.get(i).setVisible(false);
        }
        for (int i = 0; i < city.cityBuildObjects.size(); i++) {
            productionList.get(i).setVisible(visable);
        }
    }
    public static void visableUnitUI(boolean visable){
        unitBack.setVisible(visable);
        unitHealth.setVisible(visable);
        unitStrength.setVisible(visable);
        unitMoves.setVisible(visable);
        unitMove.setVisible(visable);
        unitName.setVisible(visable);
        unitIcon.setVisible(visable);
    }
    
    public static void updateProductionList(){
        for (int i = 0; i < city.cityBuildObjects.size(); i++) {
            Icon backroundImage = new ImageIcon("src\\Images\\ProductionBack.png");
            JLabel backround = new JLabel(backroundImage);
            backround.setPreferredSize(new Dimension(365, 150));
            backround.setVisible(false);
            productionBackrounds.add(backround, 0);
            productionList.add(backround);
            
            Prodution thing = new Prodution(city.cityBuildObjects.get(i));
            JLabel title = new JLabel(thing.name);
            title.setSize(100, 30);
            title.setLocation(220, 10);
            title.setFont(new Font(null, Font.PLAIN, 30));
            productionInfo.add(title, 0);
        }
    }
}
