import java.util.*;

public class TreeSize {

  public int recursive(Tree tree) {
    int totalTree = 0;
    if (tree.children().isEmpty()) {
      return tree.size();
    } else {
      for (int i = 0; i < tree.children().size(); i++) {
        totalTree += recursive(tree.children().get(i));
      }
      return totalTree + tree.size();
    }
  }

  public int iterative(Tree tree) {
    ArrayList<Tree> forest = new ArrayList<>();
    int totalTree = 0;
    if (tree.children().isEmpty()) {
      return tree.size();
    }
    
    for (int i = 0; i < tree.children().size(); i++) {
      forest.add(tree.children().get(i));
      if (!forest.get(forest.size() - 1).children().isEmpty()) {
        for (int y = 0; y < forest.get(i).children().size(); y++) {
          forest.add(forest.get(i).children().get(y));
        }
      }
    }

    for (int x = 0; x < forest.size(); x++) {
      totalTree += forest.get(x).size();
    }
    return totalTree;
  }

}
