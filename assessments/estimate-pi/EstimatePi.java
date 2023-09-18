import com.gigamonkeys.bhs.*;
import java.awt.Color;
import java.awt.Graphics;

public class EstimatePi implements ImageGenerator {

  // Increase the value of this variable to get a more precise estimate.
  int iterations = 100;

  //////////////////////////////////////////////////////////////////////
  // YOUR CODE GOES HERE - fill out the methods described in the five
  // TODO items below. Note that the first four of these methods can be
  // lifted from the unit Math.sqrt(2) assessment you just took.

  // TODO 1: Write a method named toCenter that takes two doubles, space
  // and size, and returns a double specifying where to position a line
  // of length size within a space of length space in order to center
  // it. For instance, to center a six foot rug in a ten-foot room, we
  // need to position one edge two feet from one wall so the other edge
  // will be two feet from the other wall. In other words, we want to
  // know half of the space left over when we subtract size from space.


  // TODO 2: Write a method named randomCoordinate that returns a random
  // double value in the range 0.0 to 2.0 (inclusive, exclusive)


  // TODO 3: Write a method named distance2d that returns a double
  // representing the distance in in two dimensional space between two
  // points given as four double arguments, x1, y1, x2, and y2. (Once
  // again, this is the Pythagorean theorem: the the distance is the
  // hypotenuse of the triangle formed by the distance on the x axis and
  // the distance on the y axis, i.e. the square root of the sum of the
  // squares of those distances.)


  // TODO 4: Write a method, graphicalCoordinate, that takes three
  // double arguments: a double coordinate in the range 0.0-2.0 (i.e.
  // one returned by the randomCoordinate method), a starting value and
  // a length and returns a double value so the new value is in the
  // range from start to length. For example if the first argument is
  // 0.0 then this method should return the start argument; if the
  // coordinate was 2.0 it would return start + length; and if the
  // coordinate was 1.0, it would return the value that is half the
  // length more than start.


  // TODO 5: Write a method named estimate that computes an estimate of
  // the value of π based on the number of darts that landed inside the
  // circle and the total number of darts thrown. The estimate of π is 4
  // times that proportion. To see why, consider that if the darts are
  // thrown at random, the number that land inside circle is
  // proportional to the area of the circle. And we know the area of the
  // circle is πr^2 and the area of the square is (2r)^2 or 4r^2.
  // Therefore the proportion should be π/4 and thus π is 4 times the
  // proportion of darts that land in the circle.


  // END OF CODE YOU NEED TO TOUCH
  //////////////////////////////////////////////////////////////////////


  //////////////////////////////////////////////////////////////////////
  // Code provided -- you don't need to touch anything below here but
  // you should read it to see how it makes use of the method you've
  // written above. Depending on where you are in BHSawesome there may
  // be features of Java used here that you haven't seen yet. Also note
  // that this program runs in an environment similar to Simple Graphics
  // where the entry point is the draw method.

  public static final Color INSIDE = new Color(26, 133, 255);
  public static final Color OUTSIDE = new Color(212, 17, 89);

  public void draw(Graphics g, int width, int height) {
    int side = (int) (Math.min(width, height) * 0.8);
    int sx = (int) toCenter(width, side);
    int sy = (int) toCenter(height, side);

    drawBoxAndCircle(g, sx, sy, side);

    int count = throwDarts(g, sx, sy, side, iterations);

    drawEstimate(g, 10, 20, estimate(count, iterations));
  }

  public void drawBoxAndCircle(Graphics g, int x, int y, int side) {
    g.setColor(Color.WHITE);
    g.fillRect(x, y, side, side);
    g.setColor(Color.GRAY);
    g.drawRect(x, y, side, side);
    g.drawOval(x, y, side, side);
  }

  // This method and the next go agains my advice to have methods either
  // compute a value *or* produce an effect, as it does both. Sometimes
  // you have to break the rules.
  public int throwDarts(Graphics g, int sx, int sy, int side, int iterations) {
    int count = 0;
    for (int i = 0; i < iterations; i++) {
      if (throwDart(g, sx, sy, side)) {
        count++;
      }
    }
    return count;
  }

  // Throw a random dart and both draws it on the drawing area return
  // true if it lands inside the circle
  public boolean throwDart(Graphics g, int sx, int sy, int side) {
    double x = randomCoordinate();
    double y = randomCoordinate();
    boolean inside = inCircle(x, y, 1, 1, 1);
    int gx = (int) graphicalCoordinate(x, sx, side);
    int gy = (int) graphicalCoordinate(y, sy, side);
    drawDart(g, gx, gy, inside);
    return inside;
  }

  public boolean inCircle(double x, double y, double cx, double cy, double r) {
    return distance2d(x, y, cx, cy) <= r;
  }

  public void drawDart(Graphics g, int x, int y, boolean inside) {
    g.setColor(inside ? INSIDE : OUTSIDE);
    g.fillOval(x, y, 5, 5);
  }

  public void drawEstimate(Graphics g, int x, int y, double estimate) {
    g.setColor(Color.BLACK);
    g.drawString("π ~= " + estimate, x, y);
  }
}
