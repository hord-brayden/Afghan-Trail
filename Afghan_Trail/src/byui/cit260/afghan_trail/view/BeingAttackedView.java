/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.model.Inventory;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.controller.BeingAttacked;
/**
 *
 * @author Brayden
 */
public class BeingAttackedView extends BeingAttacked {
   
    public BeingAttackedView() {
    }
    
    public static char display() {
        String[] options = {
            "Fight back",
            "Ignore",
            "Rest"
        }; 
        BasicMenu brokenWagonMenu = new BasicMenu(
                "You're being attacked", 
                options
        );
        String optionString = brokenWagonMenu.getOptionsString();
        System.out.println(brokenWagonMenu.getMessage() + '\n');
        char userInput = BasicMenu.getUserChar(optionString);
        return userInput;
    }

    
    //TODO
    //ignore()
    //useMedicine()
    //rest()
}