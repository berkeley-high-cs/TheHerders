public class Item {
    private String itemName;
    private String itemType; //currently just sword or key. Maybe just make it item name, sword, meat key, dusty large key, dank key
    public Item(String itemName, String itemType){
        this.itemName = itemName;
        this.itemType = itemType;
    }
    public String getItemName(){
        return itemName;
    }
    public String getItemType(){
        return itemType;
    }
    
}
