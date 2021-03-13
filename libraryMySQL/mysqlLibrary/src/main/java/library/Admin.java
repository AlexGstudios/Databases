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

    public static void employees(String name, String pass){

        // starts the edit employees gui

        EditEmployees ee = new EditEmployees(name, pass);
        aGui.dispose();
    }

    public static void onLoan(String name, String pass){

        // starts the onloan gui

        Onloan ol = new Onloan(name, pass);
        aGui.dispose();
    }

    public static void signOut(){

        // signs out and starts the logg in gui

        SignIn si = new SignIn();
        aGui.dispose();
    }
}
