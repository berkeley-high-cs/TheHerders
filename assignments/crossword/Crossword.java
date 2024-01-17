import java.util.*;

public class Crossword {

  public boolean fits(String guess, String word) {
    if (guess.length() != word.length()) {
      return false;
    }
    for (int i = 0; i < word.length(); i++) {
      if (
        (
          guess
            .substring(Math.max(i - 1, 0), i)
            .equals(word.substring(Math.max(i - 1, 0), i))
        ) ||
        word.substring(Math.max(i - 1, 0), i).equals("-")
      ) {} else {
        return false;
      }
    }
    return true;
  }

  public ArrayList<String> possiblities(String word, ArrayList<String> words) {
    ArrayList<String> copyWords = new ArrayList<>(words);
    for (int i = 0; i < strings.size(); i++) {
      if (!fits(copyWords.get(i), word)) {
        copyWords.remove(i);
        i--;
      }
    }
    return copyWords;
  }
}
