public class TestQuestion {
  private String id;
  private String question;
  private double points;
  public TestQuestion(String test, int qNum, String text, double pointVal){
    this.id = (test + "-" + qNum);
    this.question = (text);
    this.points = pointVal;
  }
  public String getId(){
    return id;
  }
  public String getQuestion(){
    return question;
  }
  public double getPoints(){
    return points;
  }
  public void setQuestion(String set){
    question = set;
  }
  public void setPoints(double set){
    points = set;
  }
}