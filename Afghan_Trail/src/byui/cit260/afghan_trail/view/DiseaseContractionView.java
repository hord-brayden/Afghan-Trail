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
import byui.cit260.afghan_trail.controller.Game;
//import bui.cit260.afghan_trail.controller.DiseaseContraction.isSuccessful;

/**
 *
 * @author Brayden
 */
public class DiseaseContractionView extends BasicView {
    
   
    
    DiseaseContractionView(){
        super();
        
        String[] options = {
            "Take Medicine",
            "Ignore",
            "Rest"
        };
        String message = "You're being attacked";      
        setOptions(options);
        setMessage(message);
    }
    DiseaseContractionView(String[] options, String message){
        super(options, message);
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
                         Game game, Player player){
        switch (action){
            case 'w':
                System.out.print(options[0]);
                //controller method for 
                
                break;
            case 'a':
                System.out.print(options[1]);
                break;
            case 's':
                System.out.print(options[2]);
                break;
            case 'd':
                System.out.print(options[3]);
                break;
        }
    }
    

    public DiseaseContractionView(Player player, boolean isSuccessful, Item item) {
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
