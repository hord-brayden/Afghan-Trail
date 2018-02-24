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
    
    public static void displayHelp(){  
        //display event help for each event option
System.out.print("Being Attacked Help\n");
System.out.print("FIGHT BACK lets you throw down against the assailants\n" ); 
System.out.print("IGNORE means you make a run for it and proceed to the next" 
        + "event, and  lose street cred\n");
System.out.print("REST You can't rest now! It's about to go down!\n");
    }
    
    public static char display() {
        String[] options = {
            "Fight back",
            "Ignore",
            "Rest",
            "Event Help"
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