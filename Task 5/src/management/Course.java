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

public class Course {

    connection c = new connection();
    Connection con = getConnection();
    PreparedStatement pst;

    public static int getMax() {
        try (Connection con = getConnection();
                PreparedStatement st = con.prepareStatement("SELECT MAX(ID) FROM course");
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

    public boolean getID(int ID) throws SQLException {
        pst = con.prepareStatement("Select * from student where ID= ?");
        pst.setInt(1, ID);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            Student.jTextField10.setText(String.valueOf(rs.getInt(1)));
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Student ID doesnot exist ");
        }
        return false;

    }

    public int countSemester(int ID) throws SQLException {
        int total = 0;
        pst = con.prepareStatement("SELECT COUNT(*) AS total FROM course WHERE Student_ID = ?");
        pst.setInt(1, ID);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            total = rs.getInt(1);
        }
        if (total == 12) {
            JOptionPane.showMessageDialog(null, "This Student has completed all the courses! ");
            return -1;
        }
        return total;
    }

    //Check whether student has taken the semester
    public boolean issemesterExist(int SID, int semester) throws SQLException {
        String s = "Select * from course where  Student_ID = ? and Semester =?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(s);
        pst.setInt(1, SID);
        pst.setInt(2, semester);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    //Check whether student has completed the course
    public boolean isCourseExist(int SID, String courseNo, String course) throws SQLException {
        String s = "Select * from course where  Student_ID = ? and " + courseNo + " = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(s);
        pst.setInt(1, SID);
        pst.setString(2, course);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public static void insert(int ID, int SID, int semester, String Course1, String Course2,
            String Course3, String Course4, String Course5) throws SQLException {
        String sql = "insert into course values(?,?,?,?,?,?,?,?)";

        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, ID);
        pst.setInt(2, SID);
        pst.setInt(3, semester);
        pst.setString(4, Course1);
        pst.setString(5, Course2);
        pst.setString(6, Course3);
        pst.setString(7, Course4);
        pst.setString(8, Course5);

        if (pst.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "Course added Successfully!");
        }
    }

    public void getCourseValue(JTable table, String searchValue) throws SQLException {
        String q = "select * from course where concat(ID, Student_ID, Semester) like ? order by ID desc";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(q);
        pst.setString(1, "%" + searchValue + "%");
        ResultSet rs = pst.executeQuery();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        Object[] row;
        while (rs.next()) {
            row = new Object[8];
            row[0] = rs.getInt(1);
            row[1] = rs.getString(2);
            row[2] = rs.getString(3);
            row[3] = rs.getString(4);
            row[4] = rs.getString(5);
            row[5] = rs.getString(6);
            row[6] = rs.getString(7);
            row[7] = rs.getString(8);
            model.addRow(row);
        }
    }

}
