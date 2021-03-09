package library;

import java.sql.*;

public class SignIn {

    private static Gui gui;

    private static int userID;

    private static String name;
    private static String pass;

    private static String[] check;

    private static Connection con;

    public SignIn(){

        gui = new Gui();
    }

    public static void getInput(String name, String pass){

        if (name.equals("quit")) {
            
            System.exit(0);
        }else{

            connection(name, pass);
        }
    }

    private static void connection(String conName, String conPass){

        try {
            
            con = DriverManager.getConnection("jdbc:mysql://localhost/library", conName, conPass);
            PreparedStatement preSta = con.prepareStatement("select * from burrowers;");
            ResultSet rs = preSta.executeQuery();

            String users = "";

            while (rs.next()) { 

                users = users + "," + (rs.getString(2));
            }

            check = users.split(",");

            if(ifUser(check, conName)){

                System.out.println("User");
                gui.isDispose();
                User user = new User(conName, conPass, userID);
            }else{

                System.out.println("Admin");
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Boolean ifUser(String[] names, String userName){

        for (int i = 0; i < names.length; i++) {
            
            String[] fullName = names[i].split(" ");

            String firstName = fullName[0];

            userID = i;

            if (userName.equals(firstName)) {
                
                return true;
            }
        }

        return false;
    }
}
