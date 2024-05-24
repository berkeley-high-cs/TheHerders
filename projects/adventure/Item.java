import java.util.*;

public class Item {
    private String itemName;
    private String itemType; //currently just sword or key. Maybe just make it item name, sword, meat key, dusty large key, dank key
    //changing, item type now could have food, or immovable, or something else like that
    private ArrayList<Item> itemsRefrenced = new ArrayList<Item>();
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
            if (description.get(i).toLowerCase().indexOf(keyWord.toLowerCase()) != -1){
                //System.out.println("we found " + keyWord + " at: " + i);
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
    public void addItemRefrenced(Item item){
        itemsRefrenced.add(item);
        item.getItemsRefrenced().add(this);
    }
    public ArrayList<Item> getItemsRefrenced(){
        return itemsRefrenced;
    }
    public Item findItemRefrenced(String itemType){
        for (int i = 0; i < itemsRefrenced.size(); i++){
            if (Game.debug){
                System.out.println("Item refrenced.get(i).get(itemType).toLowerCase() : " + itemsRefrenced.get(i).getItemType().toLowerCase());
                System.out.println("index Of itemType.toLowerCase : " + itemsRefrenced.get(i).getItemType().toLowerCase().indexOf(itemType.toLowerCase()));
            }
            if (itemsRefrenced.get(i).getItemType().toLowerCase().indexOf(itemType.toLowerCase()) != -1){
                return itemsRefrenced.get(i);
            }
        }
        if (Game.debug){
            System.out.println("item type not found in refrences"); //remove in final
        }
        return null;
    }
    public void removeItemRefrenced(String itemType){
        for (int i = 0; i < itemsRefrenced.size(); i++){
            if (itemsRefrenced.get(i).getItemType().indexOf(itemType) != -1){
                itemsRefrenced.get(i).removeOneItemRefrenced(this.getItemType());
                itemsRefrenced.remove(i);
                

                i = itemsRefrenced.size();
            }
        }
    }
    public void removeOneItemRefrenced(String itemType){
        for (int i = 0; i < itemsRefrenced.size(); i++){
            if (itemsRefrenced.get(i).getItemType().indexOf(itemType) != -1){
                itemsRefrenced.remove(i);
                i = itemsRefrenced.size();
            }
        }
    }
    public boolean isType(String type){
        return itemType.toLowerCase().indexOf(type.toLowerCase()) != -1;
    }
    public void removeSpecificItemRefrenced(String itemType){
        for (int i = 0; i < itemsRefrenced.size(); i++){
            if (itemsRefrenced.get(i).getItemType().toLowerCase().equals(itemType.toLowerCase())){
                itemsRefrenced.remove(i);
                i = itemsRefrenced.size();
            }
        }
    }

    
}
