/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;

import byui.cit260.afghan_trail.controller.Game;
import byui.cit260.afghan_trail.model.Banker;
import byui.cit260.afghan_trail.model.Blacksmith;
import byui.cit260.afghan_trail.model.Carpenter;
import byui.cit260.afghan_trail.model.Farmer;
import byui.cit260.afghan_trail.model.Player;

/**
 *
 * @author jonsi
 */
public class NewGameView extends BasicView{
    
    /*
        Properties
    */
    public static String introduction = "AFGHAN TRAIL!!!!!!!!!!!!\n" +
        "You are reading some sort of really, really\n" + 
        "heroic introduction. It is moving you to tears.\n" +
        "You are considering actually moving to afghanistan \n" +
        "in efforts to make your life more like the game you are \n" +
        "about to play, but you'll settle for this...for now.\n";
    public static String namePrompt = "Name your character: ";

    public NewGameView() {
        super();
        
        String[] options = {
            "Banker",
            "Blacksmith",
            "Farmer",
            "Class Descriptions"
        };
        String message = "Choose Character:";       
        setOptions(options);
        setMessage(message);
    }
    
    public NewGameView(String options[], String message){
        super(options, message);
    }    

    public static void setIntroduction(String introduction) {
        NewGameView.introduction = introduction;
    }
    
    /*
        Methods
    */
    
    @Override
    public void displayHelp(){
        System.out.print("These are the class descriptions...\n");
    }
    
    @Override
    public void display(Game game, Player player){
        
        //intro and character name
        System.out.println(introduction);
        String name = BasicView.getUserString(namePrompt);
        
        //choose character class
        System.out.println(message + '\n');
        char userInput = getUserChar(options);
        while (userInput == 'd') {
            this.displayHelp();
            userInput = getUserChar(options);
        };
        
        //set up player
        player = setUpPlayer(userInput, name); 
        game.setPlayer(player);
    }
    
    @Override
    public void doAction(String[] options, char action, Game game, Player player){};
        
    public Player setUpPlayer(char action, String name)
    {
        Player player = null;
        switch (action){
                    case 'w':
                        System.out.print("You chose '" + options[0] + "'\n");
                        player = new Banker(name);
                        player.setPlayerClass("Banker");
                    break;
                    case 'a':
                        System.out.print("You chose '" + options[1] + "'\n");
                        player = new Blacksmith(name);
                        player.setPlayerClass("Blacksmith");
                    break;
                    case 's':
                        System.out.print("You chose '" + options[2] + "'\n");
                        player = new Farmer(name);
                        player.setPlayerClass("Farmer");
                    break;
        }
        return player;
    }
}
