import java.util.ArrayList;
import java.util.List;

public class Professor {

    private int professorID;
    private String professorName;
    private String professorQualification;
    private int professorYearsOfExp;
    private List<Course> coursesTaught;

    public Professor() {
        this.professorID = 0;
        this.professorName = "";
        this.professorQualification = "";
        this.professorYearsOfExp = 0;
        this.coursesTaught = new ArrayList<>();
    }

    public Professor(int professorID,String professorName,String professorQualification,int professorYearsOfExp) {
        this.professorID = professorID;
        this.professorName = professorName;
        this.professorQualification = professorQualification;
        this.professorYearsOfExp =  professorYearsOfExp;
        this.coursesTaught = new ArrayList<>();
    }

    public int getProfessorID() {
        return professorID;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getProfessorQualification() {
        return professorQualification;
    }

    public void setProfessorQualification(String professorQualification) {
        this.professorQualification = professorQualification;
    }

    public int getProfessorYearsOfExp() {
        return professorYearsOfExp;
    }

    public void setProfessorYearsOfExp(int professorYearsOfExp) {
        this.professorYearsOfExp = professorYearsOfExp;
    }

    public List<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void addCourse(Course course) {
        if (course != null && !coursesTaught.contains(course)) {
            coursesTaught.add(course);
            if (course.getProfessor() != this) {
                course.setProfessor(this);
            }
        }
    }

    public void removeCourse(Course course) {
        if (course != null && coursesTaught.contains(course)) {
            coursesTaught.remove(course);
            if (course.getProfessor() == this) {
                course.setProfessor(null);
            }
        }
    }

    public void displayProfessorInfo() {
        System.out.println("Professor Info:");
        System.out.println("ID: " + professorID);
        System.out.println("Professor Name: " + professorName);
        System.out.println("Professor Qualification: " + professorQualification);
        System.out.println("Years of experience: " + professorYearsOfExp);
        if (coursesTaught != null && !coursesTaught.isEmpty()) {
            System.out.println("Number of courses teaching: " + coursesTaught.size());
            System.out.println("Courses Taught: ");

            for (int i = 0; i < coursesTaught.size() ; i++) {
                Course course = coursesTaught.get(i);
                System.out.println(" " + (i + 1) + "-" + course + "-" + course.getCourseCode() + "-" + course.getCourseName() + "( " + course.getCredits() + " credits)");
            }
        }
        else {
            System.out.println("No courses");
        }
    }







}
