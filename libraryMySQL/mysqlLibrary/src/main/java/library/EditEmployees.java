package library;

import java.net.IDN;
import java.sql.*;
import javax.swing.DefaultListModel;

public class EditEmployees {

    private static EditEmployeesGui eGui;

    private static String[] data;

    private static String adminName;
    private static String adminPass;
    private static String[] toArrNames;
    private static String[] toArrAddress;
    private static String[] toArrSalary;
    private static String[] toArrDaysOff;
    private static String[] toArrPhone;
    private static String[] toArrPhone2;
    private static String[] toArrPhone3;
    
    public EditEmployees(String name, String pass){

        adminName = name;
        adminPass = pass;

        data = conData(adminName, adminPass);

        eGui = new EditEmployeesGui(adminName, adminPass, data);
    }

    public static String[] conData(String conName, String conPass){

        String[] emplInfo = new String[getLength(conName, conPass)];
        String toNames = "names - ";
        String toAddress = "addresses - ";
        String toSalary = "Salarys - ";
        String toDaysOff = "Days Off - ";
        String toPhone = "Phone - ";
        String toPhone2 = "Phone2 - ";
        String toPhone3 = "Phone3 - ";

        try {
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", conName, conPass);
            PreparedStatement preSta = con.prepareStatement("select employees.name, employees.address, employees.salary, employees.daysOff, employeephone.phone, employeephone.phone2, employeephone.phone3 from employees join employeephone where employeephone.employeeID = employees.ID;");
            ResultSet rs = preSta.executeQuery();

            while (rs.next()) {

                toNames = toNames + "<>" + (rs.getString(1));
                toAddress = toAddress + "<>" + (rs.getString(2));
                toSalary = toSalary + "<>" + (rs.getString(3));
                toDaysOff = toDaysOff + "<>" + (rs.getString(4));
                toPhone = toPhone + "<>" + (String.valueOf(rs.getInt(5)));
                toPhone2 = toPhone2 + "<>" + (String.valueOf(rs.getInt(6)));
                toPhone3 = toPhone3 + "<>" + (String.valueOf(rs.getInt(7)));
            }

            toArrNames = toNames.split("<>");
            toArrAddress = toAddress.split("<>");
            toArrSalary = toSalary.split("<>");
            toArrDaysOff = toDaysOff.split("<>");
            toArrPhone = toPhone.split("<>");
            toArrPhone2 = toPhone2.split("<>");
            toArrPhone3 = toPhone3.split("<>");

            for (int i = 0; i < toArrNames.length; i++) {
                
                emplInfo[i] = toArrNames[i]  + " - " + toArrAddress[i]  + " - " + toArrSalary[i]  + " - " + toArrDaysOff[i]  + " - " + toArrPhone[i]  + " - " + toArrPhone2[i]  + " - " + toArrPhone3[i];
            }
            con.close();
        } catch (Exception e) {
            
            emplInfo = null;
            System.out.println(e);
        }

        return emplInfo;
    }

    public static int getLength(String conName, String conPass){

        int i = 0;

        try {
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", conName, conPass);
            PreparedStatement preSta = con.prepareStatement("select ID from employees;");
            ResultSet rs = preSta.executeQuery();

            while (rs.next()) {
                
                i = i + rs.getInt(1);
            }

            return i;
        } catch (Exception e) {
            i = 0;
            //TODO: handle exception
        }

        return i;
    }

    public static void updateEmployee(int ID, String name, String address, String salary, String daysOff, String phone, String phone2, String phone3, DefaultListModel<String> model){

        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/library", adminName, adminPass);
            PreparedStatement preSta = con.prepareStatement("update employees, employeephone set employees.name = ?, employees.address = ?, employees.salary = ?, employees.daysOff = ?, employeephone.phone = ?, employeephone.phone2 = ?, employeephone.phone3 = ? where employees.ID = ? and employeephone.employeeID = ?;");
            
            preSta.setString(1, name);
            preSta.setString(2, address);
            preSta.setInt(3, Integer.parseInt(salary));
            preSta.setString(4, daysOff);
            preSta.setInt(5, Integer.parseInt(phone));
            preSta.setInt(6, Integer.parseInt(phone2));
            preSta.setInt(7, Integer.parseInt(phone3));
            preSta.setInt(8, ID);
            preSta.setInt(9, ID);
            
            preSta.executeUpdate();

            String listSelect = name + " - " + address + " - " + String.valueOf(salary) + " - " + daysOff + " - " + String.valueOf(phone) + " - " + String.valueOf(phone2) + " - " + String.valueOf(phone3);

            eGui.updJList(model, ID, listSelect);
            
        } catch (Exception e) {

            System.out.println(e);
        }
    }
 
    public static String setGuiName(int i){

        return toArrNames[i];
    }

    public static String setGuiAddress(int i){

        return toArrAddress[i];
    }

    public static String setGuiSalary(int i){

        return toArrSalary[i];
    }

    public static String setGuiDaysOff(int i){

        return toArrDaysOff[i];
    }

    public static String setGuiPhone(int i){

        return toArrPhone[i];
    }

    public static String setGuiPhone2(int i){

        return toArrPhone2[i];
    }

    public static String setGuiPhone3(int i){

        return toArrPhone3[i];
    }

    public static void back(){

        Admin ad = new Admin(adminName, adminPass);
        eGui.dispose();
    }
}
