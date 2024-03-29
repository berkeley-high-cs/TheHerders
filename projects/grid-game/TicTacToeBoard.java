import java.awt.Color;
import java.awt.Graphics2D;

public class TicTacToeBoard extends GridGame {

  private Color[][] grid;
  private GuiTicTacToe board;
  private GuiSuper superBoard;
  

  public TicTacToeBoard(GuiSuper superBoard, GuiTicTacToe board) {
    
    super(3, 3, 10);
    grid = new Color[3][3];
    setColor(Color.WHITE);
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

  private void setColor(Color color) {
    for (int r = 0; r < getRows(); r++) {
      for (int c = 0; c < getColumns(); c++) {
        grid[r][c] = color;
      }
    }
  }

 
  public void guiGameStateChecker(){
    if (GuiTicTacToe.winChecker(1, board)){
      setColor(Color.RED);
      board.setWonTrue();
    } 
    else if (GuiTicTacToe.winChecker(2, board)){
      setColor(Color.BLUE);
      board.setWonTrue();
    } 
    else if (GuiTicTacToe.tieChecker(board)){
      setColor(Color.GRAY);
      board.setWonTrue();
    }
  }
}
