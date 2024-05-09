import java.util.Scanner;

public class Game {
    private static boolean end = false;
    public static Room[][] map = new Room[3][3];
    public Game(){
       map[0][0] = new Room ("You see a butchering table, with assorted meat on top. You see a hallway to the east."); //choices take meat, then add description where key is below meat. move east
       map[0][1] = new Room ("You see a locked chest in the middle of the room. You see a hallway to the west, with a foul smell coming from inside. You see a hallway south."); //try to open chest, or use key if they have it
       map[0][2] = new Room(""); //no room
       map[1][0] = new Room("");  //no room
       map[1][1] = new Room("You are in a grand hallway, with large arched door to the north, east, and south. The is an insricption on one of the doorways."); //just move and read
       map[1][2] = new Room("You are in a throne room, long forgotten. The ground is dusty, and the throne has cobwebs on it. Not cozy. The only doorway is the one you came from."); //look throne will find the chest behind, or look behind
       map[2][0] = new Room("You encounter a goblin! He hasn't noticed you yet because he is eating some miscellaneous meat. It smells dank in here. The only doorway is the one you came from.");
       map[2][1] = new Room("You see a huge oaken door, with a large keyhole in the middle. It seems the only way to get out. There is a dank smell coming from the west door, and the only other doorway is the one you came from.");
       map[2][2] = new Room(""); //no room
    }
    public static void main(String[] args){
        Game game = new Game();
        Player player = new Player(map[1][1]);
        game.startShow();
        game.gameLoop(player);
    }
    public void gameLoop(Player player){
        player.getLocation().look();
    
        while (!end){
            player.getLocation().callChoiceConsequence(getPlayerChoiceName(player), player);
        }
        
        
    }
    public String getPlayerChoiceName(Player player){ // change for gui
        System.out.println("What do you want to do?");
        System.out.println(" "); // for formatting
        Scanner scanner = new Scanner(System.in);
        String choiceName = scanner.nextLine().toLowerCase();
        if (isUnderstood(choiceName, player.getLocation())){
           return choiceName;
        } else {
            System.out.println(" "); // for formatting
            System.out.println("Sorry, I didnt understand that, please try again");
            System.out.println(" "); // for formatting
            getPlayerChoiceName(player);
        }
         return null;// should never be able to run this
    }
    public boolean isUnderstood(String choiceName, Room location){
        if (location.hasChoice(choiceName)){
            return true;
        } else {
            return false; 
        }
        //placeholder for future
    }
    public void startShow(){ //change for gui
        System.out.print("\033[2J\033[1;1H");
        System.out.println("submit choice as always being of the form VERB NOUN like, “TAKE SWORD”, “EAT FOOD”, etc.");
        System.out.println(" "); // for formatting
    }
    public Room[][] getMap(){
        return map;
    }
}