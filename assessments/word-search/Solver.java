import java.util.*;

public class Solver {

  public boolean inBounds(int row, int col, String[][] wall) {
    return ((row >= 0 && col >= 0) && (row < wall.length && col < wall[row].length));
  }

  public boolean inGrid(String word, String[][] puzzle) {
    int lettersMatched = 0;
    int direction = 0;
    boolean secondLetterFound = false;
    boolean errorTestingCheckAround = false;

    for (int row = 0; row < puzzle.length; row++) {
      for (int col = 0; col < puzzle[row].length; col++) { //iterate through every character in the 2d array

        if (puzzle[row][col].equals(word.substring(0, 1))) {

          lettersMatched++; //check if its equal to the first charcter in word

          
            if (secondLetterFound){
            for (int z = 2; z < word.length(); z++) { //it then loops through checking if the second letter is around it a bunch
                if ((checkAround(row, col, z, direction, puzzle, word))) { //and goes as far as it can
                  errorTestingCheckAround = true;
                  lettersMatched++; // adding for each letter found
                } else {
                  lettersMatched = 1;
                  errorTestingCheckAround = false;
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

  public boolean checkAround( int row, int col, int z, int i, String[][] puzzle, String word) {
    int[] rowAdds = { -1, -1, -1, 0, 0, 1, 1, 1 };
    int[] colAdds = { -1, 0, 1, -1, 1, -1, 0, 1 };
    int rowCoor = row + (rowAdds[i] * z);
    int colCoor = col + (colAdds[i] * z);
    return (inBounds(rowCoor, colCoor, puzzle) && (word.substring(z, z + 1).equals(puzzle[rowCoor][colCoor])));
  }
  public int secondLetterFound (int row, int col, String word, String[][] puzzle){
    for (int i = 0; i < 8; i++) {

            if (checkAround(row, col, 1, i, puzzle, word)) {
              return direction;
              // direction = i;
              // lettersMatched++;
              // secondLetterFound = true;
            } 
            
  }
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
}


// System.err.println("////////////////////////////////////////////////////////////////////////////");
//  System.err.println("////////////////////////////////////////////////////////////////////////////");
//  System.err.println(" word: " + word);
//  System.err.println("puzzle[rowCoor][row]: " + puzzle[row][col] );
 // System.err.println("letters Matched: " + lettersMatched);
//  System.err.println("direction: " + direction);
// System.err.println("errorTestingCheckAround" + errorTestingCheckAround);
//        System.err.println("////////////////////////////////////////////////////////////////////////////");
//  System.err.println("////////////////////////////////////////////////////////////////////////////");
//   System.err.println("word: " + word);       
//   System.err.println("rowCoor: " + rowCoor + " colCoor: " + colCoor + " word.substring(z,z + 1): " + word.substring(z,z + 1));
// if (inBounds(rowCoor,colCoor, puzzle)){
//   System.err.println("puzzle[rowCoor][colCoor]: " + puzzle[rowCoor][colCoor] );
// }
   