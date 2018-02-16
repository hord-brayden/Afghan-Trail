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

    public static void brokenWagon(Player player) {
        String prompt = "Your wagon is broken. Do you want to fix it? Y/N";
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
                    System.out.print("You're speed is up to " + 
                            player.getSpeed()+"\n");
                    if (player.getStamina() - 15 < 0)
                        player.setStamina(0);
                    else
                        player.setStamina(player.getStamina() - 5);
                }
                
                //player.inventory.setwagonParts(player.inventory.getwagonParts -5);
                
            } else {
                System.out.print("You failed to fix your wagon\n");
                noRepair(player);
            }
        } else {
            System.out.print("You don't wanna fix your wagon\n");
            noRepair(player);

        }
    }
    private static void noRepair(Player player){
        player.setSpeed(player.getSpeed() - 1);
        System.out.print("You're speed is down to " + 
                player.getSpeed() + "\n");
    }
    
}
