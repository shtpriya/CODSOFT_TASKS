package database;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
import management.Student;

public class connection {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/student_management_system", "root", "");
            //System.out.println("Connection Created");
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public static int getMax() {
        try (Connection con = getConnection();
                PreparedStatement st = con.prepareStatement("SELECT MAX(ID) FROM student");
                ResultSet rs = st.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1) + 1;
            } else {
                return -1;
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return -1;
    }
//Inserting into Student Table

    public static void insert(int ID, String Name, String DOB, String Gender, String Email, String Phone, String Address, String Father, String Mother, String imagepath) throws SQLException {
        String sql = "insert into student values(?,?,?,?,?,?,?,?,?,?)";

        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, ID);
        pst.setString(2, Name);
        pst.setString(3, DOB);
        pst.setString(4, Gender);
        pst.setString(5, Email);
        pst.setString(6, Phone);
        pst.setString(7, Address);
        pst.setString(8, Father);
        pst.setString(9, Mother);
        pst.setString(10, imagepath);

        if (pst.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "New Student added Successfully!");
        }
    }

    //Checking If Email already exists
    public boolean isEmailExist(String Email) throws SQLException {
        String s = "Select * from student where  Email = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(s);
        pst.setString(1, Email);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    //Checking If phone already exists
    public boolean isPhoneExist(String Phone) throws SQLException {
        String s = "Select * from student where  Phone = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(s);
        pst.setString(1, Phone);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    //Checking If ID already exists
    public boolean isIDExist(int ID) throws SQLException {
        String s = "Select * from student where  ID = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(s);
        pst.setInt(1, ID);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    //displaying  value from student table
    public void getStudentValue(JTable table, String searchValue) throws SQLException {
        String q = "select * from student where concat(ID, Name, Email, Phone) like ? order by ID desc";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(q);
        pst.setString(1, "%" + searchValue + "%");
        ResultSet rs = pst.executeQuery();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        Object[] row;
        while (rs.next()) {
            row = new Object[10];
            row[0] = rs.getInt(1);
            row[1] = rs.getString(2);
            row[2] = rs.getString(3);
            row[3] = rs.getString(4);
            row[4] = rs.getString(5);
            row[5] = rs.getString(6);
            row[6] = rs.getString(7);
            row[7] = rs.getString(8);
            row[8] = rs.getString(9);
            row[9] = rs.getString(10);
            model.addRow(row);
        }
    }

    //Update Student Value
    public void update(int ID, String Name, String DOB, String Gender, String Email, String Phone, String Address, String Father, String Mother, String imagepath) throws SQLException {
        String ql = "update student set Name=?, DOB=?, Gender=?, Email=?, Phone=?, "
                + "Address=?, `Father's_Name`=?, `Mother's_Name`=?, imagepath=? where ID=?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(ql);

        pst.setString(1, Name);
        pst.setString(2, DOB);
        pst.setString(3, Gender);
        pst.setString(4, Email);
        pst.setString(5, Phone);
        pst.setString(6, Address);
        pst.setString(7, Father);
        pst.setString(8, Mother);
        pst.setString(9, imagepath);
        pst.setInt(10, ID);

        if (pst.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "Student data Updated Successfully!");
        }
    }

//Delecting Student data
    public void delete(int ID) throws SQLException {
        int yesno = JOptionPane.showConfirmDialog(null, "All other records will also be delected!", "Student Delete", JOptionPane.OK_CANCEL_OPTION, 0);
        if ((yesno) == JOptionPane.OK_OPTION) {
            Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement("delete from student where id =?");
            pst.setInt(1, ID);

            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Student Deleted Successfully!");
            }
        }
    }

    //Searching data
    public void getValue(JTable table, String searchValue) throws SQLException {
        String q = "SELECT * FROM student WHERE ID = ? AND CONCAT(Name, Email, Phone) LIKE ? ORDER BY ID DESC";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(q);
        try {
            int id = Integer.parseInt(searchValue);
            pst.setInt(1, id);
        } catch (NumberFormatException e) {
            pst.setInt(1, -1);
        }

        pst.setString(2, "%" + searchValue + "%");

        ResultSet rs = pst.executeQuery();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        Object[] row;
        while (rs.next()) {
            row = new Object[10];
            row[0] = rs.getInt(1);
            row[1] = rs.getString(2);
            row[2] = rs.getString(3);
            row[3] = rs.getString(4);
            row[4] = rs.getString(5);
            row[5] = rs.getString(6);
            row[6] = rs.getString(7);
            row[7] = rs.getString(8);
            row[8] = rs.getString(9);
            row[9] = rs.getString(10);
            model.addRow(row);
        }
    }
}
