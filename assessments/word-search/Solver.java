import java.util.*;

public class Solver {

  public boolean inBounds(int x, int y, String[][] wall) {
    return ((x >= 0 && y >= 0) && (x < wall.length && y < wall[x].length));
  }

  public boolean inGrid(String word, String[][] puzzle) {
    int lettersMatched = 0;
    for (int x = 0; x < puzzle.length; x++) {
      for (int y = 0; y < puzzle[x].length; y++) {
        if (puzzle[x][y].equals(word.substring(0, 1))) {
          for (int i = 0; i < 8; i++) {
            if (checkAround(x, y, i, puzzle, word)) {
              for (int z = 0; z < word.length(); z++) {
                if (!checkAround(x, y, i, puzzle, word)) {
                  lettersMatched++;
                }
                // return true; //so far, just checks for first two characters of a string
              } 
              if (lettersMatched == word.length()){
                return true;
              } else {
                lettersMatched = 0;
              }
            }
          }
        }
      }
    }
   
    return false;
  }

  public boolean checkAround(
    int x,
    int y,
    int i,
    String[][] puzzle,
    String word
  ) {
    int[] xAdds = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
    int[] yAdds = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
    return (
      inBounds(x + xAdds[i], y + yAdds[i], puzzle) &&
      word.substring(1, 2).equals(puzzle[x + xAdds[i]][y + yAdds[i]])
    );
  }
}
