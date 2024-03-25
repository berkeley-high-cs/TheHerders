import java.util.*;

public class Quicksort {
  public ArrayList<Integer> quicksort(ArrayList<Integer> list){
    if (list.size() == 0 || list.size() == 1){
      return list;
    }
    
  //   if (isSorted(list)){
  //  //  System.err.println(isSorted(list));
  //     return list;
  //   }
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
    finalList.addAll(quicksort(smallList));
    finalList.add(pivot);
    finalList.addAll(quicksort(bigList));
    return finalList;
  }
  // public boolean isSorted(ArrayList<Integer> list){
  //   for (int i = 1; i < list.size(); i++){
  //     if (!(list.get(i) > list.get(i - 1))){
  //       return false;
  //     }
  //   }
  //   return true;
  // }


}
