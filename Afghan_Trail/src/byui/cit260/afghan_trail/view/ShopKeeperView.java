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

    String[] options = {};
    String message = "";
        
    public ShopKeeperView() {
    }
    public ShopKeeperView(String[] options, String message) {
        this.options = options;
        this.message = message;    
    }   

    public static char display(String name,int progress, Player player) {
       System.out.print("What would you like to do?\n");
        System.out.print("W - Buy\n" +
                        "A - Sell\n" +
                        "S - Rob him!\n"+
                        "D - Exit store\n"+
                        ">>>\n");
       
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
                try {
                Thread.sleep(1000); 
                } catch (Exception e) {
                e.printStackTrace();
                }
                ShopKeeperView.display(name, progress, player);
            break;
            case 'a':
                System.out.print("I am sorry we only sell stuff here!\n");
                try {
                Thread.sleep(1000); 
                } catch (Exception e) {
                e.printStackTrace();
                }
                ShopKeeperView.display(name, progress, player);
            break;
            case 's':
                System.out.print("  _____                                                              _                _   _   _ \n" +
" |_   _|                                                            | |              | | | | | |\n" +
"   | |    _ __     ___    __ _   _ __    ___    ___   _ __    __ _  | |_    ___    __| | | | | |\n" +
"   | |   | '_ \\   / __|  / _` | | '__|  / __|  / _ \\ | '__|  / _` | | __|  / _ \\  / _` | | | | |\n" +
"  _| |_  | | | | | (__  | (_| | | |    | (__  |  __/ | |    | (_| | | |_  |  __/ | (_| | |_| |_|\n" +
" |_____| |_| |_|  \\___|  \\__,_| |_|     \\___|  \\___| |_|     \\__,_|  \\__|  \\___|  \\__,_| (_) (_)\n" +
"                                                                                                \n" +
"                                                                                                \n");
                try {
                Thread.sleep(1000); 
                } catch (Exception e) {
                e.printStackTrace();
                }
                System.out.print("They took $100 out of your pocket!!\n");
                try {
                Thread.sleep(1000); 
                } catch (Exception e) {
                e.printStackTrace();
                }
                ShopKeeperView.display(name, progress, player);
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
