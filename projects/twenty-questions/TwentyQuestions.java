import java.util.Scanner;

/**
 * Play the classic game Twenty Questions. Though you'll probably actually only
 * implement Three Questions or Four Questions if you are extremely ambitious.
 */
public class TwentyQuestions {
  // Use input.readLine() to read a line at a time
  // as a String from the user.
  private Scanner input = new Scanner(System.in);

  public void play() {
    String answer = "";
    for (int i = 0; i <= 18; i++) {
      String[] words = { "real", //0
                          "alive",  //1
                          "a mammal", //2
                          "Mr.Seibel", //3
                          "Napolean", //4
                          "a lizard",  //5
                          "a crocodile", //6
                          "a mineral",  //7
                          "quartz",    //8
                          "diamond",   //9
                          "a chemical",  //10
                          "Oxygen",   //11
                          "Berkelium", //12
                          "a video game",  //13
                          "Doom",      //14
                          "Minecraft",  //15
                          "movie",    //16
                          "Wolf of Wall Street", //17
                          "Sing 2" };  //18


      System.out.println("Is it " + words[i] + "?");
      answer = input.nextLine();

      if (i == 4 || i == 6 || i == 9 || i == 10 || i == 12 || i == 15 || i == 18) {
        if (check(answer) != true) {
          System.out.println("Darn, I lost");
          break;
        }
      }
      if (i == 3 || i == 6 || i == 9 || i == 12 ||i == 5 || i == 7 || i == 9 || i == 10 || i == 12 || i == 15 || i == 18) {
        if (check(answer) == true) {
          System.out.println("Yay, I won");
          break;
        }
      }
      if (check(answer)) {
        System.out.println("Yay!");
      } else if (check(answer) != true) {
        System.out.println("Damnnitt all!");

      }

      // //Lizard
      // i += abstraction(i, 0, 3, answer);
      // //Crocodile lose con
      // i += abstraction(i, 0, 4, answer);
      // //Mr.Seibel
      // i += abstraction(i, 0, 5, answer);
      // //Napolean lose con
      // i += abstraction(i, 0, 6, answer);
      // //Quartz
      // i += abstraction(i, 0, 8, answer);
      // //Diamond lose con
      // i += abstraction(i, 0, 9, answer);
      // //Chemical lose con
      // i += abstraction(i, 0, 10, answer);
      // //Oxygen
      // i += abstraction(i, 0, 11, answer);
      // //Berkelium lose con
      // i += abstraction(i, 0, 12, answer);
      // real
      i += abstraction(i, 12, 0, answer);
      // alive change q
      i += abstraction(i, 5, 1, answer);
      // mammal change q
      i += abstraction(i, 2, 2, answer);
      // mineral change q
      i += abstraction(i, 2, 7, answer);
      // Video Game change q
      i += abstraction(i, 2, 13, answer);
      // Movie change q
      i += abstraction(i, 2, 16, answer);

    }

  }

  public static void main(String[] args) {
    new TwentyQuestions().play();
  }

  public static boolean check(String answer) {
    if (answer.toLowerCase().startsWith("y")) {
      return true;
    } else {
      return false;
    }
  }

  public static int abstraction(int i, int amountToAdd,
      int wordPlace, String answer) {
    if (check(answer) && i == wordPlace) {

      return 0;
    } else if (check(answer) != true && i == wordPlace) {

      return amountToAdd;

    } else {
      return 0;
    }

  }
}

// VERY VERY expierimental, possibly making a method to simplify the code that I
// have that is similar to
// other code I have, but I have to let in have an arbitrary amount of arguments
// which I dont understand how to
// code, and code with.
// public static int simplify(int amountToAdd, String answer, int i, int...
// wordPlace) {
// int size = wordPlace.length;
// for (int x = 0; i <= size; x++){
// if(check(answer) && i == wordPlace[x] ){
// System.out.println("Yay!");
// return i += amountToAdd;

// }
// }
// }
