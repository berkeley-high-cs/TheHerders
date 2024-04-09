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
    System.err.println("/////////////////////////////////");
    ArrayList<Tree> forest = new ArrayList<>();
    int totalTree = 0;
    if (tree.children().isEmpty()) {
      return tree.size();
    }

    for (int i = 0; i < tree.children().size(); i++) {
      forest.add(tree.children().get(i));
       printArray(forest);
      while (!forest.get(forest.size() - 1).children().isEmpty()) {
        for (int x = 0; x < forest.get(forest.size() - 1).children().size(); x++) {
          forest.add(forest.size(),forest.get(forest.size() - 1).children().get(x));
          
        }
       
      }
    }
    for (int x = 0; x < forest.size(); x++) {
      totalTree += forest.get(x).size();
    }
    return totalTree;
  }
   public void printArray(ArrayList<Tree> list){
      for (int i = 0; i < list.size(); i++){
          System.out.println(list.get(i).size());
      }
  }
}
//
//   ArrayList<Tree> forest = new ArrayList<>();
//     int totalTree = 0;
//     if (tree.children().isEmpty()) {
//       return tree.size();
//     }
//     for (int i = 0; i < tree.children().size(); i++) {
//       forest.add(tree.children().get(i));
//       if (!forest.get(i).children().isEmpty()) {
//         while (!forest.get(forest.size() - 1).children().isEmpty()) {
//           for (int y = 0; y < forest.get(forest.size() - 1).children().size(); y++) {
//             forest.add(forest.get(forest.size() - 1).children().get(y));
//           }
//         }
//       }
//     }
//     for (int x = 0; x < forest.size(); x++) {
//       totalTree += forest.get(x).size();
//     }
//     return totalTree;
