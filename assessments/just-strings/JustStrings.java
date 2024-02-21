import java.util.ArrayList;

public class JustStrings {

  public boolean isVowel(String c) {
    return "aeiou".indexOf(c) != -1;
  }
  public String insert(String word1, String word2, int index){
    String newWord = word1.substring(0, index) + word2 + word1.substring(index);
    return newWord;
  }
}
