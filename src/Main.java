public class Main {
    public static void main(String[] args) {
        System.out.println("=== UNIVERSITY COURSE MANAGEMENT SYSTEM");

        University university = new University("Astana IT University", "Astana", 2019);

        Professor prof1 = new Professor(101, "Kydyrbekova Aigerim", "PhD in Computer Science", 10, "Software Engineering");
        Professor prof2 = new Professor(102, "Chigimbayeva Diana", "PhD in Mathematics", 7, "Mathematics");

        Course se201 = new Course("SE201", "Object-Oriented Programming", 5, "Software Engineering");
        Course math201 = new Course("MATH201", "Calculus 2", 5, "Mathematics");
        Course se101 = new Course("SE101", "Intro to Programming", 3, "Software Engineering");
        Course math101 = new Course("MATH101", "Calculus 1", 4, "Mathematics");

        

    }
}