package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BorrowGui extends JFrame {
    
    private JPanel panel;

    private JList<String> avBooks;

    private JLabel label;

    private int userID;
    private int bookID;

    private String listSelect;

    private JButton btnAdd;
    private JButton back;
    private JButton btnSearch;

    private JTextField search;

    private String[] data;

    public BorrowGui(String name, int ID, String[] ls){

        // sets up gui for borrowing books

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

        // gets the ID from the string data in the list
        // that is selected in the current gui

        listSelect = avBooks.getSelectedValue().toString();

        String[] splitList = listSelect.split(" ");

        try {
            
            bookID = Integer.parseInt(splitList[0]);
        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public void updJList(DefaultListModel<String> model, int bookID, String listSelect){

        // updates the list selected

        model.set(bookID, listSelect);
    }

    public void setEle(){

        DefaultListModel<String> model = new DefaultListModel<>();
        
        // adds the data to the list

        for (String str : data) {
            
            model.addElement(str);
        }

        this.panel = new JPanel(new GridLayout(3, 1));
        this.label = new JLabel("Available books: ");
        this.avBooks = new JList<String>(model);
        this.btnAdd = new JButton("Borrow book");
        this.back = new JButton("Back");
        this.search = new JTextField();
        this.btnSearch = new JButton("Search");

        // button to add selected book

        ActionListener alAddBook = e -> {

            getBookID();
            BorrowBook.addBook(userID, bookID, listSelect, model);
        };

        this.btnAdd.addActionListener(alAddBook);

        // button to go back to the previous page

        ActionListener alBack = e -> {

            BorrowBook.back();
        };

        this.back.addActionListener(alBack);

        // button to search for the user input

        ActionListener alSearch = e -> {

            String input = this.search.getText();
            BorrowBook.search(input, model, data);
        };

        this.btnSearch.addActionListener(alSearch);

        this.avBooks.setLayoutOrientation(JList.VERTICAL);
        this.avBooks.setVisibleRowCount(-1);
    }

    public void setGui(){

        this.panel.add(label);
        this.panel.add(new JScrollPane(avBooks));
        this.panel.add(search);
        this.panel.add(btnSearch);
        this.panel.add(btnAdd);
        this.panel.add(back);
    }
}
