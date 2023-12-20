public class Super {

    public static int[][] boardBase = new int[3][3];
   public static void main(String[] args){
    int nextBoard = 0;
    int currentBoard = 0;
    int[][] boardState = {
        { 0, 0, 0 },
        { 0, 0, 0 },
        { 0, 0, 0 }
    };
    Tictactoe[] superBoard = new Tictactoe [9];
    for (int i = 0; i < 9; i++){
     
        superBoard[i] = new Tictactoe (i);
        
    }
    Tictactoe.printSuperBoard(superBoard);
    currentBoard = Math.max(0,Math.min(Tictactoe.p1StartChat() - 1, 8));
    boolean win = false;
    nextBoard = currentBoard;
    while (win != true){
    currentBoard = nextBoard; //makes board previous play
    Tictactoe.printSuperBoard(superBoard);
    System.out.println("Player 1's turn on " + (currentBoard + 1));
    Tictactoe.printBoard(superBoard[currentBoard].getBoard()); //prints current board
    nextBoard = Math.max(0,Math.min(Tictactoe.chat(1) - 1, 8)); //nextBoard is player 1's move
    Tictactoe.reader(nextBoard, superBoard[currentBoard].getBoard(), 1); //reads input and makes adjustments
    Tictactoe.printSuperBoard(superBoard); // prints updated super board
    //put win check here
    //end of player 1 turn, start of player two
    currentBoard = nextBoard;
    System.out.println("Player 2's turn on " + (currentBoard + 1)); //Says whos turn
    Tictactoe.printBoard(superBoard[currentBoard].getBoard()); // prints current board
    nextBoard = Math.max(0,Math.min(Tictactoe.chat(2) - 1, 8)); //gets input from player 2
    Tictactoe.reader(nextBoard, superBoard[currentBoard].getBoard(), 2); //reads player 2 input

    //put win check here
    //end of player 2 turn, restart game loop
   }
        // String test = ("");
      
        // boolean winCon = false;
        // while (winCon == false) {
        //   for (int i = 0; i < 9; i++) {
        //     chat(test);
        //     reader(p1Input);
        //     printBoard(board);
        //     checker(1);
        //     i++;
        //     if (i == 9) {
        //       tieChecker();
        //       winCon = true;
        //       break;
        //     }
        //     if (win == true) {
        //       winCon = true;
        //       break;
        //     }
    
        //     p2Chat(test);
        //     p2Reader(p2Input);
        //     printBoard(board);
        //     checker(2);
        //     if (i == 9) {
        //       tieChecker();
        //       winCon = true;
        //       break;
        //     }
        //     if (win == true) {
        //       winCon = true;
        //     }
        //   }
        // }
      }
   } 
