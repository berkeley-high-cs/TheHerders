import java.util.*;

public class Solver {
 public boolean inBounds(int x, int y, String[][] wall){
    return (x < wall.length && y < wall[x].length && x >= 0 && y >= 0);
 }
}
