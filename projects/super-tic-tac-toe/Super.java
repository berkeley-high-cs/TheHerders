public class Super {
    
    
    public static void main(String[] args) {
       // private int[][] boardBase = new int[3][3];
    int nextBoard;
    int currentBoard;
    Tictactoe boardState = new Tictactoe(-1);
    Tictactoe[] superBoard = new Tictactoe[9];
        for (int i = 0; i < 9; i++) {

            superBoard[i] = new Tictactoe(i);

        }
        Tictactoe.printSuperBoard(superBoard);
        currentBoard = Math.max(0, Math.min(Tictactoe.p1StartChat() - 1, 8));
        boolean win = false;
        nextBoard = currentBoard;
        while (win != true) {
            currentBoard = Tictactoe.nextBoardCheck(nextBoard, superBoard, 0); // makes board previous play if availiable
            Tictactoe.printSuperBoard(superBoard);
            System.out.println("Player 1's turn on " + (currentBoard + 1));
            superBoard[currentBoard].printBoard(); // prints current board
            nextBoard = Math.max(0, Math.min(Tictactoe.chat(1) - 1, 8)); // nextBoard is player 1's move
            Tictactoe.reader(nextBoard, superBoard[currentBoard].getBoard(), 1); // reads input and makes adjustments
            if (Tictactoe.winChecker(1, superBoard[currentBoard])) { //winCheck
                System.out.println("Player 1 wins here! Full board state below");
                boardState.getBoard()[Tictactoe.digitToBoardCoord(currentBoard)][currentBoard  % 3] = 1; //minus 1 is a trial and later probably error
                boardState.printBoard(); //puts a win on the full board state
                
            }
            Tictactoe.tieChecker(superBoard[currentBoard]);//checks for a tie
            if (Tictactoe.winChecker(1, boardState)){
                System.out.println("Player 1 has won the game!");
                win = true;
            } //checks if someone has won the entire game
            if (Tictactoe.tieChecker(boardState)){
                System.out.println("Cat's game");
                win = true;
            } // checks if the game is a tie
            Tictactoe.printSuperBoard(superBoard); // prints updated super board


            // end of player 1 turn, start of player two
            currentBoard = Tictactoe.nextBoardCheck(nextBoard, superBoard, 1);
            System.out.println("Player 2's turn on " + (currentBoard + 1)); // Says whos turn
            superBoard[currentBoard].printBoard(); // prints current board
            nextBoard = Math.max(0, Math.min(Tictactoe.chat(2) - 1, 8)); // gets input from player 2
            Tictactoe.reader(nextBoard, superBoard[currentBoard].getBoard(), 2); // reads player 2 input
            if (Tictactoe.winChecker(2, superBoard[currentBoard])) {
                System.out.println("Player 2 wins here!");
                boardState.getBoard()[Tictactoe.digitToBoardCoord(currentBoard)][currentBoard % 3] = 1;
                boardState.printBoard(); //puts a win on the full board
            } 
            Tictactoe.tieChecker(superBoard[currentBoard]);
            if (Tictactoe.winChecker(1, boardState)){
                System.out.println("Player 1 has won the game!");
                win = true;
            } //checks if someone has won the entire game
            if (Tictactoe.tieChecker(boardState)){
                System.out.println("Cat's game");
                win = true;
            }
            Tictactoe.printSuperBoard(superBoard);
            // end of player 2 turn, restart game loop
        }
    }
    public void gameLoop(){

    }
}
