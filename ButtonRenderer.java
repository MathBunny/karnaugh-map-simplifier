import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

/* Credits to: http://www.java2s.com/Code/Java/Swing-Components/ButtonTableExample.htm */

class ButtonRenderer extends JButton implements TableCellRenderer {
  
  public ButtonRenderer() {
    setOpaque(true);
  }
  
  @Override
  public Component getTableCellRendererComponent(JTable table, Object value,
                                                 boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(UIManager.getColor("Button.background"));
    }
    setText((value == null) ? "" : value.toString());
    return this;
  }
}