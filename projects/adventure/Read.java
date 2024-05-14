public class Read extends Choice {
    private String textName;
    private String text;
    public Read(String textName, String text){
        super("read " + textName);
        this.textName = textName;
        this.text = text;
    }
    public void callConsequence(Player player){
        System.out.println(""); // for formatting
        System.out.println("The text reads: ");
        System.out.println(text);
        System.out.println(""); // for formatting
    }
}
