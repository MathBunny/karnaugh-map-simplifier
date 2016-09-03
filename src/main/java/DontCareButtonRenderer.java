import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

/**
 * This class deals with the don't care button renderer, making a custom JButton UI component
 * @author Horatiu Lazu
 * @version 1.0
 */

class DontCareButtonRenderer extends JButton implements TableCellRenderer {
  /**
   * This renders the Don't care buttons
   */
  public DontCareButtonRenderer() {
    setOpaque(true);
  }

  /**
   * This gets the table cell renderer.
   * @param table JTable This is the table.
   * @param value Object This is the value in the table.
   * @param isSelected boolean This indicates if you selected it before.
   * @param hasFocus boolean This indicates if the row has a focus.
   * @param row int This is the row.
   * @param column int This is the colum
   * @return Component
   */
  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      //setForeground(table.getSelectionForeground());
      setForeground(Color.blue);
      setBackground(table.getSelectionBackground());
      if (DontCare.ignoreFlag == true){ //can get rid of this.
        DontCare.ignoreFlag = false;
      }else{
        if (column == 2){
          DontCare.twoVariableDontCare[row] = Integer.valueOf((String) value);
        }
        else if (column == 3){
          DontCare.threeVariableDontCare[row] = Integer.valueOf((String) value);
        }
        else{
          DontCare.fourVariableDontCare[row] = Integer.valueOf((String) value);
        }
      }
    } 
    else {
      setForeground(table.getForeground());
      setBackground(UIManager.getColor("Button.background"));
    }
    setText((value == null) ? "N" : "Y");
    return this;
  }
}