public class GameAlgorithms {

  public boolean inBounds(int[][] bounds, int x, int y) {
    if (x >= bounds.length || x < 0) {
      return false;
    }
    if (y >= bounds[x].length || y < 0) {
      return false;
    }
    return true;
  }

  public int sum4Neighbors(int[][] grid, int x, int y) {
    int total = 0;
    int[] xValues = { 1, -1, 0, 0 };
    int[] yValues = { 0, 0, 1, -1 };
    for (int i = 0; i < 4; i++) {
      if (inBounds(grid, x + xValues[i], y + yValues[i])) {
        total += grid[x + xValues[i]][y + yValues[i]];
      }
    }

    return total;
  }

  public int sum8Neighbors(int[][] grid, int x, int y) {
    int total = 0;
    int[] xValues = { 1, -1, 0, 0, 1, -1, -1, 1 };
    int[] yValues = { 0, 0, 1, -1, 1, -1, 1, -1 };
    for (int i = 0; i < 8; i++) {
      if (inBounds(grid, x + xValues[i], y + yValues[i])) {
        total += grid[x + xValues[i]][y + yValues[i]];
      }
    }
    return total;
  }
  public boolean areNeighbors(int x1, int y1, int x2, int y2){
     int[] xValues = { 1, -1, 0, 0, 1, -1, -1, 1 };
    int[] yValues = { 0, 0, 1, -1, 1, -1, 1, -1 };
    for (int i = 0; i < 8; i++) {
      if (x1 + xValues[i] == x2 && y1 + yValues[i] == y2) {
        return true;
      } 
    }
    return false;
  }
  public String ticTacToeWinner(String[][] board){
    String player = "";
    for (int i = 0; i < 2; i++){
      if (i == 0){
        player = "X";
      } else if (i == 1){
        player = "O"
      }
      for (int i = 0; i < 3; i++) {
        if ((board)[i][0].equals(player)) {
          if ((board)[i][1].equals(player)) {
            if ((board)[i][2].equals(player)) {
               
             
              return player;
              
            }

          }
        }
        if ((board)[0][i].equals(player)) {
          if ((board)[1][i].equals(player)) {
            if ((board)[2][i].equals(player)) {
               
              
              return player;
            }
          }
        }
      }
      if ((board)[0][0].equals(player)) {
        if ((board)[1][1].equals(player)) {
          if ((board)[2][2].equals(player)) {
             
            
            return player;
          }
        }
      }
      if ((board)[0][2].equals(player)) {
        if ((board)[1][1].equals(player)) {
          if ((board)[2][0].equals(player)) {
             
            
            return player;
          }
        }
      }

    }
     return null;
  }
}
