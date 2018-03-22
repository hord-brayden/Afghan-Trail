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
import byui.cit260.afghan_trail.controller.GameController;
import byui.cit260.afghan_trail.model.Game;
//import bui.cit260.afghan_trail.controller.DiseaseContraction.isSuccessful;
/**
 *
 * @author Brayden
 */
public class DiseaseContractionView extends BasicView {
    
   
    
    public DiseaseContractionView(){
        super();
        
        String[] options = {
            "Take Medicine",
            "Ignore",
            "Rest",
            "Event Help"
        };
        String message = "You've fallen ill";      
        setOptions(options);
        setMessage(message);
    }
    
    public DiseaseContractionView(String[] options, String message){
        super(options, message);
    }
    
    public DiseaseContractionView(char keys[]){
        this();
        if (keys.length < options.length)
            System.err.print("view must have the same amount or more keys than options");
        else
            setKeys(keys);
    }
    
    public void displayHelp(){
//display event help for each event option
System.out.print("Disease Contracation Help \n");
System.out.print("TAKE MEDICINE lets you exhause some of your medicine"
        + "supply, but has the chance to heal your herp-aids \n" ); 
System.out.print("IGNORE means you let the disease/sickness ravage your body, "
        + "also you will progress to the next stage of the game, while your "
        + "brain rots aay from syphilis \n");
System.out.print("REST menas you kick back and gain some stamina \n");
    }    
    
    public void doAction(String[] options, char action,
                         Game game){
        int actionInt = getFunctionNumberFromChar(action);
        switch (actionInt){
            
            //Take Medicine
            case 0:
  
                System.out.print("You chose '" + options[0] + "'\n");
                DiseaseContraction.takeMedicine(game.getPlayer());
                break;
             
            //Ignore    
            case 1:
                
                System.out.print("You chose '" + options[1] + "'\n");
                DiseaseContraction.ignore(game.getPlayer());
                break;
             
            //Rest    
            case 2:
                
                System.out.print("You chose '" + options[2] + "'\n");
                DiseaseContraction.rest(game.getPlayer());
                break;
        }
    }
}
