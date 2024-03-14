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
    for (int i = word.length() - 1; i >= 0; i--){
      reversed = reversed + word.substring(i, i + 1);
    }
    return reversed;
  }
  public String despace(String word){
    String newWord = word;
    while (newWord.indexOf(" ") != -1){
      newWord = newWord.substring(0, newWord.indexOf(" ")) + newWord.substring(newWord.indexOf(" ") + 1);
    }
    return newWord;
    
  }
  public String join (ArrayList<String> list, String delimiter){
    String joint = "";
    for (int i = 0; i < list.size(); i++){
      if (i == list.size() - 1){
        joint = joint + list.get(i);
      } else {
        joint = joint + list.get(i) + delimiter;
      }
      
    }
    return joint;
  }
  public boolean isSorted(String[] list){
    for (int i = 0; i < list.length - 1; i++){
      if (list[i].compareTo(list[i + 1]) > 0){
        return false;
      }
    }
    return true;
  }
  public ArrayList<String> allSubstrings(String word){
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < list.size(); i++){
      for (int x = i + 1; x < list.size(); x++){
              list.add(word.substring(i, x));
      }    
    }
    return list;
  }
}
