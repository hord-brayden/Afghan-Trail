/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.controller.Game;
import byui.cit260.afghan_trail.model.Player;
import java.util.Scanner;

/**
 *
 * @author jonsi
 */
public abstract class BasicView implements BasicViewInterface {
    
    String[] options = {}; 
    String message;
    static char[] keys = {'W', 'A', 'S', 'D', 'Q', 'E', 'Z','X','C'};
    
    BasicView(){}
    BasicView(String options[], String message){
        this.options = options;
        this.message = message;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public void display(Game game, Player player) {
        System.out.println(message + '\n');
        int opLen = options.length;
        char lastKeyChar = keys[opLen - 1];
        lastKeyChar = Character.toLowerCase(lastKeyChar);
        char userInput = lastKeyChar;
        do {
            userInput = getUserChar(options);
            if (userInput == lastKeyChar)
                this.displayHelp();
        } while (userInput == lastKeyChar);
        
        doAction(options, userInput, game, player);
    }
    
    public static char getUserChar(String[] options){
        int numOfOptions = options.length;
        String menuString = buildOptionsString(options);
        System.out.println(menuString);
        Scanner inFile;
        inFile = new Scanner(System.in);
        char userChar;
        boolean validChar = false;
        do {
            userChar = inFile.next().charAt(0);
            validChar = validateUserChar(numOfOptions, userChar);
            if (!validChar)
                System.out.println("INVALID COMMAND, TRY AGAIN");
        } while (!validChar);
        return userChar;
    }
    
    private static boolean validateUserChar(int numberOfOptions, char userChar){
        userChar = Character.toUpperCase(userChar);
        for (int i = 0; i < numberOfOptions; i++){
            if (userChar == keys[i])
                return true;
        }
        return false;
    }
    
    private static String buildOptionsString(String[] options){
        assert(keys.length == options.length);
        String optionsString = "";
        for (int i = 0; i < options.length; i++){
            String line = keys[i] + " - " + options[i] + "\n";
            optionsString += line;
        }
        optionsString += ">>>";
        return optionsString;
    }
    
    public static String getUserString(String prompt){
        System.out.println(prompt);
        Scanner inFile;
        inFile = new Scanner(System.in);
        String userString;
        boolean goodString = true;
        do {
            userString = inFile.nextLine();
            userString = userString.trim();
        } while (!goodString);
        return userString;
    }
}
