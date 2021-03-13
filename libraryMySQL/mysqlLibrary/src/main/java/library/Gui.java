package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Gui extends JFrame{
        
    private JPanel panel;

    private JLabel labelName;
    private JLabel labelPass;

    private JTextField textName;
    private JTextField textPass;

    private JButton button;

    private String name;
    private String pass;

    public Gui(){

        // Logg in screen

        this.setTitle("Sql - Gui");
        this.setSize(800, 500);
        this.setLocation(650, 250);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        setEle();
        setGui();
        
        this.add(panel);

        this.setVisible(true);
        this.setResizable(false);
    }

    public void isDispose(){

        dispose();
    }

    public void setGui(){

        this.panel.add(labelName);
        this.panel.add(textName);
        this.panel.add(labelPass);
        this.panel.add(textPass);
        this.panel.add(button);

    }

    public void setEle(){

        this.panel = new JPanel(new GridLayout(3,3));
        this.labelName = new JLabel("Name: ");
        this.textName = new JTextField();
        this.labelPass = new JLabel("Password: ");
        this.textPass = new JTextField();
        this.button = new JButton("Submit");

        ActionListener al = e -> {

            // Takes the imputs from the In logg screen
            // starts the auth check

            this.name = textName.getText();
            this.pass = textPass.getText();
            // todo: close this window
            SignIn.getInput(this.name, this.pass);
        };

        this.button.addActionListener(al);
    }
}
