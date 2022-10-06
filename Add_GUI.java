import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Add_GUI extends JFrame{

    public Add_GUI() {
        String[] typeOfAssignments = {"Homework", "Quiz", "Test"};
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 700);
        this.setTitle("Add Class");

        this.setLayout(null);

        JTextField nameTxtField = new JTextField();
        JLabel nameLabel = new JLabel("Assignment Name:");
        JComboBox types = new JComboBox<String>(typeOfAssignments);


        nameTxtField.setBounds(225, 112, 165, 25);
        nameLabel.setBounds(100, 100, 150, 50);
        types.setBounds(225, 212, 150, 30);

        this.add(nameTxtField);
        this.add(nameLabel);
        this.add(types);
        
        this.setVisible(true);
    }
}
