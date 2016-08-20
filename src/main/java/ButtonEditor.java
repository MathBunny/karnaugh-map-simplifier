import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class permits the UI to have clickable buttons in truthtables to toggle bits.
 * @author Horatiu Lazu
 * @version 1.0
 */

class ButtonEditor extends DefaultCellEditor {
  /** button JButton This is the button used in the cell */
  protected JButton button;
  /** label String This is the string in the button text */
  String label;
  /** isPushed boolean This indicates if the button was pushed or not */
  boolean isPushed;

  /** This is the class constructor.
   * @param checkBox JCheckBox
   */
  public ButtonEditor(JCheckBox checkBox) {
    super(checkBox);
    button = new JButton();
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }

  /** This method gets the table cell editor component.
   * @param table JTable This is the table being modified
   * @param value Object This is the value being set
   * @param isSelected boolean Indicates if it is selected
   * @param row int This is the row
   * @param column int This is the column
   * @return
   */
  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else {
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    label = (value == null) ? "" : value.toString();
    button.setText(label);
    isPushed = true;
    return button;
  }

  /**
   * This method returns the cell value.
   * @return Object This is the cell value (1 or 0)
   */
  public Object getCellEditorValue() {
    if (isPushed) {
      if (label.equals("0"))
        label = "1";
      else
        label = "0";
    }
    isPushed = false;
    return label;
  }

  /**
   * This method stops the cell rendering.
   * @return boolean
   */
  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  /**
   * This method simply calls its superclass's method.
   */
  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}