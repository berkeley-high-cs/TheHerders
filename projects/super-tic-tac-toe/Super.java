import java.util.Scanner;

public class Super {
        int nextBoard;
        int currentBoard;
        Tictactoe boardState = new Tictactoe(-1);
        Tictactoe[] superBoard = new Tictactoe[9];
        public Super(){
            this.nextBoard = nextBoard;
            this.currentBoard = currentBoard;
            this.boardState = boardState;
            this.superBoard = superBoard;
        }
        public Tictactoe[] getSuperBoard() {
            return superBoard;
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

    public static void main(String[] args) {
        Super superBoard = new Super();
        
        for (int i = 0; i < 9; i++) {

            superBoard.getSuperBoard()[i] = new Tictactoe(i);

        }
        superBoard.printSuperBoard();
        currentBoard = Math.max(0, Math.min(p1StartChat() - 1, 8));
        boolean win = false;
        nextBoard = currentBoard;
        while (win != true) {
            currentBoard = Tictactoe.nextBoardCheck(nextBoard, superBoard, 0); // makes board previous play if
                                                                               // availiable
            Tictactoe.printSuperBoard(superBoard);
            System.out.println("Player 1's turn on " + (currentBoard + 1));
            superBoard[currentBoard].printBoard(); // prints current board
            nextBoard = Math.max(0, Math.min(chat(1) - 1, 8)); // nextBoard is player 1's move
            Tictactoe.reader(nextBoard, superBoard[currentBoard].getBoard(), 1); // reads input and makes adjustments
            if (Tictactoe.winChecker(1, superBoard[currentBoard])) { // winCheck
                System.out.println("Player 1 wins here! Full board state below");
                boardState.getBoard()[currentBoard / 3][currentBoard % 3] = 1; // minus 1 is a trial and later probably
                                                                               // error
                boardState.printBoard(); // puts a win on the full board state

            }
            Tictactoe.tieChecker(superBoard[currentBoard]);// checks for a tie
            if (Tictactoe.winChecker(1, boardState)) {
                System.out.println("Player 1 has won the game!");
                win = true;
            } // checks if someone has won the entire game
            if (Tictactoe.tieChecker(boardState)) {
                System.out.println("Cat's game");
                win = true;
            } // checks if the game is a tie
            Tictactoe.printSuperBoard(superBoard); // prints updated super board

            // end of player 1 turn, start of player two
            currentBoard = Tictactoe.nextBoardCheck(nextBoard, superBoard, 1);
            System.out.println("Player 2's turn on " + (currentBoard + 1)); // Says whos turn
            superBoard[currentBoard].printBoard(); // prints current board
            nextBoard = Math.max(0, Math.min(chat(2) - 1, 8)); // gets input from player 2
            Tictactoe.reader(nextBoard, superBoard[currentBoard].getBoard(), 2); // reads player 2 input
            if (Tictactoe.winChecker(2, superBoard[currentBoard])) {
                System.out.println("Player 2 wins here!");
                boardState.getBoard()[currentBoard / 3][currentBoard % 3] = 1;
                boardState.printBoard(); // puts a win on the full board
            }
            Tictactoe.tieChecker(superBoard[currentBoard]);
            if (Tictactoe.winChecker(1, boardState)) {
                System.out.println("Player 1 has won the game!");
                win = true;
            } // checks if someone has won the entire game
            if (Tictactoe.tieChecker(boardState)) {
                System.out.println("Cat's game");
                win = true;
            }
            Tictactoe.printSuperBoard(superBoard);
            // end of player 2 turn, restart game loop
        }
    }

    public void gameLoop() {

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
            superBoard[i].printRow(x);
            System.out.print("  |  ");
          }
          System.out.println("           |                      |                           |                           |");
        }
        System.out.println("______________________________________________________________________________");
        for (int x = 0; x < 3; x++) {
          for (int i = 3; i < 6; i++) {
            superBoard[i].printRow(x);
            System.out.print("  |  ");
          }
          System.out.println("           |                      |                           |                           |");
        }
    
        System.out.println("______________________________________________________________________________");
        for (int x = 0; x < 3; x++) {
          for (int i = 6; i < 9; i++) {
            superBoard[i].printRow(x);
            System.out.print("  |  ");
          }
          System.out.println("           |                      |                           |                           |");
        }
    
        System.out.println("______________________________________________________________________________");
    
      }
    
}
