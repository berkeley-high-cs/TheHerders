class Eca {

  static int boardLength = 15;

  public static void main(String[] args) {
    int[] cells = new int[boardLength];
    print(cells);
  }

  public static void print(int[] cells) {
    for (int i = 0; i < boardLength; i++) {
      System.out.print(asBox(cells[i]));
    }
    System.out.println("");
  }

  // as letter changes the numbers to x's and o's, ask grayson a little bit about
  // how that works, like why is it just in front of the array id
  // for loop
  public static String asBox(int number) {
    if (number == 0) {
      return "\u25A1";
    } else if (number == 1) {
      return "\u25A0";
      // needs this in case its not 0 1 or 2

    } // reads player 1 input
    return " ";
  }
}
