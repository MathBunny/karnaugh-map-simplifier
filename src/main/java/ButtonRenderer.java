import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

class ButtonRenderer extends JButton implements TableCellRenderer {
  
  public ButtonRenderer() {
    setOpaque(true);
  }
  

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      //setForeground(table.getSelectionForeground());
      setForeground(Color.blue);
      setBackground(table.getSelectionBackground());
      if (TruthTable.ignoreFlag == true){ //can get rid of this.
        TruthTable.ignoreFlag = false;
      }else{
        System.out.println("ROW: " + row + " | COL: " + column + "VAL: " + value);
        /* two variable */
        if (column == 2){
          TruthTable.twoVariableTruth[row] = Integer.valueOf((String) value);
        }
        else if (column == 3){
          TruthTable.threeVariableTruth[row] = Integer.valueOf((String) value);
        }
        else{
          TruthTable.fourVariableTruth[row] = Integer.valueOf((String) value);
        }
        TruthTable.updateGivenSOP(column); //update the SOP.
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