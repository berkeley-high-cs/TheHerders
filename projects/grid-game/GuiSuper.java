import java.util.Scanner;

public class GuiSuper {

  int nextBoard = -1;
  int currentBoard;
  Tictactoe boardState = new Tictactoe(-1);
  Tictactoe[] boards = new Tictactoe[9];
  int turn = 0;

  public GuiSuper() {
    for (int i = 0; i < 9; i++) {
      boards[i] = new Tictactoe(i);
    }
  }
  public int getTurn(){
    return turn;
  }
  public void addTurn(){
    turn++;
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
    if (nextBoard == -1) nextBoard = n;
    currentBoard = n;
  }

  public static void main(String[] args) {
    GuiSuper superBoard = new GuiSuper();

    superBoard.printSuperBoard();
    superBoard.setCurrentBoard(Math.max(0, Math.min(p1StartChat() - 1, 8)));
    boolean win = false;
    while (win != true) {
      superBoard.gameLoop(superBoard, win, 1);
      superBoard.addTurn();
      superBoard.gameLoop(superBoard, win, 2);
      superBoard.addTurn();
    }
  }

  public void gameLoop(GuiSuper superBoard, boolean win, int player) {
    currentBoard = nextBoardCheck(nextBoard, boards, player); // makes board previous play if
    // availiable
    superBoard.printSuperBoard();
    superBoard.gameStateChecker(player, win); //checks all game states, super and otherwise
    //superBoard.printSuperBoard(); // prints updated super board
    System.out.println("Player " + player + "'s turn on " + (currentBoard + 1));
    boards[currentBoard].printBoard(); // prints current board
    
    superBoard.playerInput(superBoard, player); // recives player input, and sets board to it
    //System.out.println("about to run gameStateChecker");
    superBoard.gameStateChecker(player, win); //checks all game states, super and otherwise
    //superBoard.printSuperBoard(); // prints updated super board
    
  }

  // both chats just have text and then see the input from player and update it
  public static int p1StartChat() {
    System.out.println("");
    System.out.println(
      "What square would you like to start in? 1 through 9, left to right, up to down."
    );
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }

  public static int chat(int player) {
    System.out.println("");
    System.out.println("What is player " + player + "'s move? 1 through 9, left to right, up to down.");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
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
      System.out.println(
        "           |                      |                           |                           |"
      );
    }
    System.out.println(
      "______________________________________________________________________________"
    );
    for (int x = 0; x < 3; x++) {
      for (int i = 3; i < 6; i++) {
        boards[i].printRow(x);
        System.out.print("  |  ");
      }
      System.out.println(
        "           |                      |                           |                           |"
      );
    }

    System.out.println(
      "______________________________________________________________________________"
    );
    for (int x = 0; x < 3; x++) {
      for (int i = 6; i < 9; i++) {
        boards[i].printRow(x);
        System.out.print("  |  ");
      }
      System.out.println(
        "           |                      |                           |                           |"
      );
    }

    System.out.println(
      "______________________________________________________________________________"
    );
  }

  public int nextBoardCheck(int nextBoard, Tictactoe[] boards, int player) {
   
    if (boards[nextBoard].getWon()) {
     // printSuperBoard();
      System.out.println("That board has already been finished, where would player " + player + " like to go?");
      Scanner scanner = new Scanner(System.in);
      int newNextBoard = scanner.nextInt() - 1;
      if (nextBoardCheck(newNextBoard, boards, player) != nextBoard){
        return newNextBoard;
      } 
      
    } 
    return nextBoard;
    
    //throw new RuntimeException("Something about nextBoardCheck went wrong");
  }
  public void playerInput(GuiSuper superBoard, int player){
    nextBoard = Math.max(0, Math.min(chat(player) - 1, 8)); // nextBoard is player 1's move
    if (superBoard.getBoards()[currentBoard].isEmpty(nextBoard)) {
      superBoard.getBoards()[currentBoard].setAt(player, nextBoard); // reads input and makes adjustments MAKE THIS READER, MAKE READER WORK
    } else {
      System.out.println("That space is already taken, please try again");
      superBoard.playerInput(superBoard, player);
    }
  }
  public void gameStateChecker(int player, boolean win){
      if (Tictactoe.winChecker(player, boards[currentBoard])) { // winCheck
      System.out.println("Player " + player + " wins here! Full board state below");
      boardState.getBoard()[currentBoard / 3][currentBoard % 3] = player; //changes board state to reflect win
      boardState.printBoard(); // puts a win on the full board state
    }
    Tictactoe.tieChecker(boards[currentBoard]); // checks for a tie
    if (Tictactoe.winChecker(player, boardState)) {
      System.out.println("Player " + player + "has won the game!");
      win = true;
      
    } // checks if someone has won the entire game
    if (Tictactoe.tieChecker(boardState)) {
      System.out.println("Cat's game");
      win = true;
    }
  }
}