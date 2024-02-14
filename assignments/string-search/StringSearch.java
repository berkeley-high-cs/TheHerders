import java.util.ArrayList;

public class StringSearch {
  public String longestString(ArrayList<String> list){
    int longestIndex = 0;
    for (int i = 0; i < list.size(); i++){
      if (list.get(i).length() > list.get(longestIndex).length()){
        longestIndex = i;
      }
    }
    return list.get(longestIndex);
  }
  public ArrayList<Integer> xPositions(String word){
    ArrayList<> indexList = new ArrayList<Integer>;
    for (int i = 0; i < word.length(); i++){
      if (word.substring(i,i+1).equals("x")){
        indexList.add(i);
      }
    }
    return indexList;
  }
}
