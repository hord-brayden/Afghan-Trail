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
public class NewGameView {
    
    /*
        Properties
    */
    public static String introduction = "AFGHAN TRAIL!!!!!!!!!!!!\n" +
        "You are reading some sort of really, really\n" + 
        "heroic introduction. It is moving you to tears.\n" +
        "You are considering actually moving to afghanistan \n" +
        "in efforts to make your life more like the game you are \n" +
        "about to play, but you'll settle for this...for now.\n";
    public static String namePrompt = "Name your charachter: ";

    /*
        Getters & Setters
    */
    public static String getIntroduction() {
        return introduction;
    }

    public static void setIntroduction(String introduction) {
        NewGameView.introduction = introduction;
    }

    public static String getNamePrompt() {
        return namePrompt;
    }

    public static void setNamePrompt(String namePrompt) {
        NewGameView.namePrompt = namePrompt;
    }
    
    /*
        Methods
    */
    public static char display() {
        String[] options = {
            "Banker",
            "Blacksmith",
            "Carpenter",
            "Farmer"
        }; 
        BasicMenu brokenWagonMenu = new BasicMenu(
                "Choose Character", 
                options
        );
        String optionString = brokenWagonMenu.getOptionsString();
        System.out.println(brokenWagonMenu.getMessage() + '\n');
        char userInput = BasicMenu.getUserChar(optionString);
        return userInput;
    }
}
