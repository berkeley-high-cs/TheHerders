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

}
