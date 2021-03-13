package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;

public class BorrowBook {
    
    private static BorrowGui bGui;

    private static String userName;
    private static String userPass;

    private static int userID;

    public BorrowBook(String name, String pass, int ID){

        userName = name;
        userPass = pass;
        userID = ID;

        String[] data = conData(userName, userPass);

        bGui = new BorrowGui(name, ID, data);
    }

    public static String[] conData(String conName, String conPass){

        // gets the data from the database

        String[] bookID;
        String[] bookInfo;
        String toBookID = "";
        String toList = "books: ";

        try {
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", conName, conPass);
            PreparedStatement preSta = con.prepareStatement("select * from books;");
            ResultSet rs = preSta.executeQuery();

            while (rs.next()) {

                toBookID = toBookID + "," + (rs.getString(1));

                toList = toList + "," + (rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4));
            }

            bookID = toBookID.split(",");

            bookInfo = toList.split(",");

            for (int i = 0; i < bookID.length; i++) {
                
                if (checkBooks(bookID[i], conName, conPass)) {
                    
                    bookInfo[i] = bookInfo[i] + " - not in stock.";
                }else{

                    bookInfo[i] = bookInfo[i];
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

        // checks if books are borrowed or not
        // true if the book is borrowed by a user and false if it can be borrowed

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

    public static void search(String input, DefaultListModel<String> model, String[] data){

        // goes through the list data to match users search input

        model.clear();

        Pattern p = Pattern.compile("(?i)" + input);

        int count = 1;

        while (count != data.length) {
            
            Matcher m = p.matcher(data[count]);

            while (m.find()) {
                
                if (m.group().length() != 0) {
                    
                    model.addElement(data[count]);
                }
            }
            count++;
        }
        if (input.equals("")) {
            
            for (String str : data) {
                
                model.addElement(str);
            }
        }
    }

    public static void addBook(int userID, int bookID, String listSelect, DefaultListModel<String> model){

        // adds the selected book to the user

        try {
            
            String ID = String.valueOf(bookID);

            if (checkBooks(ID, userName, userPass)) {
                
                listSelect = listSelect + " - Does not exits";
                bGui.updJList(model, bookID, listSelect);
            }else{

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", userName, userPass);
                PreparedStatement preSta = con.prepareStatement("insert into onloan(burrowerID, bookID) values (?, ?);");
                preSta.setInt(1, userID);
                preSta.setInt(2, bookID);
                preSta.executeUpdate();

                listSelect = listSelect + " - Not in stock";
                bGui.updJList(model, bookID, listSelect);
            }
        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public static void back(){

        // exits current gui and goes back to previous gui

        User us = new User(userName, userPass, userID);
        bGui.dispose();
    }
}
