public class Main {
    public static void main(String[] args) {
        University university = new University("Astana IT University", "Astana", 2019);
        university.displayUniversityInfo();

        Professor prof1 = new Professor(101, "Kydyrbekova Aigerim", "Phd in Comp Science", 10);
        Professor prof2 = new Professor(102,"Chigimbayeva Diana","Phd in Mathematics", 7);

        Course se201 = new Course("SE201","Object-Oriented Programming",5,"Software Engineering",null);
        Course math201 = new Course("MATH201","Calculus 2",5,"Software Engineering",null);

        university.addProfessor(prof1);
        university.addProfessor(prof2);

        university.addCourse(se201);
        university.addCourse(math201);

        prof1.addCourse(se201);
        prof2.addCourse(math201);

        university.displayAllCourses();
        university.displayAllProfessors();

        System.out.println("----UPDATED UNIVERSITY INFO----");
        university.displayUniversityInfo();
        System.out.println("Average Professor Experience: " + university.getAverageProfessorExp());

        System.out.println("----COMPARISONS----");
        System.out.println("Who has more years of experience prof1 or prof2?");

        if (prof1.getProfessorYearsOfExp() > prof2.getProfessorYearsOfExp()) {
            System.out.println("Prof 1 has more Years of experience.");
        }
        else if (prof1.getProfessorYearsOfExp() < prof2.getProfessorYearsOfExp()) {
            System.out.println("Prof 2 has more Years of experience.");
        }
        else {
            System.out.println("Prof 1 and Prof 2 have same years of experience.");
        }

        System.out.println("Who has more courses teaching?");
        if (prof1.getCoursesTaught().size() > prof2.getCoursesTaught().size()) {
            System.out.println("Prof 1 has more courses teaching.");
        }
        else if (prof1.getCoursesTaught().size() < prof2.getCoursesTaught().size()) {
            System.out.println("Prof 2 has more courses teaching.");
        }
        else {
            System.out.println("Prof 1 and Prof 2 have same amount of courses teaching.");
        }

        System.out.println("Which course has more credits assigned?");
        if (se201.getCredits() > math201.getCredits()) {
            System.out.println(se201.getCourseName() + " Has more credits assigned!");
        }
        else if (se201.getCredits() < math201.getCredits()) {
            System.out.println(math201.getCourseName() + " has more credits assigned!");
        }
        else {
            System.out.println("Both courses have same amount of credits assigned.");
        }

    }
}