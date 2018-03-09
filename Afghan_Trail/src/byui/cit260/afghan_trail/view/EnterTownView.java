/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.model.Inventory;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.controller.EnterTown;
import byui.cit260.afghan_trail.controller.Game;
import byui.cit260.afghan_trail.controller.Map;
import byui.cit260.afghan_trail.controller.ShopKeeperController;
import java.util.Scanner;
import byui.cit260.afghan_trail.view.ShopKeeperView;
/**
 *
 * @author Brayden
 */
public class EnterTownView {
    
    public static String welcome = "" +
" __          __         _                                      _    _ \n" +
" \\ \\        / /        | |                                    | |  | |\n" +
"  \\ \\  /\\  / /    ___  | |   ___    ___    _ __ ___      ___  | |  | |\n" +
"   \\ \\/  \\/ /    / _ \\ | |  / __|  / _ \\  | '_ ` _ \\    / _ \\ | |  | |\n" +
"    \\  /\\  /    |  __/ | | | (__  | (_) | | | | | | |  |  __/ |_|  |_|\n" +
"     \\/  \\/      \\___| |_|  \\___|  \\___/  |_| |_| |_|   \\___| (_)  (_)\n" +
"                                                                      \n" +
"                                                                      \n";
    
    public static String invalidOptionMsg = "INVALID COMMAND, TRY AGAIN";
   
    public EnterTownView() {
    }
    
    public static char display(Game game, Player player) {
        
        // set town and character name
        String characterName = player.getName();
        int progress = game.getProgress();
        String townName = getTownName(progress);
        
        // display welcome and map
        System.out.print(welcome);
        systemPause();
        String mapString = Map.displayMap(progress);
        System.out.print(mapString + "\n\n\n");
        
        // display options
        System.out.print("Hello, " + characterName + ". You have arrived to " + townName ); 
        systemPause();
        System.out.print(".\nWhat would you like to do?\n" +
                    "W - Leave town\n" +
                    "A - Talk to shopkeeper\n" +
                    "S - Rest and save game\n" +
                    "D - Return to main menu\n" +
                    ">>>\n");
        
        // get input from user
        Scanner inFile;
        inFile = new Scanner(System.in);
        char userChar;
        boolean wasORd = false;
        do {
            userChar = inFile.next().charAt(0);
            userChar = Character.toLowerCase(userChar);
            if (userChar == 'w' || 
                userChar == 'a' || 
                userChar == 's' || 
                userChar == 'd')
                wasORd = true;
            else
                System.out.println(invalidOptionMsg);
        } while (!wasORd);
        
        // Handle user input
        switch (userChar){
            
            // Continue
            case 'w':
                //TODO see how to handle continue via testing
                System.out.print("Leaving town...\n");

            break;

            // Shopkeeper
            case 'a':
                ShopKeeperView.display(characterName, game, player);
                EnterTownView.display(game, player);
                //ShopKeeperController.shopKeeper(Player, shopKeeperChar);
            break;

            // Save game
            case 's':
                Game.saveGame();
                EnterTownView.display(game, player);
               //char shopKeeperChar = ShopKeeperView.display(player.getName());
               //ShopKeeperController.shopKeeper(player, shopKeeperChar);
            break;
            
            // Exit
            case 'd':
                System.out.print("Goodbye! Thank you for playing!\n");
                //System.exit(0); //exit system
                game.setIsQuit(true); //back to main menu
            break;
            //String optionString = enterTownMenu.getOptionsString();
            //System.out.println(enterTownMenu.getMessage() + '\n');
            //char userInput = BasicMenu.getUserChar(optionString);

        }

        return userChar;
    }
    
    public static String getTownName(int progress){
        switch (progress){
            case 0:
                return "Kandahar";
            case 5:
                return "Kabul";
            case 10:
                return "Mazar-i-Sharif";
            case 15: 
                return "Maymana";
            case 20:
                return "Herat";
            default:
                return "a town";
        }
    }
    
    public static void systemPause(){
        try {
            Thread.sleep(2000); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}