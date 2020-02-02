
import java.io.*;
import java.io.Console;
import java.util.*;
//import SrlConsoleDataTable;

public class Hello {

    
  public static void main(final String[] args) {
    final SrlConsoleDataTable srlConsoleDataTable = new SrlConsoleDataTable();

    int menuselection = 999;

    while(menuselection !=0)  {
      menuselection = MainMenu();

      switch (menuselection) {

        case 1:
        srlConsoleDataTable.SelectedAuto = AutoSelect();
        break;
        case 2:
        // code block
        break;
        case 3:
        // code block
        break;
        case 4:
        // code block
        break;
        case 5:
        // code block
        break;
        case 6:
        // code block
        break;
        case 7:
        // code block
        break;
        case 8:
        // code block
        break;
        case 9:
        // code block
        case 0:
          //Exit;
          break;
        default:
        //menuselection = Menu();
      }

    }
    System.out.println("Bye !");
  }

  public static int GetSelection() {
    int selection = 99999;
    Console console = System.console();
    //Scanner input = new Scanner(System.in);
    
    while (selection == 99999)
    {
      //String selectionStr = input.nextLine();
      String selectionStr = console.readLine("ENTER: ");
      try {
        selection = Integer.parseInt(selectionStr);
      }
  
      catch (Exception exception)
      {
        System.out.println("Error - Try Again " + exception.toString());
        
      }
  
    }

    //input.close();
    return selection;

  }

  public static int MainMenu() {

    System.out.print("\033[H\033[2J");
    //System.out.flush();

    System.out.println("==========================================================================================================");
    System.out.println("Team 6514 - Console Application");
    System.out.println("MAIN MENU");

    System.out.println("1 - Autoselection ");
    System.out.println("0 - Quit ");

    return GetSelection();

  }

  public static AutoOption AutoSelect() {
    
    AutoOption sAuto = AutoOption.Auto1;

    System.out.print("\033[H\033[2J");  
    //System.out.flush(); 

    System.out.println("==========================================================================================================");
    System.out.println("Select Auto Program");
    System.out.println("1 ==> Auto 1");
    System.out.println("2 ==> Auto 2");
    System.out.println("3 ==> Auto 3");

    int selection = GetSelection();

    switch(selection) {
      case 1:
        sAuto = AutoOption.Auto1;
        break;
      case 2:
        sAuto = AutoOption.Auto2;
      case 3:
        sAuto = AutoOption.Auto3;
        break;
      default:
        sAuto = AutoOption.Auto1;
    }

    return sAuto;

  }
}
