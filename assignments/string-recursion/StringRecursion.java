public class StringRecursion {
  public int length(String word){
    String lessWord = word.substring(0);
    if (word.isEmpty()){
      return 0;
    } else {
      return lessWord.length();
    }
  }
}
