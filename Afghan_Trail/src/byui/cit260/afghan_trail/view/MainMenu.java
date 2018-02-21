/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

/**
 *
 * @author jonsi
 */
public class MainMenu extends BasicMenu {
    
    
    
    public MainMenu (){
        setMessage("Welcome to Afghan Tails Text Adventure\n");
        String options[] = {"Start Game", "Load Game", "Exit", "Guide"};
        //String opString = buildOptionsString(options);
       // setOptionsString(opString);
    }
    
    public static String mainMenu = "" +
        "   W - Start Game\n" +
        "   A - Load Game\n"  +
        "   S - Exit\n"       +
        "   D - Guide\n"      +
        "   >";
    
    
    public static void gameWin(){
        System.out.println("YOU WON!!!");
    }
    
    public static void gameLose(){
        System.out.println("YOU ARE DEAD");
    }
}
