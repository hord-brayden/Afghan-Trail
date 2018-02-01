/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afghan_trail;
import byui.cit260.afghan_trail.model.Player;
import byui.cit260.afghan_trail.model.Game;

/**
 *
 * @author Rizky, Brayden, Jonathan
 */
public class Afghan_Trail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //start main menu
        
        //if start game get user input
            //name
            //class
        
        //create user player class and assign name;
        Player user = new Player("Jon", 12, "baker");
        Game game = new Game();
        game.setPlayer(user);
        
        
        System.out.println(game.toString()+'\n');
    }
    
}
