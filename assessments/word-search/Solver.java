import java.util.*;

public class Solver {

  public boolean inBounds(int x, int y, String[][] wall) {
    return ((x >= 0 && y >= 0) && (x < wall.length && y < wall[x].length));
  }

  public boolean inGrid(String word, String[][] puzzle) {
    int lettersMatched = 0;
    for (int x = 0; x < puzzle.length; x++) {
      for (int y = 0; y < puzzle[x].length; y++) { //iterate through every character in the 2d array

        if (puzzle[x][y].equals(word.substring(0, 1))) { //check if its equal to the first charcter in word

            if (checkAround(x, y, puzzle, word)) { // if it finds the next character around it

              for (int z = 0; z < word.length() - 2; z++) { // it loops through the word count minus the words weve checked
                 int[] xAdds = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
                 int[] yAdds = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
                if (checkPlace(x + xAdds * z, y + yAdds * z, word.substring(z, z + 1), puzzle)) { //and goes as far as it can
                  lettersMatched++; // adding for each letter found
                }
              } 
              if (lettersMatched == word.length()){ // if the letters found equal the word length
                return true; //we did it
              } else {
                lettersMatched = 0; //else we try again
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
    String[][] puzzle,
    String word
  ) {
    int[] xAdds = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
    int[] yAdds = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
    for (int i = 0; i < 8; i++){
    
      if (inBounds(x + xAdds[i], y + yAdds[i], puzzle) && (word.substring(1, 2).equals(puzzle[x + xAdds[i]][y + yAdds[i]]))){
        return true;
      }
    }
    return false;
   
  }
  public boolean checkPlace(int x, int y, String letter, String[][] puzzle){
    return inBounds(x, y, puzzle) && (letter.equals(puzzle[x][y]));
   
  }
}
