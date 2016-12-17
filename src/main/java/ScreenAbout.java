import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

/**
 * The purpose of this class is to show an about box.
 * @author Horatiu Lazu
 * @version 1.1
 */

public class ScreenAbout extends JFrame implements ActionListener{
  /** background Image This is the background image object */
  private Image background;

  /**
   * This is the class constructor.
   */
  public ScreenAbout(){
    super("About Karnaugh Map Simplification");
    setSize(250, 350);
    setResizable(false);

    addButton();
    fetchImage();

    setVisible(true);
  }

  /**
   * This method adds a button to quit.
   */
  private void addButton(){
    JPanel panel = new JPanel();
    JButton quit = new JButton("Quit");
    panel.setLayout(null);
    quit.addActionListener(this);

    quit.setSize(100, 30);
    quit.setLocation(80, 270);

    panel.add(quit);
    add(panel);
  }

  /**
   * This method fetches the image for about.
   */
  private void fetchImage(){
    try{
      background = ImageIO.read(this.getClass().getResource("About.jpg"));
    }
    catch(IOException e){
      JOptionPane.showMessageDialog(this, "Error: Could not find About screen background image!");
    }
  }

  /** This method paints the graphics.
   * @param g Graphics This is a reference variable. */
  public void paint(Graphics g){
    super.paint(g);
    g.drawImage(background, 0, 20, null);
  }

  /** This checks for a button click.
   * @param arg0 ActionEvent This is an action event reference */
  public void actionPerformed(ActionEvent arg0) {
    setVisible(false);
  }
}
