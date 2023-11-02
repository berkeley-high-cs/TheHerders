public class CountVowels {

  public boolean isVowel(String s) {
    if (s.length() != 1) return false;
    return "aeiou".indexOf(s.toLowerCase()) != -1;
  }


}
