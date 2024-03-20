public class StringRecursion {
  public int length(String word){
    String lessWord = word.substring(1);
    if (word.isEmpty()){
      return 0;
    } else {
      return lessWord.length();
    }
  }
}
