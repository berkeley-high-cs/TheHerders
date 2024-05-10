public class Move extends Choice {
    private String direction; //all lowercase, north south east west
    public Move(String direction){
        super("move " + direction);
        this.direction = direction;
    }
    public void callConsequence(Player player){
        switch(direction){

            case "north": 
            player.changeLocation(Game.getMap()[player.getLocation().getMapRow() - 1][player.getLocation().getMapCol()]);//move player north 
            showPlayerLocation(player);
            break;

            case "east":
            player.changeLocation(Game.getMap()[player.getLocation().getMapRow()][player.getLocation().getMapCol() + 1]); 
            showPlayerLocation(player);
            break;

            case "south":
            player.changeLocation(Game.getMap()[player.getLocation().getMapRow() + 1][player.getLocation().getMapCol()]);
            showPlayerLocation(player);
            break;

            case "west":
            player.changeLocation(Game.getMap()[player.getLocation().getMapRow()][player.getLocation().getMapCol() - 1]);
            showPlayerLocation(player);
            break;
            
            default:
            System.out.println("Error, direction not understood");
        }
    }
    public void showPlayerLocation(Player player){ //change for gui
        player.getLocation().callChoiceConsequence("look", player); //print out what the room they are in looks like
    }
}
