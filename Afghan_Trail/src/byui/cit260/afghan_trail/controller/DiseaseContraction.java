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
 * @author Brayden
 */
public class DiseaseContraction {
    
    public static void diseaseContraction(Player player) {
    
    String prompt = "You are feeling ill. Do you want to take medicine?";
    System.out.println(prompt);
    Scanner inFile;
    inFile = new Scanner(System.in);
    char userChar = inFile.next().charAt(0);
    userChar = Character.toLowerCase(userChar);
    
    if (userChar == 'W'){
    //Logic for calculating Medicine Bonus to your stamina, + Random INT
    //Also uses a large bonus modifier if you have a lot of medicine stocked up
            double healChance = player.getStamina() * 0.5;
            double healBonus = 1; // player.item.medicine * 10 
            double chanceToHeal = healBonus + healChance;            
            int num = (int) Math.ceil(Math.random() * 100);
            boolean isSuccessful = (num > chanceToHeal);

            if (isSuccessful){    
            //Sickness Cured, you recieve a bonus stamina boost for curing your illness
                    System.out.print("You are feeling better!\n");
                    player.setIsSick(false);
                    player.setStamina(player.getStamina() + 10);
                } 
            //This also exhausts medcine supply
            //player.inventory.setMedicine(player.inventory.getmedicine -1);
                
            } 
       
    else {
            System.out.print("You decide not to use any medicine\n");
          player.setIsSick(false);

        }
    }
}

