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
import byui.cit260.afghan_trail.controller.Game;
/**
 *
 * @author Brayden
 */
public class BrokenWagonView extends BasicView{
    
    public BrokenWagonView(){
        super();
        String message = "Your wagon is broken";
        String[] options = {
            "Fix",
            "Ignore",
            "Rest"
        };
        
    }
    public BrokenWagonView(String[] options, String message){
        super(options, message);
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

    
    //TODO
    //ignore()
    //useMedicine()
    //rest()
}