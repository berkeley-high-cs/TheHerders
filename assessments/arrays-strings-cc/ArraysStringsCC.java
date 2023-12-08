public class ArraysStringsCC {

  /*
   * Returns true if its argument is a single-character string and a vowel.
   */
  public boolean isVowel(String s) {
    return s.length() == 1 && "aeiou".indexOf(s.toLowerCase()) != -1;
  }

  /*
   * Returns true if its argument is a prime number.
   */
  public boolean isPrime(int n) {
    for (int d = 2; d <= Math.sqrt(n); d++) {
      if (n % d == 0) return false;
    }
    return n > 1;
  }
  public int countPrimes(int[] array){
    int total = 0;
    for (int i = 0; i < array.length; i++){
      if (isPrime(array[i])){
        total++;
      }
    }
    return total;
  }
  public int countVowels(String string){
    int total = 0;
    for (int i = 0; i < string.length(); i++){
      if (isVowel(string.substring(i, i+1))){
        total++;
      }
    }
    return total;
  }
  public int indexOfVowel(String string){
    for (int i = 0; i < string.length(); i++){
      if (isVowel(string.substring(i, i+1))){
        return i;
      }
    }
    return -1;
  }
  public String disemvowel(String string){
    String newString = "";
    for (int i = 0; i < string.length(); i++){
      if (isVowel(string.substring(i, i + 1)) != true){
        newString = newString + string.substring(i, i + 1);
      }
    }
    return newString;
  }
  public int countStartsWithVowel(String[] array){
    int total = 0;
    for (int i = 0; i < array.length; i++){
      if (indexOfVowel(array[i]) == 0){
        total++;
      }
    }
    return total;
  }
  public int totalLength(String[] array){
    int totalLength = 0;
    for (int i = 0; i < array.length; i++){
      totalLength += array[i].length();
    }
    return totalLength;
  }
  public int[] xs(String[] array){
    int[] indexArray = new int [array.length];
    for (int i = 0; i < array.length; i++){
      for (int x = 0; x < array[i].length(); x++)(
        if (isX(array[x].substring(x, x+1))){
          indexArray[i] = x;
        }
      

      }
      return indexArray;
    }

  }
  public boolean isX(String s) {
    return s.length() == 1 && "x".indexOf(s.toLowerCase()) != -1;
  }
  

}
