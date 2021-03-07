package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Gui extends JFrame{
        
    private JPanel panel;
    private JLabel labelName;
    private JLabel labelPass;
    private JTextArea textName;
    private JTextArea textPass;
    private JButton button;
    private String name;
    private String pass;

    public Gui(){

        this.name = "-1";
        this.pass = "-1";

        this.setTitle("Sql - Gui");
        this.setSize(1250, 800);
        this.setLocation(500, 250);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        setEle();
        setGui();
        
        this.add(panel);
        this.setVisible(true);
        this.setResizable(false);
    }

    public String getUserName(){

        if (this.name.equals("-1")){ 
            return "-1";
        }

        String toName = name;
        name = "-1";
        return toName;
    }

    public String getUserPass(){

        if (this.pass.equals("-1")) {
            return "-1";
        }

        String toPass = this.pass;
        this.pass = "-1";
        return toPass;
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
        this.textName = new JTextArea();
        this.labelPass = new JLabel("Password: ");
        this.textPass = new JTextArea();
        this.button = new JButton("Submit");

        ActionListener al = e -> {

            this.name = textName.getText();
            this.pass = textPass.getText();
            // todo: close this window
        };

        this.button.addActionListener(al);
    }
}
