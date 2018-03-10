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
            "Fight back",
            "Run away",
            "Beg for mercy",
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
    public BeingAttackedView(char keys[]){
        this();
        if (keys.length < options.length)
            System.err.print("view must have the same amount or more keys than options");
        else
            setKeys(keys);
    }
    
    public void displayHelp(){  
        //display event help for each event option
System.out.print("Being Attacked Help\n");
System.out.print("FIGHT BACK lets you throw down against the assailants\n" ); 
System.out.print("RUN AWAY means you make a run for it and proceed to the next" 
        + "event, and  lose street cred\n");
System.out.print("BEG FOR MERCY means you try and beg and hope they let you go\n");
    }
    
    public void doAction(String[] options, char action,
                         Game game, Player player){
        int actionInt = getFunctionNumberFromChar(action);
        switch (actionInt){
            
            //Fight Back
            case 0:
                
                System.out.print("You chose '" + options[0] + "'\n");
                BeingAttacked.fightBack(player);
                break;
             
            //Ignore    
            case 1:
                
                 System.out.print("You chose '" + options[1] + "'\n");
                 BeingAttacked.runAway(player);
                break;
             
            //Rest    
            case 2:
                
                 System.out.print("You chose '" + options[2] + "'\n");
                 BeingAttacked.beg(player);
                break;
        }
    }
}