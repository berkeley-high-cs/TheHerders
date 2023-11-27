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
        // needs this in case its not 0 1
        return " ";
    }

    public static int[] ruleTaker(int[] binaryRuleNum, int[] cells) {
        int[] tempCells = new int[boardLength];
        
        for (int i = 0; i < cells.length; i++){
            if (i - 1 > 0 && i + 1 < 0){
                 if (ruleChecker(cells, i, 1, 1, 1)){
                    tempCells[i] = binaryRuleNum[0];
                 }
                 if (ruleChecker(cells, i, 1, 1, 0)){
                    tempCells[i] = binaryRuleNum[1];
                 }
                 if (ruleChecker(cells, i, 1, 0, 1)){
                    tempCells[i] = binaryRuleNum[2];
                 }
                 if (ruleChecker(cells, i, 1, 0, 0)){
                    tempCells[i] = binaryRuleNum[3];
                 }
                 if (ruleChecker(cells, i, 0, 1, 1)){
                    tempCells[i] = binaryRuleNum[4];
                 }
                 if (ruleChecker(cells, i, 0, 1, 0)){
                    tempCells[i] = binaryRuleNum[5];
                 }
                 if (ruleChecker(cells, i, 0, 0, 1)){
                    tempCells[i] = binaryRuleNum[6];
                 }
                 if (ruleChecker(cells, i, 0, 0, 0)){
                    tempCells[i] = binaryRuleNum[7];
                 }
            }
        }
        return tempCells;
    }

    public static boolean ruleChecker(int[] cells, int i, int first, int second, int third){
        if (i != 0 && i != boardLength - 1){
        return ((cells[i - 1] == first) && (cells[i] == second) && (cells[i + 1] == third));
        } else if (i == 0){
            return ((first == 0) && (cells[i] == second) && (cells[i + 1] == third));
        } else if (i == boardLength - 1){
            return ((cells[i - 1] == first) && (cells[i] == second) && (third == 0));
        } else {
            return false;
        }
    }
   
    public static int[] toBinaryArray8() {
        // https://www.geeksforgeeks.org/java-program-to-convert-integer-values-into-binary/

        // Function converting decimal to binary

        // Creating and assigning binary array size
        int[] binary = new int[8];
        int id = 0;

        // Number should be positive
        while (ruleNum > 0) {
            binary[id++] = ruleNum % 2;
            ruleNum = ruleNum / 2;
        }

        // Print Binary
        return binary;
    }

    public static void read() {
        System.out.println("");
        System.out.println(
                "What is your rule?");
        Scanner scanner = new Scanner(System.in);
        ruleNum = scanner.nextInt();
    }
}
