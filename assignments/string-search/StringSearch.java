import java.util.ArrayList;

public class StringSearch {
  public String longestString(ArrayList<String> list){
    int longestIndex = 0;
    for (int i = 0; i < list.size(); i++){
      if (list.get(i).length() > longestIndex - 1){
        longestIndex = i;
      }
    }
    return list.get(longestIndex);
  }
}
