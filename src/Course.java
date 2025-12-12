public class Course {

    private int courseCode;
    private String courseName;
    private int credits;
    private String courseDepartment;
    private String professor;

    public Course() {
        this.courseCode = 0;
        this.courseName = "";
        this.credits = 0;
        this.courseDepartment = "";
        this.professor = "";
    }

    public Course(int courseCode, String courseName, int credits, String courseDepartment, String professor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.courseDepartment = courseDepartment;
        this.professor = professor;
    }

}