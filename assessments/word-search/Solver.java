import java.util.*;

public class Solver {

  public boolean inBounds(int row, int col, String[][] wall) {
    return ((row >= 0 && col >= 0) && (row < wall.length && col < wall[row].length));
  }

  public boolean inGrid(String word, String[][] puzzle) {
    int lettersMatched = 0;
    int direction = 0;

    for (int row = 0; row < puzzle.length; row++) {
      for (int col = 0; col < puzzle[row].length; col++) { //iterate through every character in the 2d array

        if (puzzle[row][col].equals(word.substring(0, 1))) {

          lettersMatched++; //check if its equal to the first charcter in word

          for (int i = 0; i < 8; i++) {

            if (checkAround(row, col, 1, i, puzzle, word)) {

              direction = i;
              i = 8;
              lettersMatched++;

              for (int z = 2; z < word.length(); z++) { //it then loops through checking if the second letter is around it a bunch

                if ((checkAround(row, col, z, direction, puzzle, word))) { //and goes as far as it can
                
                  lettersMatched++; // adding for each letter found
                }
              }
            }
          }

          if (lettersMatched == word.length()) { // if the letters found equal the word length
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
    int row,
    int col,
    int z,
    int i,
    String[][] puzzle,
    String word
  ) {
    int[] rowAdds = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int[] colAdds = { -1, 0, 1, -1, 1, -1, 0, 1 };
    int rowCoor = row + (rowAdds[i] * z);
    int colCoor = col + (colAdds[i] * z);
    if (!(inBounds(rowCoor, colCoor, puzzle) && (word.substring(z, z + 1).equals(puzzle[rowCoor][colCoor])))){
         System.err.println("rowCoor: " + rowCoor + " colCoor: " + colCoor + " word.substring(z,z + 1): " + word.substring(z,z + 1));
    if (inBounds(rowCoor,colCoor, puzzle)){
      System.err.println("puzzle[rowCoor][colCoor]: " + puzzle[rowCoor][colCoor] );
    }
    if (z != 1){
      System.err.println("direction: " + i);
    }
    }

   

    return (inBounds(rowCoor, colCoor, puzzle) && (word.substring(z, z + 1).equals(puzzle[rowCoor][colCoor])));
  }

  public ArrayList<String> found(String[][] wall, ArrayList<String> list) {
    ArrayList<String> newList = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      if (inGrid(list.get(i), wall)) {
        newList.add(list.get(i));
      }
    }
    return newList;
  }
  // public boolean checkPlace(int row, int col, String letter, String[][] puzzle){
  //   return inBounds(row, col, puzzle) && (letter.equals(puzzle[row][col]));

  // }
}
