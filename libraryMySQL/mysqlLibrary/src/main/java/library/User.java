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

        BorrowBook bb = new BorrowBook(userName, userPass, userID);
        gui.dispose();
    }

    public static void magazines(){

        Magazines mag = new Magazines(userName, userPass, userID);
        gui.dispose();
    }

    public static void signOut(){

        SignIn si = new SignIn();
        gui.dispose();
    }

    public static void showBooks(String conName, String conPass){
        
        try {
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", conName, conPass);
            PreparedStatement presta = con.prepareStatement("select books.title, books.pages, books.classification from books join onloan on onloan.burrowerID = ? and onloan.bookID = books.ID;");
            presta.setInt(1, userID);
            ResultSet rs = presta.executeQuery();

            String info = "";

            while (rs.next()) {
                
                info = info + "\n" + (rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }

            gui.setTaMyBooks(info);

        } catch (Exception e) {

            System.out.println(e);
        }

    }
}
