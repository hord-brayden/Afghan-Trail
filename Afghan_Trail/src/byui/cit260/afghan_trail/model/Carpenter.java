/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.model;

/**
 *
 * @author rizky
 */
public class Carpenter extends Player{

   private int stats[] = {5,5,10,5};  
    
   public Carpenter() {
        super("Pinocchio", 15, "Carpenter");
        generateInventory(stats);
      
    }
    
    public Carpenter(String name) {
        super(name,15,"Capenter");
        generateInventory(stats);
    }
}
