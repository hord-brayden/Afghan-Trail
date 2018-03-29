/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

import byui.cit260.afghan_trail.controller.GuideController;
import byui.cit260.afghan_trail.controller.SaveGameController;
import byui.cit260.afghan_trail.model.Game;

/**
 *
 * @author jonsi
 */
public class SaveGameView extends BasicView {

    public SaveGameView() {
        super();
        
        //functionality here to build a 
        //options menu depending on the number of slots and
        //their names
        char keys[] = {'1', '2', 'N', 'H', 'E'};
        String[] options = {
           "Slot 1?",
           "Slot 2?",
           "New Slot",
           "Save Help",
           "Return to Main Menu"
        };
        String message = "Save Game Menu";       
        setOptions(options);
        setMessage(message);
    }
    
    public SaveGameView(String options[], String message){
        super(options, message);
    }
    
    public SaveGameView(char keys[]){
        this();
        if (keys.length < options.length)
            System.err.print("view must have the same amount or more keys than options");
        else
            setKeys(keys);
    }
    
    @Override
    public void displayHelp(){
        this.console.print("Game help\n");
    }
    
    @Override
    public void display(Game game) {
        /*
            write loop that exits only when exit
            
        
        */
        
        this.console.println(message + '\n'); 
        char userInput = getUserChar(options);
        doAction(options, userInput, game);   
    }
    
    public void doAction(String[] options, 
                         char action, 
                         Game game)
    {
        String filename;
        switch (action){
            
            //Slot 1 - Slot ?
            case 'w':
                //get correct filename
                //String filename = null;
                SaveGameController.saveInSlot(filename);
                this.console.print("You chose '" + options[0] + "'\n");
                break;
             
            //New Slot
            case 'a':
                //String filename = null;
                SaveGameController.saveInNewSlot(filename);
                this.console.print("You chose '" + options[1] + "'\n");
                break;
             
            //Help    
            case 's':
                displayHelp();
                this.console.print("You chose '" + options[2] + "'\n");
                break;
                
            //return to main menu should be handled in the display method's
            //loop like we have done for other views
        }
    }   
}
