import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

/**
 * This is the button renderer.
 * @author Horatiu Lazu
 * @version 1.0
 */
class ButtonRenderer extends JButton implements TableCellRenderer {
  boolean isFiveVariablePlus = false;

  /** This is the class constructor */
  public ButtonRenderer() {
    setOpaque(true);
  }

  /** This is the class constructor */
  public ButtonRenderer(boolean isFiveVariablePlus) {
    this.isFiveVariablePlus = isFiveVariablePlus;
  }

  /**
   * This is the get table cell renderer component
   * @param table JTable This is the table
   * @param value Object This is the value of the table
   * @param isSelected boolean This indicates if is selected
   * @param hasFocus boolean This indicates if it has been focused
   * @param row int This is the row
   * @param column int This is the column
   * @return Component
   */

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      //setForeground(table.getSelectionForeground());
      setForeground(Color.blue);
      setBackground(table.getSelectionBackground());
      if (TruthTable.ignoreFlag == true){ //can get rid of this.
        TruthTable.ignoreFlag = false;
      }else{
        /* two variable */
        if (column == 2){
          TruthTable.twoVariableTruth[row] = Integer.valueOf((String) value);
        }
        else if (column == 3){
          TruthTable.threeVariableTruth[row] = Integer.valueOf((String) value);
        }
        else if (column == 4){
          TruthTable.fourVariableTruth[row] = Integer.valueOf((String) value);
        }
        else{
        }
        TruthTable.updateGivenSOP(column, isFiveVariablePlus); //update the SOP.
      }
    } 
    else {
      setForeground(table.getForeground());
      setBackground(UIManager.getColor("Button.background"));
    }
    setText((value == null) ? "" : value.toString());
    return this;
  }
}