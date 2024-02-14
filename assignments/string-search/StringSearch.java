import java.util.ArrayList;

public class StringSearch {
  public String longestString(ArrayList<String> list){
    int longestIndex
    for (int i = 0; i < list.size(); i++){
      if (list.get(i).length() > longestIndex){
        longestIndex = i;
      }
    }
    return list.get(longestIndex);
  }
}
