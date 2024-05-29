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
            if (items.get(i).getItemType().equals(item.getItemType())){
                items.remove(i);
                i = items.size(); //only want to remove one item, first one
            } else if (i == items.size() && Game.debug){
                System.out.println("you tried to remove an item that doesnt exist");
            }
        }
        
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
        removeInspects();
        createInspects();
        removeTakes();
        createTakes();
        removeAttacks();
        createAttacks();
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
    public int findKeyWordInRoom(String keyWord){
        for (int i = 0; i < description.size(); i++){
            if (description.get(i).indexOf(keyWord) != -1){
                return i;
            }
        }
        if (Game.debug){
            System.out.println("no keyword found");
        }
        return 0;
    }
    public void createInspects(){
        for (int i = 0; i < items.size(); i++){
            addChoice(new Choice.Inspect(items.get(i).getItemName(), items.get(i).getDescriptionAsString()));
        }
    }
    public void removeInspects(){
        for (int i = 0; i < choices.size(); i++){
            if (choices.get(i).getName().indexOf("inspect") != -1){
                choices.remove(i);
                i--;
            }
        }
    }
    public void createTakes(){
        for (int i = 0; i < items.size(); i++){
            
                addChoice(new Choice.Take(items.get(i)));
            
        }
    }
    public void removeTakes(){
        for (int i = 0; i < choices.size(); i++){
            if (choices.get(i).getName().indexOf("take") != -1){
                choices.remove(i);
                i--;
            }
        }
    }
    public void createAttacks(){
        for (int i = 0; i < items.size(); i++){
            addChoice(new Choice.Attack(items.get(i)));
        }
    }
    public void removeAttacks(){
        for (int i = 0; i < choices.size(); i++){
            if (choices.get(i).getName().indexOf("attack") != -1){
                choices.remove(i);
                i--;
            }
        }
    }
    public boolean isAt(int row, int col){
        return getMapRow() == row && getMapCol() == col;
    }
    public void createPlayerInventoryEats(Player player){
        for (int i = 0; i < player.getInventory().size(); i++){
            addChoice(new Choice.Eat(player.getInventory().get(i)));
        }
    }
}
