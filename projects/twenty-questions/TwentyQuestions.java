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
    System.out.print("Is it an elephant? ");
    String answer = input.nextLine();
    if (answer.toLowerCase().startsWith("y")) {
      System.out.println("Yay! I win.");
    } else {
      System.out.println("Dang it.");
    }
  }

  public static void main(String[] args) {
    new TwentyQuestions().play();
  }
}
