/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

import java.util.Scanner;

/**
 *
 * @author jonsi
 */
public class BasicMenu {
    
    public BasicMenu(){
        this.optionsString = buildOptionsString(options);
    }
    
    public BasicMenu(String message, String options[]){
        this.message = message;
        this.optionsString = buildOptionsString(options);
    }
    
    private static String message;
    public String[] options = {
        "Start Game",
        "Load Game",
        "Exit",
        "Guide"
    }; 
    final private char[] keys = {'W', 'A', 'S', 'D'};
    private String optionsString;

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        BasicMenu.message = message;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptionsString(String optionsString) {
        this.optionsString = optionsString;
    }
    
    public String getOptionsString(){
        return this.optionsString;
    }
    
    
    
    
    
    private String buildOptionsString(String[] options){
        assert(keys.length == options.length);
        String optionsString = "";
        for (int i = 0; i < options.length; i++){
            String line = "  " + keys[i] + " - " + options[i] + "\n";
            optionsString += line;
        }
        optionsString += "  >";
        return optionsString;
    }
    
    public static char getUserChar(String prompt){
        System.out.println(prompt);
        Scanner inFile;
        inFile = new Scanner(System.in);
        char userChar = inFile.next().charAt(0);
        userChar = Character.toLowerCase(userChar);
        return userChar;
    }
    
    public static String getUserString(String prompt){
        System.out.println(prompt);
        Scanner inFile;
        inFile = new Scanner(System.in);
        String userString = inFile.nextLine();
        return userString;
    }
}
