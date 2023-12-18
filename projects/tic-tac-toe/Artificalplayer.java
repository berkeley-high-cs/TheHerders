public class Artificalplayer {
    public static void main(String[] args) {

    }

    public static void move(int[][] board, int turn, String difficulty) {
        if (difficulty.equals("easy")) {
            int randSpace = (int) (Math.floor(Math.random() * (9 - 1 + 1) + 1));
            // System.out.println("randSpace is " + randSpace);
            int x = (int) (randSpace / 3.5);
            // System.out.println("x is " + x);
            int y = (randSpace + 2) % 3;
            // System.out.println("y is " + y);
            if (board[x][y] == 0) {
                board[x][y] = 2;
            } else {
                move(board, turn, difficulty);
            }
        } else if (difficulty.equals("medium")) {
            int[] loseArray = aboutToWin(board, 1); // checks if player 1 is about to win, in this case real player
            int[] winArray = aboutToWin(board, 2); // checks if ai player, or player 2 is about to win
            if (winArray[0] != -1) {

                int x = winArray[0];
                int y = winArray[1];
                board[x][y] = 2;
            } else if (loseArray[0] != -1) {
                int x = loseArray[0];
                int y = loseArray[1];
                board[x][y] = 2;
            } else {
                int randSpace = (int) (Math.floor(Math.random() * (9 - 1 + 1) + 1));
                // System.out.println("randSpace is " + randSpace);
                int x = (int) (randSpace / 3.5);
                // System.out.println("x is " + x);
                int y = (randSpace + 2) % 3;
                // System.out.println("y is " + y);
                if (board[x][y] == 0) {
                    board[x][y] = 2;
                } else {
                    move(board, turn, difficulty);
                }
            }
        } else if (difficulty.equals("hard")) {
            int[] loseArray = aboutToWin(board, 1); // checks if player 1 is about to win, in this case real player
            int[] winArray = aboutToWin(board, 2); // checks if ai player, or player 2 is about to win
            if (winArray[0] != -1) {

                int x = winArray[0];
                int y = winArray[1];
                board[x][y] = 2;
            } else if (loseArray[0] != -1) {
                int x = loseArray[0];
                int y = loseArray[1];
                board[x][y] = 2;
            } else {
                for (int x = 0; x <= 2; x += 2) {
                    for (int y = 0; y <= 2; y += 2) {
                        if (board[x][y] == 0) {
                            board[x][y] = 2;
                            x = 2;
                            y = 2;
                        } 
                    }
                }
            }
        }else if (difficulty.equals("impossible")) {
            int[] loseArray = aboutToWin(board, 1); // checks if player 1 is about to win, in this case real player
            int[] winArray = aboutToWin(board, 2); // checks if ai player, or player 2 is about to win
            if (winArray[0] != -1) {

                int x = winArray[0];
                int y = winArray[1];
                board[x][y] = 2;
            } else if (loseArray[0] != -1) {
                int x = loseArray[0];
                int y = loseArray[1];
                board[x][y] = 2;
            } else {
                for (int x = 0; x <= 2; x += 2) {
                    for (int y = 0; y <= 2; y += 2) {
                        if (board[x][y] == 0) {
                            board[x][y] = 2;
                        } 
                    }
                }
            }
        } else {
            System.out.println("Error");
        }

    }

    public static int[] aboutToWin(int[][] board, int x) {
        int[] xyArray = new int[2];
        for (int i = 0; i < 3; i++) {
            if (board[i][2] == x && board[i][1] == x && board[i][0] == 0) {
                xyArray[0] = i;
                xyArray[1] = 0;
                return xyArray;
            }
            if (board[i][2] == x && board[i][0] == x && board[i][1] == 0) {
                xyArray[0] = i;
                xyArray[1] = 1;
                return xyArray;
            }
            if (board[i][0] == x && board[i][1] == x && board[i][2] == 0) {
                xyArray[0] = i;
                xyArray[1] = 2;
                return xyArray;
            }
            if (board[0][i] == x && board[1][i] == x && board[2][1] == 0) {
                xyArray[0] = 2;
                xyArray[1] = i;
                return xyArray;
            }
            if (board[0][i] == x && board[2][i] == x && board[1][i] == 0) {
                xyArray[0] = 1;
                xyArray[1] = i;
                return xyArray;
            }
            if (board[2][i] == x && board[1][i] == x && board[0][i] == 0) {
                xyArray[0] = 0;
                xyArray[1] = i;
                return xyArray;
            }
        }
        if (board[0][0] == x && board[1][1] == x && board[2][2] == 0) {
            xyArray[0] = 2;
            xyArray[1] = 2;
            return xyArray;
        }
        if (board[2][2] == x && board[0][0] == x && board[1][1] == 0) {
            xyArray[0] = 1;
            xyArray[1] = 1;
            return xyArray;
        }
        if (board[2][2] == x && board[1][1] == x && board[0][0] == 0) {
            xyArray[0] = 0;
            xyArray[1] = 0;
            return xyArray;
        }
        if (board[0][2] == x && board[1][1] == x && board[0][1] == 0) {
            xyArray[0] = 2;
            xyArray[1] = 0;
            return xyArray;
        }
        if (board[0][2] == x && board[2][0] == x && board[0][1] == 0) {
            xyArray[0] = 1;
            xyArray[1] = 1;
            return xyArray;
        }
        if (board[2][0] == x && board[1][1] == x && board[0][1] == 0) {
            xyArray[0] = 0;
            xyArray[1] = 2;
            return xyArray;
        }
        int[] noWin = { -1 };
        return noWin;

    }

}
