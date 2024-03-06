import java.util.*;

public class Solver {

  public boolean inBounds(int x, int y, String[][] wall) {
    return ((x >= 0 && y >= 0) && (x < wall.length && y < wall[x].length));
  }

  public boolean inGrid(String word, String[][] puzzle) {
    int lettersMatched = 0;
    int direction = 0;
    
    for (int x = 0; x < puzzle.length; x++) {
      for (int y = 0; y < puzzle[x].length; y++) { //iterate through every character in the 2d array

        if (puzzle[x][y].equals(word.substring(0, 1))) {
          
          lettersMatched++; //check if its equal to the first charcter in word
                for (int i = 0; i < 8; i++){
                  
                     if (checkAround(x, y, 1, i, puzzle, word)){
                    direction = i;
                    i = 8;
                    lettersMatched++;
                    }
                }
              for (int z = 2; z < word.length(); z++) { //it then loops through checking if the second letter is around it a bunch
                  
                  
                if ((checkAround(x, y, z, direction, puzzle, word))) { //and goes as far as it can
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
   
    return false;
  }

  public boolean checkAround(
    int x,
    int y,
    int z,
    int i,
    String[][] puzzle,
    String word
  ) {
    int[] xAdds = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
    int[] yAdds = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
    int xCoor = x + (xAdds[i] * z);
    int yCoor = y + (yAdds[i] * z); 
   
    System.err.println("XCoor: " + xCoor + " yCoor: " + yCoor + " word.substring(z,z + 1): " + word.substring(z,z + 1));
    if (inBounds(xCoor,yCoor, puzzle)){
      System.err.println("puzzle[xCoor][yCoor]: " + puzzle[xCoor][yCoor] );
    }

    
  
      return (inBounds(yCoor,xCoor, puzzle) && (word.substring(z,z + 1).equals(puzzle[yCoor][xCoor])));



   
  }
  // public boolean checkPlace(int x, int y, String letter, String[][] puzzle){
  //   return inBounds(x, y, puzzle) && (letter.equals(puzzle[x][y]));
   
  // }
}