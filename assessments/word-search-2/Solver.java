import java.util.*;

public class Solver extends Helper2 {
  public boolean inBounds(int row, int col, String[][] wall) {
    return ((row >= 0 && col >= 0) && (row < wall.length && col < wall[row].length));
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
