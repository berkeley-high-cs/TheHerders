import java.util.ArrayList;

public class JustStrings {

  public boolean isVowel(String c) {
    return "aeiou".indexOf(c) != -1;
  }
  public String insert(String word1, String word2, int index){
    return word1.substring(0, index) + word2 + word1.substring(index);
  }
  public String deleteFirst(String word1, String word2){
    String newWord = word1.substring(0, word1.indexOf(word2));
    newWord = newWord + word1.substring(word1.indexOf(word2) + word2.length());
    //return word1.substring(0, word1.indexOf(word2)) + word1.substring(word1.indexOf(word2), word1.indexOf(word2) + word2.length());
    return newWord;
  }

}
