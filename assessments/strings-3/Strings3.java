import java.util.ArrayList;

public class Strings3 {
  public String insertBefore(String word, String insert, String index){
    return word.substring(0, word.indexOf(index)) + insert + word.substring(word.indexOf(index));
  }
}
