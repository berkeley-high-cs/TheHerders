import java.util.*;

public class Solver {
 public boolean inBounds(int x, int y, Strings[][] wall){
    return (x < wall.length() && y < wall[x].length());
 }
}
