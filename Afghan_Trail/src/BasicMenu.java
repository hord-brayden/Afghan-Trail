/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author jonsi
 */
public class BasicMenu {
   
    private static String message;
    private String[] options = {
        "Start Game",
        "Load Game",
        "Exit",
        "Guide"
    }; 
    final private char[] keys = {'W', 'A', 'S', 'D'};
    private String optionsString;
    
    
    
    private void buildOptionsString(String[] options){
        assert(keys.length == options.length);
        String optionsString = "";
        for (int i = 0; i < options.length; i++){
            String line = "  " + keys[i] + " - " + options[i] + "\n";
            optionsString += line;
        }
        optionsString += "  >";
        this.optionsString = optionsString;
    }
    
    public static char getUserChar(String prompt){
        System.out.println(prompt);
        Scanner inFile;
        inFile = new Scanner(System.in);
        char userChar = inFile.next().charAt(0);
        userChar = Character.toLowerCase(userChar);
        return userChar;
    }
}
