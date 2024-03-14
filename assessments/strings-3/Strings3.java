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
    for (int i = 0; i < word.length(); i++){
      for (int x = i + 1; x <= word.length(); x++){
              list.add(word.substring(i, x));
      }    
    }
    return list;
  }
  public boolean isDigit(String word){
    String listOfDigits = "0123456789";
    if(word.length() == 1){
      if (listOfDigits.indexOf(word) != -1){
        return true;
      }
    } 
    return false;

  }
  public ArrayList<Integer> numbers(String word){
     ArrayList<Integer> list = new ArrayList<>();
     String currentNum = "";
    for (int i = 0; i < word.length(); i++){
      if (isDigit(word.substring(i, i+1))){
        currentNum = currentNum + word.substring(i, i+1);
      } else if(!currentNum.equals("")){
        list.add(Integer.parseInt(currentNum));
        currentNum = "";
      }
    }
    list.add(Integer.parseInt(currentNum));

    return list;
  }
}


    // String num = "69";
    // System.err.println(Integer.parseInt(num) + 2);