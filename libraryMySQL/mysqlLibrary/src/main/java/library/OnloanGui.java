package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OnloanGui extends JFrame{

    private String[] data;

    private JPanel panel;
    private JList<String> list;
    private JButton back;
    
    public OnloanGui(String[] ls){

        // sets the onloan gui

        this.data = ls;

        this.setTitle("On Loan");
        this.setSize(800, 500);
        this.setLocation(650, 250);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setEle();
        setGui();

        this.add(panel);

        this.setVisible(true);
        this.setResizable(false);
    }

    public void setEle(){

        DefaultListModel<String> model = new DefaultListModel<String>();

        // sets the list with data

        for (String str : data) {
            
            model.addElement(str);
        }

        this.panel = new JPanel(new GridLayout(2, 2));
        this.list = new JList<String>(model);
        this.back = new JButton("Back");

        // button to go back to privious gui

        ActionListener alBack = e -> {

            Onloan.back();
        };

        this.back.addActionListener(alBack);
    }

    public void setGui(){

        this.panel.add(new JScrollPane(list));
        this.panel.add(back);
    }
}
