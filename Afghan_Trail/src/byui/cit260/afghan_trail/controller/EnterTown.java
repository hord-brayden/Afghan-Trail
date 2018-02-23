/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;
import static byui.cit260.afghan_trail.controller.Game.saveGame;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.ShopKeeper;
import byui.cit260.afghan_trail.view.ShopKeeperView;

/**
 *
 * @author jonsi
 */
public class EnterTown {
    public static void enterTown(Player player, int progress, char userChar){
          /* "Continue",
            "Map",
            "Talk to shopkeeper",
            "Rest and Save game"
            */
        switch (userChar){
            //Continue
            case 'w':
                //TODO see how to handle continue via testing
                System.out.print("Leaving town...\n");
            break;

            //Map
            case 'a':
                String mapString = Map.displayMap(progress);
                System.out.print(mapString);
            break;

            //Talk to shopkeeper
            case 's':
               char shopKeeperChar = ShopKeeperView.display(player.getName());
               ShopKeeperController.shopKeeper(player, shopKeeperChar);
            break; 
            
            case 'd':
                Game.saveGame();
            break;
        }
    }
}

