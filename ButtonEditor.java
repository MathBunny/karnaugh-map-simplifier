import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* Credits to: http://www.java2s.com/Code/Java/Swing-Components/ButtonTableExample.htm */
class ButtonEditor extends DefaultCellEditor {
  
  protected JButton button;
  private String label;
  private boolean isPushed;
  
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
  
  @Override
  public Component getTableCellEditorComponent(JTable table, Object value,
                                               boolean isSelected, int row, int column) {
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
  
  @Override
  public Object getCellEditorValue() {
    if (isPushed) {
      //JOptionPane.showMessageDialog(button, label + ": Ouch!");
      if (label.equals("0"))
        label = "1";
      else
        label = "0";
      
      
    }
    
    isPushed = false;
    return label;
  }
  
  @Override
  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }
  
  @Override
  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}