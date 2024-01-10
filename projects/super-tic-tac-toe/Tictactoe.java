import java.util.Scanner;

public class Tictactoe {
  private int place;
  private int[][] board = new int[3][3];
  private boolean won = false;

  public Tictactoe(int place) {
    this.place = place;

  }

  public int[][] getBoard() {
    return board;
  }

  public int getPlace() {
    return place;
  }

  public boolean getWon() {
    return won;
  }

  // static boolean tie = false;
  // static boolean win = false;
  // static String p1Input = "0";
  // static String p2Input = "0";

  // funciton
  public static void printBoard(int[][] board) {
    for (int i = 0; i < 3; i++) {
      System.out.println("  " + asLetter(board[i][0]) + "  |  " + asLetter(board[i][1]) + "  |  "
          + asLetter(board[i][2]) + "  |    |");
      System.out.println("                      |");
      // Pretty cool, loops three times, while also changing the first value of the
      // array id, which works because its a three by three board, but if it were 4 by
      // 3 or something like that it might be more complicated
    }
    System.out.println("___________________");
  }

  public static void printRow(int[][] board, int row) {

    System.out.print("  |  " + asLetter(board[row][0]) + "  |  " + asLetter(board[row][1]) + "  |  "
        + asLetter(board[row][2]) + "  |  ");

    // Pretty cool, loops three times, while also changing the first value of the
    // array id, which works because its a three by three board, but if it were 4 by
    // 3 or something like that it might be more complicated

  }

  public static void printSuperBoard(Tictactoe[] superBoard) {

    System.out.print("\033[2J\033[1;1H");
    System.out.println("SUPER TIC TAC TOE");
    System.out.println("");
    for (int x = 0; x < 3; x++) {
      for (int i = 0; i < 3; i++) {
        printRow(superBoard[i].getBoard(), x);
        System.out.print("  |  ");
      }
      System.out.println("           |                      |                           |                           |");
    }
    System.out.println("______________________________________________________________________________");
    for (int x = 0; x < 3; x++) {
      for (int i = 3; i < 6; i++) {
        printRow(superBoard[i].getBoard(), x);
        System.out.print("  |  ");
      }
      System.out.println("           |                      |                           |                           |");
    }

    System.out.println("______________________________________________________________________________");
    for (int x = 0; x < 3; x++) {
      for (int i = 6; i < 9; i++) {
        printRow(superBoard[i].getBoard(), x);
        System.out.print("  |  ");
      }
      System.out.println("           |                      |                           |                           |");
    }

    System.out.println("______________________________________________________________________________");

  }

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

  public static void reader(int input, int[][] board, int player) {
    if (input == 0) {
      if (board[0][0] == 0) {
        board[0][0] = player;
      } else {
        System.out.println("thats been done before");
        reader(input = chat(player) - 1, board, player);
      }
    } else if (input == 1) {
      if (board[0][1] == 0) {
        board[0][1] = player;
      } else {
        System.out.println("thats been done before");
        reader(input = chat(player) - 1, board, player);
      }
    } else if (input == 2) {
      if (board[0][2] == 0) {
        board[0][2] = player;
      } else {
        System.out.println("thats been done before");
        reader(input = chat(player) - 1, board, player);
      }
    } else if (input == 3) {
      if (board[1][0] == 0) {
        board[1][0] = player;
      } else {
        System.out.println("thats been done before");
        reader(input = chat(player) - 1, board, player);
      }
    } else if (input == 4) {
      if (board[1][1] == 0) {
        board[1][1] = player;
      } else {
        System.out.println("thats been done before");
        reader(input = chat(player) - 1, board, player);
      }
    } else if (input == 5) {
      if (board[1][2] == 0) {
        board[1][2] = player;
      } else {
        System.out.println("thats been done before");
        reader(input = chat(player) - 1, board, player);
      }
    } else if (input == 6) {
      if (board[2][0] == 0) {
        board[2][0] = player;
      } else {
        System.out.println("thats been done before");
        reader(input = chat(player) - 1, board, player);
      }
    } else if (input == 7) {
      if (board[2][1] == 0) {
        board[2][1] = player;
      } else {
        System.out.println("thats been done before");
        reader(input = chat(player) - 1, board, player);
      }
    } else if (input == 8) {
      if (board[2][2] == 0) {
        board[2][2] = player;
      } else {
        System.out.println("thats been done before");
        reader(input = chat(player) - 1, board, player);
      }
    } else {
      System.out.println("Sorry, I didn't get that, please try again");
      reader(input = chat(player) - 1, board, player);
    }

  }

  // both chats just have text and then see the input from player and update it
  public static int p1StartChat() {
    System.out.println("");
    System.out.println("What square would you like to start in? 1 through 9, left to right, up to down.");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

  public static int chat(int player) {
    int[] players = { 1, 2 };
    System.out.println("");
    System.out.println("What is player " + players[player - 1] + "'s move? 1 through 9, left to right, up to down.");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

  // check for win con
  public static boolean winChecker(int x, Tictactoe board) {
    if (board.getWon() != true) {
      for (int i = 0; i < 3; i++) {
        if (board.getBoard()[i][0] == x) {
          if (board.getBoard()[i][1] == x) {
            if (board.getBoard()[i][2] == x) {
              board.won = true;
              return true;
            }

          }
        }
        if (board.getBoard()[0][i] == x) {
          if (board.getBoard()[1][i] == x) {
            if (board.getBoard()[2][i] == x) {
              board.won = true;
              return true;
            }
          }
        }
      }
      if (board.getBoard()[0][0] == x) {
        if (board.getBoard()[1][1] == x) {
          if (board.getBoard()[2][2] == x) {
            board.won = true;
            return true;
          }
        }
      }
      if (board.getBoard()[0][2] == x) {
        if (board.getBoard()[1][1] == x) {
          if (board.getBoard()[2][0] == x) {
            board.won = true;
            return true;
          }
        }
      }

    } else {
      return true;
    }
    return false;
  }

  public static int digitToBoardCoord(int digit) {
    if (0 <= digit && digit < 3) {
      return 0;
    } else if (3 <= digit && digit < 6) {
      return 1;
    } else {
      return 2;
    }
  }

  public static int nextBoardCheck(int nextBoard, Tictactoe[] superBoard, int player) {
    int[] players = { 1, 2 };
    if (superBoard[nextBoard].getWon()) {
      printSuperBoard(superBoard);
      System.out.println("That board has already been finished, where would player " + players[player] + " like to go?");
      Scanner scanner = new Scanner(System.in);
      return scanner.nextInt() - 1;
    } else {
      return nextBoard;
    }
  }

  public static boolean tieChecker(Tictactoe board) {
    int spacesTaken = 0;
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          if (board.getBoard()[i][j] != 0) {
            spacesTaken++;
          }
        }
      }
      if (spacesTaken == 9 && board.getWon() != true){
        System.out.println("Board " + board.getPlace() + " is a tie");
        board.won = true;
        return true;
      } 
      return false;
    }
  }

