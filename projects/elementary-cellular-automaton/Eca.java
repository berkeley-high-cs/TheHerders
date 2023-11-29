import java.util.Scanner;

class Eca {
    static int ruleNum = 0;
    static int boardLength = 15;

    public static void main(String[] args) {
        read();
        int[] binaryRuleNum = toBinaryArray8();
        
        int[] cells = new int[boardLength];
        cells[boardLength / 2] = 1;
        printArray(binaryRuleNum);
        for (int i = 0; i < 10; i++) {

            print(cells);
            cells = ruleTaker(binaryRuleNum, cells);
           // ruleChecker(cells, 7 , 0, 1, 0);
        }
    }

    public static void print(int[] cells) {
        for (int i = 0; i < cells.length - 1; i++) {
            System.out.print(asBox(cells[i]));
        }
        System.out.println("");
    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i]);
        }
        System.out.println("");
    }

    public static String asBox(int number) {
        if (number == 0) {
            return "\u25A1";
        } else if (number == 1) {
            return "\u25A0";
            

        }
        // needs this in case its not 0 1
        return "\u2612";
    }

    public static int[] ruleTaker(int[] binaryRuleNum, int[] cells) {
        int[] tempCells = new int[boardLength];
        for (int i = 0; i < boardLength; i++){
            // System.out.println(i);
            if (i != 0 && i != boardLength){
                 if (ruleChecker(cells, i, 1, 1, 1)){
                    tempCells[i] = binaryRuleNum[0];
                    System.out.print("temp cells is ");
                    printArray(tempCells);
                 }
                 if (ruleChecker(cells, i, 1, 1, 0)){
                    tempCells[i] = binaryRuleNum[1];
                    System.out.println("temp cells" + tempCells);
                 }
                 if (ruleChecker(cells, i, 1, 0, 1)){
                    tempCells[i] = binaryRuleNum[2];
                    System.out.println("temp cells" + tempCells);
                 }
                 if (ruleChecker(cells, i, 1, 0, 0)){
                    tempCells[i] = binaryRuleNum[3];
                    System.out.println("temp cells" + tempCells);
                 }
                 if (ruleChecker(cells, i, 0, 1, 1)){
                    tempCells[i] = binaryRuleNum[4];
                    System.out.println("temp cells" + tempCells);
                 }
                 if (ruleChecker(cells, i, 0, 1, 0)){
                    tempCells[i] = binaryRuleNum[5];
                    System.out.println("temp cells" + tempCells);
                 }
                 if (ruleChecker(cells, i, 0, 0, 1)){
                    System.out.println("temp cells" + tempCells);
                    tempCells[i] = binaryRuleNum[6];
                 }
                 if (ruleChecker(cells, i, 0, 0, 0)){
                    tempCells[i] = binaryRuleNum[7];
                    System.out.println("temp cells" + tempCells);
                 }
            }
        }
        
        return tempCells;
    }

    public static boolean ruleChecker(int[] cells, int i, int first, int second, int third){
        boolean rule = true;
        
        if (i != 0 && i != boardLength - 1){
          rule = ((cells[i - 1] == first) && (cells[i] == second) && (cells[i + 1] == third));
          System.out.println(rule + " index is " + i + "first is " + first + "second is " 
          + second + " third is " + third + " cell value is " + cells[i]);
        return rule;
        } else if (i == 0){
          rule = ((first == 0) && (cells[i] == second) && (cells[i + 1] == third));
          System.out.println(rule + " index is " + i + "first is " + first + "second is " 
          + second + " third is " + third + " cell value is " + cells[i]);
            return rule;
        } else if (i == boardLength - 1){
          rule = ((cells[i - 1] == first) && (cells[i] == second) && (third == 0));
          System.out.println(rule + " index is " + i + "first is " + first + "second is " 
          + second + " third is " + third + " cell value is " + cells[i]);
            return rule;
        } else {
          System.out.println("whoopsie Daisy somethings wrong");
            return false;
        }
    }
   
    public static int[] toBinaryArray8() {
        // orion is my source, but i edited this to fit my code
        int[] tempBinaryArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
            String binaryWithOutLeading0 = Integer.toBinaryString(ruleNum);
            String stringRule =  "00000000".substring(binaryWithOutLeading0.length()) + binaryWithOutLeading0;
            System.out.println(stringRule);
            for (int i = 0; i < 8; i++){
                 
                tempBinaryArray[i] = (stringRule.charAt(i));
                tempBinaryArray[i] = tempBinaryArray[i] % 2;
                
            }
            return tempBinaryArray;

        }

    public static void read() {
        System.out.println("");
        System.out.println(
                "What is your rule?");
        Scanner scanner = new Scanner(System.in);
        ruleNum = scanner.nextInt();
    }
}
