import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;

/** The purpose of this class is to setup the JFrame with all the assorted GUI elements.
  * @author Horatiu Lazu
  * @version 1.0 */

public class Frame implements ActionListener{ //fix to extend JFrame
  /** a JPanel This is the panel */
  JFrame a;
  /** panel JPanel This is the panel */
  JPanel panel;
  
  /** panel1 JPanel This is the JPanel with two variables. */
  JPanel panel1;
  /** panel2 JPanel This is the JPanel with three variables. */
  JPanel panel2;
  /** panel3 JPanel This is the JPanel with four variables. */
  JPanel panel3; //try using an array?

  /** panel4 JPanel This is the JPanel for 5+ variables */
  JPanel panel4;

  /** panel5 JPanel This is the JPanel for simulations */
  JPanel panel5;

  /** panel6 JPanel This is the JPanel for virtual grids */
  JPanel panel6;

  /** panel7 JPanel This is the JPanel for tools */
  JPanel panel7;

  /** givenEq JTextField This is the array containing the given equation text fields for all JPanels */
  static JTextField [] givenEq;
  /** ans JTextField This is the array containing the answer text fields for all JPanels */
  static JTextField [] ans;
  
  /** This is the main program.
    * @param args String [] This variable passes arguements into the main method. */
  public static void main (String [] args){
    new Frame(true);
  }
  
  protected static ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = Frame.class.getResource(path);
    if (imgURL != null) {
      return new ImageIcon(imgURL);
    } else {
      return null;
    }
  }
  
  /** This method adds truth tables to the panels. */
  public void addTruthTables(){
    
    /* Adding two variable truth-table */
    panel1.setLayout(null);
    
    JLabel truthTableText [] = new JLabel [3];
    for(int i = 0; i < 3; i++)
      truthTableText[i] = new JLabel("Truth Table");
    
    DefaultTableModel dm = new DefaultTableModel();
    dm.setDataVector(generateTruthTable(2), new Object[]{"A", "B", "F (AB)"});
    
    JTable table = new JTable(dm);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    table.getColumn("F (AB)").setCellRenderer(new ButtonRenderer());
    table.getColumn("F (AB)").setCellEditor(new ButtonEditor(new JCheckBox()));
    
    panel1.add(truthTableText[0]);
    truthTableText[0].setBounds(40, 8, 100, 30);
    
    JScrollPane scroll = new JScrollPane(table);
    scroll.setBounds(25, 36, 120, 90);
    
    table.setPreferredScrollableViewportSize(table.getPreferredSize());
    
    for(int i = 0; i < 2; i++) 
      table.getColumnModel().getColumn(i).setPreferredWidth(20);
    panel1.add(scroll);
    
    /* Adding 3 variable truth-table*/
    panel2.setLayout(null);
    dm = new DefaultTableModel();
    dm.setDataVector(generateTruthTable(3), new Object[]{"A", "B", "C", "F (ABC)"});
    
    table = new JTable(dm);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    table.getColumn("F (ABC)").setCellRenderer(new ButtonRenderer());
    table.getColumn("F (ABC)").setCellEditor(new ButtonEditor(new JCheckBox()));
    
    scroll = new JScrollPane(table);
    panel2.add(truthTableText[1]);//same one? nope
    truthTableText[1].setBounds(42, 8, 100, 30); //35 prev
    
    table.setPreferredScrollableViewportSize(new Dimension(10,200)); //table.getPreferredSize()
    
    for(int i = 0; i < 3; i++)
      table.getColumnModel().getColumn(i).setPreferredWidth(10);//so buttons will fit and not be shown button..
    scroll.setBounds(25 , 36, 125, 150); //set bounds...
    
    panel2.add(scroll);
    
    /* Adding 4 variable truth-table*/
    panel3.setLayout(null);
    
    dm = new DefaultTableModel();
    dm.setDataVector(generateTruthTable(4), new Object[]{"A", "B", "C", "D", "F (ABCD)"});
    
    table = new JTable(dm);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    table.getColumn("F (ABCD)").setCellRenderer(new ButtonRenderer());
    table.getColumn("F (ABCD)").setCellEditor(new ButtonEditor(new JCheckBox()));
    
    scroll = new JScrollPane(table);
    panel3.add(truthTableText[2]);
    truthTableText[2].setBounds(47, 8, 100, 30); //35 prev
    
    table.setPreferredScrollableViewportSize(new Dimension(10,200)); //table.getPreferredSize()
    
    for(int i = 0; i < 4; i++)
      table.getColumnModel().getColumn(i).setPreferredWidth(10);//so buttons will fit and not be shown butto..
    scroll.setBounds(25 , 36, 140, 280); //set bounds...
    panel3.add(scroll);
  }
  
  /* Credits to Java Doc for code in using TabbedPanes */
  public void addTabs(){
    JTabbedPane tabbedPane = new JTabbedPane();
    ImageIcon icon = createImageIcon("middle.gif"); //get rid of ImageIcon...
    
    panel1 = new ContentPanel(2);
    tabbedPane.addTab("2 Variable", icon, panel1,"2 Variable Boolean Expression Simplification");
    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
    
    panel2 = new ContentPanel(3);
    tabbedPane.addTab("3 Variable", icon, panel2, "3 Variable Boolean Expression Simplification");
    tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
    
    panel3 = new ContentPanel(4);
    tabbedPane.addTab("4 Variable", icon, panel3,"4 Variable Boolean Expression Simplification");
    tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
    
    panel4 = new FivePlusContentPanel(); //normal JPanel
    tabbedPane.addTab("5+ Variables", icon, panel4,"5+ Variable Boolean Expression Simplification");
    tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

    panel5 = new JPanel();
    panel5.setPreferredSize(new Dimension(1000, 500));
    tabbedPane.addTab("Simulation", icon, panel5,"Simulations with Karnaugh Maps");
    tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);

    panel6 = new JPanel();
    panel6.setPreferredSize(new Dimension(1000, 500));
    tabbedPane.addTab("Virtual Grid", icon, panel6,"Virtual Grid for experimentation");
    tabbedPane.setMnemonicAt(5, KeyEvent.VK_6);

    panel7 = new JPanel();
    panel7.setPreferredSize(new Dimension(1000, 500));
    tabbedPane.addTab("Tools", icon, panel7,"Tools");
    tabbedPane.setMnemonicAt(6, KeyEvent.VK_7);


    panel.add(tabbedPane);
    
  }
  
  /** Generate truth table using bitmasking
   *  @params variables int This is the number of variables
    * @return Object [] [] This is the truth table.*/
  private Object [] [] generateTruthTable(int variables){
    Object [] [] returnArray = new Object[(int)(Math.pow(2, variables))][variables +1];
    int num = (int)(Math.pow(2, variables));
    for(int i = 0; i < num; i++){
      int tempNum = i;
      for(int x = variables-1; x >= 0; x--)
        returnArray[i][x] = (tempNum >> (variables-1-x) & 1);
      returnArray[i][variables] = "0";
    }
    return returnArray;
  }
  
  /** actionPerformed method overrides ActionListener. This is for solve.
    * @param ae ActionEvent ActionEvent reference variable. */
  public void actionPerformed(ActionEvent ae){
    //solve and generate text
    panel1.repaint();
    panel2.repaint();
    panel3.repaint();

    //get # of variables
    JOptionPane.showMessageDialog(null, "Unsimplified Expression: "
            + givenEq[Solve.NUM_VARIABLES-2].getText() + "\nSimplified Expression:    " + ans[Solve.NUM_VARIABLES-2].getText(), "Boolean Expression Minimized!", JOptionPane.INFORMATION_MESSAGE);

    if (Settings.getCopyClipboard()){
        StringSelection selection = new StringSelection(ans[Solve.NUM_VARIABLES-2].getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
        System.out.println("SET!");
    }

  }
  
  /** This method adds an explanation box for how k-maps work. */
  public void addExplanationBox(){ //remove and replace
    JEditorPane text [] = new JEditorPane [3];
    for(int i = 0; i < 3; i++){
      text[i] = new JEditorPane("Hi,","Purpose: Simplify expressions.\n\nSOP: Sum of Products.\n\nPOS: Product of sums.");
      text[i].setBorder(new LineBorder(new Color(0,191,255), 1));
      text[i].setEditable(false);
    }
    
    JLabel[] title = new JLabel [3];
    for(int i =0; i < 3; i++)
      title[i] = new JLabel("How K-maps work:");
    
    for(int i = 0; i < 3; i++){
      text[i].setBounds(720, 35, 235, 330);
      title[i].setBounds(780, 8, 270, 30);
    }
    
    panel1.add(text[0]);
    panel2.add(text[1]);
    panel3.add(text[2]);
    
    panel1.add(title[0]);
    panel2.add(title[1]);
    panel3.add(title[2]);
  }
  
  
  /** This method adds the GUI elements required to show the answer.
    * Verify: Do you need seperate objects for the same thing? */
  public void displayAnswerBox(){
    JButton[] compute = new JButton[3]; 
    JLabel [] label = new JLabel[3];
    ans = new JTextField[3];
    JLabel [] labelGiven = new JLabel[3];
    givenEq = new JTextField[3];
    
    for(int i = 0; i < ans.length; i++){
      ans[i] = new JTextField();
      ans[i].setBounds(580, 465, 250, 30);
      ans[i].setEditable(false);
      label[i] = new JLabel("Simplified Expression:");
      label[i].setBounds(430, 465, 150, 30);
      compute[i] = new JButton("Simplify");
      compute[i].addActionListener(this);
      compute[i].setBounds(850, 465, 140, 30);
      givenEq[i] = new JTextField("False");
      givenEq[i].setBounds(140, 465, 270, 30);
      givenEq[i].setEditable(false);
      labelGiven[i] = new JLabel("Given Expression:");
      labelGiven[i].setBounds(10, 465, 150, 30);
    }
    
    
    panel1.add(label[0]);
    panel1.add(ans[0]);
    panel1.add(labelGiven[0]);
    panel1.add(givenEq[0]);
    panel1.add(compute[0]);
    
    panel2.add(label[1]);
    panel2.add(ans[1]);
    panel2.add(labelGiven[1]);
    panel2.add(givenEq[1]);
    panel2.add(compute[1]);
    
    panel3.add(label[2]);
    panel3.add(ans[2]);
    panel3.add(labelGiven[2]);
    panel3.add(givenEq[2]);
    panel3.add(compute[2]);
  }
  
  /** Class constructor, that sets up the frame and calls appropriate methods to add elements to the JFrame. */
  public Frame(boolean isVisible){
    a = new JFrame("Karnaugh Map Simplification - Horatiu Lazu");
    panel = new JPanel();
    
    JMenuBar bar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu settings = new JMenu("Settings");
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
        new ScreenAbout();
      }
    });

    JCheckBoxMenuItem realtimeUpdate = new JCheckBoxMenuItem ("Update Realtime");
    realtimeUpdate.setSelected(true);
    realtimeUpdate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        Settings.toggleRealtime();
      }
    });

    JCheckBoxMenuItem copyClipboard = new JCheckBoxMenuItem ("Copy to Clipboard");
    copyClipboard.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            Settings.toggleCopyClipboard();
        }
    });

    settings.add(realtimeUpdate);
    settings.add(copyClipboard);
    
    help.add(about);
    bar.add(file);
    bar.add(settings);
    bar.add(help);
    panel.add(bar);
    addTabs();
    addTruthTables();
    displayAnswerBox();
    //addExplanationBox();
    TruthTable.initializeTruthTableValues();
    
    a.add(panel);
    a.setJMenuBar(bar);

    if (isVisible)
      a.setVisible(true);
    a.setSize(1024, 600);
    a.setResizable(false);
    a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}