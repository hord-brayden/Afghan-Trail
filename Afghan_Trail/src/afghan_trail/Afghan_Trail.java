/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afghan_trail;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.controller.Game;
import java.util.Scanner;
import byui.cit260.afghan_trail.model.Banker;
import byui.cit260.afghan_trail.model.Blacksmith;
import byui.cit260.afghan_trail.model.Carpenter;
import byui.cit260.afghan_trail.model.Farmer;
import byui.cit260.afghan_trail.controller.Map;
import byui.cit260.afghan_trail.view.MainMenu;
import byui.cit260.afghan_trail.view.BasicMenu;
import byui.cit260.afghan_trail.view.ShopKeeperView;

/**
 *
 * @author Rizky, Brayden, Jonathan
 */
public class Afghan_Trail {

    /**
     * @param args the command line arguments
     */

    public static String exitMsg = "Thank you for playing\n";
    public static String invalidOptionMsg = "INVALID COMMAND, TRY AGAIN";
    
    public static void main(String[] args) {
        
        /*
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.display();
        */
        
        // launch main menu and get user input
        char mainMenuInput = BasicMenu.getUserChar("Welcome, \n" + MainMenu.mainMenu);

        // main game loop. exits on 's' input
        while (mainMenuInput != 's') {
            switch(mainMenuInput)
            {
                case 'w':
                   Game newGame = startNewGame();
                   startGame(newGame);
                break;
                case 'a':
                   Game oldGame = loadGame();
                   startGame(oldGame);
                break;
                case 'd':
                   showGuide();
                break;
                default:
                   System.out.println(invalidOptionMsg);
                break;
            }
            mainMenuInput = BasicMenu.getUserChar(MainMenu.mainMenu);
        }
        
        // exit the game
        System.out.println(exitMsg);
    }
    

    

    
    public static Game startNewGame(){
         // prompt string setup
        String heroicIntro = "AFGHAN TRAIL!!!!!!!!!!!!\n" +
        "You are reading some sort of really, really\n" + 
        "heroic introduction. It is moving you to tears.\n" +
        "You are considering actually moving to afghanistan \n" +
        "in efforts to make your life more like the game you are \n" +
        "about to play, but you'll settle for this...for now.\n";
        String getNameString = "Character Name: ";
        String getClassString = "Character Class:\n" +
                "   W - Banker\n" + 
                "   A - Blacksmith\n" +
                "   S - Carpenter\n" +
                "   D - Farmer\n" +
                "   >";
        
        // begin game intro
        System.out.println(heroicIntro);
        String characterClass = ""; //gets set in the switch
        
        // get character name
        String characterName = BasicMenu.getUserString(getNameString);
        
        // set character class
        Player userCharacter = null;
        while (userCharacter == null)
        {
            char userClassChar = BasicMenu.getUserChar(getClassString);
        
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
                       System.out.println(invalidOptionMsg);
                    break;
            }
        }
        
        //New Game Welcome
        String gameStartString = "Welcome, " + characterName +
                characterClass + ", to the Afghan Trail\n." +
                "\n";
        System.out.println(gameStartString);
        
        // create the game object
        Game game = new Game();
        game.setPlayer(userCharacter);
        return game;
    }
    
    public static void startGame(Game game){ 
        String staticMenu = "" +
                "   W - Here\n" + 
                "   A - Map\n" +
                "   S - Guide\n" +
                "   D - Player Stats\n" +
                "   >";   
        String inTownMenu = "" +
                "   W - Continue\n" + 
                "   A - Map\n" +
                "   S - Talk to shopkeeper\n" +
                "   D - Rest and save\n" +
                "   >";   
      
        boolean isQuit = false;
        /*
           GAME LOOP IS HERE 
         
        */
        if(game.getProgress()% 5 == 0 && game.getProgress() < 25) {
            char userIn = BasicMenu.getUserChar(inTownMenu);
           switch(userIn){
               case 'w':
                   game.generateEvent();
                   break;
               case 'a':
                   int progress = game.getProgress();
                   String mapString = Map.displayMap(progress);
                   System.out.print(mapString);
                   break;
               case 's':
                   visitShop();
                   break;
               case 'd':
                   saveGame();
                   break;
               default: 
                   System.out.println(invalidOptionMsg);
                   break;}
        }   
        else if((game.getProgress() < 25 && 
               !game.getPlayer().isIsDead() &&
               !isQuit))
        {
           char userIn = BasicMenu.getUserChar(staticMenu);
           switch(userIn){
               case 'w':
                   game.generateEvent();
                   break;
               case 'a':
                   int progress = game.getProgress();
                   String mapString = Map.displayMap(progress);
                   System.out.print(mapString);
                   break;
               case 's':
                   showGuide();
                   break;
               case 'd':
                   showStats(game.getPlayer());
                   isQuit = true;
                   break;
               default: 
                   System.out.println(invalidOptionMsg);
                   break;
           }
        }
        else 
        
        if (game.getProgress() >= 25)
            MainMenu.gameWin();
        else if (game.getPlayer().isIsDead())
            MainMenu.gameLose(); //Death.display();
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
         
         Player savedPlayer = new Player ("Saved player", 12, "Saved class");
         Game savedGame = new Game();
         savedGame.setPlayer(savedPlayer);
         return savedGame;
     }
     
    public static void showGuide(){
        String guide = "This is the guide so far\n";
        System.out.println(guide);
    }
    
    public static void showStats(Player player){
        System.out.print("Name: " + player.getName());
        /*                     TODO DISPLAY ALL THIS STUFF
    private String name;
    private boolean isDead;
    private boolean isSick;
    private long stamina;
    private int numOfItems;
    private Item inventoryItems[] = new Item[numOfItems];
    private String playerClass;
    private long healthPoints;
    private BigDecimal money;
    private boolean isWagonBroken;
    private int speed;
*/
    }
    public static void visitShop(){
        String message = "This is the store so far\n";
        System.out.println(message);
        ShopKeeperView.display();
    }

    
}
