public class Read extends Choice {
    private String text;
    public Read(String text){
        super("read");
        this.text = text;
    }
    public void callConsequence(Player player){
        System.out.println(""); // for formatting
        System.out.println("The text reads: ");
        System.out.println(text);
        System.out.println(""); // for formatting
    }
}
