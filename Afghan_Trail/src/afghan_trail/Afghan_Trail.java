/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afghan_trail;
import byui.cit260.afghan_trail.view.StartProgramView;



/**
 *
 * @author Rizky, Brayden, Jonathan
 */
public class Afghan_Trail {

    /**
     * @param args the command line arguments
     */ 
    private static String title = "" +
 "                    __      _                   _______        _ _         \n" +
"             /\\    / _|    | |                 |__   __|      (_) |        \n" +
"            /  \\  | |_ __ _| |__   __ _ _ __      | |_ __ __ _ _| |        \n" +
"           / /\\ \\ |  _/ _` | '_ \\ / _` | '_ \\     | | '__/ _` | | |     \n" +
"  _   _   / ____ \\| || (_| | | | | (_| | | | |    | | | | (_| | | |  _   _ \n" +
" (_) (_) /_/    \\_\\_| \\__, |_| |_|\\__,_|_| |_|    |_|_|  \\__,_|_|_| (_) (_)\n" +
"                       __/ |                                                \n" +
"                      |___/                                                 \n";
    
    
    public static void main(String[] args) {
        
        //Shows game title
        System.out.print(title);

        //Starts Main Menu View
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.display();
    }
}
