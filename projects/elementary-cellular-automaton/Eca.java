import java.util.Scanner;

class Eca {
    static int ruleNum = 0;
    static int boardLength = 15;

    public static void main(String[] args) {
        read();
        int[] binaryRuleNum = toBinaryArray8();
        
        int[] cells = new int[boardLength];
        cells[boardLength / 2] = 1;
        System.out.println(binaryRuleNum);
        for (int i = 0; i < 10; i++) {

            print(cells);
            cells = ruleTaker(binaryRuleNum, cells);
        }
    }

    public static void print(int[] cells) {
        for (int i = 0; i < boardLength; i++) {
            System.out.print(asBox(cells[i]));
        }
        System.out.println("");
    }

  
  public static String asBox(int number) {
    if (number == 0) {
      return "\u25A1";
    } else if (number == 1) {
      return "\u25A0";
     } 
  return " ";
  }
}