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
  public void printBoard() {
    for (int i = 0; i < 3; i++) {
      System.out.println("  " + asLetter(board[i][0]) + "  |  " + asLetter(board[i][1]) + "  |  "
          + asLetter(board[i][2]) + "  |    |");
      System.out.println("                      |");
   
    }
    System.out.println("___________________");
  }

  public void printRow(int row) {

    System.out.print("  |  " + asLetter(board[row][0]) + "  |  " + asLetter(board[row][1]) + "  |  "
        + asLetter(board[row][2]) + "  |  ");


  }

  
  public String asLetter(int number) {
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
  public void setAt(int player, int space){
    if (isEmpty(space)){
      board[space/3][space % 3] = player;
    } else {
      throw new RuntimeException("square not empty");
    }
  }
  public boolean isEmpty(int space){
    return board[space/3][space % 3] == 0;
  }
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
      int num =  scanner.nextInt();
     scanner.close();
     return num - 1;
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
          } else {
            return false;
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

