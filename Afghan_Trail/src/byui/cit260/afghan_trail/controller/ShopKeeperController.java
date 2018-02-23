/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;

import static byui.cit260.afghan_trail.controller.Game.saveGame;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.ShopKeeper;
import byui.cit260.afghan_trail.view.BasicMenu;
import byui.cit260.afghan_trail.view.ShopKeeperView;

/**
 *
 * @author rizky
 */
public class ShopKeeperController {
    public static void shopKeeper(Player player, char userChar) {
        /*
            "Buy",
            "Sell",
            "Exit store"
        */
        switch (userChar){
            //Buu
            case 'w':
                //TODO buy
                System.out.print("buy\n");
            break;

            //Sell
            case 'a':
                System.out.print("Sell\n");
            break;

            //Exit store
            case 's':
                System.out.print("Goodbye\n");
            break; 
        }
    }
}