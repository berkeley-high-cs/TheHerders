public class Room {
    private String description;
    public Room(String description){
        this.description = description;
    }
    public void look(){
        System.out.println(description);
    }
    public String getDescription(){
        return description;
    }
    public void changeDescription(String newDescription){
        this.description = newDescription;
    }
}
