import javax.swing.*;

public class Remove_GUI extends JFrame{
    public Remove_GUI(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 250);
        this.setTitle("Remove Class");
        this.setLayout(null);

        JTextField IDInput = new JTextField();
        JLabel IDLabel = new JLabel("ID:");

        JButton IDSubmit = new JButton("Submit");

        IDInput.setBounds(240,80,100,40);
        IDLabel.setBounds(180,70,40,60);
        IDSubmit.setBounds(200, 160, 100, 40);

        this.add(IDInput);
        this.add(IDLabel);
        this.add(IDSubmit);
        this.setVisible(true);
    }
    
}
