import java.util.*;

public class Quicksort {
  public ArrayList<Integer> quicksort(ArrayList<Integer> list){
    if (list.size() == 0){
      return list;
    }
    int pivot = list.get(0);
    ArrayList<Integer> smallList = new ArrayList<>();
    ArrayList<Integer> bigList = new ArrayList<>();
    ArrayList<Integer> finalList = new ArrayList<>();
    for (int i = 1; i < list.size(); i++){
      if (list.get(i) > pivot){
        bigList.add(list.get(i));
      } else {
        smallList.add(list.get(i));
      }
    }
    finalList.addAll(smallList);
    finalList.add(pivot);
    finalList.addAll(bigList);
    return finalList;
  }


}
