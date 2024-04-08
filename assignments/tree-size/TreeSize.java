import java.util.*;

public class TreeSize {
  public int recursive(Tree tree){
    int totalTree = 0;
    if (tree.children().isEmpty()){
      return tree.size();
    } else {
      for (int i = 0; i <= tree.children().size(); i++){
        totalTree += tree.size() + recursive(tree.children().get(i));
      }
   return totalTree;
   }
    return -2147483648;
  }
}
