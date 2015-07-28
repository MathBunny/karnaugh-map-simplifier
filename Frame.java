import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.TableCellRenderer;


public class Frame implements ActionListener{
  JFrame a;
  JPanel panel;
  int [] [] truthTableVal;
  JButton [] [] truthTable;
  
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
    JLabel test = new JLabel ("Hello World.");
    panel1.add(test);
    /* Insert the rest of the code here. */
    
    /* 2 variable */
    truthTable = new JButton[2][4];
    truthTableVal = new int [2][4];
    for(int x = 0; x < truthTable.length; x++){
      for(int y = 0; y < truthTable[0].length; y++){
        truthTable[x][y] = new JButton("0");
        truthTableVal[x][y] = 0;
        truthTable[x][y].setActionCommand("" + 4 * x + y);
      }
    }
  }
  
  
  public void actionPerformed(ActionEvent ae){
    int num = Integer.parseInt(ae.getActionCommand());
    int x,y;
    if (num > 4){
      x = 1; 
      y = num - 4;
    }
    else{
      y = num;
      x = 0;
    }
    
    
    
    if (truthTableVal[x][y] == 0){
      truthTableVal[x][y] = 1;
      truthTable[x][y] = new JButton("1");
    }
    else{
      truthTableVal[x][y] = 0;
      truthTable[x][y] = new JButton("0");
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