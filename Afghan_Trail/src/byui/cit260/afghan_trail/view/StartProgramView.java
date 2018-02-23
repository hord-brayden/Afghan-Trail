/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

import static afghan_trail.Afghan_Trail.loadGame;
import static afghan_trail.Afghan_Trail.showGuide;
import static afghan_trail.Afghan_Trail.startGame;
import static afghan_trail.Afghan_Trail.startNewGame;
import byui.cit260.afghan_trail.controller.Game;

/**
 *
 * @author jonsi
 */
public class StartProgramView {

    
    public static String winMsg = "You Won!";
    public static String loseMsg = "You Are Dead!";
    public static String exitMsg = "Thank you for playing\n";
    
    public StartProgramView(){
    }
    
    public static char displayStartProgramView(){
        String[] options = {
            "Start Game", 
            "Load Game", 
            "Exit", 
            "Guide"
        };
        BasicMenu menu = new BasicMenu(
                "You're being attacked", 
                options
        );
        String optionString = menu.getOptionsString();
        System.out.println(menu.getMessage() + '\n');
        char userInput = BasicMenu.getUserChar(optionString);
        return userInput;
    }
    
    public static void mainLoop(){
        // main game loop. exits on 's' input
        char mainMenuInput;
        do{
            
            //ensures wasORd
            mainMenuInput = StartProgramView.displayStartProgramView();
            switch(mainMenuInput)
            {
                //Start Game
                case 'w':
                   Game newGame = startNewGame();
                   startGame(newGame);
                break;
                
                //Load Game
                case 'a':
                   Game oldGame = loadGame();
                   startGame(oldGame);
                break;
                
                //Guide
                case 's':
                   showGuide();
                break;  
            }
            mainMenuInput = StartProgramView.displayStartProgramView();
        } while (mainMenuInput != 'd');
        
        System.out.println(exitMsg);
    }
}
