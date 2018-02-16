/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;
import  byui.cit260.afghan_trail.model.Inventory;
import  byui.cit260.afghan_trail.model.Item;
import java.math.BigDecimal;


/**
 *
 * @author jonsi
 */
public class Blacksmith extends Player{
    public Blacksmith() {
        super("Souron", 12, "Blacksmith");
        generateInventory();
    }
    
    public Blacksmith(String name) {
        super(name, 12, "Blacksmith");
    }
    
    private void generateInventory(){
        //generate blacksmith inventory
        BigDecimal price = new BigDecimal(2.00);
        Item wagonParts = new Item ("Wheel", "Wagon Parts", price);
        playerInventory.addNewItem(wagonParts);
        
        //TODO random or hardcoded?
        
        
    }
}
