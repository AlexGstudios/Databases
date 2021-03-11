package library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

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

    public void getBookID(){

        listSelect = avMagazines.getSelectedValue().toString();

        String[] splitList = listSelect.split(" ");

        try {
            
            bookID = Integer.parseInt(splitList[0]);
        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public void updJList(DefaultListModel<String> model, int bookID, String listSelect){
        // change bookid to magid---------x-x-x-x-x-x

        model.set(bookID, listSelect);
    }

    public void setEle(){

        DefaultListModel<String> model = new DefaultListModel<>();

        for (String str : data) {
            
            model.addElement(str);
        }

        this.panel = new JPanel(new GridLayout(2, 1));
        this.avMagazines = new JList<String>(model);
        this.back = new JButton("Back");
        this.search = new JTextField();
        this.btnSearch = new JButton("Search");

        ActionListener alBack = e -> {

            Magazines.back();
        };

        this.back.addActionListener(alBack);

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
