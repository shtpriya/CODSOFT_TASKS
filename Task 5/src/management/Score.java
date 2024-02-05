package management;

import database.connection;
import static database.connection.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Score {

    connection c = new connection();
    Connection con = getConnection();
    PreparedStatement pst;

    public static int getMax() {
        try (Connection con = getConnection();
                PreparedStatement st = con.prepareStatement("SELECT MAX(ID) FROM score");
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

    public boolean getDetails(int sid, int sem) throws SQLException {
        pst = con.prepareStatement("Select * from course where Student_ID= ? and Semester= ?");
        pst.setInt(1, sid);
        pst.setInt(2, sem);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            Student.jTextField12.setText(String.valueOf(rs.getInt(2)));
            Student.jTextField21.setText(String.valueOf(rs.getInt(3)));
            Student.jTextField22.setText(rs.getString(4));
            Student.jTextField23.setText(rs.getString(5));
            Student.jTextField25.setText(rs.getString(6));
            Student.jTextField26.setText(rs.getString(7));
            Student.jTextField27.setText(rs.getString(8));

            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Student ID or Semester doesnot exist ");
        }
        return false;

    }

    public boolean isIDExist(int ID) throws SQLException {
        String s = "Select * from score where  ID = ?";
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

    //checking student id or semester exists or not
    public boolean issidsemExist(int sid, int sem) throws SQLException {
        String s = "Select * from score where  Student_ID = ? and Semester =?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(s);
        pst.setInt(1, sid);
        pst.setInt(2, sem);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public static void insert(int ID, int SID, int semester, String Course1, String Course2, String Course3, String Course4, String Course5, double score1, double score2, double score3, double score4, double score5, double average) throws SQLException {
        String sql = "insert into score values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, ID);
        pst.setInt(2, SID);
        pst.setInt(3, semester);
        pst.setString(4, Course1);
        pst.setDouble(5, score1);
        pst.setString(6, Course2);
        pst.setDouble(7, score2);
        pst.setString(8, Course3);
        pst.setDouble(9, score3);
        pst.setString(10, Course4);
        pst.setDouble(11, score4);
        pst.setString(12, Course5);
        pst.setDouble(13, score5);
        pst.setDouble(14, average);

        if (pst.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "Score added Successfully!");
        }
    }

    public void getScoreValue(JTable table, String searchValue) throws SQLException {
        String q = "select * from score where concat(ID, Student_ID, Semester) like ? order by ID desc";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(q);
        pst.setString(1, "%" + searchValue + "%");
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

    public void update(int ID, double score1, double score2, double score3, double score4, double score5, double average) throws SQLException {
        String ql = "update score set score1=?, score2=?, score3=?, score4=?, score5=?, average=?  where ID=?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(ql);
        pst.setDouble(1, score1);
        pst.setDouble(2, score2);
        pst.setDouble(3, score3);
        pst.setDouble(4, score4);
        pst.setDouble(5, score5);
        pst.setDouble(6, average);
        pst.setInt(7, ID);

        if (pst.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "Score Updated Successfully!");
        }
    }
}
