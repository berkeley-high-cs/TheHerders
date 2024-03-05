import java.util.*;

public class Solver {
 public boolean inBounds(int x, int y, String[][] wall){
    return ( (x >= 0 && y >= 0) && (x < wall.length && y < wall[x].length));
 }
 public boolean inGrid(String word, String[][] puzzle){
 
  for (int x = 0; x < puzzle.length; x++){
    for (int y = 0; y < puzzle[x].length; y++){
      if (puzzle[x][y].equals(word.substring(0,1))){
          for (int i = 0; i < 8; i++){
            if (checkAround(x, y, puzzle, word)){
              return true; //so far, just checks for first two characters of a string
            }
          }
      }
    }
  }
  return false;
 }
 public boolean checkAround(int x, int y, String[][] puzzle, String word){
   int[] xAdds = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
  int[] yAdds = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
  return inBounds(x + xAdds[i], y + yAdds[i], puzzle) && word.substring(1,2).equals(puzzle[x+xAdds[i]][y+yAdds[i]]);
 }
}
