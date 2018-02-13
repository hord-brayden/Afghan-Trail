package byui.cit260.afghan_trail.controller;

 
import java.util.Scanner;
 
public class Map {
	
	/**
	 * tests the map
	 */
	public static void testMap() {
		// create an input file for the console
		Scanner inFile;
		inFile = new Scanner(System.in);
		int progress = 0;
		do {
			
			progress = 0;
			do {
				// print out the welcome message
				System.out.println();
				System.out.println("This program tests the Afghan Trail Map\n\n");
				
				// prompt to enter the users name
				System.out.println("\nPlease enter a number between 1-25: ");
				
				// read the value of the next line typed in the console
				progress = inFile.nextInt();
				
			} while (progress < 0 || progress > 25);
			
			if (progress != 0)
				displayMap(progress);
			
			
		} while (progress != 0);
	}
	
	public static String displayMap(int progress) {
		progress--;
		char[] p = new char[]{
			'o','/','/','_','_',
			'o','|','|','\\','\\',
			'o','\\','_','_','_',
			'o','/','_','_','_',
			'o','\\','\\','\\','_'};
		
		//used to set and reset color
		//public static final String ANSI_RED = "\u001B[31m";
		//public static final String ANSI_RESET = "\u001B[0m";
		
		p[progress] = 'X';
		
	    String mapString = "\n"  +
		"\n"  +
		"                        ,-.^._                 _\n"  +
		"               "+p[24]+"     Maymana      `-.            ,' ;\n"  +
		"               /"+p[23]+"-.  ,----' "+p[15]+"__"+p[14]+"_"+p[13]+"_"+p[12]+" `-.   _  ,-.,'  `\n"  +
		"            _.'  "+p[22]+"`--'     /   ^^  \\"+p[11]+"  `-' '-'      ;\n"  +
		"           :      "+p[21]+"  "+p[19]+"_"+p[18]+"_"+p[17]+"_"+p[16]+" ^ ^^^^    "+p[10]+"             ;    __,-.\n"  +
		"           ,'      "+p[20]+"/       ^   Mazar-i-Sharif       ;_,-',.__'--.\n"  +
		"          :      Herat     ^^         \\"+p[9]+"            ,--```    `--'\n"  +
		"          :                ^^          \\"+p[8]+"         ;\n"  +
		"          :             ^^^^^       ^^   "+p[7]+"        :\n"  +
		"          ;         ^  ^ ^ ^        ^^^  "+p[6]+"       :\n"  +
		"         (       ^ ^ ^ ^             "+p[4]+"_  |       ;\n"  +
		"          `-.    ^ ^ ^ ^       __"+p[3]+"__/   "+p[5]+"      ,'\n"  +
		"            ;    ^ ^ ^        "+p[2]+"       Kabul   :\n"  +
		"          .'    ^  ^         /  ^^^      .-._,' \n"  +
		"        .'                  "+p[1]+"    ^       `.               \n"  +
		"     _.'                   /            .__;  \n"  +
		"     `._                  "+p[0]+"           ;                       \n"  +
		"        `.             Kandahar       :    \n"  +
		"          `.               ,..__,---._;     \n"  +
		"            `-.__         :                                          \n"  +
		"                 `.--.____;                                          \n";
		
            return mapString;		
	}
}