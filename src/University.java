import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class University {
    private String name;
    private String location;
    private int foundedYear;
    private List<Course> courses;
    private List<Professor> professors;
    private List<Student> students;

    public University(String name, String location, int foundedYear) {
        this.name = name;
        this.location = location;
        this.foundedYear = foundedYear;
        this.courses = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    // SEARCHING METHOD
    public Course findCourseByCode(String code) {
        return courses.stream()
                .filter(course -> course.getCourseCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    public Professor findProfessorByName(String name) {
        return professors.stream()
                .filter(professor -> professor.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<Course> findCourseByDepartment(String department) {
        return courses.stream()
                .filter(course -> course.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    // filtering methods

    public List<Professor> filterProfessorsByExperience(int minYears) {
        return professors.stream()
                .filter(professor -> professor.getYearsOfExp() >= minYears)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Course> filterCoursesByCredits(int minCredits, int maxCredits) {
        return courses.stream()
                .filter(course -> course.getCredits() >= minCredits && course.getCredits() <= maxCredits)
                .collect(Collectors.toUnmodifiableList());
    }

    // sort method

    public void sortProfessorsByExperience() {
        professors.sort(Comparator.comparingInt(Professor::getYearsOfExp).reversed());
    }

    public void sortCoursesByName() {
        courses.sort(Comparator.comparing(Course::getCourseName));
    }

    public void sortCoursesByCredits() {
        courses.sort(Comparator.comparingInt(Course::getCredits).reversed());
    }

    // statistical

    public Map<String, Long> getCoursesByDepartment() {
         return courses.stream()
                 .collect(Collectors.groupingBy(Course::getDepartment, Collectors.counting()));
    }

    public double getAverageProfessorExperience() {
        return professors.stream()
                .mapToInt(Professor::getYearsOfExp)
                .average()
                .orElse(0.0);
    }

    public int getTotalEnrollment() {
        return courses.stream()
                .mapToInt(courses -> courses.getEnrolledStudents().size())
                .sum();
    }





//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public int getFoundedYear() {
//        return foundedYear;
//    }
//
//    public void setFoundedYear(int foundedYear) {
//        this.foundedYear = foundedYear;
//    }
//
//    public List<Course> getCourses() {
//        return courses;
//    }
//
//    public List<Professor> getProfessors() {
//        return professors;
//    }
    // inactive

   // managing datapool
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

    public void addStudent(Student student) {
        if (student != null && !students.contains(student)) {
            students.add(student);
        }
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public void removeProfessor(Professor professor) {
        professors.remove(professor);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }




    // display methods

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
                professor.displayInfo();
                System.out.println();
            }
        }
    }

    public void displayStatistics() {
        System.out.println("\n=== UNIVERSITY STATISTICS ===");
        System.out.println("Total Courses: " + courses.size());
        System.out.println("Total Professors: " + professors.size());
        System.out.println("Total Students: " + students.size());
        System.out.println("Average Professor Experience: " + getAverageProfessorExperience());
        System.out.println("Total Enrollment: " +  getTotalEnrollment());

        System.out.println("\nCourses by Department:");
        getCoursesByDepartment().forEach((dept, count) ->
                System.out.println("  " + dept + ": " + count + " courses"));
    }

    //getters
    public List<Course> getCourses() { return courses; }
    public List<Professor> getProfessors() { return professors; }
    public List<Student> getStudents() { return students; }

}
