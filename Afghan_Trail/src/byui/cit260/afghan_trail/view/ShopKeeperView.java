/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

import byui.cit260.afghan_trail.controller.Game;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.view.EnterTownView;
import java.util.Scanner;

/**
 *
 * @author rizky
 */
public class ShopKeeperView {

public ShopKeeperView() {
    }
   

    public static char display(String name,int progress, Player player) {
       System.out.print("W - Buy\n" +
                        "A - Sell\n" +
                        "S - Rob him!\n"+
                        "D - Exit store\n");
       
    String invalidOptionMsg = "INVALID COMMAND, TRY AGAIN";

       Scanner inFile;
        inFile = new Scanner(System.in);
        char userChar;
        boolean wasORd = false;
        do {
            userChar = inFile.next().charAt(0);
            userChar = Character.toLowerCase(userChar);
            if (userChar == 'w' || 
                userChar == 'a' || 
                userChar == 's' || 
                userChar == 'd')
                wasORd = true;
            else
                System.out.println(invalidOptionMsg);
        } while (!wasORd);
        switch(userChar){
            case 'w':
                System.out.print("I am sorry we are sold out!\n");
            break;
            case 'a':
                System.out.print("I am sorry we only sell stuff here!\n");
            break;
            case 's':
                System.out.print("Get out of here!\n");
            break;
            case 'd':
                //int progress = Game.getProgress();
               
                EnterTownView.display(progress, player);
            break;
        }
                
    
    //TODO
    //ignore()
    //useMedicine()
    //rest()
    return userChar;
}
}
