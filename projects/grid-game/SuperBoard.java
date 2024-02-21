import java.awt.Color;
import java.awt.Graphics2D;

public class SuperBoard extends GridGame {

  private Color[][] grid;
  private GuiSuper superBoard;
  private TicTacToeBoard[][] superBoardGui; 
  

  public SuperBoard(GuiSuper superBoard, TicTacToeBoard[][] superBoardGui) {
    
    super(3, 3, 10);
    grid = new Color[9][9];
    setColor(0);
    this.superBoard = superBoard;
    this.superBoardGui = superBoardGui;
    for (int i = 0; i < 9; i++){
        superBoardGui[i/3][i%3] = new TicTacToeBoard(superBoard, superBoard.getBoards()[i]);
    }
    
  }

  /*
   * This method will be called whenever you need to draw a cell. The Graphics2D
   * object is essentially the same one you used in the Flag but with a few more
   * methods. See:
   *
   * https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/java/awt/Graphics2D.html
   */
  public void paintCell(int row, int column, Graphics2D g) {
    g.setFont(g.getFont().deriveFont(32f));
    g.setColor(grid[row][column]);
    g.drawRect(0, 0, cellWidth(), cellHeight());
    //g.fillRect(0, 0, cellWidth(), cellHeight());
    g.setColor(Color.BLACK);

      //System.out.println("board space.asLetter: " + board.asLetter(board.getBoard()[row][column]));
      g.drawString(superBoardGui[row][column].getGuiBoard().asLetter(superBoardGui[row][column].getGuiBoard().getBoard()[row][column]),cellWidth()/2, cellHeight()/2);
      //GuiSuper.superGameLoop(superBoard);
    
    
  }

  /*
   * This method will be called for you when the user clicks a cell in the grid.
   */
  public void cellClicked(int row, int col) {
    
    repaint();

   
  }

  //////////////////////////////////////////////////////////////////////////////
  // Private helper methods.

  private void setColor(int color) {
    for (int r = 0; r < getRows(); r++) {
      for (int c = 0; c < getColumns(); c++) {
        grid[r][c] = setColorWhiteOrWin(color);
      }
    }
  }

  private Color setColorWhiteOrWin(int color) {
    //integer max value is white, 0 is black
    //player 0 is white, player 1 is x/red, player two is 0/blue
    //0-255-0 is yellow
   if (color == 0){
    return Color.WHITE;
   } 
   else if (color == 1){
    return Color.RED;
   }
   else if (color == 2){
    return Color.BLUE;
   } else{
    return Color.GRAY;
   }
     
    
      
 

    
  }
  //public void guiGameStateChecker(Graphics2D g){
    // if (GuiTicTacToe.winChecker(1, board)){
    //   setColor(1);
    //   board.setWonTrue();
    // } 
    // if (GuiTicTacToe.winChecker(2, board)){
    //   setColor(2);
    //   board.setWonTrue();
    // } 
    // if (GuiTicTacToe.tieChecker(board)){
    //   setColor(-1);
    //   board.setWonTrue();
   // }
  //}
}
