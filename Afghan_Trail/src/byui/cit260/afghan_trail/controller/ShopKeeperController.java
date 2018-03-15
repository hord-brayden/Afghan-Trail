/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;

import static byui.cit260.afghan_trail.controller.Game.saveGame;
import byui.cit260.afghan_trail.model.Inventory;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.ShopKeeper;
import byui.cit260.afghan_trail.view.BasicView;
import byui.cit260.afghan_trail.view.ShopKeeperView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rizky
 */
public class ShopKeeperController {
        public static String jailed = "  _____                                                              _                _   _   _ \n" +
" |_   _|                                                            | |              | | | | | |\n" +
"   | |    _ __     ___    __ _   _ __    ___    ___   _ __    __ _  | |_    ___    __| | | | | |\n" +
"   | |   | '_ \\   / __|  / _` | | '__|  / __|  / _ \\ | '__|  / _` | | __|  / _ \\  / _` | | | | |\n" +
"  _| |_  | | | | | (__  | (_| | | |    | (__  |  __/ | |    | (_| | | |_  |  __/ | (_| | |_| |_|\n" +
" |_____| |_| |_|  \\___|  \\__,_| |_|     \\___|  \\___| |_|     \\__,_|  \\__|  \\___|  \\__,_| (_) (_)\n" +
"                                                                                                \n" +
"                                                                                                \n";
    
    public static void buy(Player player, ShopKeeper shopKeeper) {
        
        //inventories
        Inventory playerInv = player.getPlayerInventory();
        Inventory shopKeeperInv = shopKeeper.getPlayerInventory();
        ArrayList<Item> shopKeeperItems = shopKeeperInv.getInventoryItems();
        
        if (shopKeeperItems.size() <= 0){
            System.out.print("You don't have any items\n");
            return;
        }
        else
        {
            //sort items by price
            int len = shopKeeperItems.size();
            int rightVar; 
            for (int out = len; out >= 0; out--){
                for (int i = 0; i < len - 1; i++){
                    rightVar = i + 1;
                    double left = shopKeeperItems.get(i).getPrice().doubleValue();
                    double right = shopKeeperItems.get(rightVar).getPrice().doubleValue();
                    if (left < right){
                        Item temp;
                        temp = shopKeeperItems.get(i);
                        shopKeeperItems.set(i, shopKeeperItems.get(rightVar));
                        shopKeeperItems.set(rightVar, temp);
                    }
                }
            }
        }
        
        if (shopKeeperItems.size() <= 0){
            System.out.print("The shop is all out of items\n");
            return;
        }
        
        //print shopkeeper items
        System.out.print("Let's take a look at the Shop Keepers inventory\n\n");
        int itemNum = 1;
        for (Item item : shopKeeperItems){  
            System.out.print(itemNum + ": ");
            item.display();
            itemNum++;
        } 
        System.out.print(itemNum + ": Exit\n\n");
        int exitInt = itemNum;
        
        //get user choice
        Item userItem = null;
        boolean validatedInput = true;
        do 
        {
            int userChoice = 0;
            System.out.print("What item would you like to buy?\n" + 
                    player.getName() + ": $");
            System.out.printf("%.2f", player.getMoney());
            System.out.print("\nShop Keeper: $");
            System.out.printf("%.2f", shopKeeper.getMoney());
            System.out.print("\nEnter number of the item you want to buy.\n");
            
            //get userChoice
            Scanner inFile;
            inFile = new Scanner(System.in);
            try {
                if (inFile.hasNextInt()){
                    userChoice = inFile.nextInt();
                    System.out.print(userChoice);
                } else {
                    validatedInput = false;
                }
            }
            catch (Exception e) {
                System.out.print("Fail\n");
                validatedInput = false;
            }
            
            for (int i = 0; i < shopKeeperItems.size(); i++){
                if ((userChoice - 1) == i){
                    userItem = shopKeeperItems.get(i);
                    validatedInput = true;
                }
            }
            
            //debug  range
            if (userChoice <= shopKeeperItems.size() 
                    && userChoice > 0 
                    && validatedInput){
                //make sure user has enough money
                double playerMoney = player.getMoney().doubleValue();
                if (playerMoney < userItem.getPrice().doubleValue()){
                    System.out.print("You don't have enough money!\n");
                    validatedInput = false;
                }
            }   
            
            // validate input
            if (!validatedInput || userItem == null)
                System.out.print("\n\nINVALID INPUT, Please select an item number\n");
            
            //exit loop, user wants to go back
            if (userChoice == exitInt)
                return; 
            

                
        }
        while (userItem == null || !validatedInput);
        double itemPrice = userItem.getPrice().doubleValue();
        
        //update player money
        double playerMoney = player.getMoney().doubleValue();
        BigDecimal newPlayerMoney = new BigDecimal(playerMoney - itemPrice);
        player.setMoney(newPlayerMoney);
        
        //update shopkeeper money
        double shopKeeperMoney = shopKeeper.getMoney().doubleValue();
        BigDecimal newShopKeeperMoney = new BigDecimal(shopKeeperMoney + itemPrice);
        shopKeeper.setMoney(newShopKeeperMoney);
        
        //update inventories
        shopKeeperItems.remove(userItem);
        playerInv.addNewItem(userItem);
        
        //display something to the screen
        System.out.print("\n\nYou bought: ");
        userItem.display();
        System.out.print("\n");
        //user needs to be able to:
        /*
            -see money: displayed once? when?
            -see inventory: same as ^
            -see shop inventory: same as ^
            -choose item to buy: choose by typing item name? or map items to chars
            -see confirmation of purchase: what all should be displayed (inv, money, etc)
        */
    }
    
    public static void sell(Player player, ShopKeeper shopKeeper) {
        
        //inventories
        Inventory playerInv = player.getPlayerInventory();
        Inventory shopKeeperInv = shopKeeper.getPlayerInventory();
        ArrayList<Item> playerItems = playerInv.getInventoryItems();
        
        if (playerItems.size() <= 0){
            System.out.print("You don't have any items\n");
            return;
        }
        else
        {
            //sort items by price
            int len = playerItems.size();
            int rightVar; 
            for (int out = len; out >= 0; out--){
                for (int i = 0; i < len - 1; i++){
                    rightVar = i + 1;
                    double left = playerItems.get(i).getPrice().doubleValue();
                    double right = playerItems.get(rightVar).getPrice().doubleValue();
                    if (left < right){
                        Item temp;
                        temp = playerItems.get(i);
                        playerItems.set(i, playerItems.get(rightVar));
                        playerItems.set(rightVar, temp);
                    }
                }
            }
        }
        
        //print shopkeeper items
        System.out.print("Let's take a look at your inventory\n\n");
        int itemNum = 1;
        for (Item item : playerItems){  
            System.out.print(itemNum + ": ");
            item.display();
            itemNum++;
        } 
        System.out.print(itemNum + ": Exit\n\n");
        int exitInt = itemNum;
        
        //get user choice
        Item userItem = null;
        boolean validatedInput = true;
        do 
        {
            int userChoice = 0;
            System.out.print("What item would you like to buy?\n" + 
                    player.getName() + ": $");
            System.out.printf("%.2f", player.getMoney());
            System.out.print("\nShop Keeper: $");
            System.out.printf("%.2f", shopKeeper.getMoney());
            System.out.print("\nEnter number of the item you want to buy.\n");
            
            //get userChoice
            Scanner inFile;
            inFile = new Scanner(System.in);
            try {
                if (inFile.hasNextInt()){
                    userChoice = inFile.nextInt();
                    System.out.print(userChoice);
                } else {
                    validatedInput = false;
                }
            }
            catch (Exception e) {
                System.out.print("Fail\n");
                validatedInput = false;
            }
            
            for (int i = 0; i < playerItems.size(); i++){
                if ((userChoice - 1) == i){
                    userItem = playerItems.get(i);
                    validatedInput = true;
                }
            }
            
            //debug  range
            if (userChoice <= playerItems.size() 
                    && userChoice > 0 
                    && validatedInput){
                //make sure user has enough money
                double shopKeeperMoney = shopKeeper.getMoney().doubleValue();
                if (shopKeeperMoney < userItem.getPrice().doubleValue()){
                    System.out.print("The shop keeper is out of money!\n");
                    validatedInput = false;
                }
            }   
            
            // validate input
            if (!validatedInput || userItem == null)
                System.out.print("\n\nINVALID INPUT, Please select an item number\n");
            
            //exit loop, user wants to go back
            if (userChoice == exitInt)
                return;    
        }
        while (userItem == null || !validatedInput);
        double itemPrice = userItem.getPrice().doubleValue();
        
        //update player money
        double playerMoney = player.getMoney().doubleValue();
        BigDecimal newPlayerMoney = new BigDecimal(playerMoney + itemPrice);
        player.setMoney(newPlayerMoney);
        
        //update shopkeeper money
        double shopKeeperMoney = shopKeeper.getMoney().doubleValue();
        BigDecimal newShopKeeperMoney = new BigDecimal(shopKeeperMoney - itemPrice);
        shopKeeper.setMoney(newShopKeeperMoney);
        
        //update inventories
        playerItems.remove(userItem);
        shopKeeperInv.addNewItem(userItem);
        
        //display something to the screen
        System.out.print("\n\nYou sold: ");
        userItem.display();
        System.out.print("\n");        
        //user needs to be able to:
        /*
            -see money: displayed once? when?
            -see inventory: same as ^
            -see shop inventory: same as ^
            -choose item to sell: choose by typing item name? or map items to chars
            -see confirmation of sale: what all should be displayed (inv, money, etc)
        */

    }
    
    public static void rob(Player player, ShopKeeper shopKeeper) {
        //here we can just do a chance thing where if it fails
        //you go to jail (display jailed string, set player to dead)
        //otherwise you get a bunch of stuff 
        System.out.print(jailed);
    }
 
    public static void takeItem(Player player, ShopKeeper shopKeeper) {
        //see if you can get out of the store with an item, 
        //if you get caught, you won't be jailed, but the shopkeeper will take
        //all your money
    }
    
}