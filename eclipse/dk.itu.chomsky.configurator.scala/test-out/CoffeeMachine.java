import java.util.Scanner;

class FSMCoffeeMachine {

  static final int INITIAL = 0;
  static final int SELECTION = 1;
  static final int BREWCOFFEE = 2;
  static final int BREWTEA = 3;
  static final int BROKEN = 4;

  static int current;

  static final String[] stateNames = {
    "initial", "selection", "brewCoffee", "brewTea", "broken"
  };

  static final String[] availableInputs = {
    "<coin><break>",
    "<tea><coffee><timeout><break>",
    "<done><break>",
    "<done><break>",
    ""
  };

  public static void main (String[] args) {

    @SuppressWarnings(value = { "resource" })
    Scanner scanner = new Scanner (System.in);
    current = INITIAL;

    while (true) {

      System.out.print ("[" + stateNames[current] + "] ");
      System.out.print ("What is the next event? available: "
                           + availableInputs[current]);
      System.out.print ("?");
      String input = scanner.nextLine();

      switch (current) {
                       
          case INITIAL:
            switch (input) {
              case "coin":
                System.out.println ("machine says: what drink do you want?");
                current = SELECTION;
                break;
              case "break":
                System.out.println ("machine says: machine is broken");
                current = BROKEN;
                break;
            }
            break;
        
          case SELECTION:
            switch (input) {
              case "tea":
                System.out.println ("machine says: serving tea");
                current = BREWTEA;
                break;
              case "coffee":
                System.out.println ("machine says: serving coffee");
                current = BREWCOFFEE;
                break;
              case "timeout":
                System.out.println ("machine says: coin returned; insert coin");
                current = INITIAL;
                break;
              case "break":
                System.out.println ("machine says: machine is broken!");
                current = BROKEN;
                break;
            }
            break;
        
          case BREWCOFFEE:
            switch (input) {
              case "done":
                System.out.println ("machine says: coffee served. Enjoy!");
                current = INITIAL;
                break;
              case "break":
                System.out.println ("machine says: machine is broken!");
                current = BROKEN;
                break;
            }
            break;
        
          case BREWTEA:
            switch (input) {
              case "done":
                System.out.println ("machine says: tea served. Enjoy!");
                current = INITIAL;
                break;
              case "break":
                System.out.println ("machine says: machine is broken!");
                current = BROKEN;
                break;
            }
            break;
        
          case BROKEN:
            switch (input) {
            }
            break;
        
      }
    }
  }
}
