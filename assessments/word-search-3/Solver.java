import java.util.*;

public class Solver extends Helper3 {
   public boolean inBounds(int row, int col, String[][] wall) {
    return ((row >= 0 && col >= 0) && (row < wall.length && col < wall[row].length));
  }
  public boolean startingAt(String word, String[][] puzzle, int row, int col){
    int[] xAdds = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int[] yAdds = { -1, 0, 1, -1, 1, -1, 0, 1 };
    for (int i = 0; i < 8; i++){
      if (atAndInDirection(word, puzzle, row, col, xAdds[i], yAdds[i])){
        return true;
      }
    }
    return false;
  }
}
