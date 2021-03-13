package library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MagazinesGui extends JFrame {
    
    private JPanel panel;

    private JList<String> avMagazines;

    private JLabel label;

    private int userID;
    private int bookID;

    private String listSelect;

    private JButton btnAdd;
    private JButton back;
    private JButton btnSearch;

    private JTextField search;

    private String[] data;

    public MagazinesGui(String name, int ID, String[] ls){

        // sets up the magazine gui

        this.data = ls;
        this.userID = ID;

        this.setTitle(name + " My Books");
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

        DefaultListModel<String> model = new DefaultListModel<>();

        // adds the data to the JList

        for (String str : data) {
            
            model.addElement(str);
        }

        this.panel = new JPanel(new GridLayout(2, 1));
        this.avMagazines = new JList<String>(model);
        this.back = new JButton("Back");
        this.search = new JTextField();
        this.btnSearch = new JButton("Search");

        // button to go back to previous gui

        ActionListener alBack = e -> {

            Magazines.back();
        };

        this.back.addActionListener(alBack);

        // button for search

        ActionListener alSearch = e -> {

            String input = this.search.getText();
            BorrowBook.search(input, model, data);
        };

        this.btnSearch.addActionListener(alSearch);

        this.avMagazines.setLayoutOrientation(JList.VERTICAL);
        this.avMagazines.setVisibleRowCount(-1);
    }

    public void setGui(){

        this.panel.add(search);
        this.panel.add(btnSearch);
        this.panel.add(new JScrollPane(avMagazines));
        this.panel.add(back);
    }
}
