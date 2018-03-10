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
    
    //default properties for all views. 
    //these should be overwritten in the views constructor
    String[] options = {"Option 1", "Option 2", "Option 3", "Option 4"}; 
    String message = "This is the default menu";
    
    //default keys can optionally be overwritten
    char[] keys = {'W', 'A', 'S', 'D', 'Q', 'E', 'Z','X','C'};
    
    BasicView(){}
    BasicView(String options[], String message){
        this.options = options;
        this.message = message;
    }
    BasicView(char[] keys){
        this.keys = keys;
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

    public char[] getKeys() {
        return keys;
    }

    public void setKeys(char[] keys) {
        this.keys = keys;
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
    
    public char getUserChar(String[] options){
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
    
    private boolean validateUserChar(int numberOfOptions, char userChar){
        userChar = Character.toUpperCase(userChar);
        for (int i = 0; i < numberOfOptions; i++){
            if (userChar == keys[i])
                return true;
        }
        return false;
    }
    
    private String buildOptionsString(String[] options){
        assert(keys.length == options.length);
        String optionsString = "";
        for (int i = 0; i < options.length; i++){
            String line = keys[i] + " - " + options[i] + "\n";
            optionsString += line;
        }
        optionsString += ">>>";
        return optionsString;
    }
    
    protected int getFunctionNumberFromChar(char userResponse){
        int functionNum = 0;
        userResponse = Character.toUpperCase(userResponse);
        for (int i = 0; i < keys.length; i++){
            if (userResponse == keys[i]){
                functionNum = i;
                break;
            }
        }
        return functionNum;
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
