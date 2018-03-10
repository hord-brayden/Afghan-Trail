/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;

import static byui.cit260.afghan_trail.controller.Game.saveGame;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.ShopKeeper;
import byui.cit260.afghan_trail.view.BasicView;
import byui.cit260.afghan_trail.view.ShopKeeperView;

/**
 *
 * @author rizky
 */
public class ShopKeeperController {
        public static String jailed = "  _____                                                              _                _   _   _ \n" +
" |_   _|                                                            | |              | | | | | |\n" +
"   | |    _ __     ___    __ _   _ __    ___    ___   _ __    __ _  | |_    ___    __| | | | | |\n" +
"   | |   | '_ \\   / __|  / _` | | '__|  / __|  / _ \\ | '__|  / _` | | __|  / _ \\  / _` | | | | |\n" +
"  _| |_  | | | | | (__  | (_| | | |    | (__  |  __/ | |    | (_| | | |_  |  __/ | (_| | |_| |_|\n" +
" |_____| |_| |_|  \\___|  \\__,_| |_|     \\___|  \\___| |_|     \\__,_|  \\__|  \\___|  \\__,_| (_) (_)\n" +
"                                                                                                \n" +
"                                                                                                \n";
    
    public static void buy(Player player, ShopKeeper shopKeeper) {
        System.out.print("Let's take a look at the ShopKeepers inventory\n\n");
        shopKeeper.getPlayerInventory().display();
        System.out.print("\n");
    }
    
    public static void sell(Player player, ShopKeeper shopKeeper) {
        System.out.print("Let's take a look at your inventory\n\n");
        player.getPlayerInventory().display();
        System.out.print("\n");
    }
    
    public static void rob(Player player, ShopKeeper shopKeeper) {
        //here we can just do a chance thing where if it fails
        //you go to jail (display jailed string, set player to dead)
        //otherwise you get a bunch of stuff 
        System.out.print(jailed);
    }
 
    public static void takeItem(Player player, ShopKeeper shopKeeper) {
        //see if you can get out of the store with an item, 
        //if you get caught, you won't be jailed, but the shopkeeper will take
        //all your money
    }
    
}