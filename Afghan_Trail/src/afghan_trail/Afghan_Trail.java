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

/**
 *
 * @author Rizky, Brayden, Jonathan
 */
public class Afghan_Trail {

    /**
     * @param args the command line arguments
     */
    public static String welcome = "Welcome to Afghan Tails Text Adventure\n";
    public static String mainMenu = "" +
        "   W - Start Game\n" +
        "   A - Load Game\n"  +
        "   S - Exit\n"       +
        "   D - Guide\n"      +
        "   >";
    public static String exitMsg = "Thank you for playing\n";
    public static String invalidOptionMsg = "INVALID COMMAND, TRY AGAIN";
    
    public static void main(String[] args) {
        
        // launch main menu and get user input
        char mainMenuInput = getUserChar(welcome + mainMenu);

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
            mainMenuInput = getUserChar(mainMenu);
        }
        
        // exit the game
        System.out.println(exitMsg);
    }
    
    public static char getUserChar(String prompt){
        System.out.println(prompt);
        Scanner inFile;
        inFile = new Scanner(System.in);
        char userChar = inFile.next().charAt(0);
        userChar = Character.toLowerCase(userChar);
        return userChar;
    }
    
    public static String getUserString(String prompt){
        System.out.println(prompt);
        Scanner inFile;
        inFile = new Scanner(System.in);
        String userString = inFile.nextLine();
        return userString;
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
        String characterName = getUserString(getNameString);
        
        // set character class
        Player userCharacter = null;
        while (userCharacter == null)
        {
            char userClassChar = getUserChar(getClassString);
        
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
                "   W - Continue\n" + 
                "   A - Map\n" +
                "   S - Save\n" +
                "   D - Save & Quit\n" +
                "   >";   
            
        boolean isQuit = false;
        while (game.getProgress() < 25 && 
               !game.getPlayer().isIsDead() &&
               !isQuit)
        {
           char userIn = getUserChar(staticMenu);
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
                   System.out.print("Cannot save games yet.\n");
                   break;
               case 'd':
                   System.out.print("Cannot save but will quit\n");
                   isQuit = true;
               default: 
                   System.out.println(invalidOptionMsg);
                   break;
           }
        }
        
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
    
    public static void showGuide(){
        String guide = "This is the guide so far\n";
        System.out.println(guide);
    }
    
}
