package management;

import database.connection;
import static database.connection.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MarksSheet {

    connection c = new connection();
    Connection con = getConnection();
    PreparedStatement pst;

    public boolean isIDExist(int sid) throws SQLException {
        String s = "Select * from  score where  Student_ID = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(s);
        pst.setInt(1, sid);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public void getMarksSheetValue(JTable table, int sid) throws SQLException {
        String q = "select * from score where Student_ID=? ";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(q);
        pst.setInt(1, sid);
        ResultSet rs = pst.executeQuery();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        Object[] row;
        while (rs.next()) {
            row = new Object[14];
            row[0] = rs.getInt(1);
            row[1] = rs.getInt(2);
            row[2] = rs.getInt(3);
            row[3] = rs.getString(4);
            row[4] = rs.getDouble(5);
            row[5] = rs.getString(6);
            row[6] = rs.getDouble(7);
            row[7] = rs.getString(8);
            row[8] = rs.getDouble(9);
            row[9] = rs.getString(10);
            row[10] = rs.getDouble(11);
            row[11] = rs.getString(12);
            row[12] = rs.getDouble(13);
            row[13] = rs.getDouble(14);
            model.addRow(row);
        }
    }

    public double getCGPA(int sid) throws SQLException {
        double cgpa = 0.0;
        Statement pst = con.createStatement();
        String ql = "select avg(average) from score where Student_ID =" + sid + " ";
        ResultSet rs = pst.executeQuery(ql);
        if (rs.next()) {
            cgpa = rs.getDouble(1);
        }
        return cgpa;
    }
}
