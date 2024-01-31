import java.awt.Color;
import java.awt.Graphics2D;

public class Demo extends GridGame {

  private Color[][] grid;

  public Demo(int rows, int columns) {
    super(rows, columns, 10);
    grid = new Color[rows][columns];
    setColor();
  }

  /*
   * This method will be called whenever you need to draw a cell. The Graphics2D
   * object is essentially the same one you used in the Flag but with a few more
   * methods. See:
   *
   * https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/java/awt/Graphics2D.html
   */
  public void paintCell(int row, int column, Graphics2D g) {
    g.setColor(grid[row][column]);
    g.fillRect(0, 0, cellWidth(), cellHeight());
  }

  /*
   * This method will be called for you when the user clicks a cell in the grid.
   */
  public void cellClicked(int row, int col) {
    int player = 1;
    if (grid[row][col].getRGB() == Integer.MAX_VALUE){
    grid[row][col] = setColorBlackOrWhite((player % 3) + 1);
    player++;
  } else {
    grid[row][col] = setColorBlackOrWhite(1);
  }
    
    // You can't directly call a method to paint the component but the repaint
    // method (which you inherit from GridGame) tells the Swing framework that
    // this component needs to be repainted which will result in a call to
    // paintComponent (defined in GridGame) which will then cause paintCell to
    // be called for each cell.
    repaint();

    // after(
    //   500,
    //   () -> {
    //     grid[row][col] = old;
    //     repaint();
    //   }
    // );
  }

  //////////////////////////////////////////////////////////////////////////////
  // Private helper methods.

  private void setColor() {
    for (int r = 0; r < getRows(); r++) {
      for (int c = 0; c < getColumns(); c++) {
        grid[r][c] = setColorBlackOrWhite(0);
      }
    }
  }

  private Color setColorBlackOrWhite(int player) {
    //integer max value is white, 0 is black
    //player 0 is empty, player 1 is x/red, player two is 0/blue
    if (player == 0){
      return new Color(Integer.MAX_VALUE, false);
    } else if (player == 1){
      return new Color(255, false);
    } else if (player == 2){
      return new Color(0-255, false);
    } else {
      throw new RuntimeException("player value not understood");
    
    }
      
 

    
  }
}
