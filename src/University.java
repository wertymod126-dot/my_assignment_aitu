import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private String location;
    private int foundedYear;
    private List<Course> courses;
    private List<Professor> professors;

    public University() {
        this.name = "";
        this.location = "";
        this.foundedYear = 0;
        this.courses = new ArrayList<>();
        this.professors = new ArrayList<>();
    }

    public University(String name, String location, int foundedYear) {
        this.name = name;
        this.location = location;
        this.foundedYear = foundedYear;
        this.courses = new ArrayList<>();
        this.professors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(int foundedYear) {
        this.foundedYear = foundedYear;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void addCourse(Course course) {
        if (course != null && !courses.contains(course)) {
            courses.add(course);
        }
    }

    public void addProfessor(Professor professor) {
        if (professor != null && !professors.contains(professor)) {
            professors.add(professor);
        }
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public void removeProfessor(Professor professor) {
        professors.remove(professor);
    }

    public double getAverageProfessorExp() {
        if (professors.isEmpty()) {
            return 0.0;
        }
        else {
            int totalexp = 0;
            for (Professor professor : professors) {
                totalexp += professor.getProfessorYearsOfExp();
            }
            return (double) totalexp / professors.size();

        }
    }

    public void displayUniversityInfo() {
        System.out.println("=== UNIVERSITY INFORMATION ===");
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Founded: " + foundedYear);
        System.out.println("Number of Courses: " + courses.size());
        System.out.println("Number of Professors: " + professors.size());
        System.out.println("-----------------------------");
    }

    public void displayAllCourses() {
        System.out.println("=== ALL COURSES ===");
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (int i = 0; i < courses.size(); i++) {
                System.out.print((i + 1) + ". ");
                courses.get(i).displayCourseInfo();
            }
        }
    }

    public void displayAllProfessors() {
        System.out.println("\n=== ALL PROFESSORS ===");
        if (professors.isEmpty()) {
            System.out.println("No professors available.");
        } else {
            for (Professor professor : professors) {
                professor.displayProfessorInfo();
                System.out.println();
            }
        }
    }

}
