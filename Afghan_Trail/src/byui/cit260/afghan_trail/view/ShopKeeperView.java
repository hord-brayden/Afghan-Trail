/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

import byui.cit260.afghan_trail.controller.Game;
import byui.cit260.afghan_trail.controller.shopKeeperController;
import byui.cit260.afghan_trail.exceptions.shopKeeperControllerException;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.ShopKeeper;
import byui.cit260.afghan_trail.view.EnterTownView;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        boolean resume = true;
        switch (actionInt){
            
            // Buy
            case 0:
                
                System.out.print("You chose '" + options[0] + "'\n");
                resume = true;
                do {
                    try {
                        resume = shopKeeperController.buy(player, shopKeeper);
                    } catch (shopKeeperControllerException e ) {
                        System.out.print(e.getMessage());
                    } catch (NumberFormatException nf){
                        System.out.print(nf.getCause() + " is not a number\n");
                    }
                } while (resume);
                break;
             
            // Sell  
            case 1:
                
                System.out.print("You chose '" + options[1] + "'\n");
                resume = true;
                do {
                    try {
                        resume = shopKeeperController.sell(player, shopKeeper);
                    } catch (shopKeeperControllerException e) {
                        System.out.print(e.getMessage());
                    }
                } while (resume);
                break;
             
            // Rob
            case 2:
                
                System.out.print("You chose '" + options[2] + "'\n");
                resume = true;
                do {
                    try {
                        resume = shopKeeperController.rob(player, shopKeeper);
                    } catch (shopKeeperControllerException e) {
                        System.out.print(e.getMessage());
                    } catch (Throwable e) {
                        System.out.print("Please enter a valid number, between 1 - 5\n");
       
            } 
                } while (resume);
                
                break;
               
            
            // Shopkeeper Help
            case 3:
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
