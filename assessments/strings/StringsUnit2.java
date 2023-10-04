public class StringsUnit2 {

  // Write methods here. They should be public but not static.
  public String firstCharacter(String s){
    return s.substring(0,1);
  }
  public String lastCharacter(String s){
    int last = (s.length()) - 1;
    return s.substring(last);
  }
  public String pair(String s, String a){
    return (s + " and " + a);
  }
  public boolean longerThan(String s, String a){
    int firstStringLength = s.length();
    int secondStringLength = a.length();
    if (firstStringLength > secondStringLength == true){
    return true;
    } else {
      return false;
    }
  }
   public String upDown(String s){
    return (s.toUpperCase() + s.toLowerCase());
  }
  public boolean contains(String s, String a){
    if (s.contains(a) == true ){
      return true;
    } else {
      return false;
    }
  }
   public String slug(String s, String a, String b){
    String x = s.toLowerCase();
    String y = a.toLowerCase();
     String z = b.toLowerCase();
    return (x + "-" + y + "-" + z);
  }
  public String simplePigLatin(String s,int i){
    String newWord = (s.substring(i, s.length()) + s.substring(0,i) + "ay");
    return (newWord);
  }
}
