public class Look extends Choice {
    public Look(){
        super("look"); 
    }
    public void callConsequence(Player player){
        System.out.println(""); // for formatting
        System.out.println(player.getLocation().getDescription());
    }
}
