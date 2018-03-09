/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.view.BasicView;
import byui.cit260.afghan_trail.model.Player;
import java.lang.Math;

/**
 *
 * @author rizky
 */
public class BrokenWagon {

    public static void fix(Player player) {

        //first check if player even has parts
        boolean hasParts = player.getPlayerInventory().hasItemType("Parts");
        if (!hasParts){
            System.out.print("Oh no! You don't have parts!");
            noRepair(player);
        }
        
        //otherwise calculate the odds of the fix working
        double staminaChance = player.getStamina() * 0.8;
        double chance = 20 + staminaChance;            
        int num = (int) Math.ceil(Math.random() * 100);
        boolean isSuccessful = (num > chance);

        if (isSuccessful){

            int rand = (int) Math.ceil(Math.random() * 2);

            if (rand == 1){
                //wagon fixed
                System.out.print("Your wagon is fixed\n");
                player.setIsWagonBroken(false);
                if (player.getStamina() - 5 < 0)
                    player.setStamina(0);
                else
                    player.setStamina(player.getStamina() - 5);
            } else {
                
                //wagon upgraded
                System.out.print("Your wagon has been upgraded\n");
                player.setSpeed(player.getSpeed() + 1);
                
                //display speed
                System.out.print("" +
                        "You're speed is up to " + 
                        player.getAdjustedSpeed()+"\n");
                
                player.setStamina(player.getStamina() - 5);
            }
        

            Item removedItem = player.getPlayerInventory().removeItemOfType("Parts");
            System.out.print("Removed " + removedItem.getName() + 
            " from player inventory\n"); 
                
        } else {
            System.out.print("You failed to fix your wagon\n");
            noRepair(player);
        }
    }
    
    public static void ignore(Player player){
        System.out.print("You don't wanna fix your wagon?\n");
        noRepair(player);
    }
    
    public static void rest(Player player){
        System.out.print("You don't wanna fix your wagon?\n");
        noRepair(player);
    }
    
    private static void noRepair(Player player){
        player.setIsWagonBroken(true);
        System.out.print("You're speed is down to " + 
                player.getAdjustedSpeed() + "\n");
    }
    
    public static boolean brokenWagon(
            long stamina, 
            int wagonParts, 
            int progress) 
    {
        //if they don't have enough parts return false
        
        if (wagonParts > 5 && stamina > 5)
        {
            double baseChance = 0.1;
            double staminaChance = stamina * baseChance;
            double wagonChance = wagonParts * baseChance;
            double progressChance = progress * baseChance;
            double total = staminaChance + wagonChance + progressChance;
            double average = total / 3;
            if (average > 6)
                return true;   
        }
        return false;
    }
    
}
