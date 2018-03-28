/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.model.Inventory;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.controller.GameController;
import byui.cit260.afghan_trail.controller.Map;
import byui.cit260.afghan_trail.controller.shopKeeperControllerTestable;
import byui.cit260.afghan_trail.model.Game;
import byui.cit260.afghan_trail.model.ShopKeeper;
import java.util.Scanner;
import byui.cit260.afghan_trail.view.ShopKeeperView;
/**
 *
 * @author Brayden
 */
public class EnterTownView extends BasicView {
    
    private ShopKeeper shopKeeper = new ShopKeeper();
    public static String welcome = "" +
" __          __         _                                      _    _ \n" +
" \\ \\        / /        | |                                    | |  | |\n" +
"  \\ \\  /\\  / /    ___  | |   ___    ___    _ __ ___      ___  | |  | |\n" +
"   \\ \\/  \\/ /    / _ \\ | |  / __|  / _ \\  | '_ ` _ \\    / _ \\ | |  | |\n" +
"    \\  /\\  /    |  __/ | | | (__  | (_) | | | | | | |  |  __/ |_|  |_|\n" +
"     \\/  \\/      \\___| |_|  \\___|  \\___/  |_| |_| |_|   \\___| (_)  (_)\n" +
"                                                                      \n" +
"                                                                      \n";
   
   
    public EnterTownView() {
        super();
        char townKeys[] = {'S','L','R','E','H'};
        String[] options = {
           "Talk to Shopkeeper",
           "Leave Town",
           "Rest and Save Game",
           "Return to Main Menu",
           "Town Menu Help"
        };
        String message = "Town Menu";       
        setOptions(options);
        setMessage(message);
        setKeys(townKeys);
    }
    
    public EnterTownView(String options[], String message){
        super(options, message);
    }
    
    public EnterTownView(char keys[]){
        this();
        if (keys.length < options.length)
            System.err.print("view must have the same amount or more keys than options");
        else
            setKeys(keys);
    }
    
    @Override
    public void displayHelp(){
        System.out.print("Town Help\n");
    }
    
    @Override
    public void display(Game game){
            
            //keep looping on evens
//           "Talk to Shopkeeper",   0 even
//           "Leave Town",           1
//           "Rest and Save GameController",   2 even
//           "Return to Main Menu",  3
//           "Town Help"             4 even keep looping
           
        System.out.println(message + '\n');
        int functionInt = 0;
        do {
            char userInput = getUserChar(options);
            doAction(options, userInput, game);
            functionInt = getFunctionNumberFromChar(userInput);
        } while (functionInt % 2 == 0 && !game.getPlayer().isIsDead());
    }
    
    public void arrivalToTown(Game game){
        // set town and character name
        String characterName = game.getPlayer().getName();
        int progress = game.getProgress();
        String townName = getTownName(progress);
        
        System.out.print(welcome);

        //systemPause();

        String mapString = Map.displayMap(progress);
        System.out.print(mapString + "\n\n\n");
        
        // display options
        System.out.print("Hello, " + characterName + ". You have arrived to " + townName + "\n"); 

        //systemPause();

    }
    
    @Override
    public void doAction(String[] options, 
                         char action, 
                         Game game)
    {
        int actionInt = getFunctionNumberFromChar(action);
        switch (actionInt){
            
            // Talk to Shopkeeper
            case 0:
                
                System.out.print("You chose '" + options[0] + "'\n");
                char shopKeeperKeys[] = {'B','S','R','T','H','E'};
                ShopKeeperView shopKeeperView = new ShopKeeperView(shopKeeperKeys);
                shopKeeperView.setShopKeeper(shopKeeper);
                shopKeeperView.display(game);
                break;
             
            // Leave Town    
            case 1:
                
                System.out.print("You chose '" + options[1] + "'\n");
                break;
             
            // Rest and Save GameController
            case 2:
                
                System.out.print("You chose '" + options[2] + "'\n");
                GameController.saveGame();
                break;
                
            // Return to Main Menu
            case 3:
                System.out.print("Heading back to the Main Menu\n");
                
                // let the user save
                System.out.print("Would you like to save? Y\\N\n");
                Scanner inFile;
                inFile = new Scanner(System.in);
                char userChar = 'f';
                do {
                    userChar = inFile.next().charAt(0);
                    userChar = Character.toLowerCase(userChar);
                } while (userChar != 'y' && userChar != 'n');
                
                if (userChar == 'y'){
                    GameController.saveGame();
                }
                
                //System.exit(0); //exit system
                game.setIsQuit(true); //back to main menu
                break;
            
            // Town Help
            case 4:
                displayHelp();
        }
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