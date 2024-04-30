import java.util.*;

public class Room {
    private String description;
    private ArrayList<Choice> choices = new ArrayList<Choice>();
    public Room(String description){
        this.description = description;
        choices.add(new Look()); 
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
    public ArrayList<Choice> getChoices(){
        return choices;
    }
    public void callChoiceConsequence(String choiceName, Player player){ //pre requisite, choice name must be in choices
        for (int i = 0; i < choices.size(); i++){
            if (choices.get(i).getName().equals(choiceName)){
                choices.get(i).callConsequence(player);
            }
        }
    }
}
