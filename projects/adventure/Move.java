public class Move extends Choice {
    private String direction; //all lowercase, north south east west
    public Move(String direction){
        super("move " + direction);
        this.direction = direction;
    }
    public void callConsequence(Player player){
        switch(direction){
            case "north": 
            player.changeLocation(Game.getMap()[player.getLocation().getMapRow() - 1][player.getLocation().getMapRow()]);//move player north 
            player.getLocation().callChoiceConsequence("look", player); //print out what the room they are in looks like
            System.out.println("Player row is: " + player.getLocation().getMapRow() + "Player column is: " + player.getLocation().getMapCol());
            break;
            case "east":
            player.changeLocation(Game.getMap()[player.getLocation().getMapRow()][player.getLocation().getMapRow() + 1]); 
            player.getLocation().callChoiceConsequence("look", player); 
            System.out.println("Player row is: " + player.getLocation().getMapRow() + "Player column is: " + player.getLocation().getMapCol());
            break;
            case "south":
            player.changeLocation(Game.getMap()[player.getLocation().getMapRow() + 1][player.getLocation().getMapRow()]);
            player.getLocation().callChoiceConsequence("look", player);  
            System.out.println("Player row is: " + player.getLocation().getMapRow() + "Player column is: " + player.getLocation().getMapCol());
            break;
            case "west":
            player.changeLocation(Game.getMap()[player.getLocation().getMapRow()][player.getLocation().getMapRow() - 1]);
            player.getLocation().callChoiceConsequence("look", player); 
            System.out.println("Player row is: " + player.getLocation().getMapRow() + " Player column is: " + player.getLocation().getMapCol());
            break;
            default:
            System.out.println("Error, direction not understood");
        }
    }
}
