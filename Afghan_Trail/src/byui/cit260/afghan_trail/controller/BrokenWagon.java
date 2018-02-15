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
 * @author rizky
 */
public class BrokenWagon {

    public static void BrokenWagon(Player player) {
        String prompt = "You wagon is broken. Do you want to fix it? Y/N";
        System.out.println(prompt);
        Scanner inFile;
        inFile = new Scanner(System.in);
        char userChar = inFile.next().charAt(0);
        userChar = Character.toLowerCase(userChar);
        if (userChar == 'y'){
            double staminaChance = player.getStamina() * 0.8;
            double chance = 20 + staminaChance;            
            int num = (int) Math.ceil(Math.random() * 100);
            boolean isSuccessful = (num > chance);

            if (isSuccessful){
                if (player.getStamina() + 10 > 100)
                    player.setStamina(100);
                else
                    player.setStamina(player.getStamina() - 5);
                    player.inventory.setwagonParts(player.inventory.getwagonParts -5);
                    player.setisWagonBroken(player.getisWagonBroken = false);
            } else {
                noRepair(player);
            }
        } else {
            noRepair(player);

        }
    }
    private static void noRepair(Player player){
        player.isDead = true;
    }
    
}
