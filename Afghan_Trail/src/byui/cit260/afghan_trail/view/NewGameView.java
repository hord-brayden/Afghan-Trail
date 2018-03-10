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
    public String introduction = "AFGHAN TRAIL!!!!!!!!!!!!\n" +
        "You are reading some sort of really, really\n" + 
        "heroic introduction. It is moving you to tears.\n" +
        "You are considering actually moving to afghanistan \n" +
        "in efforts to make your life more like the game you are \n" +
        "about to play, but you'll settle for this...for now.\n";
    public String namePrompt = "Name your character: ";

    public NewGameView() {
        super();
        
        String[] options = {
            "Banker",
            "Blacksmith",
            "Carpenter",
            "Farmer",
            "Class Descriptions"
        };
        String message = "\nChoose Character:";       
        setOptions(options);
        setMessage(message);
    }
    
    public NewGameView(String options[], String message){
        super(options, message);
    }    
    
    public NewGameView(char keys[]){
        this();
        if (keys.length < options.length)
            System.err.print("view must have the same amount or more keys than options");
        else
            setKeys(keys);
    }   

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    
    public String getIntroduction(){
        return introduction;
    }
    
    public void setNamePrompt(String namePrompt){
        this.namePrompt = namePrompt;
    }
    
    public String getNamePrompt(){
        return namePrompt;
    }
    
    /*
        Methods
    */
    
    @Override
    public void displayHelp(){
        /*
            "Banker",
            "Blacksmith",
            "Carpenter",
            "Farmer",
        */
        System.out.print("These are the class descriptions...\n");
    }
    
    @Override
    public void display(Game game, Player player){
        
        //intro and character name
        System.out.println(introduction);
        String name = BasicView.getUserString(namePrompt);
        
        //choose character class
        int opLen = options.length;
        char guideOp = keys[opLen - 1];  //last
        guideOp = Character.toLowerCase(guideOp);
        char userInput = guideOp;
        
        do {
            System.out.println(message + '\n');
            userInput = getUserChar(options);
            if (userInput == guideOp)
                this.displayHelp();
        } while (userInput == guideOp);
        
        //set up player
        player = setUpPlayer(userInput, name); 
        game.setPlayer(player);
    }
    
    @Override
    public void doAction(String[] options, char action, Game game, Player player){};
        
    public Player setUpPlayer(char action, String name)
    {
        Player player = null;
        int actionInt = getFunctionNumberFromChar(action);
        switch (actionInt){
                    case 0:
                        System.out.print("You chose '" + options[0] + "'\n");
                        player = new Banker(name);
                        player.setPlayerClass("Banker");
                    break;
                    case 1:
                        System.out.print("You chose '" + options[1] + "'\n");
                        player = new Blacksmith(name);
                        player.setPlayerClass("Blacksmith");
                    break;
                    case 2:
                        System.out.print("You chose '" + options[2] + "'\n");
                        player = new Carpenter(name);
                        player.setPlayerClass("Carpenter");
                    break;
                    case 3:
                        System.out.print("You chose '" + options[3] + "'\n");
                        player = new Farmer(name);
                        player.setPlayerClass("Farmer");
                    break;
        }
        return player;
    }
}
