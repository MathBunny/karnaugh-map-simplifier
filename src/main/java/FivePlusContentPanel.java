import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the content panel for 5+ variables
 * @author Horatiu Lazu
 * @version 1.0
 */

public class FivePlusContentPanel extends JPanel implements ActionListener{
    /** tableWidth int This is the width of the table, so the button and combobox can match its dimensions */
    private int tableWidth = 0;

    /**
     * This method adds the truth table (which is adjustable by variable count)
     * @param variableNumber int This is the number of variables
     */
    private void addTruthTable(int variableNumber){
        removeAll();
        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(generateTruthTable(variableNumber), generateTableColumns(variableNumber));

        JTable table = new JTable(dm);

        table.getColumn(generateTableColumns(variableNumber)[variableNumber].toString()).setCellRenderer(new ButtonRenderer(true));
        table.getColumn(generateTableColumns(variableNumber)[variableNumber].toString()).setCellEditor(new ButtonEditor(new JCheckBox()));

        JLabel truthTableText = new JLabel("Truth Table");
        add(truthTableText);
        truthTableText.setBounds(30 + 12 * variableNumber, 8, 100, 30);


        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(25, 66, 120, 90);
        scroll.setSize(new Dimension(85 + 25 * variableNumber, 400));
        tableWidth = 85 + 25 * variableNumber;

        for(int i = 0; i < variableNumber; i++)
            table.getColumnModel().getColumn(i).setPreferredWidth(variableNumber);

        table.getColumnModel().getColumn(variableNumber).setPreferredWidth(45 + 5 * variableNumber);
        add(scroll);
        addVariableSelection(variableNumber);
    }

    /**
     * This method generates the combobox for the variable selection.
     * @param variableNumber int This is the number of variables to be selected by default
     */
    private void addVariableSelection(int variableNumber){
        String[] variables = new String[14];
        for(int x = 2; x <= 15; x++){
            variables[x-2] = x + " variables";
        }

        final DefaultComboBoxModel variableSelection = new DefaultComboBoxModel();
        for (String v : variables)
            variableSelection.addElement(v);

        final JComboBox variableCombo = new JComboBox(variableSelection);
        variableCombo.setSelectedIndex(variableNumber-2);

        variableCombo.setBounds(25, 36, 400, 90);
        variableCombo.setSize(new Dimension(tableWidth, (int) variableCombo.getPreferredSize().getHeight()));

        variableCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTruthTable(variableCombo.getSelectedIndex()+2);
            }
        });

        add(variableCombo);
        addSimplifyButton();
        repaint();
        revalidate();
    }

    /**
     * This method adds the simplify button
     */
    private void addSimplifyButton(){
        JButton simplify = new JButton("Simplify");
        simplify.setBounds(25, 466, 400, 90);
        simplify.setSize(new Dimension(tableWidth, (int) simplify.getPreferredSize().getHeight()));
        simplify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //simplify
            }
        });
        add(simplify);
    }


    /** Generates the column table headings, for the truth-table
     * @param variables int This is the number of variables
     * @return Object [] Array with the titles
     */
    private Object [] generateTableColumns (int variables){
        char s = 'A';
        Object [] arr = new Object[variables+1];
        for(int x = 0; x < variables; x++){
            arr[x] = ((char)(s + x)) + "";
        }
        StringBuilder finalFunction = new StringBuilder("F (");
        for(int x = 0; x < variables; x++){
            finalFunction.append(((char)('A' + x)) + "");
        }
        arr[arr.length-1] = finalFunction.toString().trim() + ")";
        return arr;
    }

    /** Generate truth table using bitmasking
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

    /**
     * This is the class constructor, that sets up the size and adds the default truth-table with 5 variables.
     */
    public FivePlusContentPanel(){
        super();
        setLayout(null);
        setPreferredSize(new Dimension(1000, 500));
        addTruthTable(5);
    }

    /**
     * This paints the components.
     * @param g Graphics This it the graphics object.
     */
    protected void paintComponent(Graphics g) {}

    /**
     * This is the action performed method, in case of any actions from clicks, etc.
     * @param e ActionEvent This is the reference to ActionEvent.
     */
    public void actionPerformed(ActionEvent e){}

}