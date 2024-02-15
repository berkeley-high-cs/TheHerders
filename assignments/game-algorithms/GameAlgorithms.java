public class GameAlgorithms {
  public boolean inBounds(int[][] bounds, int x, int y){
    if (x >= bounds.length || x < 0){
      return false;
    } 
    if (y >= bounds[x].length || y < 0){
      return false;
    } 
    return true;
  }
  public int sum4Neighbors(int[][] grid, int x, int y){
    int total = 0;

    if (inBounds(grid, x+1, y)){
      total += grid[x+1][y];
    } 
    if (inBounds(grid, x-1, y)){
      total += grid[x-1][y];
    }
     if (inBounds(grid, x, y+1)){
      total += grid[x][y+1];
    } 
    if (inBounds(grid, x, y-1)){
      total += grid[x][y-1];
    }
    return total;

  }
  public int sum8Neighbors(int[][ grid, int x, int y]){
    int total = 0;

    if (inBounds(grid, x+1, y)){
      total += grid[x+1][y];
    } 
    if (inBounds(grid, x-1, y)){
      total += grid[x-1][y];
    }
     if (inBounds(grid, x, y+1)){
      total += grid[x][y+1];
    } 
    if (inBounds(grid, x, y-1)){
      total += grid[x][y-1];
    }
    return total;
  }

}
