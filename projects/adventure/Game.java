import java.util.Scanner;

public class Game {
    public static Room[][] map = new Room[3][3];
    public Game(){
        for (int y = 0; y < 3; y++){
            for (int x = 0; x < 3; x++){
                map[y][x] = new Room("You are in a grand hall way, with halls to each and every side");
            } 
        }
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