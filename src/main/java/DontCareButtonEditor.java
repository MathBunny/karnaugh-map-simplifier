import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class extends the DontCare UI implementation
 * @author Horatiu Lazu
 * @version 1.0
 */
public class DontCareButtonEditor extends ButtonEditor{
  //private boolean isPushed;

  /**
   * This is the editor for the dont care editor.
   * @param checkBox JCheckBox
   */
  public DontCareButtonEditor(JCheckBox checkBox) {
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

  /**
   * This gets the cell editor value.
   * @return Object This is the value.
   */
  @Override
  public Object getCellEditorValue() { //update this
    if (isPushed) {
      //JOptionPane.showMessageDialog(button, label + ": Ouch!");
      if (label.equals("N"))
        label = "Y";
      else
        label = "N";
    }
    isPushed = false;
    return label;
  }
}