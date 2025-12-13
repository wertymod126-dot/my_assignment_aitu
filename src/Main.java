public class Main {
    public static void main(String[] args) {
        Professor professor1 = new Professor(1001,"Advert", "Software Engineering ", 5 );

        Course se25 = new Course("SE25", "Object-Oriented Programming", 5, "Software Engineering", professor1.getProfessorName());
        professor1.addCourse(se25);

        se25.displayCourseInfo();

        professor1.displayProfessorInfo();
    }
}