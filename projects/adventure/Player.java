import java.util.*;

public class Player {
    private ArrayList<String> inventory = new ArrayList<String>();
    private Room location;
    public Player(Room startingRoom){
        this.location = startingRoom;

    }
    public ArrayList<String> getInventory(){ // for code
        return inventory;
    }
    // these are choices and should be added to room as basic always avalible actions
    // public void lookAtInventory(){ //for player
    //     System.out.println("Your inventory includes: ");
    //     for (int i = 0; i < inventory.size(); i++){
    //         System.out.println(inventory.get(i));
    //     }
    // } 
    // public void look(){ // for player
    //     System.out.println(location.getDescription());
    // }
    public Room getLocation(){
        return location;
    }
    public void addToInventory(String item){
        inventory.add(item);
    }
    public void removeFromInventory(String item){
        for (int i = 0; i < inventory.size(); i++){
            if (item.equals(inventory.get(i))){
                inventory.remove(i);
            }
        }
    }
    public void changeLocation(Room newLocation){
        this.location = newLocation;
    }
}
