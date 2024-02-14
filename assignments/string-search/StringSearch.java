import java.util.ArrayList;

public class StringSearch {
  public String longestString(ArrayList<String> list){
    int longestIndex = 0;
    for (int i = 0; i < list.size(); i++){
      if (list.get(i).length() - 1 > longestIndex){
        longestIndex = i;
      }
    }
    return list.get(longestIndex);
  }
}
