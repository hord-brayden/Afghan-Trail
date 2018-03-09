/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

import byui.cit260.afghan_trail.controller.Game;
import static byui.cit260.afghan_trail.controller.Game.loseMsg;
import static byui.cit260.afghan_trail.controller.Game.winMsg;
import byui.cit260.afghan_trail.controller.Map;
import byui.cit260.afghan_trail.model.Player;

/**
 *
 * @author jonsi
 */
public class GameMenuView extends BasicView {
    public GameMenuView() {
        super();
        
        String[] options = {
            "Continue",
            "Map",
            "Player Stats",
            "Player Inventory",
            "Guide",
            "Exit without saving"
        }; 
        String message = "Game Menu";       
        setOptions(options);
        setMessage(message);
    }
    
    public GameMenuView(String options[], String message){
        super(options, message);
    }
    
    @Override
    public void displayHelp(){
        System.out.print("" +
            "GAME MENU GUIDE\n\n" + 
            "\tPressing W\n\n" +
            "Continue will move your character\n" +
            "to thier next adventure event\n\n" + 
            "\tPressing A\n\n" + 
            "Map will show the map of the\n" +
            "afghan trail and your character's position\n\n" +
            "\tPressing S\n\n" +
            "Player Stats will show your\n" +
            "character's stats\n" + 
            "\tPressing D\n\n" +
            "Player inventory will be shown\n" +
            "\tPressing Q\n\n" +
            "Displays this game guide\n" +
            "\tPressing E\n\n" +
            "Exits the game without saving\n" + 
            "Saving can only be done in towns\n");
    }
    
    @Override
    public void display(Game game, Player player) {
        
        while ((game.getProgress() < 24 && 
       !game.getPlayer().isIsDead() &&
       !game.isIsQuit()))
        {
            System.out.print("\n\n" + message + "\n");
            char userInput = getUserChar(options);
            doAction(options, userInput, game, player);
        }
        
        
    }
    
    public void doAction(String[] options, 
                         char action, 
                         Game game,
                         Player player)
    {
        switch (action){
           case 'w':

               //Continue
               game.generateEvent();

               break;

           case 'a':

               //Map
               int progress = game.getProgress();
               String mapString = Map.displayMap(progress);
               System.out.print(mapString);
               break;

           case 's':

               //Player Stats
               game.getPlayer().showStats();
               break;

           case 'd':

               //Player Inventory
               game.getPlayer().showInventory();
               break;

           case 'q': 

               //Game Help
               displayHelp();
               break;
               
           case 'e':
               
               //Exit Game without saving
               game.setIsQuit(true);
               break;
               
           default: 
               System.out.println("INVALID OPTION\n");
               break;
        }
    }
}
