package com.aitu.university;
import java.sql.*;

public class StudentDAO {

    // 1. WRITE (Create/Insert)
    public void addStudent(Student student) {
        String sql = "INSERT INTO students(student_id, name, major, study_year, gpa) VALUES(?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getMajor());
            pstmt.setInt(4, student.getYear());
            pstmt.setDouble(5, student.getGpa());

            pstmt.executeUpdate();
            System.out.println("Student added: " + student.getName());

        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // 2. READ (Select)
    public void getAllStudents() {
        String sql = "SELECT * FROM students";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- LIST OF STUDENTS FROM DB ---");
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("student_id") +
                                " | Name: " + rs.getString("name") +
                                " | Major: " + rs.getString("major") +
                                " | GPA: " + rs.getDouble("gpa")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
    }

    // 3. UPDATE
    public void updateStudentGpa(int id, double newGpa) {
        String sql = "UPDATE students SET gpa = ? WHERE student_id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, newGpa);
            pstmt.setInt(2, id);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Updated Student ID " + id + " with new GPA: " + newGpa);
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    // 4. DELETE
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE student_id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Deleted Student ID " + id);
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}
