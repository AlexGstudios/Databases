package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserGui extends JFrame {
    
    private JPanel panel;
    private JButton btnMyBooks;
    private JButton btnAddBook;
    private JButton btnSignOut;
    private JTextArea tfMyBooks;

    public UserGui(String name){

        this.setTitle(name + " My Books");
        this.setSize(1250, 800);
        this.setLocation(500, 250);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setEle();
        setGui();

        this.add(panel);
        this.setVisible(true);
        this.setResizable(false);
    }

    public void setTfMyBooks(String[] books){

        String concat = "";

        for (String str : books) {
            
            concat = concat + str + "\n";
        }
        this.tfMyBooks.setText(concat);
    }

    public void setEle(){

        this.panel = new JPanel(new GridLayout(2, 2));
        this.btnMyBooks = new JButton("My Books");
        this.btnAddBook = new JButton("Borrow a book");
        this.btnSignOut = new JButton("Sign Out");
        this.tfMyBooks = new JTextArea();

        ActionListener alMyBooks = e -> {

            // todo: update users list with setTfMyBooks() from the database "select * from borrowed;"
        };

        this.btnMyBooks.addActionListener(alMyBooks);

        ActionListener alAddBook = e -> {

            // todo: open a new window with a list of all the available books
        };

        this.btnAddBook.addActionListener(alAddBook);

        ActionListener alSignOut = e ->{

            SignIn si = new SignIn();
            dispose();
        };

        this.btnSignOut.addActionListener(alSignOut);
    }

    public void setGui(){

        this.panel.add(btnMyBooks);
        this.panel.add(btnAddBook);
        this.panel.add(tfMyBooks);
        this.panel.add(btnSignOut);
    }
}
