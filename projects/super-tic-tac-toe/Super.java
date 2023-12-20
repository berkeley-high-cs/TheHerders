public class Super {

    public static int[][] boardBase = new int[3][3];
   public static void main(String[] args){
    int[][] boardState = {
        { 0, 0, 0 },
        { 0, 0, 0 },
        { 0, 0, 0 }
    };
    Tictactoe[] superBoard = new Tictactoe [9];
    for (int i = 0; i < 9; i++){
     
        superBoard[i] = new Tictactoe (i);
        
    }
    (superBoard[2].getBoard())[0][0] = 1;
    Tictactoe.printSuperBoard(superBoard);
        // String test = ("");
      
        // boolean winCon = false;
        // while (winCon == false) {
        //   for (int i = 0; i < 9; i++) {
        //     p1Chat(test);
        //     p1Reader(p1Input);
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
