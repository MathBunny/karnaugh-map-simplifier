import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.*;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the content panel for 5+ variables
 * @author Horatiu Lazu
 * @version 1.0
 */

public class FivePlusContentPanel extends JPanel implements ActionListener{
    private int tableWidth = 0;
    public FivePlusContentPanel(){
        super();
        final int VARIABLE_NUMBER = 5;
        /* Adding two variable truth-table */
        setLayout(null);
        setPreferredSize(new Dimension(1000, 500));

        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(generateTruthTable(VARIABLE_NUMBER), generateTableColumns(VARIABLE_NUMBER));

        JTable table = new JTable(dm);

        table.getColumn(generateTableColumns(VARIABLE_NUMBER)[VARIABLE_NUMBER].toString()).setCellRenderer(new ButtonRenderer());
        table.getColumn(generateTableColumns(VARIABLE_NUMBER)[VARIABLE_NUMBER].toString()).setCellEditor(new ButtonEditor(new JCheckBox()));

        JLabel truthTableText = new JLabel("Truth Table");
        add(truthTableText);
        truthTableText.setBounds(40, 8, 100, 30); //adjust this dynamically ???


        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(25, 66, 120, 90);
        scroll.setSize(new Dimension(175, 400));
        tableWidth = 175;

        for(int i = 0; i < VARIABLE_NUMBER; i++)
            table.getColumnModel().getColumn(i).setPreferredWidth(VARIABLE_NUMBER);
        table.getColumnModel().getColumn(VARIABLE_NUMBER).setPreferredWidth(75);
        add(scroll);


        getVariableSelection();
    }

    private void getVariableSelection(){
        String[] variables = new String[24];
        for(int x = 2; x <= 25; x++){
            variables[x-2] = x + " variables";
        }

        final DefaultComboBoxModel variableSelection = new DefaultComboBoxModel();
        for (String v : variables){
            variableSelection.addElement(v);
        }

        final JComboBox variableCombo = new JComboBox(variableSelection);
        variableCombo.setSelectedIndex(4);

        variableCombo.setBounds(25, 36, 400, 90);
        variableCombo.setSize(new Dimension(tableWidth, (int)variableCombo.getPreferredSize().getHeight()));

        JButton showButton = new JButton("Show");

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //variableCombo.getSelectedIndex()
            }
        });

        add(variableCombo);
        add(showButton);
    }

    private Object [] generateTableColumns (int variables){
        char s = 'A';
        Object [] arr = new Object[variables+1];
        for(int x = 0; x < variables; x++){
            arr[x] = ((char)(s + x)) + "";
        }
        StringBuilder finalFunction = new StringBuilder("F (");
        for(int x = 0; x < variables-1; x++){
            finalFunction.append(((char)('A' + x)) + " ");
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
     * This paints the components.
     * @param g Graphics This it the graphics object.
     */
    protected void paintComponent(Graphics g) {

    }

    public void actionPerformed(ActionEvent e){

    }

}