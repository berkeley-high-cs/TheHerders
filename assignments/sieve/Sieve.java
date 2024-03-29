public class Sieve {
  public int[] numberTable(int length){
    int[] array = new int [length];
    for (int i = 0; i < length; i ++){
      array[i] = i;
    }
    return array;
  }
  public int countNonZeros(int[] array){
    int total = 0;
    for (int i = 0; i < array.length; i++){
      if (array[i] != 0){
        total++;
      }
    }
    return total;
  }
  public void clearMultiples(int[] array, int num){
    for (int i = 0; i < array.length; i++){
      if (i % num == 0 && i != num && array[i] != 0){
        array[i] = 0;
      }
    }
  }
  public int[] nonZeros(int[] array){
    int x = 0;
    int[] nonZeros = new int[countNonZeros(array)];
      for (int i = 0; i < array.length; i++){
      if (array[i] != 0){
        nonZeros[x] = array[i];
        x++;
      }
    }
    return nonZeros;
  }
   public int nextNonZero(int[] array, int index){
    
    for (int i = index + 1; i < array.length; i++){
      if (array[i] != 0){
        return array[i];
      }
    }
    return 0;
  }
  public int[] primes(int size){
    int[] array = numberTable(size);
    if (array.length >= 2){
      array[1] = 0;
    }
    for (int i = 2; i < array.length;){
    clearMultiples(array, i);
    i = nextNonZero(array, i);
    if(i == 0){
      return nonZeros(array); 
    }
  }
      
    return nonZeros(array); 
  }
}
