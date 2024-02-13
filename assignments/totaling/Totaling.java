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
     return total;
  }
   public int sumList(ArrayList<Integer> list){
    int total = 0;
    for (int i = 0; i < list.size(); i++){
      total += list.get(i);
    }
     return total;
  }
   public int sumPrimes(ArrayList<Integer> list){
    int total = 0;
    for (int i = 0; i < list.size(); i++){
      if (isPrime(list.get(i))){
      total += list.get(i);
      }
    }
     return total;
  }
  public int sumCells(int[][] wall){
     int total = 0;
    for (int i = 0; i < wall.length; i++){
      for(int x = 0; x < wall[i].length; x++){
        total += wall[i][x];
      }
    }
     return total;
  }
}

