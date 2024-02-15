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
    for (int x = 0; x < 2; x++){
      if (x == 0){
        player = "X";
      } else if (x == 1){
        player = "O";
      }
      for (int i = 0; i < 3; i++) {
        if (player.equals((board)[i][0])) {
          if (player.equals((board)[i][1])) {
            if (player.equals((board)[i][2])) {
               
             
              return player;
              
            }

          }
        }
        if (player.equals((board)[0][i])) {
          if (player.equals((board)[1][i])) {
            if (player.equals((board)[2][i])) {
               
              
              return player;
            }
          }
        }
      }
      if (player.equals((board)[0][0])) {
        if (player.equals((board)[1][1])) {
          if (player.equals((board)[2][2])) {
             
            
            return player;
          }
        }
      }
      if (player.equals((board)[0][2])) {
        if (player.equals((board)[1][1])) {
          if (player.equals((board)[2][0])) {
             
            
            return player;
          }
        }
      }

    }
     return null;
  }
}
