import java.util.*;

public class ListRecursion {

  /*
   * A useful helper method. Returns a list containing all but the first element
   * of the argument list. I.e. if you pass a list containing [1, 2, 3, 4] it
   * will return a list containing [2, 3, 4]. If you pass it a single-element
   * list it returns an empty list.
   */
  private ArrayList<Integer> rest(ArrayList<Integer> list) {
    return new ArrayList<>(list.subList(1, list.size()));
  }


}
