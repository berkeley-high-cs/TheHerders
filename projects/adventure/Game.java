import java.util.Scanner;

public class Game {
    private static boolean end = false;
    public static Room[][] map = new Room[3][3];
    public Game(){
       map[0][0] = new Room ("You see a butchers table, with assorted rotting meat on top. It doesnt look like any meat you recognize. You see a hallway to the east.", 0, 0); //choices take meat, then add description where key is below meat. move east
       map[0][1] = new Room ("You see a locked chest in the middle of the room. You see a hallway to the west, with a foul smell coming from inside. You see a hallway south.", 0, 1); //try to open chest, or use key if they have it
       map[0][2] = new Room("", 0, 2); //no room
       map[1][0] = new Room("", 1, 0);  //no room
       map[1][1] = new Room("You are in a grand hallway, with large arched door to the north, east, and south. The is an inscription on one of the doorways.", 1, 1); //just move and read
       map[1][2] = new Room("You are in a throne room, long forgotten. The ground is dusty, and the throne has cobwebs on it. Not cozy. The only doorway is the one you came from.", 1, 2); //look throne will find the chest behind, or look behind
       map[2][0] = new Room("You encounter a goblin! He hasn't noticed you yet because he is eating some miscellaneous meat. It smells dank in here. The only doorway is the one you came from.", 2, 0);
       map[2][1] = new Room("You see a huge oaken door, with a large keyhole in the middle. It seems the only way to get out. There is a dank smell coming from the west door, and the only other doorway is the one you came from.", 2, 1);
       map[2][2] = new Room("", 2, 2); //no room
       map[0][0].addChoice(new Move("east"));
       map[0][1].addChoice(new Move("west"));
       map[0][1].addChoice(new Move("south"));
       map[1][1].addChoice(new Move("north"));
       map[1][1].addChoice(new Move("east"));
       map[1][1].addChoice(new Move("south"));
       map[1][2].addChoice(new Move("west"));
       map[2][0].addChoice(new Move("east"));
       map[2][1].addChoice(new Move("north"));
       map[2][1].addChoice(new Move("west"));
       map[1][1].addChoice(new Inspect("inscription", "The text reads: " + "\n" +
                                    "The keys three you will need " + "\n" +
                                    "from butchers table cleaned to chest " + "\n" +
                                    "the one that bleeds has another " + "\n" +
                                    "and behind the throne secrets smothered "));
       map[0][0].addChoice(new Inspect("table", "You disgustingly look under the rotten weird meat. Under the piles of meat, and blood, and stench, you find a key on the table"));
       map[0][1].addChoice(new Inspect("chest", "The chest looks relatively normal, albeit gross. The keyhole has bits of rotting meat in it. Gross."));
       map[1][2].addChoice(new Inspect("throne", "The dusty throne has something large behind it. As you get close, it looks to be a large chest, that smells quite dank"));
       map[2][0].addChoice(new Inspect("goblin", "He smells dank. His loincloth has pockets in it. Fancy"));
       map[2][1].addChoice(new Inspect("door", "The keyhole is huge and dusty, and the door seems unbreakable"));
       
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
        Normalize normalize = new Normalize();
        System.out.println("What do you want to do?");
        System.out.println(" "); // for formatting
        Scanner scanner = new Scanner(System.in);
        String choiceName = scanner.nextLine().toLowerCase();
        choiceName = normalize.normalizeInput(choiceName);
        if (isUnderstood(choiceName, player.getLocation())){
           return choiceName;
        } else {
            System.out.println(" "); // for formatting
            System.out.println("Sorry, I didnt understand that, please try again");
            System.out.println(" "); // for formatting
            return getPlayerChoiceName(player);
        }
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
        System.out.println("submit choice as always being of the form VERB NOUN like, “inspect insription”, “move west”, etc.");
        System.out.println(" "); // for formatting
    }
    public static Room[][] getMap(){
        return map;
    }

}