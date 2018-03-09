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
import byui.cit260.afghan_trail.controller.Game;
/**
 *
 * @author Brayden
 */
public class BeingAttackedView extends BasicView {
   
   
    
    public BeingAttackedView(){
        super();
        
        String[] options = {
            "Fight Back",
            "Ignore",
            "Rest",
            "Event Help"
        };
        String message = "You're being attacked";    
        setOptions(options);
        setMessage(message);
    }
    public BeingAttackedView(String[] options, String message){
        this.options = options;
        this.message = message;
    }
    
    public void displayHelp(){  
        //display event help for each event option
System.out.print("Being Attacked Help\n");
System.out.print("FIGHT BACK lets you throw down against the assailants\n" ); 
System.out.print("IGNORE means you make a run for it and proceed to the next" 
        + "event, and  lose street cred\n");
System.out.print("REST You can't rest now! It's about to go down!\n");
    }
    
    public void doAction(String[] options, char action,
                         Game game, Player player){
        switch (action){
            
            //Fight Back
            case 'w':
                
                System.out.print("You chose '" + options[0] + "'\n");
                BeingAttacked.fightBack(player);
                break;
             
            //Ignore    
            case 'a':
                
                 System.out.print("You chose '" + options[1] + "'\n");
                 BeingAttacked.ignore(player);
                break;
             
            //Rest    
            case 's':
                
                 System.out.print("You chose '" + options[2] + "'\n");
                 BeingAttacked.rest(player);
                break;
        }
    }
}