import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private int studentId;
    private String major;
    private int group;
    private int year;
    private double gpa;
    private List<Course> enrolledCourses;

    public Student(int id, String name,String major,int group,int year) {
        super(id, name);
        this.major = major;
        this.year = year;
        this.group = group;
        this.gpa = 0.0;
        this.enrolledCourses = new ArrayList<>();
    }

    @Override
    public void displayInfo() {
        System.out.println("Student: " + name + " - " + major );
        System.out.println("Year: " + year + ", GPA: " + gpa + ", Group: " + group );
    }

    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(enrolledCourses)) {
            enrolledCourses.add(course);
            System.out.println(name + " is now enrolled in " + course.getCourseName());
        }
    }

    public void dropCourse(Course course) {
        if (enrolledCourses.contains(course)) {
            enrolledCourses.remove(course);
        }
    }

    public double calculateGPA() {
        if (enrolledCourses.isEmpty()) {
            return 0.0;
        }
        // not finished yet
        return 1.1;
    }

    //getters setters
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public void setGroup(int group) {
        this.group = group;
    }
    public int getGroup() {
        return group;
    }
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    public List<Course> getEnrolledCourses() { return enrolledCourses; }

}
