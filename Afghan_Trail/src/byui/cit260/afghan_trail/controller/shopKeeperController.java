/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;

import static byui.cit260.afghan_trail.controller.Game.saveGame;
import byui.cit260.afghan_trail.exceptions.shopKeeperControllerException;
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
public class shopKeeperController {
        public static String jailed = "  _____                                                              _                _   _   _ \n" +
" |_   _|                                                            | |              | | | | | |\n" +
"   | |    _ __     ___    __ _   _ __    ___    ___   _ __    __ _  | |_    ___    __| | | | | |\n" +
"   | |   | '_ \\   / __|  / _` | | '__|  / __|  / _ \\ | '__|  / _` | | __|  / _ \\  / _` | | | | |\n" +
"  _| |_  | | | | | (__  | (_| | | |    | (__  |  __/ | |    | (_| | | |_  |  __/ | (_| | |_| |_|\n" +
" |_____| |_| |_|  \\___|  \\__,_| |_|     \\___|  \\___| |_|     \\__,_|  \\__|  \\___|  \\__,_| (_) (_)\n" +
"                                                                                                \n" +
"                                                                                                \n";
    
    public static boolean buy(Player player, ShopKeeper shopKeeper) throws shopKeeperControllerException {
        
        //inventories
        Inventory playerInv = player.getPlayerInventory();
        Inventory shopKeeperInv = shopKeeper.getPlayerInventory();
        ArrayList<Item> shopKeeperItems = shopKeeperInv.getInventoryItems();
        
        if (shopKeeperItems.size() <= 0){
            System.out.print("Shopkeeper doesn't have any items\n");
            return false;
        } else {
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
               
        System.out.print("What item would you like to buy?\n" + 
                player.getName() + ": $");
        System.out.printf("%.2f", player.getMoney());
        System.out.print("\nShop Keeper: $");
        System.out.printf("%.2f", shopKeeper.getMoney());
        System.out.print("\nEnter number of the item you want to buy.\n");

        //get userChoice
        int userChoice = getUserInput();

        Item userItem = null;
        for (int i = 0; i < shopKeeperItems.size(); i++){
            if ((userChoice - 1) == i){
                userItem = shopKeeperItems.get(i);
            }
        }

        //debug  range
        if (userChoice <= shopKeeperItems.size() && userChoice > 0){
            //make sure user has enough money
            double playerMoney = player.getMoney().doubleValue();
            if (playerMoney < userItem.getPrice().doubleValue()){
                throw new shopKeeperControllerException("You don't have enough money!\n");
            }
        }
        else if (userChoice != exitInt){
            String err = "\n\nINVALID INPUT, please select an item number " +
                    "between 1 - " + shopKeeperItems.size() + "\n" +
                    "or choose " + exitInt + " to exit\n";
            throw new shopKeeperControllerException(err);
        } else {
            System.out.print("Okay, comeback soon\n");
            return false; 
        }
            
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
        shopKeeper.getPlayerInventory().setInventoryItems(shopKeeperItems);
        playerInv.addNewItem(userItem);
        
        //display something to the screen
        System.out.print("\n\nYou bought: ");
        userItem.display();
        System.out.print("\n");
        return true;
    }
    
    public static boolean sell(Player player, ShopKeeper shopKeeper) 
            throws shopKeeperControllerException {
        
        //inventories
        Inventory playerInv = player.getPlayerInventory();
        Inventory shopKeeperInv = shopKeeper.getPlayerInventory();
        ArrayList<Item> playerItems = playerInv.getInventoryItems();

        if (playerItems.size() <= 0){
            System.out.print("You don't have any items\n");
            return false;
        } else {
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

        System.out.print("What item would you like to sell?\n" + 
                player.getName() + ": $");
        System.out.printf("%.2f", player.getMoney());
        System.out.print("\nShop Keeper: $");
        System.out.printf("%.2f", shopKeeper.getMoney());
        System.out.print("\nEnter number of the item you want to sell.\n");

        //get userChoice
        int userChoice = getUserInput(); 

        Item userItem = null;
        for (int i = 0; i < playerItems.size(); i++){
            if ((userChoice - 1) == i){
                userItem = playerItems.get(i);
            }
        }

        //debug  range
        if (userChoice <= playerItems.size() && userChoice > 0){
            //make sure user has enough money
            double shopKeeperMoney = shopKeeper.getMoney().doubleValue();
            if (shopKeeperMoney < userItem.getPrice().doubleValue()){
                throw new shopKeeperControllerException("The shop keeper is out of money!\n");
            }
        }   
        else if (userChoice != exitInt){
            String err = "\n\nINVALID INPUT, please select an item number " +
                    "between 1 - " + playerItems.size() + "\n";
            throw new shopKeeperControllerException(err);
        } else {
            System.out.print("Okay, come back soon\n");
            return false; 
        }
        

        //make adjustments to shopkeeper and player  
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
        return true;
    }
    
    public static boolean rob(Player player, ShopKeeper shopKeeper) throws shopKeeperControllerException, Throwable {

        Inventory shopKeeperInv = shopKeeper.getPlayerInventory();
        ArrayList<Item> shopKeeperItems = shopKeeperInv.getInventoryItems();
        
        int userChoice = getUserInput();
        if (shopKeeperItems.size() == 0){
            throw new shopKeeperControllerException("\nShop Keeper is all out of items\n"); 
        } else if(userChoice > 5 || userChoice <= 0) {
            throw new shopKeeperControllerException("Please enter a valid number, between 1 - 5\n");
        } else{
            System.out.print("\n\nHow many items do you think you can take? 1-5\n");
            
            runRisk(player, shopKeeper, userChoice);
            if (player.isIsDead() || shopKeeperItems.size() == 0)
                return false;
            else {
                System.out.print("\n\nDo you want to keep taking things? Y\\N");
                char userChar = getUserChar();
                if (userChar == 'y')
                    return true;
                else
                    return false;
            }
        }
    }
 
    private static void robSuccess(Player player, ShopKeeper shopKeeper, int items){
        
        // get variables
        Inventory playerInv = player.getPlayerInventory();
        Inventory shopKeeperInv = shopKeeper.getPlayerInventory();
        ArrayList<Item> shopKeeperItems = shopKeeperInv.getInventoryItems();
        
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

        
        ArrayList<Item> splendor = new ArrayList<Item>();
            
        //pass items to player
        for (int i = 0; i < items; i++){
            if (shopKeeperItems.size() > i){
                Item item = shopKeeperItems.get(i);
                playerInv.addNewItem(item);
                shopKeeperInv.removeItem(item);
                splendor.add(item);
            } else {
                System.out.print("Shop keeper is out of items\n");
                break;
            }
        }
        
        //display splendor
        System.out.print("You got: \n");
        for (Item item : splendor){
            item.display();
        }
        System.out.print('\n');
    } 
    
    private static void runRisk(Player player, ShopKeeper shopKeeper, int risk){
        int rand = (int) Math.ceil(Math.random() * 25);
        if (rand > risk){
            player.setIsDead(true);
            System.out.print(jailed);
        }
        else{
            robSuccess(player, shopKeeper, risk); 
        }
    }
    
    private static int getUserInput() throws NumberFormatException{
        Scanner inFile;
        inFile = new Scanner(System.in);
        int userChoice = 0;
        userChoice = Integer.parseInt(inFile.next());
        return userChoice;
    }
    
    private static char getUserChar() throws Throwable {
        Scanner inFile;
        inFile = new Scanner(System.in);
        char userChoice;
        do {
            userChoice = inFile.next().charAt(0);
            userChoice = Character.toLowerCase(userChoice);
        } while (userChoice != 'y' && userChoice != 'n');

        return userChoice;
    }
}