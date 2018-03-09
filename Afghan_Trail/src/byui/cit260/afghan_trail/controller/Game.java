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
    
    public static void displayHelp(){
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
  
    public void generateEvent(){
       
        //get random on event
        int numOfEvents = 5;
        int eventId = (int) Math.ceil(Math.random() * numOfEvents);

        //to debug change eventId
        //eventId = 1;

        switch(eventId){
            case 1:
                BeingAttackedView beingAttackedView = new BeingAttackedView();
                beingAttackedView.display(this, player);
            break;
            case 2:
                HuntView huntView = new HuntView();
                huntView.display(this, player);
            break;
            case 3:
                 BrokenWagonView brokenWagonView = new BrokenWagonView();
                 brokenWagonView.display(this, player);
            break;
            case 4:
                 DiseaseContractionView diseaseContractionView = new DiseaseContractionView();
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
            char userChar = EnterTownView.display(this, player);
            EnterTown.enterTown(player, progress, userChar);
        }   
        
    }
        
    public Game initializeGame(){  
        
        // this view sets up the character
        NewGameView newGameView = new NewGameView();
        newGameView.display(this, null);
        
        // first event should be the town of Kandahar
        String firstTownString = "" +
                "Your adventure starts in the town of Kandahar\n" + 
                "It would probably be smart sto stock up on some supplies\n";
        System.out.print(firstTownString);
        char userChar = EnterTownView.display(this, getPlayer());
        EnterTown.enterTown(player, progress, userChar);
        
        return this;
    }
    
    public static void startGame(Game game){  
        String staticTitle = "Game Menu\n";
        String staticMenu = "\n" +
                "   W - Continue\n" + 
                "   A - Map\n" +
                "   S - Player Stats\n" +
                "   D - Player Inventory\n" + 
                "   Q - Guide\n" +
                "   >";  
        String[] options = {
            "Continue",
            "Map",
            "Player Stats",
            "Player Inventory",
            "Guide"
        }; 

        /*
           GAME LOOP IS HERE 
        */
        while ((game.getProgress() < 24 && 
               !game.getPlayer().isIsDead() &&
               !game.isIsQuit()))
        {
            
            System.out.print(staticTitle);
            char userIn = BasicView.getUserChar(options);

            switch (userIn){
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
                   Game.displayHelp();
                   break;
                   
               default: 
                   System.out.println("INVALID OPTION\n");
                   break;
           }
        }
 
        if (game.getProgress() >= 25)
            System.out.println(winMsg);
        else if (game.getPlayer().isIsDead())
            System.out.println(loseMsg);
        else
            System.out.print("Returning to main menu\n");
        
        //NOTE HERE
        //WE ARE STILL IN THE MAIN MENU LOOP
        //this means that when this function ends because the game loop
        //ends (user quits, wins, or loses) then we go back to the main menu.
    }  
    
    
    public static Game loadGame(){
        System.out.println("Load Game from memory");
        
        //okay here let's fake like we got a game from memory
        Player fakePlayer = new Player("Unknown", 12, "No Class");
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
         Player savedPlayer = new Player ("Saved player", 12, "Saved class");
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
        
        
        
        if (true){
            setProgress(getProgress() + 1);
        }
    }
    
};
    
   