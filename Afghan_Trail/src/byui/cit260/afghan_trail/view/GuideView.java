/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.controller.Game;
import byui.cit260.afghan_trail.controller.GuideController;
import byui.cit260.afghan_trail.model.Player;
/**
 *
 * @author jonsi
 */
public class GuideView {
    
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
    
    public void display(){
        System.out.println(message + '\n'); 
        char userInput = BasicView.getUserChar(options);
        GuideController.guideController(userInput);   
    }
}
