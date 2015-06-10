/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

/**
 *
 * @author b.allen
 */
class Buildings {
    public int productionBonus;
    public int foodBonus;
    public int GoldChange;
    public int CityIndex;
    public int Type;
    Buildings(int CityIndex, int type){
        if (type == 25){
            this.GoldChange = 0;
            this.foodBonus = 0;
            this.CityIndex = 0;
            this.Type = type;
        }
        if (type == 24) {
            this.GoldChange = 0;
            this.foodBonus = 0;
            this.CityIndex = 0;
            this.Type = type;
        }
        if (type == 23) {
            this.GoldChange = 0;
            this.foodBonus = 0;
            this.CityIndex = 0;
            this.Type = type;
        }
    }
            
}
