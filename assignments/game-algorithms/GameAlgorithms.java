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
    int maxX = Math.max(x - 1, 0);
    int minX = Math.min(x + 1, grid.length);
    int maxY = Math.max(y - 1,0);
    int minY = Math.min(y + 1, grid[x].length);
    return grid[maxX][y] + grid[x][maxY] + grid[mixX][y] + grid[x][minY];

  }

}
