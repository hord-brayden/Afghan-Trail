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
    public static void tryHunt(Player player){
        
        //Prompt the user and get response
        String prompt = "Looks like a good place to hunt.\n" +
                "Would you like to hunt? Y/N";
        System.out.println(prompt);
        Scanner inFile;
        inFile = new Scanner(System.in);
        char userChar = inFile.next().charAt(0);
        userChar = Character.toLowerCase(userChar);
        
        //Handle the response
        if (userChar == 'y'){
 

            do {
                //do hunt stuff
                double staminaChance = player.getStamina() * 0.6;
                double chance = 20 + staminaChance;            
                int num = (int) Math.ceil(Math.random() * 100);
                boolean isSuccessful = (num > chance);
                System.out.print("num > chance = " + 
                        num + " > " + chance + "\n");
               
                //TODO handle successful hunt
                if (isSuccessful){
                    System.out.print("Nice hit!\n");
                   
                    //setup item
                    double rand = Math.ceil(Math.random() * 5);
                    BigDecimal price = new BigDecimal(rand);
                    Item meat = new Item("Duck", "Food", price);
                    
                    Inventory playerInv = player.getPlayerInventory();
                    playerInv.addNewItem(meat);
                    System.out.print("Added Meat to Inventory\n");
                    
                } else {
                    System.out.print("You missed!\n");
                }

                //prompt for exit
                System.out.println("Continue? Y/N");
                userChar = inFile.next().charAt(0);
                userChar = Character.toLowerCase(userChar);
            } while (/*check bullets && */ userChar == 'y');
            System.out.print("Hope you enjoyed!\n");
          
        } else {
            System.out.print("Okay, maybe next time\n");
        }

    }
}
