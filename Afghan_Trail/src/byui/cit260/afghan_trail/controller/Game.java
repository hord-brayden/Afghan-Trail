/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.afghan_trail.controller;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.controller.BeingAttacked;
import byui.cit260.afghan_trail.controller.EnterTown;
import byui.cit260.afghan_trail.controller.Hunt;
import byui.cit260.afghan_trail.model.Banker;
import byui.cit260.afghan_trail.model.Blacksmith;
import byui.cit260.afghan_trail.model.Carpenter;
import byui.cit260.afghan_trail.model.Farmer;
import byui.cit260.afghan_trail.view.BasicView;
import byui.cit260.afghan_trail.view.BeingAttackedView;
import byui.cit260.afghan_trail.view.BrokenWagonView;
import byui.cit260.afghan_trail.view.DiseaseContractionView;
import byui.cit260.afghan_trail.view.HuntView;
import java.io.Serializable;
import byui.cit260.afghan_trail.view.EnterTownView;
import byui.cit260.afghan_trail.view.NewGameView;
import byui.cit260.afghan_trail.view.ShopKeeperView;
import byui.cit260.afghan_trail.view.StartProgramView;
import byui.cit260.afghan_trail.controller.Game;
import byui.cit260.afghan_trail.exceptions.BrokenWagonException;
import byui.cit260.afghan_trail.view.GameMenuView;

/**
 *
 * @author jonsi
 */
public class Game implements Serializable{
    
    /*
        Properties
    */
    private int progress;
    private boolean isQuit;
    private Player player;
    public static String winMsg = "You Won!";
    public static String loseMsg = "You Are Dead!";

    /*
        Getters & Setters
    */
    public Game() {
        setProgress(0);
        setIsQuit(false);
    }  
    
    public Game(Player player){
        setProgress(0);
        setIsQuit(false);
        this.player = player;
    }

    public int getProgress() {
        return progress;
    }

    public boolean isIsQuit() {
        return isQuit;
    }

    public void setIsQuit(boolean isQuit) {
        this.isQuit = isQuit;
    }
    
    public void setProgress(int progress) {
        //keep progress withing limits
        if (progress < 0)
            progress = 0;
        else if (progress > 24)
            progress = 24;
        
        this.progress = progress;
    }

    public Player getPlayer() {
        return player;
    }
    
    public void setPlayer(Player player){
        this.player = player;
    }
    
    @Override
    public String toString() {
        return "Game{" + "progress=" + progress + ", player=" + 
        player.toString() + "}";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.progress;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.progress != other.progress) {
            return false;
        }
        return true;
    }
  
    /*
        Methods
    */
    public void generateEvent() throws BrokenWagonException{
       
        //get random on event
        int numOfEvents = 5;
        int eventId = (int) Math.ceil(Math.random() * numOfEvents);

        //to debug change eventId
        //eventId = 2;

        switch(eventId){
            case 1:
                
                // Being Attacked
                char caseOneKeys[] = {'F','R','B','H'};
                BeingAttackedView beingAttackedView = new BeingAttackedView(caseOneKeys);
                beingAttackedView.display(this, player);
                
            break;
            case 2:
                
                // Hunt
                char caseTwoKeys[] = {'H','I','R','E'};
                HuntView huntView = new HuntView(caseTwoKeys);
                huntView.display(this, player);
                
            break;
            case 3:
                 
                // Broken Wagon
                char caseThreeKeys[] = {'F','I','R','E'};
                BrokenWagonView brokenWagonView = new BrokenWagonView(caseThreeKeys);
                brokenWagonView.display(this, player);
            
            break;
            case 4:
                
                // Disease Contraction
                char caseFourKeys[] = {'T','I','R','E'};
                DiseaseContractionView diseaseContractionView = new DiseaseContractionView(caseFourKeys);
                diseaseContractionView.display(this, player);
            
            break;
            case 5:
                 FindItem.findItem(player);
            break;
            default:
                System.out.print("Non eventful stop on the map\n");
        }
        
        //update progress | speed mechanism implemented here
        progressPlayer();
        
        //check if user should enter town
        if (progress % 5 == 0){
            char townKeys[] = {'S','L','R','E','H'};
            EnterTownView enterTownView = new EnterTownView(townKeys);
            enterTownView.arrivalToTown(this);
            enterTownView.display(this, player);
            //EnterTown.enterTown(player, progress, userChar);
        }    
    }
        
    public Game initializeGame(){  
        
        // this view sets up the character
        char characterKeys[] = {'B','S','C','F','H'};
        NewGameView newGameView = new NewGameView(characterKeys);
        newGameView.display(this, null);
        
        // first event should be the town of Kandahar
        String firstTownString = "" +
                "Your adventure starts in the town of Kandahar\n" + 
                "It would probably be smart sto stock up on some supplies\n";
        System.out.print(firstTownString);
        
        char townKeys[] = {'S','L','R','E','H'};
        EnterTownView enterTownView = new EnterTownView(townKeys);
        enterTownView.arrivalToTown(this);
        enterTownView.display(this, player);
        //EnterTown.enterTown(player, progress, userChar);
        
        return this;
    }
    
    public static void startGame(Game game){  
        /*
            to customize the game menu keys,
            fill the array and pass it to the GameMenuView constructor
        */  
        
        char gameOptionKeys[] = {'C','M','S','I','G','E'};
        
        GameMenuView gameMenuView = new GameMenuView(gameOptionKeys);
        gameMenuView.display(game, game.getPlayer());
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
     
    /*
        The most a player can be moved forward is 1 position of 25 on the map.
        This way the player does not skip any towns. 
        Whether he is moved after this event is decided on various factors:
            - speed 
            - wagon status
            - sick
            - stamina
     
        Adjustments to the speed are made in getAdjustedSpeed and do not effect
        the players speed property
     
        speed: The higher the speed the higher the chance is that the user
        will progress to the next position. The lowest it can go is 1 which
        corresponds to a 10 % chance. The highest it can go is 10.
    */ 
    private void progressPlayer(){
        int speed = getPlayer().getAdjustedSpeed();
        
        //debug line that shows the chances of moving forward
        System.out.print("Chance of moving forward: " + speed * 10 + "%\n");

        if (true && !player.isResting()){
            setProgress(getProgress() + 1);
        }
        else if (player.isResting()){
            System.out.print("Player is rested up\n");
            player.setStamina(100);
        }
        
        //report progress
        System.out.print("Progress " + (getProgress() + 1) + "/25\n");
        
        //stop resting
        player.setResting(false);
    }
    
};
    
   