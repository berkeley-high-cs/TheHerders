public class StringRecursion {
  public int length(String word){
    
    if (word.isEmpty()){
      return 0;
    } else {
      String lessWord = word.substring(1);
      return length(lessWord) + 1;
    }
  }
}
