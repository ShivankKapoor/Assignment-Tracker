import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Status_GUI extends JFrame  {

    public Status_GUI(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500, 250);
        this.setTitle("Toggle Status");
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
