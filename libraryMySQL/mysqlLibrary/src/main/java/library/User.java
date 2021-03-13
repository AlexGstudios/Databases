package library;

import java.sql.*;

public class User {
      
    private static UserGui gui;

    private static String userName;
    private static String userPass;

    private static int userID;

    public User(String name, String pass, int ID){

        gui = new UserGui(name);

        userName = name;
        userPass = pass;

        userID = ID;

        showBooks(name, pass);
    }

    public static void borrowBook(){

        // method for borrowing books button and closes the current gui

        BorrowBook bb = new BorrowBook(userName, userPass, userID);
        gui.dispose();
    }

    public static void magazines(){

        // method for magazine button and closes the current gui

        Magazines mag = new Magazines(userName, userPass, userID);
        gui.dispose();
    }

    public static void signOut(){

        // method for sign out button and closes the current gui

        SignIn si = new SignIn();
        gui.dispose();
    }

    public static void showBooks(String conName, String conPass){
        
        // gets the borrowed books for the user

        try {
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", conName, conPass);
            PreparedStatement presta = con.prepareStatement("select books.title, books.pages, books.classification from books join onloan on onloan.burrowerID = ? and onloan.bookID = books.ID;");
            presta.setInt(1, userID);
            ResultSet rs = presta.executeQuery();

            String info = "";

            while (rs.next()) {
                
                info = info + "\n" + (rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

            // method to display users book/books

            gui.setTaMyBooks(info);

        } catch (Exception e) {

            System.out.println(e);
        }

    }
}
