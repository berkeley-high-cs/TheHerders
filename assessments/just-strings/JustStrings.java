import java.util.ArrayList;

public class JustStrings {

  public boolean isVowel(String c) {
    return "aeiou".indexOf(c) != -1;
  }

  public String insert(String word1, String word2, int index) {
    return word1.substring(0, index) + word2 + word1.substring(index);
  }

  public String deleteFirst(String word1, String word2) {
    return (
      word1.substring(0, word1.indexOf(word2)) +
      word1.substring(word1.indexOf(word2) + word2.length())
    );
  }

  public String deleteAll(String word1, String word2) {
    String newWord = word1;
    while (newWord.indexOf(word2) != -1) {
      newWord = deleteFirst(newWord, word2);
    }
    return newWord;
  }

  public String nCharacters(String word, int n, int i) {
    return word.substring(i, i + n);
  }

  public String nCharactersBefore(String word, int n, String word2) {
    return word.substring(word.indexOf(word2) - n, word.indexOf(word2));
  }

  public String nCharactersAfter(String word, int n, String word2) {
    return word.substring(
      word.indexOf(word2) + word2.length(),
      word.indexOf(word2) + word2.length() + n
    );
  }

  public boolean isPalindrome(String word) {
    String flippedWord = "";
    for (int i = word.length() - 1; i >= 0; i--) {
      flippedWord = flippedWord + word.substring(i, i + 1);
      // System.err.println(flippedWord);
    }
    return flippedWord.equals(word);
  }

  public String ubbieDubbie(String word) {
    String newWord = word;
    int ubAmount = 0;
    for (int i = 0; i < word.length(); i++) {
      if (isVowel(word.substring(i, i + 1))) {
        if (i == 0) {
          newWord = newWord.substring(0, i + ubAmount) + "ub" + newWord.substring(i + ubAmount);
          ubAmount++;
        } else if (!isVowel(word.substring(i - 1, i))) {
          newWord = newWord.substring(0, i + ubAmount) + "ub" + newWord.substring(i + ubAmount);
          ubAmount++;
        }
      }
    }
    return newWord;
  }
  // public String runLengthEncoding(String word){
  //   String newWord = word;
  //   for (int i)
  // }

}
