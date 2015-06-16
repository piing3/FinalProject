/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileNotFoundException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame; 
import javax.swing.JOptionPane;

/**
 *
 * @author d.holmberg
 */
abstract class Visual extends JFrame implements KeyListener, MouseMotionListener, MouseListener  {
    static Container tiles;
    static Container Units;
    static Container UI;
    static Container CityUI;
    static Container ProdutionUI;
    static Container UnitUI;
    static int width; 
    static int hight;
    static boolean moveEnabled = true;
    static boolean diselectEnabled = true;
    static boolean movingUnit = false;
    static boolean attackingUnit = false;
    static boolean UnitUIOpen = false;
    static boolean CityUIOpen = false;
    
    static Boolean menuOpen = false;
    static Menu menu = new Menu();
    
    static int downOff = 0, rightOff = 0;//Down and Right offsets, used for moving map.
    
    int mouseX1;
    int mouseX2;
    int mouseY1;
    int mouseY2;
    
    public Visual() throws FileNotFoundException {
        this.setSize(1256, 728);    

        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        width = this.getWidth();
        hight = this.getHeight();
        
        tiles = this.getContentPane();
        Units = this.getContentPane();
        UI = this.getContentPane();
        UnitUI = this.getContentPane();
        CityUI = this.getContentPane();
        ProdutionUI = this.getContentPane();  
        
        Visual.tiles.setLayout(null);
        
        this.addKeyListener(this);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        
        UserInt userInt = new UserInt();
        Map map = new Map();
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 27){
            if (menuOpen == false){
                menu.setVisible(true);
                menuOpen = true;
            }
            else if (menuOpen == true){
                menu.setVisible(false);
                menuOpen = false;
            }    
        }
        
        if (e.getKeyCode() == 81){
            int cityX = (getMousePosition().x-25)/50+rightOff;
            int cityY = (getMousePosition().y-25)/50+downOff;
            int index = FindCity(cityX, cityY);
            if (index == -1)
            {
                FinalProject.cities.add(new City(cityX, cityY, TurnOrder.whoTurn()-1));
            } 
            
        }
        
        if (e.getKeyCode() == 87){
            int unitX = (getMousePosition().x-25)/50+rightOff;
            int unitY = (getMousePosition().y-25)/50+downOff;
            int index = UnitType.FindUnit(unitX, unitY);
            if (index == -1)
            {
                int type = Integer.parseInt(JOptionPane.showInputDialog("Enter Unit Type"));
                UnitType.CreateUnit(unitX, unitY, type, Units);
            } 
            
        }
        if(moveEnabled){
            
            if (e.getKeyCode() == 38){//up
                if (downOff != 0){
                    downOff--;
                }
                redrawMap();
                LoadUnits();
            }
            if (e.getKeyCode() == 37){//left
                if (rightOff != 0){
                    rightOff--;
                }
                redrawMap();
                LoadUnits();
            }
            if (e.getKeyCode() == 40){//down

                if (downOff != (72-Map.y)){
                    downOff++;    
                }
                redrawMap();
                LoadUnits();
            }
            if (e.getKeyCode() == 39){//right

                if (rightOff != (128-Map.x)){
                    rightOff++;    
                }
                redrawMap();
                LoadUnits();
            }
        }
    }
    
    public static void redrawMap(){
        for (int i = 0; i < Map.x; i++){
                for (int j = 0; j < Map.y; j++){
                    Map.grid[i][j].setTile(Map.tileType[i + rightOff][j + downOff]);
                    Map.borderGrid[i][j].setBorder(Map.borderType[i + rightOff][j + downOff]);

                }
            }
    }
    public static void LoadUnits(){
        for (int i = 0; i <= 127; i++){
            for (int j = 0; j <= 71; j++){
                if (UnitType.FindUnit(i,j) > -1){
                    int index = UnitType.FindUnit(i,j);
                    Unit unit = FinalProject.units.get(index);
                    if (unit.x == i&& unit.y == j){
                        unit.setLocation((i- rightOff)*50, (j- downOff)*50);
                        unit.setUnit(Globals.unitGrid[i/* + Map.downOff*/][j/* + Map.rightOff*/]);
                    }
                }
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
            
        int tileX = (getMousePosition().x-25)/50+rightOff;
        int tileY = (getMousePosition().y-25)/50+downOff;
        int cityIndex = FindCity(tileX, tileY);
        int unitIndex = -1; 
        if (movingUnit == false && attackingUnit == false && 
                Tile.getTileType(Map.grid[tileX][tileY]) != 2 && Tile.getTileType(Map.grid[tileX][tileY]) != 3){
            
            unitIndex = UnitType.FindUnit(tileX, tileY);
            if (unitIndex != -1 && cityIndex != -1) {
                if (CityUIOpen) {
                    UserInt.UnitUI(FinalProject.units.get(unitIndex));
                    moveEnabled = true;
                    CityUIOpen = false;
                    UnitUIOpen = true;
                }
                else if (UnitUIOpen) {
                    UserInt.CityUI(FinalProject.cities.get(cityIndex));
                    moveEnabled = false;
                    CityUIOpen = true;
                    UnitUIOpen = false;
                }
                else if (!UnitUIOpen && !CityUIOpen){
                    UserInt.UnitUI(FinalProject.units.get(unitIndex));
                    moveEnabled = true;
                    CityUIOpen = false;
                    UnitUIOpen = true;
                }
            }
            else if (cityIndex != -1) {
                UserInt.CityUI(FinalProject.cities.get(cityIndex));
                moveEnabled = false;
                CityUIOpen = true;
                UnitUIOpen = false;
            }
            else if (unitIndex != -1) {
                UserInt.UnitUI(FinalProject.units.get(unitIndex));
                moveEnabled = true;
                CityUIOpen = false;
                UnitUIOpen = true;
            }
            if (cityIndex == -1 && unitIndex == -1) {
                UserInt.NormalUI(); 
                moveEnabled = true;
                CityUIOpen = false;
                UnitUIOpen = false;
            }
        }
        if (movingUnit && attackingUnit == false){
            int unitX = UserInt.unit.x;//FinalProject.units.get(unitIndex).x;
            int unitY = UserInt.unit.y;//FinalProject.units.get(unitIndex).y;
            if (Globals.unitGrid[unitX][unitY] != 4){
                UnitType.MoveGround(UnitType.FindUnit(UserInt.unit.x, UserInt.unit.y), tileX, tileY);
                UserInt.updateMoves();
            }
            if (Globals.unitGrid[unitX][unitY] == 4){
                UnitType.MoveWater(UnitType.FindUnit(UserInt.unit.x, UserInt.unit.y), tileX, tileY);
                UserInt.updateMoves();
            }
        }
        if (movingUnit == false && attackingUnit) {
            int index1 = UnitType.FindUnit(UserInt.unit.x, UserInt.unit.y);
            int index2 = UnitType.FindUnit(tileX, tileY);
            UnitType.Attack(index1, index2);
        }
    }
    
     @Override
    public void mouseReleased(MouseEvent e) {
    }

    public static int FindCity(int x, int y){
        //System.out.println("" + FinalProject.units.size());
        int result = -1;
        if (FinalProject.cities.size() <= 0){
            //System.out.println("oo");
        }
        for (int i = 0; i < FinalProject.cities.size(); i++) {
            City city = FinalProject.cities.get(i);
            if (city.x == x && city.y == y){
                result = i;
            }
        }
        return result;
    } 
   
    
}


