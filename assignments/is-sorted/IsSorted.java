import java.util.ArrayList;

public class IsSorted {
  public boolean isSorted(ArrayList<Integer> list){
    int highestNum = 0;
    for (int i = 0; i < list.size(); i++){
      if (list[i] < highestNum){
        return false;
      } else {
        highestNum = list[i];
      }
    }
  }

}
