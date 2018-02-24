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
public class StartProgramView {

   
    /*
        Properties
    */
    public static String exitMsg = "Thank you for playing\n";
    public static String welcomeMsg = "Welcome to Afghan Trail!!\n";
    
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
        BasicMenu menu = new BasicMenu(
                welcomeMsg, 
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
                   showGuide();
                break;  
            }
            mainMenuInput = StartProgramView.displayStartProgramView();
        } while (mainMenuInput != 's');
        
        System.out.println(exitMsg);
    }
    
    public static void showGuide(){
        
        System.out.print("You are a refugee fleeing from the Al Qaeda "
                + "extremists in Southern Afghanistan! In this journey you'll "
                + "need to procure goods, and make a journey throughout the "
                + "countryside of Afghanistan. You will meet local shopkeepers, "
                + "flee from the Taliban, brigands, and also fend off "
                + "micro-biological attackers! This action packed text-based "
                + "game will have you sitting on the edge of your seat as you "
                + "make your way towards the southern border of the more "
                + "civilized and policed country of Iran. As a refugee, "
                + "you'll need to avoid conflict from NATO forces and their "
                + "questioning, in addition to circumventing some of the "
                + "largest provinces in Afghanistan! "
                + "Good luck, and always remember - 'Allah Akbar!!' !\n");
        
    }
    

}
