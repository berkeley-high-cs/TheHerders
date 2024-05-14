public class Inspect extends Choice {
    private String textName;
    private String text;
    public Inspect(String textName, String text){
        super("inspect " + textName);
        this.textName = textName;
        this.text = text;
    }
    public void callConsequence(Player player){
        System.out.println(""); // for formatting
        System.out.println(text);
        System.out.println(""); // for formatting
    }
}
