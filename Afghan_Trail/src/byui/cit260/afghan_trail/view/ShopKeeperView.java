/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

import byui.cit260.afghan_trail.controller.GameController;
import byui.cit260.afghan_trail.controller.shopKeeperController;
import byui.cit260.afghan_trail.exceptions.shopKeeperControllerException;
import byui.cit260.afghan_trail.model.Game;
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
        this.console.println("Shopkeeper Help\n");
    }
    
    @Override
    public void display(Game game) {
        this.console.println(message + '\n');
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
            doAction(options, userInput, game);
        } while (userInput != lastKeyChar && 
                 userInput != robChar &&
                 userInput != takeChar);
    }
    
    @Override
    public void doAction(String[] options, 
                         char action, 
                         Game game)
    {
        int actionInt = getFunctionNumberFromChar(action);
        boolean resume = true;
        switch (actionInt){
            
            // Buy
            case 0:
                
                this.console.print("You chose '" + options[0] + "'\n");
                resume = true;
                do {
                    try {
                        resume = shopKeeperController.buy(game.getPlayer(), shopKeeper);
                    } catch (shopKeeperControllerException e ) {
                        ErrorView.display(this.getClass().getName(),
                                e.getMessage());
                    } catch (NumberFormatException nf){
                        ErrorView.display(this.getClass().getName(),
                                nf.getCause() + " is not a member\n");
                    }
                } while (resume);
                break;
             
            // Sell  
            case 1:
                
                this.console.print("You chose '" + options[1] + "'\n");
                resume = true;
                do {
                    try {
                        resume = shopKeeperController.sell(game.getPlayer(), shopKeeper);
                    } catch (shopKeeperControllerException e) {
                        ErrorView.display(this.getClass().getName(),
                                e.getMessage());
                    }
                } while (resume);
                break;
             
            // Rob
            case 2:
                
                this.console.print("You chose '" + options[2] + "'\n");
                resume = true;
                do {
                    try {
                        resume = shopKeeperController.rob(game.getPlayer(), shopKeeper);
                    } catch (shopKeeperControllerException e) {
                        ErrorView.display(this.getClass().getName(), 
                                e.getMessage());
                    } catch (Throwable e) {
                        ErrorView.display(this.getClass().getName(),
                                "Please enter a valid number between 1 & 5\n");
                    } 
                } while (resume);
                
                break;
               
            
            // Shopkeeper Help
            case 3:
                displayHelp();
                
                
            // Case 5 is Exit, handled in loop in display
        }
    }    
}
