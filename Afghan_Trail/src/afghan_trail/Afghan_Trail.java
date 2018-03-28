/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afghan_trail;
import byui.cit260.afghan_trail.view.StartProgramView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
/**
 *
 * @author Rizky, Brayden, Jonathan
 */
public class Afghan_Trail {

    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    private static String exitMsg = "Thank you for playing\n";
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
        
        //prepare I/O
        try {
            setInFile(
                    new BufferedReader(
                            new InputStreamReader(System.in)
                    )
            );
            setOutFile(new PrintWriter(System.out, true));
        } catch (Throwable e) {
            System.out.println("Eception: " + e.toString() + 
                    "\nCause: " + e.getCause() + 
                    "\nMessage: " + e.getMessage());
            e.printStackTrace();
        }        
        
        //Shows game title
        System.out.print(title);

        //Starts Main Menu View
        StartProgramView startProgramView = new StartProgramView();
        try {
            startProgramView.display(null);
        } catch (Throwable te) {
            te.printStackTrace();
            System.out.print(te.getMessage());
        } finally {
            System.out.print(exitMsg);
            System.out.close();
        }
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        Afghan_Trail.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        Afghan_Trail.inFile = inFile;
    }
    
    
}
