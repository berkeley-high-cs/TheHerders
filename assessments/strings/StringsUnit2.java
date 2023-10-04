public class StringsUnit2 {

  // Write methods here. They should be public but not static.
  public String firstCharacter(String s){
    return s.substring(0,1);
  }
  public String lastCharacter(String s){
    String secondLast = s.length() - 2;
    String last = s.length() - 1;
    return s.substring(secondLast,last);
  }
}
