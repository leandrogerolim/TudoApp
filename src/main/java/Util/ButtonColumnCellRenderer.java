
package Util;
import Model.Task;
import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author user
 */
public class ButtonColumnCellRenderer extends DefaultTableCellRenderer {
    
    private String buttonType;
    
    public ButtonColumnCellRenderer (String buttonType){
        this.buttonType = buttonType;
    }

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }
    
        @Override
    public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent( table, value, isSelected, hasFocus, row, column);
        
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/" + buttonType + ".png")));
        
        return label;
    }

   
    }
    
