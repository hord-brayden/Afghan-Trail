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

/**
 *
 * @author jonsi
 */
public class Hunt {
    public static void hunt(Player player){

        // continue input stuff
        Scanner inFile;
        inFile = new Scanner(System.in);
        char userChar;
        
        // loops so player can keep hunting a while
        do {
            
            //check if they have ammo
            boolean hasAmmo = player.getPlayerInventory().hasItemType("Ammo");
            if (!hasAmmo){
                System.out.print("Looks like you are out of ammo!\n");
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
                System.out.print("Added Meat to Inventory\n");                    
            }
            
            //remove some ammo
            Item removedItem = player.getPlayerInventory().removeItemOfType("Ammo");
            System.out.print("Removed " + removedItem.getName() + 
            " from player inventory\n"); 
            
            //hunting lowers player stamina
            player.setStamina(player.getStamina() - 5);
            
            //prompt for exit
            System.out.println("Continue? Y/N");
            userChar = inFile.next().charAt(0);
            userChar = Character.toLowerCase(userChar);
        } while (/*check bullets && */ userChar == 'y');
        System.out.print("Hope you enjoyed!\n");

    }
    
    public static Item tryHunt(long stamina, int chance, double money){
        Item item = null;
        
        //negative values fail
        if (stamina < 0 || chance < 0 || money < 0)
            return item;
        
        //do hunt stuff
        double modifiedChance = chance * 0.6;
        double cutOff = 100 - (20 + modifiedChance);     
        boolean isSuccessful = (stamina > cutOff);
        
        /* DEBUG HUNT STUFF
        System.out.print("modifiedChance = " + modifiedChance + "\n");
        System.out.print("cutOff = " + cutOff + "\n");
        System.out.print("(stamina > cutOff) = (" + 
                stamina  + " > " + cutOff + ")\n");
        System.out.print("isSuccessful = " + isSuccessful + "\n");
        */
        
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
        player.setStamina(player.getStamina() + 3);
        System.out.print("Stamina increased to " + 
                player.getStamina() + "\n");
    }
    
    
}
