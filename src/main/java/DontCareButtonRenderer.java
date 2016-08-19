import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

/**
 * This class deals with the don't care button renderer, making a custom JButton UI component
 * @author Horatiu Lazu
 * @version 1.0
 */

class DontCareButtonRenderer extends JButton implements TableCellRenderer {
  
  public DontCareButtonRenderer() {
    setOpaque(true);
  }
  
  @Override
  public Component getTableCellRendererComponent(JTable table, Object value,
                                                 boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      //setForeground(table.getSelectionForeground());
      setForeground(Color.blue);
      setBackground(table.getSelectionBackground());
      if (DontCare.ignoreFlag == true){ //can get rid of this.
        DontCare.ignoreFlag = false;
      }else{
        System.out.println("ROW: " + row + " | COL: " + column + "VAL: " + value);
        if (column == 2){
          DontCare.twoVariableDontCare[row] = Integer.valueOf((String) value); //use SET/GET methods!
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