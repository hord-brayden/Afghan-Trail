/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.model.Inventory;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.controller.EnterTown;
/**
 *
 * @author Brayden
 */
public class EnterTownView {
   
public EnterTownView() {
    }

    public static char display(int progress) {
        String townName = "a town";
        switch (progress){
            case 0:
                townName = "Kandahar";
                break;
            case 5:
                townName = "Kabul";
                break;
            case 10:
                townName = "Mazar-i-Sharif";
                break;
            case 15: 
                townName = "Maymana";
                break;
            case 20:
                townName = "Herat";
                break;
            default:
                townName = "a town";
        }
        System.out.print("Player has entered " + townName + "\n");
        
        String[] options = {
            "Continue",
            "Map",
            "Talk to shopkeeper",
            "Rest and Save game"
        }; 
        BasicMenu enterTownMenu = new BasicMenu(
                "You have entered a town", options
                
        );
        String optionString = enterTownMenu.getOptionsString();
        System.out.println(enterTownMenu.getMessage() + '\n');
        char userInput = BasicMenu.getUserChar(optionString);
        return userInput;
    }

    
    //TODO
    //ignore()
    //useMedicine()
    //rest()
}