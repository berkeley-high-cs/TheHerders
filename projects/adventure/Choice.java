public class Choice {
    private String choiceName;
    public Choice(String choiceName){
        this.choiceName = choiceName;
    }

    public String getName(){
        return choiceName;
    }
    public void callConsequence(Player player){
        System.out.println("you arent really supposed to call me, callConsequence");
        return; //just for other methods to change
    }
  
}
