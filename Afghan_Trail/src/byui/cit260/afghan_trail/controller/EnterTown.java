/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.ShopKeeper;

/**
 *
 * @author jonsi
 */
public class EnterTown {
    public static void playerEntersTown(Player player, int progress){
        String townName = "a town";
        switch (progress){
            case 0:
                townName = "Kandahar";
                break;
            case 5:
                townName = "Kabul";
                break;
            case 10:
                townName = "Mazar-i-Sharif";
                break;
            case 15: 
                townName = "Maymana";
                break;
            case 20:
                townName = "Herat";
                break;
            default:
                townName = "a town";
        }
        System.out.print("Player has entered " + townName + "\n");
        
        //TODO
        //Allow user to save
        //Save & quit
        //talk to shopKeeper
        
    }
    public static boolean playerEntersTown(int healthPoints, int progress) {
        if (healthPoints > 0 && progress < 25) {
            String townName = "a town";
        switch (progress){
            case 0:
                townName = "Kandahar";
                break;
            case 5:
                townName = "Kabul";
                break;
            case 10:
                townName = "Mazar-i-Sharif";
                break;
            case 15: 
                townName = "Maymana";
                break;
            case 20:
                townName = "Herat";
                break;
            default:
                townName = "a town";
                System.out.print("Player is in the wilderness\n");
        return true;
               
        }
        System.out.print("Player has entered " + townName + "\n");
        return true;
        } else {
            System.out.print("Error!\n");

        }
        return false;
}
}

