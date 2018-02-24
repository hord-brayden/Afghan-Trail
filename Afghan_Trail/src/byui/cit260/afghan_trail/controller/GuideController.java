/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;

/**
 *
 * @author jonsi
 */
public class GuideController {
    public static void guideController(char userChar){
        switch(userChar){
            case 'w':
                //Goal of the Game
                showGoal();
                break;
            case 'a':
                //Show Start
                showStart();
                break;
            case 's':
                //Show Load
                showLoad();
                break;
            case 'd':
                //Show Exit
                showExit();
                break;
        }
    }
    
    public static void showGoal(){
        
        System.out.print("You are a refugee fleeing from the Al Qaeda"
                + "\nextremists in Southern Afghanistan! In this journey you'll"
                + "\nneed to procure goods, and make a journey throughout the"
                + "\ncountryside of Afghanistan. You will meet local shopkeepers"
                + "\nflee from the Taliban, brigands, and also fend off"
                + "\nmicro-biological attackers! This action packed text-based"
                + "\ngame will have you sitting on the edge of your seat as you"
                + "\nmake your way towards the southern border of the more"
                + "\ncivilized and policed country of Iran. As a refugee,"
                + "\nyou'll need to avoid conflict from NATO forces and their"
                + "\nquestioning, in addition to circumventing some of the"
                + "\nlargest provinces in Afghanistan!"
                + "\nGood luck, and always remember "
                + "\n\t- 'Allah Akbar!!' !\n");
    }
    
    public static void showStart(){
        System.out.print("Pressing W - Start Game on the main menu will\n" + 
                "start a new game.\n");
    }
    
    public static void showLoad(){
        System.out.print("Pressing A - Load Game on the main menu will allow\n" +
                "you to load a previously saved game.\n");
    } 
    
    public static void showExit(){
        System.out.print("Pressing S - Exit on the main menu will exit the game\n");
    } 
}
