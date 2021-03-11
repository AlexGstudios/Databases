package library;

import java.sql.*;

public class Magazines {
    
    private static MagazinesGui mGui;

    private static String userName;
    private static String userPass;

    private static int userID;

    public Magazines(String name, String pass, int ID){

        userName = name;
        userPass = pass;
        userID = ID;

        String[] magData = conData(userName, userPass);

        mGui = new MagazinesGui(userName, userID, magData);
    }

    public static String[] conData(String name, String pass){

        String[] magID;
        String[] magInfo;
        String toMagID = "";
        String toList = "Magazines: ";

        try {
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", name, pass);
            PreparedStatement preSta = con.prepareStatement("select * from magazine;");
            ResultSet rs = preSta.executeQuery();

            while (rs.next()) {

                toMagID = toMagID + "," + (rs.getString(1));

                toList = toList + "," + (rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4));
            }

            magID = toMagID.split(",");

            magInfo = toList.split(",");

            for (int i = 0; i < magID.length; i++) {
                
                if (checkMag(magID[i], name, pass)) {
                    
                    magInfo[i] = magInfo[i] + " - not in stock.";
                }else{

                    magInfo[i] = magInfo[i];
                }
            }
            con.close();
        } catch (Exception e) {
            
            magInfo = null;
            System.out.println(e);
        }

        return magInfo;
    }

    public static Boolean checkMag(String magID, String name, String pass){

        String[] allMags;
        String onloanMagID = "x";

        Boolean isTrue = false;

        try {
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", name, pass);
            PreparedStatement preSta = con.prepareStatement("select magazineID from onloan;");
            ResultSet rsLoan = preSta.executeQuery();

            while (rsLoan.next()) {
                
                onloanMagID = onloanMagID + "," + (rsLoan.getString(1));
            }

            allMags = onloanMagID.split(",");

            for (int i = 0; i < allMags.length; i++) {
                
                if (magID.equals(allMags[i])) {
                    
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

        User user = new User(userName, userPass, userID);
        mGui.dispose();
    }
}
