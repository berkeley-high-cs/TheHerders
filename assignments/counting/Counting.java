import java.util.ArrayList;

public class Counting {

  // You'll need to use this method
  public boolean isVowel(String c) {
    return "aeiou".indexOf(c) != -1;
  }
  public int countLetter(String first, String second){
    int count = 0;
    for (int i = 0; i < first.length(); i++){
      if (first.substring(i, i+1).equals(second)){
        count++;
      }
    }
    return count;
  }
  public int countNumber(int[] array, int num){
    int count = 0;
    for (int i = 0; i < array.length; i++){
      if (array[i] == num){
        count++;
      }
    }
    return count;
  }
  public int countString(ArrayList<String> arrayList, String word){
    int count = 0
    for (int i = 0; i < arrayList.size; i++){
      if(arrayList.get(i).equals(word)){
        count++;
      }
    }
    return count;
  }

}
