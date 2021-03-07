package library;

import java.sql.*;

public class User {
      
    private UserGui gui;
    private Connection userCon;

    public User(String name, Connection con){

        gui = new UserGui(name);

        this.userCon = con;
    }

    public void xxx(){
        
    }
}
