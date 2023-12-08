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
    String string = "";
    int[] indexArray = new int [array.length];
    for (int i = 0; i < array.length; i++){
      for (int x = 0; x < array[i].length(); x++){
        string = array[x];
        if (x + 1 > string.length()){ 
            if (string.equals("x")){
              indexArray[i] = x;
            }
        }else if (string.substring(x, x + 1).equals("x")){
            indexArray[i] = x;
        } else {
          indexArray[i] = -1;
        }
      }
      
    }
    return indexArray;

  }
  public int countByLength(String[] array, int num){
    int total = 0;
    for (int i = 0; i < array.length; i++){
      if (array[i].length() == num){
        total++;
      }
    }
    return total;
  }
  public String[] collectFourLetterWords(String[] array){
    int x = 0;
    String[] newArray = new String [countByLength(array, 4)];
    for (int i = 0; i < array.length; i++){
      if (array[i].length() == 4){
        newArray[x++] = array[i];
      }
    }
    return newArray;
  }
  public String[] collectShouting(String[] array){
    String[] newArray = new String [array.length];
    for (int i = 0; i< array.length; i++){
      newArray[i] = array[i].toUpperCase();
    }
    return newArray;
  }
  public int hailstoneLength(int num){
    int steps = 0;
    while (true){
    if (num == 1){
      return ++steps;
     } else if (num % 2 == 0){
      steps++;
      num = num / 2;
    } else if (num % 2 == 1){
      steps++;
      num = num * 3 + 1;
     }
    }
  }
  
  

}
