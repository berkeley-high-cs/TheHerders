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
   public double mod(double a, double b){ return a % b; }

 public double averageOfTwo (double a, double b){return (a + b) /  2; }
 public double averageOfThree (double a, double b, double c){return (a + b  + c) /  3; }
   public double distance (double a, double b) { return Math.abs(a - b); }
  
  public double manhattanDistance (double x1, double y1, double x2, double y2){return (x1-x2) + (y1-y2);}

  // Add more methods here ...
}
