import java.util.*;

public class Solver extends Helper3 {
   public boolean inBounds(int row, int col, String[][] wall) {
    return ((row >= 0 && col >= 0) && (row < wall.length && col < wall[row].length));
  }
  public boolean startingAt(String word, String[][] puzzle, int row, int col){
    int[] rowAdds = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int[] colAdds = { -1, 0, 1, -1, 1, -1, 0, 1 };
    for (int i = 0; i < 8; i++){
      if (atAndInDirection(word, puzzle, row, col, rowAdds[i], colAdds[i])){
        return true;
      }
    }
    return false;
  }
   public boolean inGrid(String word, String[][] puzzle) {

    for (int row = 0; row < puzzle.length; row++) {
      for (int col = 0; col < puzzle[row].length; col++) { //iterate through evercol character in the 2d arracol

        if (puzzle[row][col].equals(word.substring(0, 1))) {
          if (startingAt(word, puzzle, row, col)){
            return true;
          }
      } 
    }
  }
  return false;

}
}
