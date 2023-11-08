public class Test {
    static int[][] constGrid = new int[2][2];
   // static int[][] tempGrid = new int[2][2];
    

    public static void main(String[] args) {
        int x = 2;
        int y = 2;
        findPathNum(0, x, y);
        
    }

    public static void findPathNum(int pathNum, int x, int y) {
        // tempGrid = constGrid;
        // tempGrid[x][y] = 1;
        // printBoard(tempGrid);
        if (x == 0 && y == 0) {
            System.out.println("Yay " + pathNum);
            
        } else {
            if (y > 0) {
                findPathNum(pathNum + 1, x, y - 1);
            }
            if (x > 0) {
                findPathNum(pathNum + 1, x - 1, y);
            }
        }

    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < 2; i++) {
            for (int x = 0; x < 2; x++){
            System.out.print((board[i][x]));
           
             }
             System.out.println("");
        }
    }
}


// + "  |  " + (board[i][2])