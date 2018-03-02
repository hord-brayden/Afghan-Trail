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
public class StartProgramView extends BasicView{

   
    /*
        Properties
    */
    public static String exitMsg = "Thank you for playing\n";
    public static String welcomeMsg = "Main Menu\n";
    
    /*
        Constructors
    */
    public StartProgramView(){
    }
    
    public static char displayStartProgramView(){
        String[] options = {
            "Start Game", 
            "Load Game", 
            "Exit", 
            "Guide"
        };
        String optionString = buildOptionsString(options);
        System.out.println(welcomeMsg);
        char userInput = BasicMenu.getUserChar(optionString);
        return userInput;
    }
    
    public static void mainLoop(){
        // main game loop. exits on 's' input
        char mainMenuInput;
        do{
            
            //ensures wasORd
            mainMenuInput = displayStartProgramView();
            switch(mainMenuInput)
            {
                //Start Game
                case 'w':
                   Game newGame = Game.startNewGame();
                   Game.startGame(newGame);
                break;
                
                //Load Game
                case 'a':
                   Game oldGame = Game.loadGame();
                   Game.startGame(oldGame);
                break;
                
                //Guide
                case 'd':
                   GuideView guideView = new GuideView();             
                   guideView.display();
                break;  
            }
        } while (mainMenuInput != 's');
        
        System.out.println(exitMsg);
    }
    
    public static void showGuide(){
        /*
    		W - Continue
		A - Map
		S - Player Stats    
        */
        System.out.print("   GAME MENU GUIDE\n\n" + 
                "\tPressing W\n\n" +
                "Continue will move your character\n" +
                "to thier next adventure event\n\n" + 
                "\tPressing A\n\n" + 
                "Map will show the map of the\n" +
                "afghan trail and your character's position\n\n" +
                "\tPressing S\n\n" +
                "Player Stats will show your\n" +
                "character's stats and inventory\n");
    }
}


