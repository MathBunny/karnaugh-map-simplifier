/**
 * SyntheticApp - This class acts as the about class.
 * @author Horatiu Lazu
 * @version 1.0.0.2
 * 
 */

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;


public class About{
  
  /** This is the class constructor */
  public About(){
    final JFrame j = new JFrame("About: Synthetic Divisor");
    Container a = new Container();
    
    
    JButton done = new JButton("Quit");
    
    JLabel dev = new JLabel("Application developed by: Horatiu Lazu");
    JLabel dev2 = new JLabel("Copyright: 2015 SoftwareEngenius");
    JLabel dev3 = new JLabel("Version: 1.0.0.0");
    JLabel dev4 = new JLabel("Purpose: Simplify boolean expressions by using a k-map");
    JLabel dev5 = new JLabel("To be used for educational purposes. Do not edit source.");
    
    done.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e)
      {
        //Execute when button is pressed
        j.dispose();
        j.setVisible(false);
      }
    });
    
    dev.setBounds(7, 5, 300, 20);
    dev2.setBounds(7, 25, 300, 20);
    dev3.setBounds(7, 45, 300, 20);
    dev4.setBounds(7, 65, 500, 20);
    dev5.setBounds(7, 85, 500, 20);
    done.setBounds(90, 115, 200, 30);
    
    a.add(dev);
    a.add(dev2);
    a.add(dev3);
    a.add(dev4);
    a.add(dev5);
    a.add(done);
    
    j.add(a);
    j.setSize(new Dimension(400, 170));
    j.setDefaultCloseOperation(0xffffffff * 0 + JFrame.EXIT_ON_CLOSE);
    j.setVisible(true);
    
    
  }
}