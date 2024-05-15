public class Choice {
    private String choiceName;
    public Choice(String choiceName){
        this.choiceName = choiceName;
    }

    public String getName(){
        return choiceName;
    }
    public void callConsequence(Player player){
        System.out.println("you arent really supposed to call me, callConsequence");
        return; //just for other methods to change
    }
    public static class Look extends Choice {
        public Look(){
            super("look"); 
        }
        public void callConsequence(Player player){
            System.out.println(""); // for formatting
            player.getLocation().look();
            System.out.println(""); // for formatting
        }
    }
    public static class Inspect extends Choice {
        private String textName;
        private String text;
        public Inspect(String textName, String text){
            super("inspect " + textName);
            this.textName = textName;
            this.text = text;
        }
        public void callConsequence(Player player){
            System.out.println(""); // for formatting
            System.out.println(text);
            System.out.println(""); // for formatting
        }
    }
    public static class Move extends Choice {
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
    public static class Take extends Choice{
        private Item item;
        public Take(Item item){
            super("take " + item);
            this.item = item;
        }
        public void callConsequence(Player player){
            if (player.getLocation().hasItem(item)){
                player.addToInventory(item);
                player.getLocation().removeItem(item);
                System.out.println(""); //formatting
                System.out.println("You take the " + item.getItemName());
                System.out.println(""); //formatting
            } else {
                System.out.println(""); //formatting
                System.out.println("There is no " + item);
                System.out.println(""); //formatting
            }
            
        }
    }
    
    
    
  
}
