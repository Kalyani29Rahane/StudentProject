package DAO;

import model.Student1;
import java.sql.*;
import java.util.*;

public class StudentDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/studentinfo";
    private static final String USER = "root";
    private static final String PASS = "Wj28@krhps";

    public boolean addStudent(Student1 s) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO student (roll_no, name, marks, course, address, class, city, college_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getRollNo());
            ps.setString(2, s.getName());
            ps.setDouble(3, s.getMarks());
            ps.setString(4, s.getCourse());
            ps.setString(5, s.getAddress());
            ps.setString(6, s.getClassName());
            ps.setString(7, s.getCity());
            ps.setString(8, s.getCollegeName());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error in addStudent: " + e.getMessage());
            return false;
        }
    }

    public List<Student1> getAllStudents() {
        List<Student1> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT * FROM student";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Student1 s = new Student1();
                s.setRollNo(rs.getInt("roll_no"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getDouble("marks"));
                s.setCourse(rs.getString("course"));
                s.setAddress(rs.getString("address"));
                s.setClassName(rs.getString("class"));
                s.setCity(rs.getString("city"));
                s.setCollegeName(rs.getString("college_name"));
                list.add(s);
            }
        } catch (Exception e) {
            System.out.println("Error in getAllStudents: " + e.getMessage());
        }
        return list;
    }

    public boolean updateStudent(Student1 s) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "UPDATE student SET name=?, marks=?, course=?, address=?, class=?, city=?, college_name=? WHERE roll_no=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setDouble(2, s.getMarks());
            ps.setString(3, s.getCourse());
            ps.setString(4, s.getAddress());
            ps.setString(5, s.getClassName());
            ps.setString(6, s.getCity());
            ps.setString(7, s.getCollegeName());
            ps.setInt(8, s.getRollNo());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error in updateStudent: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteStudent(int rollNo) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "DELETE FROM student WHERE roll_no=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, rollNo);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error in deleteStudent: " + e.getMessage());
            return false;
        }
    }
}

