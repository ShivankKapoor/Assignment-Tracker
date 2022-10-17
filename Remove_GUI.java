import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

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

        IDSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String rawID = IDInput.getText();
                if(checkIfInt(rawID)){
                    int ID = Integer.parseInt(rawID);
                    Tracker.removeAssignment(ID);
                }

                try {
                    Tracker.saveAndQuit();
                } catch (IOException e1) {
                    
                    e1.printStackTrace();
                }
                Tracker.refresh();
                setVisible(false);
                dispose(); 
                
            }
        });
    }
    private boolean checkIfInt(String what) {
        if (what == null) {
            return false;
        }
        int length = what.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (what.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = what.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
    
}
