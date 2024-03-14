import java.util.ArrayList;

public class Strings3 {
  public String insertBefore(String word, String insert, String index){
    String newWord = word;
    newWord = newWord.substring(0, word.indexOf(index)) + insert + newWord.substring(word.indexOf(index));
    return newWord;
  }
}
