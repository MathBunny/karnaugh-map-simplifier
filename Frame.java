import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Frame implements ActionListener{
  JFrame a;
  JPanel panel;
  
  public static void main (String [] args){
    new Frame();
  }
  
  protected JComponent makeTextPanel(String text) {
    JPanel panel = new JPanel(false);
    JLabel filler = new JLabel(text);
    filler.setHorizontalAlignment(JLabel.CENTER);
    panel.setLayout(new GridLayout(1, 1));
    panel.add(filler);
    return panel;
  }
  
  protected static ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = Frame.class.getResource(path);
    if (imgURL != null) {
      return new ImageIcon(imgURL);
    } else {
      System.err.println("Couldn't find file: " + path);
      return null;
    }
  }
  
  /* Credits to Java Doc for code in using TabbedPanes */
  public void addTabs(){
    JTabbedPane tabbedPane = new JTabbedPane();
    ImageIcon icon = createImageIcon("images/middle.gif");
    
    JComponent panel1 = makeTextPanel("Panel #1");
    tabbedPane.addTab("2 Variable", icon, panel1,
                      "Does nothing");
    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
    
    JComponent panel2 = makeTextPanel("Panel #2");
    tabbedPane.addTab("3 Variable", icon, panel2,
                      "Does twice as much nothing");
    tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
    
    JComponent panel3 = makeTextPanel("Panel #3");
    tabbedPane.addTab("4 Variable", icon, panel3,
                      "Still does nothing");
    tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
    
    JComponent panel4 = makeTextPanel("Panel #4 (has a preferred size of 410 x 50).");
    panel4.setPreferredSize(new Dimension(1000, 500));
    
    tabbedPane.addTab("Virtual Grid", icon, panel4,
                      "Does nothing at all");
    tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
    panel.add(tabbedPane);
  }
  
  
  public void actionPerformed(ActionEvent ae){
    if (ae.equals("about")){
      new About();
      
    }
  }
  
  
  public Frame(){
    a = new JFrame("Karnaugh Map Simplification - Horatiu Lazu");
    panel = new JPanel();
    
    JMenuBar bar = new JMenuBar();
    
    JMenu file = new JMenu("File");
    JMenu help = new JMenu("Help");
    
    JMenuItem quit = new JMenuItem("Quit");
    file.add(quit);
    quit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        System.exit(0);
      }
    });
    
    JMenuItem about = new JMenuItem("About");
    about.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        new About();
      }
    });
    help.add(about);
    
    bar.add(file);
    bar.add(help);
    panel.add(bar);
    addTabs();
    a.add(panel);
    a.setJMenuBar(bar);
    
    
    a.setVisible(true);
    a.setSize(1024, 600);
    
    //new About(); //test
  }
  
  
}