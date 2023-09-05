/*
 * Just add test methods like the one shown below. (Oh, and maybe fix the bug in
 * subtract.) All numbers are double.
 */

public class Geometry {
  public double midpoint (double a, double b){
    return (a + b) / 2;
  }
  public double areaOfTrapezoid (double a, double b, double c){
    return ((a + b) / 2) * c;
  }
  public double hypotenuse (double a, double b){
    return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
  }
  public double areaOfCircle(double r){
    return areaOfCircle(2);
  }
  public double surfaceAreaOfSphere(double r){
    return areaOfCircle(2) * 4;
  }
  public double totalSurfaceAreaOfCylinder(double r, double h){
    return Math.PI * r * 2 * h + 2 * (areaOfCircle(2));
  }
  public double curvedSurfaceAreaOfConeFromSlantHeight(double r, double h){
    return Math.PI * r * h;
  }
  public double totalSurfaceAreaOfConeFromSlantHeight(double r, double h){
    return Math.PI * r * h + areaOfCircle(2);
  }
  public double totalSurfaceAreaOfConeFromHeight(double r, double h){
    return Math.PI * r * Math.sqrt(Math.pow(r, 2) + Math.pow(h, 2)) + areaOfCircle(2);
  }
  public double volumeOfCone (double r, double h){
    return areaOfCircle(2) * h / 3;
  }
  public double perimeterOfSquare(double side) {
    return side * 4;
  }

  // Add more methods here ...
}
