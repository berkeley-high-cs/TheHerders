import java.util.Scanner;

public class Game {
    public static Room[][] map = new Room[3][3];
    public Game(){
       map[0][0] = new Room ("You see a butchering table, with assorted meat on top. You see a hallway to the east."); //choices take meat, then add description where key is below meat. move east
       map[0][1] = new Room ("You see a locked chest in the middle of the room. You see a hallway to the west, with a foul smell coming from inside. You see a hallway south."); //try to open chest, or use key if they have it
       map[0][2] = new Room(""); //no room
       m
    }
    public static void main(String[] args){
        Game game = new Game();
        Player player = new Player(map[1][1]);
        game.startShow();
        game.gameLoop(player);
    }
    public void gameLoop(Player player){
        player.getLocation().look();
        player.getLocation().callChoiceConsequence(getPlayerChoiceName(player), player);
        
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
}