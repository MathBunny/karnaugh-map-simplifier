import javax.swing.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;


public class ContentPanel extends JPanel{
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
  
  /** This method draws the graphics. */
  protected void paintComponent(Graphics g) {
    //System.out.println("Called!");
    final int ROWS = (var % 2 == 0) ? (var) : (var + 1);
    final int COLS = (var % 2 == 0) ? (var) : ((var-1)); //really?
    //now I need to adjust the size factor of the # of cols...
    
    
    //paintComponent(g); test?
    Graphics2D g2 = (Graphics2D) g.create();
    /* Populate chart */
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
    
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
    
    g2.draw(new Line2D.Double(START_X, START_Y, START_X - 30, START_Y - 30));
    
    g.drawString((var == 2) ? ("A") : ("AB"), START_X - 35, START_Y - 5);
    g.drawString((var == 2) ? ("B") : (var == 3) ? ("C") : ("CD"), START_X - 15, START_Y - 18);
    
    for(int i = 0; i < COLS; i++){
      if (COLS == 2 || COLS == 3){
        g.drawString((i & 1) + "", START_X + i * WIDTH + WIDTH/2, START_Y - 10);
      }else{
        String outputString = "";
        int [] bits = new int[]{0, 0};
        for(int x = 0; x < i; x++){
          if (bits[1] == 0){
            bits[1] = 1;
          }else{ //if (bits[1] == 1 && bits[0] == 0)
            bits[1] = 0;
            bits[0] = 1;
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
          }else{ //if (bits[1] == 1 && bits[0] == 0)
            bits[1] = 0;
            bits[0] = 1;
          }
        }
        outputString += bits[0];
        outputString += bits[1];
        g.drawString(outputString, START_X - 24, START_Y + i * WIDTH + WIDTH/2 + 5); //+5?
      }
    }
    
    /*
     int w = getWidth();
     int h = getHeight();
     Insets insets = getInsets();    // border info
     double xInc = (w - insets.left - insets.right - 2*PAD)/COLS;
     double yInc = (h - insets.top - insets.bottom - 2*PAD)/ROWS;
     g2.setPaint(Color.blue);
     
     // vertical lines
     double x1 = insets.left + PAD, y1 = insets.top + PAD,
     y2 = h - insets.bottom - PAD, x2;
     for(int j = 0; j <= COLS; j++){
     g2.draw(new Line2D.Double(x1, y1, x1, y2));
     x1 += xInc;
     }
     // horizontal lines
     x1 = insets.left + PAD; x2 = w - insets.right - PAD;
     for(int j = 0; j <= ROWS; j++){
     g2.draw(new Line2D.Double(x1, y1, x2, y1));
     y1 += yInc;
     }
     // try a couple of cell strings
     g2.setPaint(Color.red);
     Font font = g2.getFont().deriveFont(18f);
     g2.setFont(font);
     FontRenderContext frc = g2.getFontRenderContext();
     x1 = 0;
     for(int j = 0; j < msgs.length; j++)
     {
     float width = (float)font.getStringBounds(msgs[j], frc).getWidth();
     LineMetrics lm = font.getLineMetrics(msgs[j], frc);
     float ascent = lm.getAscent(), descent = lm.getDescent();
     float sx = (float)(insets.left + PAD + x1 + (xInc - width)/2);
     float sy = (float)(insets.top + PAD + (yInc + ascent)/2 - descent);
     g2.drawString(msgs[j], sx, sy);
     x1 += xInc;
     } */
  }
  
}