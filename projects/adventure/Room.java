import java.util.*;

public class Room {
    private ArrayList<String> description = new ArrayList<String>();
    private ArrayList<Choice> choices = new ArrayList<Choice>();
    private int mapRow;
    private int mapCol;
    private ArrayList<Item> items = new ArrayList<Item>();
    public Room(String description, int mapRow, int mapCol){
        this.description.add(description);
        choices.add(new Choice.Look()); 
        this.mapRow = mapRow;
        this.mapCol = mapCol;
    }
    public void addItem(Item item){
        items.add(item);
    }
    public void removeItem(Item item){
        for (int i = 0; i < items.size(); i++){
            if (items.get(i).getItemType() == item.getItemType()){
                items.remove(i);
                i = items.size(); //only want to remove one item, first one
            }
        }
        System.out.println("you tried to remove an item that doesnt exist");
    }
    public boolean hasItem(Item item){
        for (int i = 0; i < items.size(); i++){
            if (items.get(i).getItemType() == item.getItemType()){
                return true;
            }
        }
       return false;
    }
    public void look(){
        for (int i = 0; i < description.size(); i++){
            System.out.print( description.get(i));
        }
        //System.out.println(description);
        System.out.println(" "); // for formatting
    }
    public ArrayList<String> getDescription(){
        return description;
    }
    public void changeDescription(String newDescription, int index){
        this.description.set(index, newDescription);
    }
    public void addDescription(String newPart){
        this.description.add(newPart);
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
