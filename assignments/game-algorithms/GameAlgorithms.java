public class GameAlgorithms {
  public boolean inBounds(int[][] bounds, int x, int y){
    if (x >= bounds.length){
      return false;
    } 
    if (y >= bounds[x].length){
      return false;
    } 
    return true;
  }

}
