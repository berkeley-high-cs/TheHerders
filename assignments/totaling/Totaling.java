import java.util.ArrayList;

public class Totaling {

  // You'll need to use this method
  public boolean isPrime(int n) {
    if (n < 2) return false;
    for (int d = 2; d <= Math.sqrt(n); d++) {
      if (n % d == 0) return false;
    }
    return true;
  }
  public int sumArray(int[] array){
    int total = 0;
    for (int i = 0; i < array.length; i++){
      total += array[i];
    }
  }
  return total;
}
