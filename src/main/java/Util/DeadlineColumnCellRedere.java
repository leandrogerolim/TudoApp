
package Util;

import Model.Task;
import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author user
 */
    public class DeadlineColumnCellRedere extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label;
        label = (JLabel) super.getTableCellRendererComponent(
                jtable, value, hasFocus, hasFocus, row, row);
        
        label.setHorizontalAlignment(CENTER);
        TaskTableModel taskModel = (TaskTableModel) jtable.getModel();
        Task task = taskModel.getTasks().get(row);
        
        if(task.getDeadline().after(new Date())) {
            label.setBackground(Color.GREEN);
        } else {
            label.setBackground(Color.RED);
        }
        
        return label;
    }
    }

    
    

