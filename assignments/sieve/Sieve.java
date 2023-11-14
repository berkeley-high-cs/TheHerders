public class Sieve {
  public int[] numberTable(int length){
    int[] grid = new int [length];
    for (int i = 0; i < length; i ++){
      grid[i] = i;
    }
    return grid;
  }
  public int countNonZeros(int[] grid){
    int total = 0;
    for (int i = 0; i < grid.length; i++){
      if (grid[i] != 0){
        total++;
      }
    }
    return total;
  }
  public void clearMultiples(int[] grid, int num){
    for (int i = 0; i < grid.length; i++){
      if (grid[i] % num == 0 && grid[i] != num){
        grid[i] = 0;
      }
    }
  }
}
