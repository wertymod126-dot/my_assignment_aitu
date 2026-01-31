package com.aitu.university;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Course implements Displayable {

    private String courseCode;
    private String courseName;
    private int credits;
    private String department;
    private Professor professor;
    private List<Student> enrolledStudents;

    public Course(String courseCode, String courseName, int credits, String department) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.enrolledStudents = new ArrayList<>();
    }

    //Implementing displayable interface
    @Override
    public void displayBriefInfo() {
         System.out.println(courseCode + ": " + courseName + " (" + credits + " credits)");
    }

    @Override
    public void displayDetailedInfo() {
        System.out.println("=== COURSE DETAILS ===");
        System.out.println("Code: " + courseCode);
        System.out.println("Name: " + courseName);
        System.out.println("Credits: " + credits);
        System.out.println("Department: " + department);
        if (professor != null) {
            System.out.println("Professor: " + professor.getName());
        }
        System.out.println("Enrolled Students: " + enrolledStudents.size());
    }

    // boolean methods
    public boolean hasHighEnrollment(int limit) {
        return enrolledStudents.size() >= limit;
    }

    public boolean isCourseInDepartment(String dept) {
        return department.equalsIgnoreCase(dept);
    }

    //sorting
    public static Comparator<Course> sortByCredits() {
        return Comparator.comparingInt(Course::getCredits).reversed();
    }

    public static Comparator<Course> sortByName() {
        return Comparator.comparing(Course::getCourseName);
    }

    //
    @Override
    public String toString() {
        return courseCode + ": " + courseName + " [" + department + ", " + credits + " credits]";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
            Course course = (Course) obj;
            return courseCode.equals(course.courseCode);

    }

    public int hashCode() {
        return courseCode.hashCode();
    }

    //getters and setters

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }
    public List<Student> getEnrolledStudents() { return enrolledStudents; }





//    public void displayCourseInfo() {
//        System.out.println("=== COURSE INFORMATION ===");
//        System.out.println("Code: " + courseCode);
//        System.out.println("Name: " + courseName);
//        System.out.println("Credits: " + credits);
//        System.out.println("Department: " + department);
//        if (professor != null) {
//            System.out.println("Professor: " + professor.getName());
//        } else {
//            System.out.println("Professor: Not assigned");
//        }
//        System.out.println("==========================");
//    }



}