import java.util.*;

public class Room {
    private String description;
    private ArrayList<Choice> choices = new ArrayList<Choice>();
    public Room(String description){
        this.description = description;
    }
    public void look(){
        System.out.println(description);
        System.out.println(" "); // for formatting
    }
    public String getDescription(){
        return description;
    }
    public void changeDescription(String newDescription){
        this.description = newDescription;
    }
    public void addChoice(Choice choice){
        choices.add(choice);
    }
    public boolean hasChoice(String choiceName){
        for (int i = 0; i < choices.size(); i++){
            if (choices.get(i).getName().equals(choiceName)){
                return true;
            }
        }
        return false;
    }
}
