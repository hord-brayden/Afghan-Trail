/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.afghan_trail.controller;
import byui.cit260.afghan_trail.exceptions.BrokenWagonException;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.view.BeingAttackedView;
import byui.cit260.afghan_trail.view.BrokenWagonView;
import byui.cit260.afghan_trail.view.DiseaseContractionView;
import byui.cit260.afghan_trail.view.HuntView;
import java.io.Serializable;
import byui.cit260.afghan_trail.view.EnterTownView;
import byui.cit260.afghan_trail.view.NewGameView;
import byui.cit260.afghan_trail.exceptions.GameControllerException;
import byui.cit260.afghan_trail.model.Game;
import byui.cit260.afghan_trail.view.GameMenuView;

/**
 *
 * @author jonsi
 */
public class GameController implements Serializable{

    public static void generateEvent(Game game) throws GameControllerException, BrokenWagonException{
       
        //get random on event
        int numOfEvents = 5;
        int eventId = (int) Math.ceil(Math.random() * numOfEvents);

        //to debug change eventId
        //eventId = 3;

        switch(eventId){
            case 1:
                
                // Being Attacked
                char caseOneKeys[] = {'F','R','B','H'};
                BeingAttackedView beingAttackedView = new BeingAttackedView(caseOneKeys);
                beingAttackedView.display(game);
                
            break;
            case 2:
                
                // Hunt
                char caseTwoKeys[] = {'H','I','R','E'};
                HuntView huntView = new HuntView(caseTwoKeys);
                huntView.display(game);
                
            break;
            case 3:
                 
                // Broken Wagon
                char caseThreeKeys[] = {'F','I','R','E'};
                BrokenWagonView brokenWagonView = new BrokenWagonView(caseThreeKeys);
                brokenWagonView.display(game);
            
            break;
            case 4:
                
                // Disease Contraction
                String message = "You've fallen ill";
                if (game.getPlayer().isIsSick())
                    message = "You are still sick";
                DiseaseContractionView diseaseContractionView = new DiseaseContractionView();
                diseaseContractionView.display(game);
            
            break;
            case 5:
                 FindItem.findItem(game.getPlayer());
            break;
            default:
                System.out.print("Non eventful stop on the map\n");
        }
        
        //update progress | speed mechanism implemented here
        game.progressPlayer();
        
        //check if user should enter town
        if (game.getProgress() % 5 == 0){
            EnterTownView enterTownView = new EnterTownView();
            enterTownView.arrivalToTown(game);
            enterTownView.display(game);
        }    
    }
        
    public static Game initializeGame(Game game){  
        
        // this view sets up the character
        NewGameView newGameView = new NewGameView();
        newGameView.display(game);
        
        // first event should be the town of Kandahar
        String firstTownString = "" +
                "Your adventure starts in the town of Kandahar\n" + 
                "It would probably be smart to stock up on some supplies\n";
        System.out.print(firstTownString);
        
        
        EnterTownView enterTownView = new EnterTownView();
        enterTownView.arrivalToTown(game);
        enterTownView.display(game);
        game.setProgress(1); //this is so we don't repeat this town
        
        return game;
    }
    
    public static void startGame(Game game){  
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display(game);
    }  
    
    
    public static Game loadGame(){
        System.out.println("Load Game from memory");
        
        //okay here let's fake like we got a game from memory
        Player fakePlayer = new Player("Unknown", "No Class");
        Game fakeGame = new Game();
        fakeGame.setPlayer(fakePlayer);
        
        //now we just return it
        return fakeGame;
    }
    
     public static Game saveGame(){
         System.out.println("Saving game....");
        
         try {
        Thread.sleep(3000); 
        } catch (Exception e) {
        e.printStackTrace();
        }
         System.out.println("   _____                                                                   _   _   _ \n" +
"  / ____|                                                                 | | | | | |\n" +
" | |  __    __ _   _ __ ___     ___       ___    __ _  __   __   ___    __| | | | | |\n" +
" | | |_ |  / _` | | '_ ` _ \\   / _ \\     / __|  / _` | \\ \\ / /  / _ \\  / _` | | | | |\n" +
" | |__| | | (_| | | | | | | | |  __/     \\__ \\ | (_| |  \\ V /  |  __/ | (_| | |_| |_|\n" +
"  \\_____|  \\__,_| |_| |_| |_|  \\___|     |___/  \\__,_|   \\_/    \\___|  \\__,_| (_) (_)\n" +
"                                                                                     \n" +
"                                                                                     \n");
         try {
        Thread.sleep(1000); 
        } catch (Exception e) {
        e.printStackTrace();
        }
         Player savedPlayer = new Player ("Saved player", "Saved class");
         Game savedGame = new Game();
         savedGame.setPlayer(savedPlayer);
         return savedGame;
     }
     


    
};
    
   