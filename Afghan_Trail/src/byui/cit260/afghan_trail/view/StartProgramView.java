/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.afghan_trail.view;
import byui.cit260.afghan_trail.controller.Game;
import byui.cit260.afghan_trail.controller.GuideController;
import byui.cit260.afghan_trail.model.Player;

/**
 *
 * @author jonsi
 */
public class StartProgramView extends BasicView{
    
    /*
        Constructors
    */
    public StartProgramView(){  
        String[] options = {
            "Start Game", 
            "Load Game", 
            "Guide",
            "Exit"
        };
        String message = "Main Menu";       
        setOptions(options);
        setMessage(message);
    }
    
    public StartProgramView(String options[], String message){
        super(options, message);
    }
    
    public StartProgramView(char keys[]){
        this();
        if (keys.length < options.length)
            System.err.print("view must have the same amount or more keys than options");
        else
            setKeys(keys);
    }
    
    @Override
    public void displayHelp(){
        GuideView guideView = new GuideView();             
        guideView.display(null, null);
    }
    
    @Override
    public void display(Game game, Player player) {
        
        int opLen = options.length;
        char exitOp = keys[opLen - 1];  //last
        char guideOp = keys[opLen - 2]; //second to last
        exitOp = Character.toLowerCase(exitOp);
        guideOp = Character.toLowerCase(guideOp);
        char userInput = guideOp;
        
        do {
            System.out.println(message + '\n');
            userInput = getUserChar(options);
            if (userInput == guideOp)
                this.displayHelp();
            else
                doAction(options, userInput, game, player);
        } while (userInput != exitOp);
        //LOOP should exit only on exitOp 
    }
    
    @Override
    public void doAction(String[] options, 
                           char action, 
                           Game game,
                           Player player)
    {
        
        int actionInt = getFunctionNumberFromChar(action);
       
        switch(actionInt)
        {
            //Start Game
            case 0:
               Game newGame = new Game();
               newGame.initializeGame();
               Game.startGame(newGame);
            break;

            //Load Game
            case 1:
               Game oldGame = Game.loadGame();
               Game.startGame(oldGame);
            break;
            
            //exit handled by display
            //show guide handled by display

        }
            
    }
}


