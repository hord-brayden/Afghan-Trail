/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;
import byui.cit260.afghan_trail.model.Player;
import java.lang.Math;
import java.util.Scanner;

/**
 *
 * @author jonsi
 */
public class BeingAttacked {
    
    public static void attacked(Player player){
        
        //let user decide how to respond
        String prompt = "You are being attacked. Fight Back? Y/N";
        System.out.println(prompt);
        Scanner inFile;
        inFile = new Scanner(System.in);
        char userChar = inFile.next().charAt(0);
        userChar = Character.toLowerCase(userChar);
        
        if (userChar == 'y'){
            double staminaChance = player.getStamina() * 0.6;
            double chance = 20 + staminaChance;
            int num = (int) Math.ceil(Math.random() * 100);
            boolean isSuccessful = (num > chance);
            
            if (isSuccessful){
                if (player.getStamina() + 10 > 100)
                    player.setStamina(100);
                else
                    player.setStamina(player.getStamina() + 10);
            } else {
                surrender(player, 5);
            }
        } else {
            surrender(player, 3);
        }
         
    }
    
    private static void surrender(Player player, int deductionDegree){
        
        //take 1-deductionDegree out items out of player inventory
        int num = (int) Math.ceil(Math.random() * deductionDegree);
        for (int i = 0; i < num; i++)
            System.out.print("remove item from inventory\n");
        
        //reduce thier stamina by 5
        if (player.getStamina() - 5 < 0)
            player.setStamina(0);
        else
            player.setStamina(player.getStamina() - 5);
    }
    
}
