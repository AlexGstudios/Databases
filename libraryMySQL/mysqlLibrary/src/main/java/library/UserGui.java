package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserGui extends JFrame {
    
    private JPanel panel;

    private JButton btnMagazines;
    private JButton btnAddBook;
    private JButton btnSignOut;
    
    private JTextArea taMyBooks;

    private static String userName;

    public UserGui(String name){

        // sets up gui for user, displays loaned books
        // button to see magazines and a button 
        // to borrow new books

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

        // displays current borrowed books

        this.taMyBooks.setText(books);
    }

    public void setEle(){

        this.panel = new JPanel(new GridLayout(2, 2));
        this.btnMagazines = new JButton("Magazines");
        this.btnAddBook = new JButton("Borrow a book");
        this.btnSignOut = new JButton("Sign Out");
        this.taMyBooks = new JTextArea();

        // button for magazines

        ActionListener alMagazines = e -> {

            User.magazines();
        };

        this.btnMagazines.addActionListener(alMagazines);

        // button to borrow books

        ActionListener alAddBook = e -> {

            User.borrowBook();
        };

        this.btnAddBook.addActionListener(alAddBook);

        // button to sign out

        ActionListener alSignOut = e ->{

            User.signOut();

            // SignIn si = new SignIn();
            // dispose();
        };

        this.btnSignOut.addActionListener(alSignOut);
    }

    public void setGui(){

        this.panel.add(btnMagazines);
        this.panel.add(btnAddBook);
        this.panel.add(taMyBooks);
        this.panel.add(btnSignOut);
    }
}
