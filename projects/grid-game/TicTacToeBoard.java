import java.awt.Color;
import java.awt.Graphics2D;

public class TicTacToeBoard extends GridGame {

  private Color[][] grid;
  private GuiTicTacToe board;
  private GuiSuper superBoard;
  

  public TicTacToeBoard(GuiSuper superBoard, GuiTicTacToe board) {
    
    super(3, 3, 10);
    grid = new Color[3][3];
    setColor(0);
    this.board = board;
    this.superBoard = superBoard;
    
  }
  public GuiTicTacToe getGuiBoard(){
    return board;
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
    g.fillRect(0, 0, cellWidth(), cellHeight());
    g.setColor(Color.BLACK);

      //System.out.println("board space.asLetter: " + board.asLetter(board.getBoard()[row][column]));
      g.drawString(board.asLetter(board.getBoard()[row][column]),cellWidth()/2, cellHeight()/2);
      
    
    
  }

  /*
   * This method will be called for you when the user clicks a cell in the grid.
   */
  public void cellClicked(int row, int col) {
    System.out.println("row: " + row + " col: " + col);
      
    if (board.getBoard()[row][col] == 0 && board.getWon() != true){
      superBoard.addTurn();
      board.getBoard()[row][col] = (superBoard.getTurn() % 2) + 1;
    }
   
    
    System.out.println("value in spot: " + board.getBoard()[row][col] + " player: " + ((superBoard.getTurn() % 2) + 1));
    guiGameStateChecker();
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
  public void guiGameStateChecker(){
    if (GuiTicTacToe.winChecker(1, board)){
      setColor(1);
      board.setWonTrue();
    } 
    if (GuiTicTacToe.winChecker(2, board)){
      setColor(2);
      board.setWonTrue();
    } 
    if (GuiTicTacToe.tieChecker(board)){
      setColor(-1);
      board.setWonTrue();
    }
  }
}
