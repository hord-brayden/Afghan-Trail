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
    private int progress;
    Player player;
    public static String winMsg = "You Won!";
    public static String loseMsg = "You Are Dead!";

    public Game() {
        setProgress(1);
    }  

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        //keep progress withing limits
        if (progress < 1)
            progress = 1;
        else if (progress > 25)
            progress = 25;
        
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
  
    public void generateEvent(){
        
        //update progress  display
        setProgress(getProgress() + player.getSpeed());
        
        //check if player has entered town
        char userChar;
        //progress = 10;
        if (progress % 5 == 0){
            userChar = EnterTownView.display(getProgress() , player);
            EnterTown.enterTown(player, progress, userChar);
        } else {
            //get random on event
            int numOfEvents = 3;
            int eventId = (int) Math.ceil(Math.random() * numOfEvents);
            
            //to debug change eventId
            eventId = 2;
            
           
            
            switch(eventId){
                case 1:
//                    do {
//                        userChar = BeingAttackedView.display();
//                        if (userChar == 'd')
//                            BeingAttacked.displayHelp();
//                    } while (userChar == 'd');
//                    BeingAttacked.attacked(player, userChar);
                    BeingAttackedView beingAttackedView = new BeingAttackedView();
                    beingAttackedView.display(this, player);
                break;
                case 2:
                    HuntView huntView = new HuntView();
                    huntView.display(this, player);
                break;
                case 3:
//                    do {
//                        userChar = BrokenWagonView.display();
//                        if (user= 'Char == 'd')
//                            BrokenWagonView.displayHelp();
//                    } while (userChar == 'd');
//                    BrokenWagon.brokenWagon(player, userChar);
                     BrokenWagonView brokenWagonView = new BrokenWagonView();
                     brokenWagonView.display(this, player);
                break;
                case 4:
//                    do {
//                        userChar = DiseaseContractionView.display();
//                        if (userChar == 'd')
//                            DiseaseContractionView.displayHelp();
//                    } while (userChar =d');
//                    DiseaseContraction.diseaseContraction(player, userChar);
                default:
                    System.out.print("Non eventful stop on the map\n");
            }
        }
    }
        
    public static Game startNewGame(){
        
        // get player info
        System.out.println(NewGameView.getIntroduction());
        String characterName = BasicView.getUserString(NewGameView.getNamePrompt());
        char userClassChar = NewGameView.getCharacter();

        String characterClass = ""; //gets set in the switch
        Player userCharacter = null;
        while (userCharacter == null)
        {
        
            // setup player subclass based on user input
            switch (userClassChar){
                    case 'w':
                       userCharacter = new Banker(characterName);
                       characterClass = " the Banker";
                    break;
                    case 'a':
                       userCharacter = new Blacksmith(characterName);
                       characterClass = " the Blacksmith";
                    break;
                    case 's':
                       userCharacter = new Carpenter(characterName);
                       characterClass = " the Carpenter";
                    break;
                    case 'd':
                       userCharacter = new Farmer(characterName);
                       characterClass = " the Farmer";
                    break;
                    default:
                       System.out.println("INVALID OPTION\n");
                    break;
            }
        }
        
        //New Game Welcome
        String gameStartString = "Welcome, " + characterName +
                characterClass + ", to the Afghan Trail\n" +
                "\n";
        System.out.println(gameStartString);
        
        // create the game object
        Game game = new Game();
        game.setPlayer(userCharacter);
        return game;
    }
    
    public static void startGame(Game game){ 
        String staticTitle = "Game Menu\n";
        String staticMenu = "\n" +
                "   W - Continue\n" + 
                "   A - Map\n" +
                "   S - Player Stats\n" +
                "   D - Guide\n" +
                "   >";    

        /*
           GAME LOOP IS HERE 
        */
        boolean isQuit = false;
        while ((game.getProgress() < 25 && 
               !game.getPlayer().isIsDead() &&
               !isQuit))
        {
            
            System.out.print(staticTitle);
            char userIn = BasicView.getUserChar(staticMenu);

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
                   
                   //Guide 
                   StartProgramView.showGuide();
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
            System.out.print("\nReturning to main menu");
        
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
     
    
};

   