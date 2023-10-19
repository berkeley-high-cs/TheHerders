import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.*;

class Main {
    static String player1Hand, player2Hand;
    static int sameSuits = 0;
    static int p1Rank = 0;
    static String[] listOfValues = { "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A" };

    public static void main(String[] args) {
        try {
            File pokerHands = new File("Poker.txt");
            Scanner myReader = new Scanner(pokerHands);
            while (myReader.hasNextLine()) {

                player1Hand = myReader.next() + myReader.next() + myReader.next() + myReader.next() + myReader.next();
                System.out.println(player1Hand);
                player2Hand = myReader.next() + myReader.next() + myReader.next() + myReader.next() + myReader.next();
                // System.out.println(player2Hand);
                p1ValueCheck();
                p1SuitChecker();
                p1RoyalFlushCheck();
                p1StraightFlushCheck();
                // scrapped idea, replaced with checking p1Rank individually p1p1RankCheck();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    static void p1ValueCheck() {
        // int sameSuits = 0;
        char val;
        List<Character> valueCheck = new ArrayList<Character>();
        for (int i = 0; i < 9; i += 2) {
            val = player1Hand.charAt(i);
            if (valueCheck.contains(val)) {
                System.out.println(valueCheck);
            } else {
                valueCheck.add(val);
                System.out.println(valueCheck);
            }

        }
    }

    public static int p1SuitChecker() {
        sameSuits = 0;
        char suit;
        List<Character> suitCheck = new ArrayList<Character>();
        for (int i = 1; i <= 9; i += 2) {
            suit = player1Hand.charAt(i);
            if (suitCheck.contains(suit)) {
                System.out.println(suitCheck);
                sameSuits++;
            } else {
                suitCheck.add(suit);
                System.out.println(suitCheck);

            }

        }
        return sameSuits;
    }

    static boolean p1RoyalFlushCheck() {

        if (player1Hand.contains("T") && player1Hand.contains("J") &&
                player1Hand.contains("Q") && player1Hand.contains("K") &&
                player1Hand.contains("A") && sameSuits == 4) {
            p1Rank = 10;
            System.out.println(p1Rank);
            return true;

        } else {
            System.out.println(p1Rank);
            return false;
        }
    }

    static boolean p1StraightFlushCheck() {
        for (int i = 0; i <= 8; i++) {
            if (player1Hand.contains(listOfValues[i]) &&
                    player1Hand.contains(listOfValues[i + 1]) &&
                    player1Hand.contains(listOfValues[i + 2]) &&
                    player1Hand.contains(listOfValues[i + 3]) && player1Hand.contains(listOfValues[i + 4]) &&
                    sameSuits == 4) {
                p1Rank = 9;
                System.out.println(p1Rank);
                System.out.println("frick");
                return true;
            }
        }
        System.out.println(p1Rank);
        return false;

    }
}
