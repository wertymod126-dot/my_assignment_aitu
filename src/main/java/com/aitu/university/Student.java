package com.aitu.university;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends Person {
    private String major;
    private int studyGroup; // 'group' is a protected word in SQL, so we use studyGroup
    private int year;
    private double gpa;

    @Transient // This prevents errors with the Course list until you create a Course table
    private List<Course> enrolledCourses = new ArrayList<>();

    public Student() {} // Required!

    public Student(int id, String name, String major, int studyGroup, int year) {
        super(id, name);
        this.major = major;
        this.studyGroup = studyGroup;
        this.year = year;
        this.enrolledCourses = new ArrayList<>();
    }

    @Override
    public void displayInfo() {
        System.out.println("Student: " + name + " (ID: " + id + ")");
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    // Getters and Setters for all fields
    public int getYear() {
        return year;
    }
    public void setYear(int year) {}
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    public int getStudyGroup() { return studyGroup; }
    public void setStudyGroup(int studyGroup) { this.studyGroup = studyGroup; }
}