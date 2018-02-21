/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.controller;

import byui.cit260.afghan_trail.view.BasicMenu;

/**
 *
 * @author jonsi
 */
public class HuntView {
    public char display() {
        String[] options = {
            "Hunt",
            "Ignore",
            "Rest"
        }; 
        BasicMenu brokenWagonMenu = new BasicMenu(
                "Looks like a good place to hunt", 
                options
        );
        String optionString = brokenWagonMenu.getOptionsString();
        System.out.println(brokenWagonMenu.getMessage() + '\n');
        char userInput = BasicMenu.getUserChar(optionString);
        return userInput;
    }
}
