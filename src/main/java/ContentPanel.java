import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;



public class ContentPanel extends JPanel{
  private int var;
  private Color [] colors = {
    new Color(0x673ab7),
    new Color(0x00e676),
    new Color(0xe91e63),
    new Color(0x2196f3),
    new Color(0x009688),
    new Color(0xff5722)
  };

  public static final int GROUPING_THICKNESS = 4;
  private int tick = 0;
  
  
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


  public void drawGroup(Graphics g2){
    System.out.println(tick);

    final int ROWS = (var % 2 == 0) ? (var) : (var + 1);
    final int COLS = (var % 2 == 0) ? (var) : (var - 1); //really?

    final int START_X = 270;
    final int START_Y = 50;
    final int END_X = (COLS == ROWS) ? (670) : (START_X + WIDTH * COLS);
    final int END_Y = 450;

    final int DIST = (var == 2) ? (200) : (100); //size of box
    final int CURVE = (var == 2) ? (100) : (50);

    tick(g2);
    ((Graphics2D)(g2)).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    ((Graphics2D)(g2)).setStroke(new BasicStroke(ContentPanel.GROUPING_THICKNESS));
    ((Graphics2D)(g2)).draw(new RoundRectangle2D.Float(START_X, START_Y, DIST*2, DIST*2, CURVE, CURVE));
    if (var == 4) {
      tick(g2);
      ((Graphics2D) (g2)).draw(new RoundRectangle2D.Float(START_X, START_Y + DIST*2, DIST * 4, DIST, CURVE, CURVE));

      tick(g2);
      ((Graphics2D) (g2)).draw(new RoundRectangle2D.Float(START_X+DIST*3, START_Y, DIST * 1, DIST * 4, CURVE, CURVE));

    }
  }

  private void tick(Graphics g2){
    tick = (tick+1)%colors.length;
    g2.setColor(colors[tick]);
  }
  
  /** This method draws the graphics. */
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