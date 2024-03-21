import java.util.*;

public class ListRecursion {
int x = 0;
  /*
   * A useful helper method. Returns a list containing all but the first element
   * of the argument list. I.e. if you pass a list containing [1, 2, 3, 4] it
   * will return a list containing [2, 3, 4]. If you pass it a single-element
   * list it returns an empty list.
   */
  private ArrayList<Integer> rest(ArrayList<Integer> list) {
    return new ArrayList<>(list.subList(1, list.size()));
  }

  public int sum(ArrayList<Integer> list) {
    if (list.size() == 0) {
      if (x++ < 20) System.err.println("running sum, returning 0");
      return 0;
    } else {
      if (x++ < 20) System.err.println("running sum again with value: " +  list.get(0));
      return sum(rest(list)) + list.get(0);
    }
  }

  public int product(ArrayList<Integer> list) {
    if (list.size() == 0) {
      return 1;
    } else {
      return product(rest(list)) * list.get(0);
    }
  }

  public boolean allEven(ArrayList<Integer> list) {
    if (list.size() == 0) {
      return true;
    } else if (list.get(0) % 2 == 0) {
      return allEven(rest(list));
    } else {
      return false;
    }
  }

  public boolean someEven(ArrayList<Integer> list) {
    if (list.size() == 0) {
      return false;
    } else if (list.get(0) % 2 == 0) {
      return true;
    } else {
      return someEven(rest(list));
    }
  }
}
