import java.util.*;

public class Solver {

  public boolean inBounds(int row, int col, String[][] wall) {
    return (
      (row >= 0 && col >= 0) && (row < wall.length && col < wall[row].length)
    );
  }

  public boolean atAndInDirection(String word, String[][] puzzle, int row, int col, int rowChange, int colChange) {
    int rowCoor = 0;
    int colCoor = 0;
    for (int i = 0; i < word.length(); i++) {

      rowCoor = row + (rowChange * i);
      colCoor = col + (colChange * i);

      if (inBounds(rowCoor, colCoor, puzzle) && !(rowChange == 0 && colChange == 0) && puzzle[rowCoor][colCoor].equals(word.substring(i, i + 1))) {
        return true;
      }
    }
    return false;
  }

  public boolean startingAt(String word, String[][] puzzle, int row, int col) {
    int[] rowChange = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int[] colChange = { -1, 0, 1, -1, 1, -1, 0, 1 };
    for (int i = 0; i < 8; i++) {
      if (atAndInDirection(word, puzzle, row, col, rowChange[i], colChange[i])) {
        return true;
      }
    }
    return false;
  }

  public boolean inGrid(String word, String[][] puzzle) {
    for (int row = 0; row < puzzle.length; row++) {
      for (int col = 0; col < puzzle[row].length; col++) { //iterate through every character in the 2d array
        if (puzzle[row][col].equals(word.substring(0, 1))) {
          if (startingAt(word, puzzle, row, col)) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
