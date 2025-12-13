import java.lang.classfile.constantpool.ConstantPool;

public class Course {

    private int courseCode;
    private String courseName;
    private int credits;
    private String courseDepartment;
    private Professor professor;

    public Course() {
        this.courseCode = 0;
        this.courseName = "";
        this.credits = 0;
        this.courseDepartment = "";
        this.professor = null;
    }

    public Course(int courseCode, String courseName, int credits, String courseDepartment, String professor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.courseDepartment = courseDepartment;
        this.professor = null;
    }

    public int getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(int code) {
        courseCode = code;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        if (professor != null) {
            this.professor = professor;
        }
    }

}