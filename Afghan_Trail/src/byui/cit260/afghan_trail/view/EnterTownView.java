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
   
    public EnterTownView() {
    }
    
    public static char display(int progress, Player player) {
        String characterName = player.getName();
        String townName = "a town";
        switch (progress){
            case 0:
                townName = "Kandahar";
                break;
            case 5:
                townName = "Kabul";
                break;
            case 10:
                townName = "Mazar-i-Sharif";
                break;
            case 15: 
                townName = "Maymana";
                break;
            case 20:
                townName = "Herat";
                break;
            default:
                townName = "a town";
        }
        System.out.print(" __          __         _                                      _    _ \n" +
" \\ \\        / /        | |                                    | |  | |\n" +
"  \\ \\  /\\  / /    ___  | |   ___    ___    _ __ ___      ___  | |  | |\n" +
"   \\ \\/  \\/ /    / _ \\ | |  / __|  / _ \\  | '_ ` _ \\    / _ \\ | |  | |\n" +
"    \\  /\\  /    |  __/ | | | (__  | (_) | | | | | | |  |  __/ |_|  |_|\n" +
"     \\/  \\/      \\___| |_|  \\___|  \\___/  |_| |_| |_|   \\___| (_)  (_)\n" +
"                                                                      \n" +
"                                                                      \n");
            try {
            Thread.sleep(2000); 
            } catch (Exception e) {
            e.printStackTrace();
            }
        String mapString = Map.displayMap(progress);
        System.out.print(mapString + "\n\n\n");
        
        System.out.print("Hello, " + characterName + ". You have arrived to " + townName ); 
                try {
                Thread.sleep(2000); 
                } catch (Exception e) {
                e.printStackTrace();
                }
        System.out.print(".\nWhat would you like to do?\n" +
                    "W - Leave town\n" +
                    "A - Talk to shopkeeper\n" +
                    "S - Rest and save game\n" +
                    "D - Exit game...\n" +
                    ">>>\n");
        
        /*BasicMenu enterTownMenu = new BasicMenu(
                "You have entered a town", options
        );
         */ 
        //public static char getUserChar(String optionsString){
        String invalidOptionMsg = "INVALID COMMAND, TRY AGAIN";
        //System.out.println(optionsString);
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
        
    
        switch (userChar){
         //Continue
         case 'w':
             //TODO see how to handle continue via testing
             System.out.print("Leaving town...\n");

         break;

         //Shopkeeper
         case 'a':
             ShopKeeperView.display(characterName, progress, player);
             EnterTownView.display(progress,player);
             //ShopKeeperController.shopKeeper(Player, shopKeeperChar);
         break;

         //Save game
         case 's':
             Game.saveGame();
             EnterTownView.display(progress,player);
            //char shopKeeperChar = ShopKeeperView.display(player.getName());
            //ShopKeeperController.shopKeeper(player, shopKeeperChar);
         break; 
         //exit
         case 'd':
             System.out.print("Goodbye! Thank you for playing!\n");
             System.exit(0);
         break;
         //String optionString = enterTownMenu.getOptionsString();
         //System.out.println(enterTownMenu.getMessage() + '\n');
         //char userInput = BasicMenu.getUserChar(optionString);

         }

    
        //TODO
        //ignore()
        //useMedicine()
        //rest()
        return userChar;

    }
}