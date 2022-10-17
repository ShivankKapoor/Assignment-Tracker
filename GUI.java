import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUI extends JFrame {
    public static JTable assignments;
    private static String[] Columns ={"I.D #", "NAME", "COURSE", "TYPE","DUE DATE", "STATUS","DIFFICULTY"};
    public GUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000, 600);
        this.setTitle("Assignment Tracker");   
        this.setLayout(null);

        
        
        assignments = new JTable(Tracker.toStringArray(),Columns);
        assignments.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        assignments.setBounds(160,20,800,500);
        assignments.getColumnModel().getColumn(0).setPreferredWidth(20);
        assignments.getColumnModel().getColumn(6).setPreferredWidth(20);
        assignments.setFocusable(false);
        assignments.setRowSelectionAllowed(true);

        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        JButton statusButton = new JButton("Toggle Status");
        

        assignments.setLayout(null);

        addButton.setBounds(20, 100, 100, 60);
        removeButton.setBounds(20, 200, 100, 60);
        statusButton.setBounds(20, 300, 100, 60);
       
        
        
        JScrollPane assignmentsHold = new JScrollPane(assignments);
        assignments.setLayout(null);
        assignmentsHold.setBounds(160,20,800,500);


        this.add(assignmentsHold);
        this.add(addButton);
        this.add(removeButton);
        this.add(statusButton);

        this.setVisible(true);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Add_GUI addFrame = new Add_GUI();
            }
        });

        statusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Status_GUI statusFrame = new Status_GUI();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Remove_GUI removeFrame = new Remove_GUI();
            }
        });

    }

    public void refresh(){
        setVisible(false);
    }

}
