/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;
import byui.cit260.afghan_trail.exceptions.BeingAttackedException;
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
    
    public static void fightBack(Player player) throws BeingAttackedException {

        //chance logic
        long stamina = player.getStamina();
        if (stamina > 100 || stamina < 0)
            throw new BeingAttackedException("Invalid Stamina");
        
        
        double staminaChance = stamina * 0.6;
        double chance = 20 + staminaChance;
        String numStr = Double.toString(Math.ceil(Math.random() * 100));
        double num = Double.parseDouble(numStr);
        boolean isSuccessful = (num > chance);

        if (isSuccessful){
            System.out.print("You beat the bad guys!\n");
            player.setStamina(player.getStamina() + 10);
            System.out.print("Your stamina is " +
            player.getStamina() + "\n");
        } else {
            loseFight(player, 5);
        }
    }
    
    public static void runAway(Player player) throws BeingAttackedException {
        System.out.print("You are attempting to run away...");

        long stamina = player.getStamina();
        if (stamina > 100 || stamina < 0)
            throw new BeingAttackedException("Invalid Stamina");
        
        //chance logic
        double staminaChance = stamina * 0.7;
        double chance = 20 + staminaChance;
        int num = (int) Math.ceil(Math.random() * 100);
        boolean isSuccessful = (num > chance);
        
        if (isSuccessful){
            System.out.print("You out ran them!\n" + 
                    "Better catch your breath\n");
            player.setStamina(player.getStamina() - 10);
            System.out.print("Your stamina is " +
            player.getStamina() + "\n");
        } else {
            System.out.print("You couldn't quite ditch 'em\n");
            loseFight(player, 5);
        }
    }
    
    public static void beg(Player player) throws BeingAttackedException {
        System.out.print("You start begging for your life...");

        long stamina = player.getStamina();
        if (stamina > 100 || stamina < 0)
            throw new BeingAttackedException("Invalid Stamina");
        
        //chance logic
        double staminaChance = stamina * 0.7;
        double chance = 20 + staminaChance;
        int num = (int) Math.ceil(Math.random() * 100);
        boolean isSuccessful = (num > chance);
        
        if (isSuccessful){
            System.out.print("Somehow it worked!\n" + 
                    "The only thing you lost is a little pride\n");
        } else {
            System.out.print("The thugs aren't feeling merciful today\n");
            loseFight(player, 6);
        }
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

    //for class testing
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
   



   

            
       
   
 
  
