/*
 * Important facts about the birds of Booleana.
 *
 * Coloration and markings:
 *
 *   - Flobby Birds and Bloggy Birds are red.
 *   - Flibble Birds and Globby Birds are not red.
 *   - Flobby Birds and Flibble Birds are spotted.
 *   - Bloggy Birds and Globby Birds are not spotted.
 *
 * Diet:
 *
 *   - Flobby Birds eat fish, nuts, and worms.
 *   - Bloggy Birds eat mice, nuts, and worms.
 *   - Flibble Birds eat fish, mice, and worms.
 *   - Globby Birds eat fish, mice, and nuts.
 *
 */

public class BooleanBirds {
  public boolean isFlobbyBird(boolean red, boolean spotted){
      return red && spotted;
  }
  public boolean isBloggyBird(boolean red, boolean spotted){
      return red && !spotted;
  }
  public boolean isFlibbleBird(boolean red, boolean spotted){
      return !red && spotted;
  }
  public boolean isGlobbyBird(boolean red, boolean spotted){
      return !red && !spotted;
  }
  public boolean eatsWorms(boolean red, boolean spotted){
      return (!isGlobbyBird(red, spotted));
  }
  public boolean eatsNuts(boolean red, boolean spotted){
      return (!isFlibbleBird(red, spotted));
  }


}
