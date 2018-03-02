/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;
import byui.cit260.afghan_trail.model.Inventory;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.Item;
import java.lang.Math;
import java.util.Scanner;

/**
 *
 * @author jonsi
 */
public class BeingAttacked {
    
    public static String helpMsg = "Attack to defend yourself";
    
    public static void fightBack(Player player){
        Scanner inFile;
        inFile = new Scanner(System.in);

        //chance logic
        double staminaChance = player.getStamina() * 0.6;
        double chance = 20 + staminaChance;
        int num = (int) Math.ceil(Math.random() * 100);
        boolean isSuccessful = (num > chance);

        if (isSuccessful){
            System.out.print("You beat the bad guys!\n");
            if (player.getStamina() + 10 > 100)
                player.setStamina(100);
            else
                player.setStamina(player.getStamina() + 10);
            System.out.print("Your stamina is " +
            player.getStamina() + "\n");
        } else {
            loseFight(player, 5);
        }
    }
    
    public static void ignore(Player player){
        loseFight(player, 3);
    }
    
    public static void rest(Player player){
        loseFight(player, 3);
    }
    
    
    
    private static void loseFight(Player player, int deductionDegree){
        System.out.print("You have been beaten and robbed\n");
        
        //take 1-deductionDegree out items out of player inventory
        int num = (int) Math.ceil(Math.random() * deductionDegree);
        for (int i = 0; i < num; i++){
            Inventory playerInv = player.getPlayerInventory();
            Item removedItem = playerInv.removeRandomItem();
            if (removedItem != null){
                System.out.print("Removed " + removedItem.getName() + 
                        " from player inventory\n");   
            } else {
                System.out.print("Inventory is Empty");
                return;
            }
        }
        //reduce thier stamina by 5
        if (player.getStamina() - 5 < 0)
            player.setStamina(0);
        else
            player.setStamina(player.getStamina() - 5);
    }

   public static boolean attacked(int stamina, int progression, int bullets) {
       if (stamina > 5 && bullets > 5) {
           if (progression % 5 != 0) {
                double staminaChance = stamina * 0.6;
                double chance = 20 + staminaChance;
                int num = 90;
                boolean isSuccessful = (num > chance);
                return isSuccessful;
           }
           else 
               return false;
       } else 
           return false;
   }
}
   



   

            
       
   
 
  
