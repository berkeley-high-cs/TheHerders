public class AssessmentSqrt2 {

  // You will need this constant for one problem.
  public static final double C = 299792458.0;

  // Write methods here. They should be public but not static.
  public double force (double mass, double acceleration){
    return (mass * acceleration);
  }
  public double energy (double mass){
    return (Math.pow(C, 2) * mass);
  }
   public double distance (double a, double b){
    return (Math.abs(a - b));
  }
  public double distance2d (double x1, double y1, double x2, double y2){
    return (Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));
  }
  public double manhattanDistance (double x1, double y1, double x2, double y2){
    return (Math.abs(x2 - x1) + Math.abs(y2 - y1));
  }
  public String excited (String word){
    return (word + "!!!");
  }
}