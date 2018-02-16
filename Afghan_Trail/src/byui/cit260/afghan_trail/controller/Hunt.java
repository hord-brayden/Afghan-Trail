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
    public static void promptHunt(Player player){
        
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
                
                //prepare method variables
                int chance = (int) Math.ceil(Math.random() * 100);
                long stamina = player.getStamina();
                double money = Math.ceil(Math.random() * 5);
                
                //try hunt method
                Item huntReturns = tryHunt(stamina, chance, money);
                
                //give the spoils to the victor
                if (huntReturns != null){
                    Inventory playerInv = player.getPlayerInventory();
                    playerInv.addNewItem(huntReturns);
                    System.out.print("Added Meat to Inventory\n");                    
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
    
    public static Item tryHunt(long stamina, int chance, double money){
        Item item = null;
        
        //negative values fail
        if (stamina < 0 || chance < 0 || money < 0)
            return item;
        
        //do hunt stuff
        double modifiedChance = chance * 0.6;
        double cutOff = 100 - (20 + modifiedChance);     
        boolean isSuccessful = (stamina > cutOff);

        //handle successful hunt
        if (isSuccessful){
            System.out.print("Nice hit!\n");

            //setup item
            BigDecimal price = new BigDecimal(money);
            item = new Item("Duck", "Food", price);
            return item;
        } else {
            System.out.print("You missed!\n");
        }
        return item;
    }
    
    
}
