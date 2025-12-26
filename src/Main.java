import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== UNIVERSITY COURSE MANAGEMENT SYSTEM");

        University university = new University("Astana IT University", "Astana", 2019);

        // creating objects
        Professor prof1 = new Professor(101, "Kydyrbekova Aigerim", "PhD in Computer Science", 10, "Software Engineering");
        Professor prof2 = new Professor(102, "Chigimbayeva Diana", "PhD in Mathematics", 7, "Mathematics");

        Student student1 = new Student(232567, "Rinat Turkmengali", "Software Engineer", 2513,1);
        Student student2 = new Student(252776, "Abylay Yerkenov","Software Engineer",2513,1);
        Student student3 = new Student(248790, "Ivan Pizzaboy","Cybersecurity",2513,2);

        Course se201 = new Course("SE201", "Object-Oriented Programming", 5, "Software Engineering");
        Course math201 = new Course("MATH201", "Calculus 2", 5, "Mathematics");
        Course se101 = new Course("SE101", "Intro to Programming", 3, "Software Engineering");
        Course math101 = new Course("MATH101", "Calculus 1", 4, "Mathematics");

        //adding
        university.addProfessor(prof1);
        university.addProfessor(prof2);

        university.addCourse(se201);
        university.addCourse(math101);
        university.addCourse(se101);
        university.addCourse(math201);

        university.addStudent(student1);
        university.addStudent(student2);
        university.addStudent(student3);

        //setting profs  for courses
        se101.setProfessor(prof1);
        se201.setProfessor(prof1);

        math101.setProfessor(prof2);
        math201.setProfessor(prof2);

        // enrolling students

        student1.enrollCourse(se101);
        student1.enrollCourse(math101);

        student2.enrollCourse(se101);
        student2.enrollCourse(math101);

        student3.enrollCourse(se201);
        student3.enrollCourse(math201);

       //
        // polumorphism
        System.out.println("--POLYMORPHISM TEST--");
        university.displayAllPersons();

        // searching
        Course foundCourse = university.findCourseByCode("SE201");
        if (foundCourse != null) {
            System.out.println("FOUND COURSE: " + foundCourse);
        }

        //filtering
        System.out.println("\n----FILTERING TEST----");
        System.out.println("EXPERIENCED PROFESSORS WITH 5+ YEARS of EXP");
        List<Professor> experiencedProfessors = university.filterProfessorsByExperience(5);
        experiencedProfessors.forEach(professor -> System.out.println(" - " + professor));

        System.out.println("SOFTWARE ENGINEERING COURSES");
        List<Course> seCourses = university.findCourseByDepartment("Software Engineering");
        seCourses.forEach(course -> System.out.println(" - " + course));

        //sorting
        System.out.println("\n----SORTING TEST----");
        System.out.println("Courses sorted by name: ");
        university.sortCoursesByName();
        university.getCourses().forEach(course -> System.out.println(" - " + course.getCourseName()));

        System.out.println("Courses sorted by credits (descending) : ");
        university.sortCoursesByCredits();
        university.getCourses().forEach(course -> System.out.println(" - " + course.getCourseName() + "-" + course.getCredits() + "credits"));


        //data abstraction
        System.out.println("\nDATA ABSTRACTIONS USING DISPLAYABLE INTERFACE");
        se101.displayBriefInfo();
        se201.displayDetailedInfo();
        math101.displayBriefInfo();

        // testing equals






    }
}