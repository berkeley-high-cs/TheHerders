public class Point{
  private double x;
  private double y;
  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }
  public static void main(String[] args){
    System.out.println("hello, world! haha code i can put whatever I want after the hello world");
  }
  public static double distanceFromOrigin(){
    return Math.hypot(x, y);
  }
  public static double distanceTo(Point point){
    return 0;
  }

}