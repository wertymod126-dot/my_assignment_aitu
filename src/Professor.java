import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Professor extends Person {

    private String qualification;
    private int yearsOfExp;
    private List<Course> coursesTaught;
    private String department;



    public Professor(int id, String name, String qualification, int yearsOfExp, String department) {
        super(id, name);
        this.qualification = qualification;
        this.department = department;
        this.yearsOfExp = yearsOfExp;
        this.coursesTaught = new ArrayList<>();
    }

    //getters setters
    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }
    public int getYearsOfExp() { return yearsOfExp; }
    public void setYearsOfExp(int yearsOfExp) { this.yearsOfExp = yearsOfExp; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public List<Course> getCoursesTaught() { return coursesTaught; }

    // implementing method from person abstract class
    @Override
    public void displayInfo() {
        System.out.println("Professor: " + name + " (" + qualification + ")");
        System.out.println("Experience: " + yearsOfExp + " Years");
        System.out.println("Department: " + department);
    }

    // Methods
    public boolean teachesCourse(String courseCode) {
        return coursesTaught.stream()
                .anyMatch(course -> course.getCourseCode().equals(courseCode));
    }

    public void sortCoursesByName() {
        coursesTaught.sort(Comparator.comparing(Course::getCourseName));
    }

    public void sortCoursesByCredits() {
        coursesTaught.sort(Comparator.comparing(Course::getCredits).reversed());
    }

    //Filtering
    public List<Course> getCoursesWithCredits(int minCredits) {
        return coursesTaught.stream()
                .filter(course -> course.getCredits() >= minCredits)
                .collect(Collectors.toList());
    }




    @Override
    public String toString() {
        return super.toString() + " - " + qualification + " (" + yearsOfExp + " years exp)";
    }



}

