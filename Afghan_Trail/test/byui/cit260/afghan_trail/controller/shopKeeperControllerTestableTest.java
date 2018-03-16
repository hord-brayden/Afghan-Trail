/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;

import byui.cit260.afghan_trail.model.Blacksmith;
import byui.cit260.afghan_trail.model.Item;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.ShopKeeper;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonsi
 */
public class shopKeeperControllerTestableTest {
    
    public shopKeeperControllerTestableTest() {
        
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
   
    /**
     * Test of buy method, of class shopKeeperControllerTestable.
     */
    @Test
    public void testBuy() {
        
        //Set up test variables
        Player player = new Blacksmith();
        BigDecimal money = new BigDecimal(75.00);
        player.setMoney(money);
        ShopKeeper shopKeeper = new ShopKeeper();
        ArrayList<Item> shopKeeperItems = new ArrayList<>();
        shopKeeperItems = shopKeeper.getPlayerInventory().getInventoryItems();
        System.out.print("shopKeeper.size(): " + shopKeeper.getPlayerInventory().getInventoryItems().size() + "\n");
        
        //sort shopkeeper items
            //sort items by price
            int len = shopKeeperItems.size();
            int rightVar; 
            for (int out = len; out >= 0; out--){
                for (int i = 0; i < len - 1; i++){
                    rightVar = i + 1;
                    double left = shopKeeperItems.get(i).getPrice().doubleValue();
                    double right = shopKeeperItems.get(rightVar).getPrice().doubleValue();
                    if (left < right){
                        Item temp;
                        temp = shopKeeperItems.get(i);
                        shopKeeperItems.set(i, shopKeeperItems.get(rightVar));
                        shopKeeperItems.set(rightVar, temp);
                    }
                }
            }
            
         
        
        //user input fakes
        int intFirst;
        char charFirst = 'a';
        boolean firstIsInt = true;
        
       
        
        /*
            COPY THESE TWO BLOCKS FOR EACH TEST TO BE ABLE TO BUILD STRING
        
        */
        //copy this to get current invetory string
        String keeperInvString = "";
        keeperInvString += "Let's take a look at the Shop Keepers inventory\n\n";
        int itemNum = 1;
        for (Item item : shopKeeperItems){  
            keeperInvString += itemNum + ": ";
            item.display();
            itemNum++;
        };
        keeperInvString += itemNum + ": Exit\n\n";
        
        //copy this to get prompt string
        String promptString = ""; 
        promptString += "What item would you like to buy?\n" + 
                player.getName() + ": $";
        promptString += String.format("%.2f", player.getMoney());
        promptString += "\nShop Keeper: $";
        promptString += String.format("%.2f", shopKeeper.getMoney());
        promptString += "\nEnter number of the item you want to buy.\n";
        
        //Test 1
        String compareString = keeperInvString + promptString +
                "Okay, comeback soon";
        intFirst = 9;
        firstIsInt = true;
        String outputString = shopKeeperControllerTestable.buy(player, shopKeeper, intFirst, charFirst, firstIsInt);
        System.out.print("shopKeeper.size(): " + shopKeeper.getPlayerInventory().getInventoryItems().size() + "\n");
        System.out.print("CompareString:\n" + compareString + "\n");
        System.out.print("outuputString:\n" + outputString);
        assertEquals(compareString, outputString);
        System.out.print("TestResult" + (compareString == outputString));
        
        //Test 2
        
    }
    
}
