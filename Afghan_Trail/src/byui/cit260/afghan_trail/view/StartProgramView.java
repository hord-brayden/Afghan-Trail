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
        
        //ALL THIS needs to be put in the game class or something
//        System.out.print("   GAME MENU GUIDE\n\n" + 
//                "\tPressing W\n\n" +
//                "Continue will move your character\n" +
//                "to thier next adventure event\n\n" + 
//                "\tPressing A\n\n" + 
//                "Map will show the map of the\n" +
//                "afghan trail and your character's position\n\n" +
//                "\tPressing S\n\n" +
//                "Player Stats will show your\n" +
//                "character's stats and inventory\n");
    }
    
    @Override
    public void doAction(String[] options, 
                           char action, 
                           Game game,
                           Player player){
        assert(game == null);
        assert(player == null);
          
        // main game loop. exits on 'd' input
        do{
           
            //ensures wasORd
            switch(action)
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
                
                //Exit 's'
                    //exits this loop
                
                //Guide 'd'
                    //handled by display function
                
            }
            
            if (action != 's')
                display();
            
        } while (action != 's');

        System.out.println(exitMsg);
      }
}


