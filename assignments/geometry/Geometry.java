/*
 * Just add test methods like the one shown below. (Oh, and maybe fix the bug in
 * subtract.) All numbers are double.
 */

public class Geometry {
  public double midpoint (double a, double b){
    return (a + b) / 2;
  }
  public double hypotenuse (double a, double b){
    return Math.pow(a, 2) + Math.pow(b, 2);
  }
  public double perimeterOfSquare(double side) {
    return side * 4;
  }

  // Add more methods here ...
}
