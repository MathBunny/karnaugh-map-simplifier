import javax.swing.*;
import java.awt.*;


public class ContentPanel extends JPanel{
  private int var;
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
    //paintComponent(g); test?
    Graphics2D g2d = (Graphics2D) g.create();
    /* Populate chart */
    Rectangle cell;
    final  int variables = var;
    for(int x = 0; x < variables; x++){
      for(int y = 0; y < variables; y++){
        cell = new Rectangle(200 + x * 40,100 + y * 40,40,40);
        g2d.fill(cell);
        g2d.setColor(Color.BLUE);
        g2d.draw(cell);
      }
      g2d.dispose();
    }
  }
  
}