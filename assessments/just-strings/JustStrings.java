import java.util.ArrayList;

public class JustStrings {

  public boolean isVowel(String c) {
    return "aeiou".indexOf(c) != -1;
  }
  public String insert(String word1, String word2, int index){
    return word1.substring(0, index) + word2 + word1.substring(index);
  }
  public String deleteFirst(String word1, String word2){

    return word1.substring(0, word1.indexOf(word2)) +  word1.substring(word1.indexOf(word2) + word2.length());
  }
  public String deleteAll(String word1, String word2){
    String newWord = word1;
    while(newWord.indexOf(word2) != -1){
      newWord = deleteFirst(newWord, word2);
    }
    return newWord;
  }
  public String nCharacters(String word, int n, int i){
    return word.substring(i, i + n);
  }
  public String  nCharactersBefore(String word, int n, String word2){
    return word.substring(word.indexof(word2) - n, word.indexOf(word2));
  }

}
