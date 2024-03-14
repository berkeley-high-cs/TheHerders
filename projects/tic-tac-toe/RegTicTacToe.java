
//HOLY SHIT  I DID IT
//FINISHED
import java.util.Scanner;

class RegTicTacToe {

  static int[][] board = {
      { 0, 0, 0 },
      { 0, 0, 0 },
      { 0, 0, 0 }
  };
  static boolean tie = false;
  static boolean win = false;
  static String p1Input = "0";
  static String p2Input = "0";

  public static void main(String[] args) {
    System.out.println("TicTacToe App");

    // thinking we say 1 to 9 from left to right, then if else scan
    printBoard(board);

    // Scanner p1Input = new Scanner(System.in);should scan
    // System.out.println("");
    // System.out.println("What is your first move? 1 through 9, left to right");
    // Scanner scanner = new Scanner(System.in);
    // p1Input = scanner.nextLine();
    // function that does basically this, need p1Input to be global, then function
    // that does whats happening below, then check to see if anyone has won
    String test = ("");
    // these three lines should run a majority of our game, just need to make a
    // check system and a way for there to be two players
    // winCon will also triggerin a tie
    boolean winCon = false;
    while (winCon == false) {
      for (int i = 0; i < 9; i++) {
        p1Chat(test);
        p1Reader(p1Input);
        printBoard(board);
        checker(1);
        i++;
        if (i == 9) {
          tieChecker();
          winCon = true;
          break;
        }
        if (win == true) {
          winCon = true;
          break;
        }

        p2Chat(test);
        p2Reader(p2Input);
        printBoard(board);
        checker(2);
        if (i == 9) {
          tieChecker();
          winCon = true;
          break;
        }
        if (win == true) {
          winCon = true;
        }

        // here repeat chat reader and printboard but chat has to have a second player
        // here run function for checking
      }
    }
  }

  // funciton
  public static void printBoard(int[][] board) {
    for (int i = 0; i < 3; i++) {
      System.out.println(asLetter(board[i][0]) + "  |  " + asLetter(board[i][1]) + "  |  " + asLetter(board[i][2]));
      System.out.println("");
      // Pretty cool, loops three times, while also changing the first value of the
      // array id, which works because its a three by three board, but if it were 4 by
      // 3 or something like that it might be more complicated
    }
  }

  // as letter changes the numbers to x's and o's, ask grayson a little bit about
  // how that works, like why is it just in front of the array id
  // for loop
  public static String asLetter(int number) {
    if (number == 0) {
      return "_";
    } else if (number == 1) {
      return "X";
    } else if (number == 2) {
      return "O";
    }
    // needs this in case its not 0 1 or 2
    return " ";
  } // reads player 1 input

  public static void p1Reader(String p1Input) {
    if (p1Input.equals("1")) {
      if (board[0][0] == 0) {
        board[0][0] = 1;
      } else {
        System.out.println("thats been done before");
      }
    } else if (p1Input.equals("2")) {
      if (board[0][1] == 0) {
        board[0][1] = 1;
      } else {
        System.out.println("thats been done before");
      }
    } else if (p1Input.equals("3")) {
      if (board[0][2] == 0) {
        board[0][2] = 1;
      } else {
        System.out.println("thats been done before");
      }
    } else if (p1Input.equals("4")) {
      if (board[1][0] == 0) {
        board[1][0] = 1;
      } else {
        System.out.println("thats been done before");
      }
    } else if (p1Input.equals("5")) {
      if (board[1][1] == 0) {
        board[1][1] = 1;
      } else {
        System.out.println("thats been done before");
      }
    } else if (p1Input.equals("6")) {
      if (board[1][2] == 0) {
        board[1][2] = 1;
      } else {
        System.out.println("thats been done before");
      }
    } else if (p1Input.equals("7")) {
      if (board[2][0] == 0) {
        board[2][0] = 1;
      } else {
        System.out.println("thats been done before");
      }
    } else if (p1Input.equals("8")) {
      if (board[2][1] == 0) {
        board[2][1] = 1;
      } else {
        System.out.println("thats been done before");
      }
    } else if (p1Input.equals("9")) {
      if (board[2][2] == 0) {
        board[2][2] = 1;
      } else {
        System.out.println("thats been done before");
      }
    } else {
      System.out.println("that dont work");
    }

  }

  // both chats just have text and then see the input from player and update it
  public static void p1Chat(String test) {
    System.out.println("");
    System.out.println(
        "What is player 1's move? 1 through 9, left to right, up to down. Don't chose something thats been done");
    Scanner scanner = new Scanner(System.in);
    p1Input = scanner.nextLine();
    scanner.close();
  }

  public static void p2Chat(String test) {
    System.out.println("");
    System.out.println(
        "What is player 2's move? 1 through 9, left to right, up to down. Don't chose something thats been done");
    Scanner scanner = new Scanner(System.in);
    p2Input = scanner.nextLine();
    scanner.close();
  } // reads player 2 input

  public static void p2Reader(String p2Input) {
    if (p2Input.equals("1")) {
      if (board[0][0] == 0) {
        board[0][0] = 2;
      } else {
        System.out.println("thats been done before");
      }
    } else if (p2Input.equals("2")) {
      if (board[0][1] == 0) {
        board[0][1] = 2;
      } else {
        System.out.println("thats been done before");
      }
    } else if (p2Input.equals("3")) {
      if (board[0][2] == 0) {
        board[0][2] = 2;
      } else {
        System.out.println("thats been done before");
      }
    } else if (p2Input.equals("4")) {
      if (board[1][0] == 0) {
        board[1][0] = 2;
      } else {
        System.out.println("thats been done before");
      }
    } else if (p2Input.equals("5")) {
      if (board[1][1] == 0) {
        board[1][1] = 2;
      } else {
        System.out.println("thats been done before");
      }
    } else if (p2Input.equals("6")) {
      if (board[1][2] == 0) {
        board[1][2] = 2;
      } else {
        System.out.println("thats been done before");
      }
    } else if (p2Input.equals("7")) {
      if (board[2][0] == 0) {
        board[2][0] = 2;
      } else {
        System.out.println("thats been done before");
      }
    } else if (p2Input.equals("8")) {
      if (board[2][1] == 0) {
        board[2][1] = 2;
      } else {
        System.out.println("thats been done before");
      }
    } else if (p2Input.equals("9")) {
      if (board[2][2] == 0) {
        board[2][2] = 2;
      } else {
        System.out.println("thats been done before");
      }
    } else {
      System.out.println("that dont work");
    }
  }

  // check for win con
  public static void checker(int x) {

    for (int i = 0; i < 3; i++) {
      if (board[i][0] == x) {
        if (board[i][1] == x) {
          if (board[i][2] == x) {
            win = true;
          }

        }
      }
      if (board[0][i] == x) {
        if (board[1][i] == x) {
          if (board[2][i] == x) {
            win = true;
          }
        }
      }
    }
    if (board[0][0] == x) {
      if (board[1][1] == x) {
        if (board[2][2] == x) {
          win = true;
        }
      }
    }
    if (board[0][2] == x) {
      if (board[1][1] == x) {
        if (board[2][0] == x) {
          win = true;
        }
      }
    }
    if (win == true) {
      System.out.println("player " + x + " wins!");

    } // tie checks if there are any spaces left, currently check if any space has
      // been taken
  }

  public static void tieChecker() {
    if (win == false) {
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          if (board[i][j] != 0) {
            tie = true;

          }
        }
      }
      if (tie = true) {
        System.out.println("Cat's Game!");

      }
    }
  }
}
