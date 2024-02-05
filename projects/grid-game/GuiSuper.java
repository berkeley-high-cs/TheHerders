import java.util.Scanner;

public class GuiSuper {
 
  int nextBoard = -1;
  int currentBoard;
  Tictactoe boardState = new Tictactoe(-1);
  Tictactoe[] boards = new Tictactoe[9];

  public GuiSuper() {
    for (int i = 0; i < 9; i++) {
      boards[i] = new Tictactoe(i);
    }
  }

  public Tictactoe[] getBoards() {
    return boards;
  }

  public int getNextBoard() {
    return nextBoard;
  }

  public int getCurrentBoard() {
    return currentBoard;
  }

  public Tictactoe getBoardState() {
    return boardState;
  }

  public void setCurrentBoard(int n) {
    if (nextBoard == -1)
      nextBoard = n;
    currentBoard = n;
  }

  public static void main(String[] args) {
    Super superBoard = new Super();

    superBoard.printSuperBoard();
    superBoard.setCurrentBoard(Math.max(0, Math.min(p1StartChat() - 1, 8)));
    boolean win = false;
      while (win != true) {
        superBoard.gameLoop(superBoard, win, 1);
        superBoard.gameLoop(superBoard, win, 2);
    }
  }

  public void gameLoop(Super superBoard, boolean win, int player) {
    currentBoard = nextBoardCheck(nextBoard, boards, player); // makes board previous play if
    // availiable
    superBoard.printSuperBoard();
    System.out.println("Player " + player + "'s turn on " + (currentBoard + 1));
    boards[currentBoard].printBoard(); // prints current board
    nextBoard = Math.max(0, Math.min(chat(player) - 1, 8)); // nextBoard is player 1's move
    if (superBoard.getBoards()[currentBoard].isEmpty(nextBoard)) {
      superBoard.getBoards()[currentBoard].setAt(player, nextBoard); // reads input and makes adjustments MAKE THIS READER, MAKE READER WORK
    } else {
      System.out.println("That space is already taken, please try again");
      nextBoard = Math.max(0, Math.min(chat(player) - 1, 8)); // nextBoard is player 1's move
    }   if (Tictactoe.winChecker(player, boards[currentBoard])) { // winCheck
      System.out.println("Player " + player + " wins here! Full board state below");
      boardState.getBoard()[currentBoard / 3][currentBoard % 3] = player; // minus 1 is a trial and later probably
      // error
      boardState.printBoard(); // puts a win on the full board state

    }
    Tictactoe.tieChecker(superBoard.boards[currentBoard]);// checks for a tie
    if (Tictactoe.winChecker(player, boardState)) {
      System.out.println("Player "+ player + "has won the game!");
      win = true;
    } // checks if someone has won the entire game
    if (Tictactoe.tieChecker(boardState)) {
      System.out.println("Cat's game");
      win = true;
    } // checks if the game is a tie
    superBoard.printSuperBoard(); // prints updated super board

  }

  // both chats just have text and then see the input from player and update it
  public static int p1StartChat() {
    System.out.println("");
    System.out.println("What square would you like to start in? 1 through 9, left to right, up to down.");
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    scanner.close();
    return num;
  }

  public static int chat(int player) {
    int[] players = { 1, 2 };
    System.out.println("");
    System.out
        .println("What is player " + players[player - 1] + "'s move? 1 through 9, left to right, up to down.");
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    scanner.close();
    return num;
  }

  public void printSuperBoard() {

    System.out.print("\033[2J\033[1;1H");
    System.out.println("SUPER TIC TAC TOE");
    System.out.println("");
    for (int x = 0; x < 3; x++) {
      for (int i = 0; i < 3; i++) {
        boards[i].printRow(x);
        System.out.print("  |  ");
      }
      System.out.println("           |                      |                           |                           |");
    }
    System.out.println("______________________________________________________________________________");
    for (int x = 0; x < 3; x++) {
      for (int i = 3; i < 6; i++) {
        boards[i].printRow(x);
        System.out.print("  |  ");
      }
      System.out.println("           |                      |                           |                           |");
    }

    System.out.println("______________________________________________________________________________");
    for (int x = 0; x < 3; x++) {
      for (int i = 6; i < 9; i++) {
        boards[i].printRow(x);
        System.out.print("  |  ");
      }
      System.out.println("           |                      |                           |                           |");
    }

    System.out.println("______________________________________________________________________________");

  }

  public int nextBoardCheck(int nextBoard, Tictactoe[] boards, int player) {
    int[] players = { 1, 2 };
    if (boards[nextBoard].getWon()) {
      printSuperBoard();
      System.out.println("That board has already been finished, where would player " + players[player - 1] + " like to go?");
      Scanner scanner = new Scanner(System.in);
      int num =  scanner.nextInt();
     scanner.close();
     return num - 1;
    } else {
      return nextBoard;
    }
  }

}
//past game loop
//   currentBoard = Tictactoe.nextBoardCheck(nextBoard, superBoard, 0); // makes board previous play if
    //                                                                      // availiable
    //   Tictactoe.printSuperBoard(superBoard);
    //   System.out.println("Player 1's turn on " + (currentBoard + 1));
    //   superBoard[currentBoard].printBoard(); // prints current board
    //   nextBoard = Math.max(0, Math.min(chat(1) - 1, 8)); // nextBoard is player 1's move
    //   Tictactoe.reader(nextBoard, superBoard[currentBoard].getBoard(), 1); // reads input and makes adjustments
    //   if (Tictactoe.winChecker(1, superBoard[currentBoard])) { // winCheck
    //     System.out.println("Player 1 wins here! Full board state below");
    //     boardState.getBoard()[currentBoard / 3][currentBoard % 3] = 1; // minus 1 is a trial and later probably
    //                                                                    // error
    //     boardState.printBoard(); // puts a win on the full board state

    //   }
    //   Tictactoe.tieChecker(superBoard[currentBoard]);// checks for a tie
    //   if (Tictactoe.winChecker(1, boardState)) {
    //     System.out.println("Player 1 has won the game!");
    //     win = true;
    //   } // checks if someone has won the entire game
    //   if (Tictactoe.tieChecker(boardState)) {
    //     System.out.println("Cat's game");
    //     win = true;
    //   } // checks if the game is a tie
    //   Tictactoe.printSuperBoard(superBoard); // prints updated super board

    //   // end of player 1 turn, start of player two
    //   currentBoard = Tictactoe.nextBoardCheck(nextBoard, superBoard, 1);
    //   System.out.println("Player 2's turn on " + (currentBoard + 1)); // Says whos turn
    //   superBoard[currentBoard].printBoard(); // prints current board
    //   nextBoard = Math.max(0, Math.min(chat(2) - 1, 8)); // gets input from player 2
    //   Tictactoe.reader(nextBoard, superBoard[currentBoard].getBoard(), 2); // reads player 2 input
    //   if (Tictactoe.winChecker(2, superBoard[currentBoard])) {
    //     System.out.println("Player 2 wins here!");
    //     boardState.getBoard()[currentBoard / 3][currentBoard % 3] = 1;
    //     boardState.printBoard(); // puts a win on the full board
    //   }
    //   Tictactoe.tieChecker(superBoard[currentBoard]);
    //   if (Tictactoe.winChecker(1, boardState)) {
    //     System.out.println("Player 1 has won the game!");
    //     win = true;
    //   } // checks if someone has won the entire game
    //   if (Tictactoe.tieChecker(boardState)) {
    //     System.out.println("Cat's game");
    //     win = true;
    //   }
    //   Tictactoe.printSuperBoard(superBoard);
    //   // end of player 2 turn, restart game loop
