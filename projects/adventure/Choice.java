public class Choice {
    private String choiceName;
    private String consequence; //format should be add "item" to inventory, move player left, and consistent
    public Choice(String choiceName, String consequence){
        this.choiceName = choiceName;
        this.consequence = consequence;
    }
    public String getConsequence(){
        return consequence;
    }
    public String getName(){
        return choiceName;
    }
}
