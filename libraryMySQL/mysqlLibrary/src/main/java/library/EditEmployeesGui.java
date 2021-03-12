package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class EditEmployeesGui extends JFrame{
    
    private JPanel panel;

    private JList<String> list;
    
    private String adminName;
    private String adminPass;
    private String listSelect;

    private String[] data;

    private JTextArea name;
    private JTextArea address;
    private JTextArea salary;
    private JTextArea daysOff;
    private JTextArea phone;
    private JTextArea phone2;
    private JTextArea phone3;

    private JButton btnUpdate;
    private JButton btnBack;
    
    public EditEmployeesGui(String name, String pass, String[] ls){

        this.adminName = name;
        this.adminPass = pass;

        this.data = ls;

        this.setTitle(adminName + " Update Employees");
        this.setSize(800, 500);
        this.setLocation(650, 250);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setEle();
        setGui();

        this.add(panel);

        this.setVisible(true);
        this.setResizable(false);
    }

    public void updJList(DefaultListModel<String> model, int index, String element){

        model.set(index, element);
    }

    public void setEle(){

        DefaultListModel<String> model = new DefaultListModel<String>();

        for (String str : data) {
            
            model.addElement(str);
        }

        this.panel = new JPanel(new GridLayout(10, 1));
        this.list = new JList<String>(model);
        this.name = new JTextArea("Name");
        this.address = new JTextArea("Address");
        this.salary = new JTextArea("Salary");
        this.daysOff = new JTextArea("Days Off");
        this.phone = new JTextArea("Phone nr 1");
        this.phone2 = new JTextArea("Phone nr 2");
        this.phone3 = new JTextArea("Phone nr 3");
        this.btnUpdate = new JButton("Update");
        this.btnBack = new JButton("Back");

        MouseListener mlClick = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me){

                name.setText(EditEmployees.setGuiName(list.getSelectedIndex()));
                address.setText(EditEmployees.setGuiAddress(list.getSelectedIndex()));
                salary.setText(EditEmployees.setGuiSalary(list.getSelectedIndex()));
                daysOff.setText(EditEmployees.setGuiDaysOff(list.getSelectedIndex()));
                phone.setText(EditEmployees.setGuiPhone(list.getSelectedIndex()));
                phone2.setText(EditEmployees.setGuiPhone2(list.getSelectedIndex()));
                phone3.setText(EditEmployees.setGuiPhone3(list.getSelectedIndex()));
            }
        };

        this.list.addMouseListener(mlClick);

        ActionListener alUpdate = e -> {

            EditEmployees.updateEmployee(list.getSelectedIndex(), name.getText(), address.getText(), salary.getText(), daysOff.getText(), phone.getText(), phone2.getText(), phone3.getText(), model);
        };

        this.btnUpdate.addActionListener(alUpdate);

        ActionListener alBack = e -> {

            EditEmployees.back();
        };

        this.btnBack.addActionListener(alBack);
    }

    public void setGui(){

        this.panel.add(new JScrollPane(list));
        this.panel.add(name);
        this.panel.add(address);
        this.panel.add(salary);
        this.panel.add(daysOff);
        this.panel.add(phone);
        this.panel.add(phone2);
        this.panel.add(phone3);
        this.panel.add(btnUpdate);
        this.panel.add(btnBack);
    }
}
