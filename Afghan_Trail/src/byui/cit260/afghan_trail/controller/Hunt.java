/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.model.Inventory;
import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;
import java.util.Iterator;

/**
 *
 * @author jonsi
 */
public class Hunt {
    
    private static int maxHunt = 12;
    
    public static void hunt(Player player){

        // continue input stuff
        Scanner inFile;
        inFile = new Scanner(System.in);
        char userChar;
        
        // loops so player can keep hunting a while
        ArrayList<Item> huntSummary = new ArrayList<Item>(12);
        do {
            
            //check if they have ammo
            boolean hasAmmo = player.getPlayerInventory().hasItemType("Ammo");
            if (!hasAmmo){
                System.out.print("Looks like you are out of ammo!\n");
                if(huntSummary.size() > 0)
                    reportSummary(huntSummary, "Any way, Here is what you got:");
                return;
            }
            
            //prepare method variables
            int chance = (int) Math.ceil(Math.random() * 100);
            long stamina = player.getStamina();
            double money = Math.ceil(Math.random() * 5);

            //try hunt method
            //System.out.print(stamina + ", " + chance + ", " + money + "\n");
            Item huntReturns = tryHunt(stamina, chance, money);

            //give the spoils to the victor
            if (huntReturns != null){
                Inventory playerInv = player.getPlayerInventory();
                playerInv.addNewItem(huntReturns);
                huntSummary.add(huntReturns);
                if (huntSummary.size() == maxHunt){
                    System.out.print("It's getting dark, better keep moving,\n");
                    reportSummary(huntSummary, "but real quick, take a look at what you got:");
                    return;
                }
                System.out.print("Added Meat to Inventory\n");                    
            }
            
            //remove some ammo
            Item removedItem = player.getPlayerInventory().removeItemOfType("Ammo");
            System.out.print("Removed " + removedItem.getName() + 
            " from player inventory\n"); 
            
            //hunting lowers player stamina
            player.setStamina(player.getStamina() - 5);
            
            //prompt for exit
            do {
                System.out.println("Continue? Y/N");
                userChar = inFile.next().charAt(0);
                userChar = Character.toLowerCase(userChar);
                if (userChar != 'y' && userChar != 'n')
                    System.out.println("INVALID INPUT\n");
            } while (userChar != 'y' && userChar != 'n');
        } while (userChar == 'y');
        reportSummary(huntSummary, "Great Job. Here is what you got:");

    }
    
    public static Item tryHunt(long stamina, int chance, double money){
        Item item = null;
        
        //negative values fail
        if (stamina < 0 || chance < 0 || money < 0)
            return item;
        
        /* Explanation of Logic
           chance will be a number between 0 & 100
           cutoff is the lowest your stamina can be and still hunt
           chance effects cutoff in this fashion (when modifier = 0.6)
           if chance = 100, cutoff = 50
           if chance = 80,  cutoff = 60
           if chance = 20,  cutoff = 90
           if chance = 0,   cutoff = 100
        */
        
        //do hunt stuff
        double modifier = 0.6;
        double modifiedChance = chance * modifier;
        double cutOff = 100 - modifiedChance;     
        boolean isSuccessful = (stamina > cutOff);
        
         //DEBUG HUNT STUFF
        System.out.print("modifiedChance = " + modifiedChance + "\n");
        System.out.print("cutOff = " + cutOff + "\n");
        System.out.print("(stamina > cutOff) = (" + 
                stamina  + " > " + cutOff + ")\n");
        System.out.print("isSuccessful = " + isSuccessful + "\n");
        
        
        //handle successful hunt
        if (isSuccessful){
            System.out.print("Nice hit!\n");

            //setup item
            BigDecimal price = new BigDecimal(money);
            item = new Item("Duck", 1, price);
            return item;
        } else {
            System.out.print("You missed!\n");
        }
        return item;
    }
    
    public static void rest(Player player){
        player.setResting(true);
        System.out.print("Player will be rested up soon\n");
        
    }
    
    public static void ignore(Player player){
        System.out.print("Maybe next time\n");
    }
    
    private static void reportSummary(ArrayList<Item> huntSummary, String msg){
        
        System.out.print(msg + "\n");
        Iterator<Item> iterator = huntSummary.iterator();
        while (iterator.hasNext()) {
            Item thisItem = iterator.next();
            thisItem.display();
        }
    }
}
