/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

import byui.cit260.afghan_trail.controller.Game;
import byui.cit260.afghan_trail.controller.ShopKeeperController;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.ShopKeeper;
import byui.cit260.afghan_trail.view.EnterTownView;
import java.util.Scanner;

/**
 *
 * @author rizky
 */
public class ShopKeeperView extends BasicView{
    
    private ShopKeeper shopKeeper = new ShopKeeper();
    
    public ShopKeeperView() {
        super();
        String[] options = {
           "Buy",
           "Sell",
           "Rob",
           "Take an item",
           "Shopkeeper Help",
           "Exit Store"
        };
        String message = "Shopkeeper Menu";       
        setOptions(options);
        setMessage(message);
    }
    
    public ShopKeeperView(String options[], String message){
        super(options, message);
    }
    
    public ShopKeeperView(char keys[]){
        this();
        if (keys.length < options.length)
            System.err.print("view must have the same amount or more keys than options");
        else
            setKeys(keys);
    }
    
    public void setShopKeeper(ShopKeeper shopKeeper){
        this.shopKeeper = shopKeeper;
    }
    
    public ShopKeeper getShopKeeper(){
        return shopKeeper;
    }
    
    @Override
    public void displayHelp(){
        System.out.print("Shopkeeper Help\n");
    }
    
    @Override
    public void display(Game game, Player player) {
        System.out.println(message + '\n');
        int opLen = options.length;
        char lastKeyChar = keys[opLen - 1]; //exit
        char robChar = keys[2];             //rob
        char takeChar = keys[3];            //take
        lastKeyChar = Character.toLowerCase(lastKeyChar);
        robChar = Character.toLowerCase(robChar);
        takeChar = Character.toLowerCase(takeChar);
        char userInput = lastKeyChar;
        do {
            userInput = getUserChar(options);
            doAction(options, userInput, game, player);
        } while (userInput != lastKeyChar && 
                 userInput != robChar &&
                 userInput != takeChar);
    }
    
    @Override
    public void doAction(String[] options, 
                         char action, 
                         Game game,
                         Player player)
    {
        int actionInt = getFunctionNumberFromChar(action);
        switch (actionInt){
            
            // Buy
            case 0:
                
                System.out.print("You chose '" + options[0] + "'\n");
                ShopKeeperController.buy(player, shopKeeper);
                break;
             
            // Sell  
            case 1:
                
                System.out.print("You chose '" + options[1] + "'\n");
                ShopKeeperController.sell(player, shopKeeper);
                break;
             
            // Rob
            case 2:
                
                System.out.print("You chose '" + options[2] + "'\n");
                ShopKeeperController.rob(player, shopKeeper);
                break;
                
            // Take an item
            case 3:
                System.out.print("You chose '" + options[3] + "'\n");
                ShopKeeperController.takeItem(player, shopKeeper);
                break;
            
            // Shopkeeper Help
            case 4:
                displayHelp();
                
                
            // Case 5 is Exit, handled in loop in display
        }
    }    

    /*
        switch(userChar){
            case 'w':
                System.out.print("I am sorry we are sold out!\n");
                try {
                Thread.sleep(1000); 
                } catch (Exception e) {
                e.printStackTrace();
                }
                ShopKeeperView.display(name, game, player);
            break;
            case 'a':
                System.out.print("I am sorry we only sell stuff here!\n");
                try {
                Thread.sleep(1000); 
                } catch (Exception e) {
                e.printStackTrace();
                }
                ShopKeeperView.display(name, game, player);
            break;
            case 's':
                System.out.print("  _____                                                              _                _   _   _ \n" +
" |_   _|                                                            | |              | | | | | |\n" +
"   | |    _ __     ___    __ _   _ __    ___    ___   _ __    __ _  | |_    ___    __| | | | | |\n" +
"   | |   | '_ \\   / __|  / _` | | '__|  / __|  / _ \\ | '__|  / _` | | __|  / _ \\  / _` | | | | |\n" +
"  _| |_  | | | | | (__  | (_| | | |    | (__  |  __/ | |    | (_| | | |_  |  __/ | (_| | |_| |_|\n" +
" |_____| |_| |_|  \\___|  \\__,_| |_|     \\___|  \\___| |_|     \\__,_|  \\__|  \\___|  \\__,_| (_) (_)\n" +
"                                                                                                \n" +
"                                                                                                \n");
                try {
                Thread.sleep(1000); 
                } catch (Exception e) {
                e.printStackTrace();
                }
                System.out.print("They took $100 out of your pocket!!\n");
                try {
                Thread.sleep(1000); 
                } catch (Exception e) {
                e.printStackTrace();
                }
                ShopKeeperView.display(name, game, player);
            break;
            case 'd':
                //int progress = Game.getProgress();
               
                //EnterTownView.display(game, player);
            break;
        }
                

    }
    */
}
