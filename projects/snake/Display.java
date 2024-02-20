package projects.snake;

public class Display {
    public static void printScreen(int[][] screen){
        System.out.print("\033[2J\033[1;1H");
        for (int i = 0; i < Snake.boardSize; i++){
            for(int x = 0; x < Snake.boardSize; x++){
                System.out.print(toString(screen[i][x])); // print components
            }
            System.out.println("");//new line
        }
    }
    public static String toString(int object){
        if (object == 0){
            return " ";
        } 
        if (object == 1){
            return "_";
        }
        if (object == 2){
            return "|";
        }
        if (object == 3){
            return "U+1F7E9";
        }
        if (object == 4){
            return "U+1F34E";
        }
        return "error";
    }
    
}
