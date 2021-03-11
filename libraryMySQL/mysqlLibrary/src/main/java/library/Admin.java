package library;

public class Admin {
    
    private static AdminGui aGui;

    private static String adminName;
    private static String adminPass;

    public Admin(String name, String pass){

        adminName = name;
        adminPass = pass;

        aGui = new AdminGui(adminName, adminPass);
    }

    public static void employees(String name){

        EditEmployees ee = new EditEmployees(name);
        aGui.dispose();
    }

    public static void onLoan(String name, String pass){

        Onloan ol = new Onloan(name, pass);
        aGui.dispose();
    }

    public static void signOut(){

        SignIn si = new SignIn();
        aGui.dispose();
    }
}
