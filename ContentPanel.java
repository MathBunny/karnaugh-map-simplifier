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
  
  /** This method draws the graphics. 
    * Credits to forums for the code...*/
  protected void paintComponent(Graphics g) {
    //System.out.println("Called!");
    final int ROWS = var * var;
    final int COLS = var * var; //really?
    final int PAD = 50; //10?
    String[] msgs;
    msgs = new String[]{"Hello World", "Graphics Test"};
    
    //paintComponent(g); test?
    Graphics2D g2 = (Graphics2D) g.create();
    /* Populate chart */
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
    
    
    final int START_X = 250;
    final int START_Y = 10;
    final int END_X = 690;
    final int END_Y = 450;
    
    final int WIDTH = (440 / ROWS);
    
    for(int i = 0; i <= ROWS; i++){
      g2.draw(new Line2D.Double(START_X, START_Y + i * WIDTH, END_X, START_Y + i * WIDTH));
    }
    
    for(int i = 0; i <= COLS; i++){
      g2.draw(new Line2D.Double(START_X + i * WIDTH, START_Y, START_X + i * WIDTH, END_Y));
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