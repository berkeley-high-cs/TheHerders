public class Point{
  private double x;
  private double y;
  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }
  public static void main(String[] args){
    Point newPoint = new Point (300, 400);

  }
  public double distanceFromOrigin(){
    return Math.hypot(x, y);
  }
  public double distanceTo(Point point){
    return Math.hypot(Math.abs(x - point.x), Math.abs(y - point.y));
  }
  public void move(double xMove, double yMove){
    x += xMove;
    y += yMove;
  }
  public Point midwayTo(Point point){
    
    return Point midWayPoint = new Point ((x + point.x)/2, (y + point.y)/2);
  }
  public String toString(){
    return ("Point<" + x + "," + y + ">");
  }
  

}