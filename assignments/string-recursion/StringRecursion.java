public class StringRecursion {
  public int length(String word){
    
    if (word.isEmpty()){
      return 0;
    } else {
      return length(word.substring(1)) + 1;
    }
  }
  public int countXs(String word){
    if (word.isEmpty()){
      return 0;
    } else if(word.equals("x")){
      return 1;
    } else {
      return countXs(word.substring(1));
    }
  }
}
