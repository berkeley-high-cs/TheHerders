public class TestQuestion {
  private String id;
  private String question;
  private double points;
  public TestQuestion(String test, int qNum, String text, double pointVal){
    this.id = (test + "-" + qNum);
    this.question = (text);
    this.points = pointVal;
  }
}