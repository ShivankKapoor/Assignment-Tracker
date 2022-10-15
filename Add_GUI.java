import java.util.*;
import javax.swing.*;

public class Add_GUI extends JFrame {

    public Add_GUI() {
        String[] typeOfAssignments = { "Homework", "Quiz", "Test" };
        Integer[] assignmentDifficutly = { 1, 2, 3, 4, 5 };
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 700);
        this.setTitle("Add Class");

        this.setLayout(null);

        JTextField nameTxtField = new JTextField();
        JLabel nameLabel = new JLabel("Assignment Name:");

        JComboBox types = new JComboBox<String>(typeOfAssignments);
        JLabel typesLabel = new JLabel("Assignment Type:");

        JTextField courseNameField = new JTextField();
        JLabel courseNameLabel = new JLabel("Couse Name:");

        JTextField monthField = new JTextField("MM");
        JTextField dayField = new JTextField("DD");
        JTextField yearField = new JTextField("YYYY");
        JLabel dateLabel = new JLabel("Due Date:");

        JComboBox<Integer> asgnmtDiffBox = new JComboBox<>(assignmentDifficutly);
        JLabel difLabel = new JLabel("Assignment Diff");

        JButton addAssignment = new JButton("Add");

        nameTxtField.setBounds(225, 112, 165, 25);
        nameLabel.setBounds(100, 100, 150, 50);

        types.setBounds(225, 162, 150, 30);
        typesLabel.setBounds(100, 150, 150, 50);

        courseNameField.setBounds(225, 212, 165, 25);
        courseNameLabel.setBounds(100, 202, 150, 50);

        monthField.setBounds(225, 252, 50, 25);
        dayField.setBounds(275, 252, 50, 25);
        yearField.setBounds(325, 252, 50, 25);
        dateLabel.setBounds(100, 240, 150, 50);

        asgnmtDiffBox.setBounds(225,292,75,30);
        difLabel.setBounds(100, 280, 150, 50);

        addAssignment.setBounds(200,575,100,50);

        this.add(addAssignment);
        this.add(difLabel);
        this.add(asgnmtDiffBox);
        this.add(yearField);
        this.add(dateLabel);
        this.add(monthField);
        this.add(dayField);
        this.add(nameTxtField);
        this.add(nameLabel);
        this.add(types);
        this.add(typesLabel);
        this.add(courseNameField);
        this.add(courseNameLabel);

        this.setVisible(true);
    }
}
