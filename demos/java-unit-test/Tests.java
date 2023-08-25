/*
 * Just add test methods like the one shown below. (Oh, and maybe fix the bug in
 * subtract.) All numbers are double.
 */
// Math.abs(-42) &  Math.sqrt(2)

public class Tests {

  public double add(double x, double y) { return x + y; }

  public double subtract(double a, double b) { return a - b; }

  public double multiply(double a, double b) { return a * b; }

   public double divide(double a, double b) { return a / b; }

   public double remainder(double a, double b) { return a % b; }


   public double distance(double x1 = 0; double x2 = 0; double y1 = 0; double y2 = 0; double[] a = {x1,y1}, double[] b = {x2,y2}) { return Math.abs(a - b); }

  // Add more methods here ...
}
