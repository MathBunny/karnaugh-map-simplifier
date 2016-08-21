import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * This is the content panel drawing graphics
 * @author Horatiu Lazu
 * @version 1.0
 */

public class ContentPanel extends JPanel{
  /** var int This is the number of variables */
  private int var;
  
  /** This method is the class constructor.
    * @param var int This is the number of variables. */
  public ContentPanel(int var){
    this.var = var;
  }
  
  /** This method returns the variable.
    * @return int The number of variables. */
  public int getVar(){
    return var;
  }

  /**
   * This method draws a group in the field by using DrawGroups
   * @param g2 Graphics This is the graphics reference.
   */
  public void drawGroup(Graphics g2){
    Solve.solveKarnaughMap(var, false); //solve!
    LinkedList<Grouping> sol = Solve.solution;
    DrawGroupings dG = new DrawGroupings(sol, var, (Graphics2D)g2);
    dG.drawGroups();
    if (Settings.getRealtime())
      repaint();
  }

  /**
   * This paints the components including the grid.
   * @param g Graphics This it the graphics object.
   */
  protected void paintComponent(Graphics g) {
    final int ROWS = (var % 2 == 0) ? (var) : (var + 1);
    final int COLS = (var % 2 == 0) ? (var) : ((var-1)); //really?
    Graphics2D g2 = (Graphics2D) g.create();
    
    /* Populate chart */
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    
    final int WIDTH = (400 / ROWS);
    final int START_X = 270;
    final int START_Y = 50;
    final int END_X = (COLS == ROWS) ? (670) : (START_X + WIDTH * COLS);
    final int END_Y = 450;
    
    for(int i = 0; i <= ROWS; i++){
      g2.draw(new Line2D.Double(START_X, START_Y + i * WIDTH, END_X, START_Y + i * WIDTH));
    }
    
    for(int i = 0; i <= COLS; i++){
      g2.draw(new Line2D.Double(START_X + i * WIDTH, START_Y, START_X + i * WIDTH, END_Y));
    }
    
    /* Add the labelling for the variable names. */
    g2.draw(new Line2D.Double(START_X, START_Y, START_X - 30, START_Y - 30));
    
    g.drawString((var == 2) ? ("A") : ("AB"), START_X - 35, START_Y - 5);
    g.drawString((var == 2) ? ("B") : (var == 3) ? ("C") : ("CD"), START_X - 15, START_Y - 18);
    
    /* Add the labelling for the sides. */
    for(int i = 0; i < COLS; i++){
      if (COLS == 2 || COLS == 3){
        g.drawString((i & 1) + "", START_X + i * WIDTH + WIDTH/2, START_Y - 10);
      }else{
        String outputString = "";
        int [] bits = new int[]{0, 0};
        for(int x = 0; x < i; x++){
          if (bits[1] == 0){
            bits[1] = 1;
          }else if (bits[0] == 0){ //if (bits[1] == 1 && bits[0] == 0)
            bits[1] = 1;
            bits[0] = 1;
          }
          else{
            bits[1] = 0; 
          }
        }
        outputString += bits[0];
        outputString += bits[1];
        g.drawString(outputString, START_X + i * WIDTH + WIDTH/2 - 10, START_Y - 10);
      }
    }
    
    for(int i = 0; i < ROWS; i++){
      if (ROWS == 2){
        g.drawString((i & 1) + "", START_X - 20, START_Y  + i * WIDTH + WIDTH/2);
      }else{
        String outputString = "";
        int [] bits = new int[]{0, 0};
        for(int x = 0; x < i; x++){
          if (bits[1] == 0){
            bits[1] = 1;
          }else if (bits[0] == 0){ //if (bits[1] == 1 && bits[0] == 0)
            bits[1] = 1;
            bits[0] = 1;
          }
          else{
            bits[1] = 0; 
          }
        }
        outputString += bits[0];
        outputString += bits[1];
        g.drawString(outputString, START_X - 24, START_Y + i * WIDTH + WIDTH/2 + 5); //+5?
      }
    }

    //temporary
    drawGroup(g);
  }
  
}