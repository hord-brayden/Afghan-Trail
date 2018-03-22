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
import byui.cit260.afghan_trail.exceptions.BrokenWagonException;
import byui.cit260.afghan_trail.exceptions.GameMenuControllerException;
import byui.cit260.afghan_trail.model.Player;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public GameMenuView(char keys[]){
        this();
        if (keys.length < options.length)
            System.err.print("view must have the same amount or more keys than options");
        else
            setKeys(keys);
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
        
        if (game.getProgress() >= 24){
            //player won
            gameWin();
        } else if (game.getPlayer().isIsDead()) {
            //player is dead
            gameLose();
        } else if (game.isIsQuit()) {
            //player quit
            gameQuit();
        }
        
        
        
    }
    
    public void doAction(String[] options, 
                         char action, 
                         Game game,
                         Player player)
    {
        int actionInt = getFunctionNumberFromChar(action);
        switch (actionInt){
           case 0:

        {
            try {
                game.generateEvent();
            } catch (BrokenWagonException e) {
                System.out.print("Error loading events");
            }
        }

               break;

           case 1:

               //Map
               int progress = game.getProgress();
               String mapString = Map.displayMap(progress);
               System.out.print(mapString);
               break;

           case 2:

               //Player Stats
               game.getPlayer().showStats();
               break;

           case 3:

               //Player Inventory
               game.getPlayer().showInventory();
               break;

           case 4: 

               //Game Help
               displayHelp();
               break;
               
           case 5:
               
               //Exit Game without saving
               game.setIsQuit(true);
               break;
               
           default: 
               System.out.println("INVALID OPTION\n");
               break;
        }
    }
    
    public void gameWin(){
        System.out.print("You won the game\n");
    }
    
    public void gameLose(){
        System.out.print("You lose the game\n");
    }
    
    public void gameQuit(){
        System.out.print("Okay, come back soon\n");
    }
}
