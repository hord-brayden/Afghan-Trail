/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.model.Inventory;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.controller.BrokenWagon;
/**
 *
 * @author Brayden
 */
public class BrokenWagonView {

    public BrokenWagonView() {
        
    }
    
    public static void displayHelp(){
        //display event help for each event option
        System.out.print("Broken Wagon Help\n");
        System.out.print("FIX WAGON exhaust your wagon supplies, and some "
                + "stamina in order to try and fix up your wagon!\n" ); 
System.out.print("IGNORE means you really don't care that your wagon is broken,"
        + "because you're a strong independant woman, who don't need no wagon."
        + "It also progresses to the next stage of the game.\n");
System.out.print("REST This means a broken wagon can wait - you need a nap!\n");
    }
   
    public static char display() {
        String[] options = {
            "Fix Wagon",
            "Ignore",
            "Rest",
            "Event Help"
        }; 
        BasicMenu brokenWagonMenu = new BasicMenu(
                "You're wagon is broken", 
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