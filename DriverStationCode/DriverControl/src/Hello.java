
import java.io.*;
import java.util.*;


public class Hello {

    private String menuSelection = "";
    private String selectedAuto = "1";
    private boolean programExit = false;
    
    public static void main(String[] args) {
        private String menuSelection = "";
        private String selectedAuto = "1";
        private boolean programExit = false;
    

        while (programExit) {
            MainMenu();
          }        
    


    }

    private void AutoSelect() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    

        System.out.println("==========================================================================================================");
        System.out.println("Select Auto Program");
        System.out.println("  1 ==> Auto 1");
        System.out.println("  2 ==> Auto 1");
        System.out.println("  3 ==> Auto 1");

        Console console = System.console();
        SelectedAuto = console.readLine();



    }

    private void MainMenu() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    
        System.out.println("==========================================================================================================");
        System.out.println("Team 6514 - Console Application");
        System.out.println("MAIN MENU");
        System.out.println("  1 ==> Select Auto");
        System.out.println("  2 ==> ");
        System.out.println("  3 ==> ");
        System.out.println("  E ==> Exit");
        Console console = System.console();
        String MenuSelection = console.readLine();

        switch(MenuSelection) {
            case "1" :
              System.out.println("Excellent!");
              AutoSelect();
              break;
            case "2" :
              System.out.println("Next");
            case "E":
              programExit = true;
            default:
              MainMenu();

        }
 
    }

 
}