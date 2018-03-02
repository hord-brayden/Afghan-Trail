/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.controller.Game;
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
}
