package library;

import java.sql.*;

public class Onloan {
    
    private String[] onloan;

    private static OnloanGui oGui;

    private static String adminName;
    private static String adminPass;

    public Onloan(String name, String pass){

        adminName = name;
        adminPass = pass;

        String[] data = conData(adminName, adminPass);

        oGui = new OnloanGui(data);
    }
    public static String[] conData(String conName, String conPass){

        // gets the data from the database

        String[] bookID;
        String[] bookInfo;
        String toBookID = "";
        String toList = "books: ";

        try {
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", conName, conPass);
            PreparedStatement preSta = con.prepareStatement("select books.title, books.pages, burrowers.name from books, burrowers join onloan where books.ID = onloan.bookID and burrowers.ID = onloan.burrowerID;");
            ResultSet rs = preSta.executeQuery();

            while (rs.next()) {

                // toBookID = toBookID + "," + (rs.getString(1));

                toList = toList + "," + (rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(3));
            }

            bookID = toBookID.split(",");

            bookInfo = toList.split(",");

            for (int i = 0; i < bookID.length; i++) {
                
                if (checkBooks(bookID[i], conName, conPass)) {
                    
                    bookInfo[i] = bookInfo[i] + " - not in stock.";
                }else{

                    // bookInfo[i] = bookInfo[i];
                }
            }
            con.close();
        } catch (Exception e) {
            
            bookInfo = null;
            System.out.println(e);
        }

        return bookInfo;
    }

    public static Boolean checkBooks(String checkBookID, String conName, String conPass){

        // checks if a user has borrowed a book
        // returns true if the book is borrowed

        String[] allBooks;
        String onloanBookID = "x";

        Boolean isTrue = false;

        try {
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", conName, conPass);
            PreparedStatement preSta = con.prepareStatement("select bookID from onloan;");
            ResultSet rsLoan = preSta.executeQuery();

            while (rsLoan.next()) {
                
                onloanBookID = onloanBookID + "," + (rsLoan.getString(1));
            }

            allBooks = onloanBookID.split(",");

            for (int i = 0; i < allBooks.length; i++) {
                
                if (checkBookID.equals(allBooks[i])) {
                    
                    return isTrue = true;
                }else{
                    
                    isTrue = false;
                }
            }

            con.close();
        } catch (Exception e) {
            
            System.out.println(e);
        }


        return isTrue;
    }

    public static void back(){

        // gets back to the previous gui

        Admin us = new Admin(adminName, adminPass);
        oGui.dispose();
    }
}
