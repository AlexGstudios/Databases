package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminGui extends JFrame {

    private JButton btnOnloan;
    private JButton btnEmployees;
    private JButton signOut;

    private String adminName;
    private String adminPass;

    private JPanel panel;
    
    public AdminGui(String name, String pass){

        // sets up the admin gui

        this.adminName = name;
        this.adminPass = pass;

        this.setTitle(adminName + " Admin page");
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

        this.panel = new JPanel(new GridLayout(2, 1));
        this.btnEmployees = new JButton("Edit Employees");
        this.btnOnloan = new JButton("On loan");
        this.signOut = new JButton("Sign Out");

        // button to go to the edit employees gui

        ActionListener alEdit = e -> {

            Admin.employees(adminName, adminPass);
        };

        this.btnEmployees.addActionListener(alEdit);

        // button to go to the onloan gui

        ActionListener alOnloan = e -> {

            Admin.onLoan(adminName, adminPass);
        };

        this.btnOnloan.addActionListener(alOnloan);

        // button to sign out

        ActionListener alSignOut = e -> {

            Admin.signOut();
        };

        this.signOut.addActionListener(alSignOut);
    }

    public void setGui(){

        this.panel.add(btnEmployees);
        this.panel.add(btnOnloan);
        this.panel.add(signOut);
    }
}
