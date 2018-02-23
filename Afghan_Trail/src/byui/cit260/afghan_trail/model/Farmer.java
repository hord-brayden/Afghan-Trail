/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;

/**
 *
 * @author Brayden
 */
public class Farmer extends Player {

    private int stats[] = {5,7,5,5};
    
    public Farmer() {
        super("OldMcdonald", 12, "Farmer'"); 
        generateInventory(stats);
    }    
    

    public Farmer(String name) {
        super(name, 12, "Farmer");
        generateInventory(stats);
    }
    
    
}
