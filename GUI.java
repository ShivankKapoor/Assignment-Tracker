import javax.swing.*;

public class GUI extends JFrame {
    public GUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1000, 600);

        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        JButton editButton = new JButton("Edit");

        this.setLayout(null);

        addButton.setBounds(40, 100, 100, 60);
        removeButton.setBounds(40, 200, 100, 60);
        editButton.setBounds(40, 300, 100, 60);

        this.add(addButton);
        this.add(removeButton);
        this.add(editButton);

        this.setVisible(true);
    }


}