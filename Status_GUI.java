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

        JTextField IDInput = new JTextField();
        JLabel IDLabel = new JLabel("ID: ");

        JButton IDSubmit = new JButton("Submit");

        this.setVisible(true);
    }
    
}
