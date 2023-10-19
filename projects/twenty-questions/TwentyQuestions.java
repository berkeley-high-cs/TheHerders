import java.util.Scanner;

/**
 * Play the classic game Twenty Questions. Though you'll probably actually only
 * implement Three Questions or Four Questions if you are extremely ambitious.
 */
public class TwentyQuestions {

  private final static int WON = -1;
  private final static int LOST = -2;

  private final String[] words = {
    "real",                //0
    "alive",               //1
    "a mammal",            //2
    "Mr.Seibel",           //3
    "Napolean",            //4
    "a lizard",            //5
    "a crocodile",         //6
    "a mineral",           //7
    "quartz",              //8
    "diamond",             //9
    "a chemical",          //10
    "Oxygen",              //11
    "Berkelium",           //12
    "a video game",        //13
    "Doom",                //14
    "Minecraft",           //15
    "movie",               //16
    "Wolf of Wall Street", //17
    "Sing 2"               //18
  };

  // Next element of words given a yes or no answer. This is pretty fragile/hard
  // to maintain as it's basically representing the question tree via direct
  // indices. If the tree was a bit more regular we could use math to figure out
  // where the next question lives but this basically encodes all the magic
  // numbers that were in the original code in one place. (It is actually
  // slightly different than the original code; I don't know if that's because I
  // misunderstood the order you intended to ask the questions or possibly if
  // there were bugs in the original code. I think this order is at least
  // coherent, if not what you originally intended.)
  private final int[][] next = {
    { 1, 13 },     // real       -> alive or video game
    { 2, 7 },      // alive      -> mammal or mineral
    { 3, 5 },      // mammmal    -> Mr. Seibel or lizard
    { WON, 4 },    // Mr. Seibel -> win or Napoleon
    { WON, LOST }, // Napoleon   -> win or lose
    { WON, 6 },    // lizard     -> win or crocodile
    { WON, LOST }, // crocodile  -> win or lose
    { 8, 9 },      // mineral    -> quartz or chemical
    { WON, 9 },    // quartz     -> win or diamond
    { WON, LOST }, // diamond    -> win or lose
    { 11, LOST },  // chemical   -> O2 or lose
    { WON, 12 },   // O2         -> win or Bk
    { WON, LOST }, // Bk         -> win or lose
    { 14, 16 },    // video game -> Doom or movie
    { WON, 15 },   // Doom       -> win or Minecraft
    { WON, LOST }, // Minecraft  -> win or lose
    { 17, LOST },  // movie      -> Wolf or lose
    { WON, 18 },   // Wolf       -> win or Sing 2
    { WON, LOST }  // Sing 2     -> win or lose
  };

  private Scanner input = new Scanner(System.in);

  public void play() {

    int i = 0;

    while (i >= 0) {
      System.out.println("Is it " + words[i] + "?");
      i = next[i][isYes(input.nextLine()) ? 0 : 1];
    }

    if (i == WON) {
      System.out.println("I win!");
    } else {
      System.out.println("Dang it. You stumped me.");
    }
  }

  public boolean isYes(String answer) {
    return answer.toLowerCase().startsWith("y");
  }

  public static void main(String[] args) {
    new TwentyQuestions().play();
  }

}
