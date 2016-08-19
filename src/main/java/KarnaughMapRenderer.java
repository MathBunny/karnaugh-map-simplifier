import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

/** This class is used to render the Karnaugh Map.
 * @author Horatiu Lazu
 * @version 1.0
 */

public class KarnaughMapRenderer extends JButton implements TableCellRenderer {

  /** This is the class constructor */
  public KarnaughMapRenderer() {
    setOpaque(true);
  }

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      //setForeground(table.getSelectionForeground());
      setForeground(Color.blue);
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(UIManager.getColor("Button.background"));
    }
    setText((value == null) ? "" : value.toString());
    return this;
  }
}