import com.gigamonkeys.bhs.ImageGenerator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Flag implements ImageGenerator {

  /*
   * These variables define the three colors you need. Since they are variables
   * in this class you can refer to them in your code as just RED, WHITE, and
   * BLUE.
   */
  private static final Color RED = new Color(179, 25, 66);
  private static final Color WHITE = Color.WHITE;
  private static final Color BLUE = new Color(10, 49, 97);

  /*
   * This is the method you need to implement.
   */
  public void drawFlag(Graphics g, int width, int height) {
    // TODO: add code here to draw the flag. You may want to write your own
    // methods below and call them from here. You will presumably delete this
    // next line but to get you started, here's an example of calling the
    // provided drawStar method to draw a star, in this case a red star with a
    // diameter of 100 at the center of the canvas.
   // drawStar(g, RED, width / 2, height / 2, 100);
    
    int flagHeight = (height);
    int flagLength = ((flagHeight * 2) - flagHeight/10);
    int stripeWidth = (flagHeight / 13);
    int starDiameter = (stripeWidth * 4 / 5);
    int horizontalCenter = ((width - flagLength) / 2);
    int blueRecLength = (flagLength * 2 / 5);
    int blueRecHeight = (7 * stripeWidth);
    //System.out.println(horizontalCenter);
    g.setColor(WHITE);
    g.fillRect(horizontalCenter, 0, flagLength, flagHeight);
    g.setColor(RED);
    g.fillRect(horizontalCenter, 0, flagLength, stripeWidth);
    for (int i = 0; i < 13; i++){
      if (i % 2 == 1){
        g.setColor(RED);
      } else{
        g.setColor(WHITE);
      }
      g.fillRect(horizontalCenter, flagHeight - (i * stripeWidth), flagLength, stripeWidth);
    }
    g.setColor(BLUE);
    g.fillRect(horizontalCenter, 0, blueRecLength, blueRecHeight);
    int stars = 0;
    int starterPos = 0;
    for (int x = 0; x <= 9; x++){
      if (x % 2 == 1){
        stars = 6;
      } else{
        stars = 5;
      }
      for (int i = 0; i < stars; i++){
        if (stars % 2 == 1){
          starterPos = 1;
        } else {
          starterPos = 0;
        }
        drawStar(g, WHITE, horizontalCenter +  ((blueRecLength / 12 + (blueRecLength / 12) ) * (i + starterPos) ),
       (blueRecHeight / 10) * x, starDiameter);
      }
     }
    // drawStars(g, 6, blueRecLength, blueRecHeight, starDiameter, horizontalCenter, 1);
    // drawStars(g, 5, blueRecLength, blueRecHeight, starDiameter, horizontalCenter, 2);

  }
  // private void drawStars(Graphics g, int amount, int blueRecLength, int blueRecHeight, int starDiameter, int horizontalCenter, int level){
  //   for (int i = 1; i < amount + 1; i++){
  //     drawStar(g, WHITE, horizontalCenter +  ((blueRecLength / 12 + (blueRecLength / 12)) * i),
  //      (blueRecHeight / 10) * level, starDiameter);
  //   }
  // }

  ////////////////////////////////////////////////////////////////////////
  // You do not need to touch any code below this point. You will use the first
  // method, drawStar, to draw your stars.

  /*
   * Draw a five pointed star of Color c with its center at the coordinates x, y
   * and with a diameter of d.
   */
  private void drawStar(Graphics g, Color c, int x, int y, int d) {
    g.setColor(c);
    g.fillPolygon(makeStar(x, y, d));
  }

  /*
   * This is the entry point invoked by the graphics framework to create your
   * image. You don't need to touch it as it already fills in the grey
   * background and then calls the drawFlag method that you will implement.
   */
  public void draw(Graphics g, int width, int height) {
    drawBackground(g, width, height);
    drawFlag(g, width, height);
  }

  /*
   * Fills in the background with gray.
   */
  private void drawBackground(Graphics g, int width, int height) {
    g.setColor(Color.GRAY);
    g.fillRect(0, 0, width, height);
  }

  /*
   * Make a Polygon representing a star centered at x,y with diameter d.
   */
  private Polygon makeStar(int x, int y, int d) {
    double theta = Math.TAU / 5;
    int r = d / 2;
    // 1.25 to make the stars a bit more chonky
    int r2 = (int) (1.25 * r * Math.cos(theta) / Math.cos(theta / 2));

    Polygon star = new Polygon();
    for (int i = 0; i < 5; i++) {
      double a = (i * theta) - Math.TAU / 4;
      addPointOnCircle(star, x, y, r, a);
      addPointOnCircle(star, x, y, r2, a + theta / 2);
    }
    return star;
  }

  /*
   * This is a helper only used in drawStart which exists just to make that code
   * a bit easier to read. It adds a point to the Polygon specified by the x, y
   * at the center of a circle, the radius of the circle, and an angle.
   */
  private void addPointOnCircle(Polygon p, int x, int y, int r, double a) {
    p.addPoint(x + (int) (Math.cos(a) * r), y + (int) (Math.sin(a) * r));
  }

}
