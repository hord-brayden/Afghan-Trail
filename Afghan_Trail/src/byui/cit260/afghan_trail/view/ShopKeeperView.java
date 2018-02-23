/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

import byui.cit260.afghan_trail.model.Player;

/**
 *
 * @author rizky
 */
public class ShopKeeperView {
    
public ShopKeeperView() {
    }

    public static char display(String name) {
        String[] options = {
            "Buy",
            "Sell",
            "Exit store"
        }; 
        String msg = "Hello, " + name;
        BasicMenu shopKeeperMenu = new BasicMenu(
                msg, options   
        );
        String optionString = shopKeeperMenu.getOptionsString();
        System.out.println(shopKeeperMenu.getMessage() + '\n');
        char userInput = BasicMenu.getUserChar(optionString);
        return userInput;
    }

    
    //TODO
    //ignore()
    //useMedicine()
    //rest()
}