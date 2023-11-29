
class Latticepaths {
  static int boardLength = 21; // Counts points on each side, so a two by two grid has three points on each side and therfore is repreasented as 3
  static long[][] board = new long [boardLength + 1][boardLength + 1];
  public static void main(String[] args){
    
    
    long totalMoves = 0;
    // for (int x = 1; x <= boardLength; x++){
    //   for (int y = 1; y <= boardLength; y++){

            totalMoves = possiblePathsToPoint(boardLength, boardLength);
            System.out.println(totalMoves);
    //  }
    // }
    //woaringk on memeorizzztion where 2d array keeps values then access them
     
    } 
    public static long possiblePathsToPoint(int x, int y){
      int x1 =Math.max(0, x);
      int y1 = Math.max(0, y);
      if (board[x1][y1] != 0){
        return board[x1][y1];
      }
      if (x == 1 && y == 1){
        return 1;
      }
      if (x < 0 || y < 0){
        return 0;
      }
      long pathsToPoint = possiblePathsToPoint(x - 1, y) + possiblePathsToPoint(x, y - 1);
      //System.out.println("x is " + x + ". y is " + y);
      
      board[x1][y1] = pathsToPoint;
      
      return pathsToPoint;
    }

}


//possible paths to point code
//int validPaths = 0;
// for (int z = 0; z < y; z++){
//   for (int i = 0; i < x; i++){
//     if (isValidMove(i)){
//       validPaths++;
//     }
//   }
// }
//   return validPaths;













//after trying to math it out i did recursion
// public class Latticepaths {
//     public static void main(String[] args){
//         int[][] board = [3][3];
//         int totalMoves = 0;
//         for (int i = 0; i < 3; i++){
           
//                 totalMoves += isValidMove(i);
            
//          }
//          System.out.println(totalMoves);
//         } 
//         public int isValidMove(int x, int y){
//             int validMoves = 0;
//             if ((x + 1) < 3){
//                 validMoves++;
//             }
//             if((y + 1) < 3 ){
//                 validMoves++;
//             }
//             return validMoves;
//         }
//     }
//somethings I found, for grid x by x, x * 4 points are on the outside
// the amount of possible paths, for the ones I calculated, is equal to the 
// added amount of each possible path from a point divided by two, so in a one by one, 
// from the top left we add two because there are two paths from that point, then 
//from each of the points arrived from the first there is one possible path, adding to four.
//Dividing four by two gets us our correct answer of two







//tried to actually make the grid and show the movemnts, decided to just math that shtuff
// public class Latticepaths {
//     static int[][] grid =   {{0, 0},
//                              {0, 0}};
//     static int x = 0;
//     static int y = 0;
//     public static void main(String[] args){
//         grid[x][y] = 1;
//         printBoard(grid);
       
//        grid[x][y] = 1;
//        printBoard(grid);
       
//        grid[x][y] = 1;
//        printBoard(grid);
//         }
//     public static void move(){
//         int[] movements = {0,0};
//         int length = movements.length;
//         for (int i = 0; i <= length - 1; i++){
    
//         }
//     }
//     public static void printBoard (int[][] board) {
//         for(int i = 0; i < 2; i++) {
//             System.out.println((board[i][0]) + "  |  " + (board[i][1]));
// 					System.out.println("");
//                 if (i == 2){
//                     System.out.println("");
//                 }

//         }
//     }
// }
