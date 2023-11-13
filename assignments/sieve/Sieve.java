public class Sieve {
  public int[] numberTable(int length){
    int[] grid = new int [length];
    for (int i = 0; i < length; i ++){
      grid[i] = i;
    }
    return grid;
  }
}
