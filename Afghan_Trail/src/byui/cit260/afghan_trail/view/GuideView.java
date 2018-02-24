/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

/**
 *
 * @author jonsi
 */
public class GuideView {
    public static char display() {
        String[] options = {
            "Goal of the Game",
            "Start Game Help",
            "Load Game Help",
            "Exit Game Help"
        }; 
        BasicMenu brokenWagonMenu = new BasicMenu(
                "Afghan Trail Game Guide", 
                options
        );
        String optionString = brokenWagonMenu.getOptionsString();
        System.out.println(brokenWagonMenu.getMessage() + '\n');
        char userInput = BasicMenu.getUserChar(optionString);
        return userInput;
    }
    
}
