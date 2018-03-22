/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.controller.GameController;
import byui.cit260.afghan_trail.controller.GuideController;
import byui.cit260.afghan_trail.model.Game;
import byui.cit260.afghan_trail.model.Player;
/**
 *
 * @author jonsi
 */
public class GuideView extends BasicView {
    
    String[] options = {
            "Goal of the Game",
            "Start Game Help",
            "Load Game Help",
            "Exit Game Help"
        };
    String message = "Afghan Trail Game Guide";
    
    GuideView(){}
    GuideView(String[] options, String message){
        this.options = options;
        this.message = message;
    }
    
    @Override
    public void displayHelp(){

    }
    
    @Override
    public void display(Game game) {
        System.out.println(message + '\n'); 
        char userInput = getUserChar(options);
        GuideController.guideController(userInput);   
    }
    
    public void doAction(String[] options, 
                         char action, 
                         Game game)
    {
        switch (action){
            
            //Hunt
            case 'w':
                
                System.out.print("You chose '" + options[0] + "'\n");
                break;
             
            //Ignore    
            case 'a':
                
                System.out.print("You chose '" + options[1] + "'\n");
                break;
             
            //Rest    
            case 's':
                
                System.out.print("You chose '" + options[2] + "'\n");
                break;
        }
    }
}
