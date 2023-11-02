public class CountVowels {

  public boolean isVowel(String s) {
    if (s.length() != 1) return false;
    return "aeiou".indexOf(s.toLowerCase()) != -1;
  }
  public int countVowels(String s){
    int total = 0;
    Char letter = s.charAt(i);
    for (int i = 0; i < s.length(); i++){
      if (isVowel(Character.toString(letter))){
        total++;
      }
    }
    return total;
  }
}
