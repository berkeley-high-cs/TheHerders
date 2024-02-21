package projects.snake;

public class Snake {
    public static final int boardSize = 16;
    public static void main(String[] args) {
        
        int[][] screen = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int x = 0; x < boardSize; x++){
                if(i == 0 || i == boardSize){
                    screen[i][x] = 1;
                } else if (x == 0 || x == boardSize){
                screen[i][x] = 2;
                }
            }

        }
        Display.printScreen(screen);
    }
}
