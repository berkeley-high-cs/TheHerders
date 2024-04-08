import java.util.*;

public class TreeSize {
  public int recursive(Tree tree){
    if (tree.children().isEmpty()){
      return tree.size();
    } else {
      for (int i = 0; i < tree.children().size()){
        return recursive(tree.children().get(i));
      }
    }
  }
}
