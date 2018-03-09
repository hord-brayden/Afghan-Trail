/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.controller.Game;
import byui.cit260.afghan_trail.model.Inventory;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.controller.Hunt;
/**
 *
 * @author Brayden
 */
public class HuntView extends BasicView {
    
    public HuntView() {
        super();
        
        String[] options = {
           "Hunt",
           "Ignore",
           "Rest",
           "Event Help",
           
        };
        String message = "Looks like a good place to hunt";       
        setOptions(options);
        setMessage(message);
    }
    
    public HuntView(String options[], String message){
        super(options, message);
    }
    
    @Override
    public void displayHelp(){
        //display event help for each event option
        System.out.print("Hunt Help\n");
        System.out.print("HUNT lets you kill some animals, and anger some vegans \n" ); 
        System.out.print("IGNORE means animals being present don't phase you, and you got "
                + "better things to do. The game wil progress to its "
                + "next stage as well.\n");
        System.out.print("REST menas you kick back, let the animals do their thing, "
                + "and gain back some stamina\n");
    }
    
    public void doAction(String[] options, 
                         char action, 
                         Game game,
                         Player player)
    {
        switch (action){
            
            //Hunt
            case 'w':
                
                System.out.print("You chose '" + options[0] + "'\n");
                Hunt.hunt(player);
                break;
             
            //Ignore    
            case 'a':
                
                System.out.print("You chose '" + options[1] + "'\n");
                //Hunt.ignore(player);
                break;
             
            //Rest    
            case 's':
                
                System.out.print("You chose '" + options[2] + "'\n");
                //Hunt.rest(player);
                break;
        }
    }
}