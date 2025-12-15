public class Course {

    private String courseCode;
    private String courseName;
    private int credits;
    private String courseDepartment;
    private Professor professor;

    public Course() {
        this.courseCode = "";
        this.courseName = "";
        this.credits = 0;
        this.courseDepartment = "";
        this.professor = null;
    }

    public Course(String courseCode, String courseName, int credits, String courseDepartment, Professor professor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.courseDepartment = courseDepartment;
        this.professor = null;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String code) {
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
    public String getCourseDepartment() {
        return courseDepartment;
    }

    public void setCourseDepartment(String courseDepartment) {
        this.courseDepartment = courseDepartment;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        if (professor != null) {
            this.professor = professor;
        }
    }

    @Override
    public String toString() {
        return courseCode + ": " + courseName + " [" + courseDepartment +
                ", " + credits + " credits]";
    }

    public void displayCourseInfo() {
        System.out.println("=== COURSE INFORMATION ===");
        System.out.println("Code: " + courseCode);
        System.out.println("Name: " + courseName);
        System.out.println("Credits: " + credits);
        System.out.println("Department: " + courseDepartment);
        if (professor != null) {
            System.out.println("Professor: " + professor.getProfessorName());
        } else {
            System.out.println("Professor: Not assigned");
        }
        System.out.println("==========================");
    }

    public void displayBriefInfo() {
        System.out.println(courseCode + " - " + courseName +
                " (" + courseDepartment + ") - " +
                credits + " credits");
    }

}