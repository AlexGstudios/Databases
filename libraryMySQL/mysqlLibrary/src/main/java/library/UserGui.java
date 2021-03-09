package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserGui extends JFrame {
    
    private JPanel panel;

    private JButton btnMyBooks;
    private JButton btnAddBook;
    private JButton btnSignOut;
    
    private JTextArea taMyBooks;

    private static String userName;

    public UserGui(String name){

        this.setTitle(name + " My Books");
        this.setSize(800, 500);
        this.setLocation(650, 250);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setEle();
        setGui();

        this.add(panel);

        this.setVisible(true);
        this.setResizable(false);

        userName = name;
    }

    public void setTaMyBooks(String books){

        this.taMyBooks.setText(books);
    }

    public void setEle(){

        this.panel = new JPanel(new GridLayout(2, 2));
        this.btnMyBooks = new JButton("My Books");
        this.btnAddBook = new JButton("Borrow a book");
        this.btnSignOut = new JButton("Sign Out");
        this.taMyBooks = new JTextArea();

        ActionListener alMyBooks = e -> {

            // todo: update users list with setTfMyBooks() from the database "select * from borrowed;" maybe not needed
        };

        this.btnMyBooks.addActionListener(alMyBooks);

        ActionListener alAddBook = e -> {

            User.borrowBook();
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
        this.panel.add(taMyBooks);
        this.panel.add(btnSignOut);
    }
}
