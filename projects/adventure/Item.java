import java.util.*;

public class Item {
    private String itemName;
    private String itemType; //currently just sword or key. Maybe just make it item name, sword, meat key, dusty large key, dank key
    //changing, item type now could have food, or immovable, or something else like that
    private ArrayList<String> description = new ArrayList<String>();
    public Item(String itemName, String itemType, String description){
        this.itemName = itemName;
        this.itemType = itemType;
        this.description.add(description);
    }
    public String getItemName(){
        return itemName;
    }
    public String getItemType(){
        return itemType;
    }
    public ArrayList<String> getDescription(){
        return description;
    }
    public void changeDescription(int index, String newDescription){
        description.set(index, newDescription);
    }
    public int findKeyWordInDescription(String keyWord){
        for (int i = 0; i < description.size(); i++){
            if (description.get(i).indexOf(keyWord) != -1){
                return i;
            }
        }
        System.out.println("no keyword found");
        return -1;
    }
    public String getDescriptionAsString(){
        String stringDescription = "";
        for (int i = 0; i < description.size(); i++){
            stringDescription += description.get(i);
        }
        return stringDescription;
    }
    public void addDescription(String newDescription){
        description.add(newDescription);
    }
    
}
