import java.util.Scanner;

public class Game {
    public static Room[][] map = new Room[3][3];
    public Game(){
        for (int y = 0; y < 3; y++){
            for (int x = 0; x < 3; x++){
                map[y][x] = new Room("letter in the form of words together");
            } 
        }
    }
    public static void main(String[] args){
        Player player = new Player(map[1][1]);
        Game game = new Game();
        System.out.println("submit choice as always being of the form VERB NOUN like, “TAKE SWORD”, “EAT FOOD”, etc.");
        game.gameLoop(player);
    }
    public void gameLoop(Player player){
        player.getLocation().look();
        
    }
    public String getPlayerChoice(){
        System.out.println("What do you want to do?");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (isUnderstood(choice)){
            return choice;
        } else {
            System.out.println("Sorry, I didnt understand that, please try again");
            getPlayerChoice();
        }
        return null; // should never be able to run this
    }
    public boolean isUnderstood(String choice){
        return false; //placeholder for future
    }
}