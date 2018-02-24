/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.model.Inventory;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.controller.DiseaseContraction;
//import bui.cit260.afghan_trail.controller.DiseaseContraction.isSuccessful;

/**
 *
 * @author Brayden
 */
public class DiseaseContractionView extends DiseaseContraction {
    
    public static void displayHelp(){
        //display event help for each event option
        System.out.print("Disease Contracation Help\n");
    }    
    
    public static char display(){
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

    public DiseaseContractionView(Player player, boolean isSuccessful /** item*/) {
        //Print out to user what the current situation is, and whatever
        //they input, print out what the result, or process is
        if (isSuccessful == true) {    
            //Sickness Cured, you recieve a bonus stamina boost for curing your illness
                    System.out.print("You are feeling better!\n");
                    System.out.print("What would you like to do next?\n");
                    System.out.print("You have! /**item.medicine*/ left.\n");
            //Have alternate options for the player as to what they can do next
                    
        } else{
                    System.out.print("You are feeling very ill. THis will affect you in many ways.\n");
                    System.out.print("What would you like to do next?\n");
            //Have alternate options for the player as to what they can do next
        }
    
    //TODO
    //ignore()
    //useMedicine()
    //rest()
    
    }
}
