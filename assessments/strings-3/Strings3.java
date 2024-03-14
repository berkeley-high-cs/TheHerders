import java.util.ArrayList;

public class Strings3 {
  public String insertBefore(String word, String insert, String index){
    return word.substring(0, word.indexOf(index)) + insert + word.substring(word.indexOf(index));
  }
  public String insertAfter(String word, String insert, String index){
    return word.substring(0, word.indexOf(index) + index.length()) + insert + word.substring(word.indexOf(index) + index.length());
  }
  public String reverse(String word){
    String reversed = "";
    for (int i = word.length(); i < 0; i--){
      reversed = reversed + word.substring(i, i - 1);
    }
    return reversed;
  }
}
