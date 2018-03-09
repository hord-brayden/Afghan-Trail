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
    
    /*
        Constructors
    */
    public StartProgramView(){
        super();
        
        String[] options = {
            "Start Game", 
            "Load Game", 
            "Exit", 
            "Guide"
        };
        String message = "Main Menu";       
        setOptions(options);
        setMessage(message);
    }
    
    public StartProgramView(String options[], String message){
        super(options, message);
    }
    
    @Override
    public void displayHelp(){
        GuideView guideView = new GuideView();             
        guideView.display();
    }
    
    @Override
    public void doAction(String[] options, 
                           char action, 
                           Game game,
                           Player player){
          
        // main game loop. exits on 'd' input
        do{
           
            //ensures wasORd
            switch(action)
            {
                //Start Game
                case 'w':
                   Game newGame = new Game();
                   newGame.initializeGame();
                   Game.startGame(newGame);
                break;

                //Load Game
                case 'a':
                   Game oldGame = Game.loadGame();
                   Game.startGame(oldGame);
                break;
                
                //Exit 's'
                    //exits this loop
                
                //Guide 'd'
                    //handled by display function
                
            }
            
            if (action != 's')
                display(null, null);
            
        } while (action != 's');

        System.out.println(exitMsg);
      }
}


