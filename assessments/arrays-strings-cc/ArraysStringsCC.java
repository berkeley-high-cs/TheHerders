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
      indexArray[i] = array[i].indexOf("x");
      
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
  public int hailstoneMax (int num){
    int biggest = 1;
    while (true){
    if (num == 1){
      return biggest;
     } else if (num % 2 == 0){
      if (num > biggest) {
        biggest = num;
      }
      num = num / 2;
    } else if (num % 2 == 1){
      if (num > biggest) {
        biggest = num;
      }
      num = num * 3 + 1;
     }
    }
  }
  public int[] hailstone(int num){
    int length = hailstoneLength(num);
    int[] sequence = new int [length];
    for (int i = 0; i <= length; i++){
    if (num == 1){
      sequence[i] = num;
      return sequence;
     } else if (num % 2 == 0){
      sequence[i] = num;
      num = num / 2;
    } else if (num % 2 == 1){
      sequence[i] = num;
      num = num * 3 + 1;
     }
    }
    return sequence;
  }
  public int[] lengthHistogram(String[] array){
    int[] intArray = new int [11];
    for (int i = 0; i < 10; i++){
      intArray[i] = countByLength(array, i);
    }
    intArray[10] = countByLengthAboveNum(array, 10);
    return intArray;
  }
  public int countByLengthAboveNum(String[] array, int num){
    int total = 0;
    for (int i = 0; i < array.length; i++){
      if (array[i].length() >= num){
        total++;
      }
    }
    return total;
  }
  public void rotateLeft(String[] array){
    String[] newArray = array.clone();
    for (int i = 0; i < array.length; i++){
      if (i != array.length - 1){
        array[i] = newArray[i + 1];
      } else {
        array[array.length - 1] = newArray[0];
        
      } 
    }
    
    
  }
  public void rotateRight(String[] array){
    String[] newArray = array.clone();
    for (int i = 0; i < array.length; i++){
      if (i != 0){
        array[i] = newArray[i - 1];
      } else {
        array[0] = newArray[array.length - 1];
        
      } 
    }
    
    
  }

  
  

}
