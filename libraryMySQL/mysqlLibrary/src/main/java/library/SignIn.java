package library;

import java.sql.*;

public class SignIn {
       
    Gui gui;

    private String name;
    private String pass;
    private String check;
    private Connection con;

    public SignIn(){

        gui = new Gui();

        this.name = "-1";
        this.pass = "-1";

        while (!name.equals("q")) {
            
            if(name.equals("-1")){

                this.name = gui.getUserName();
                this.pass = gui.getUserPass();

                if (!name.equals("-1")) {
                    
                    connection(name, pass);
                }
            }
    
        }
    }

    private void connection(String conName, String conPass){

        try {
            
            // Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/library", "", "");
            PreparedStatement preSta = con.prepareStatement("select * from burrowers;");
            ResultSet rs = preSta.executeQuery();

            while (rs.next()) {
                check = check + "\n" + (rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
            }
            System.out.println(check);
        } catch (Exception e) {
            System.out.println(e);
        }

        setName();
        setPass();
    }

    public void setName(){

        this.name = "-1";
    }

    public void setPass(){

        this.pass = "-1";
    }
}
