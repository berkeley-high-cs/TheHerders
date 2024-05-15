import java.util.*;

public class Room {
    private String description;
    private ArrayList<Choice> choices = new ArrayList<Choice>();
    private int mapRow;
    private int mapCol;
    public Room(String description, int mapRow, int mapCol){
        this.description = description;
        choices.add(new Choice.Look()); 
        this.mapRow = mapRow;
        this.mapCol = mapCol;
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
    public int getMapRow(){
        return mapRow;
    }
    public int getMapCol(){
        return mapCol;
    }
}
