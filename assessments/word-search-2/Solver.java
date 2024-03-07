import java.util.*;

public class Solver extends Helper2 {
  public boolean inBounds(int x, int y, String[][] wall) {
    return ((x >= 0 && y >= 0) && (x < wall.length && y < wall[x].length));
  }
  
}
