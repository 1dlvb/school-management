import io.github.cdimascio.dotenv.Dotenv;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Dotenv dotenv = Dotenv.configure().load();
        String username = dotenv.get("DB_USERNAME");
        String password = dotenv.get("DB_PASSWORD");
        String connectionUrl = dotenv.get("DB_URL");

        DB db = new DB(connectionUrl, username, password);
        School school = new School();
        new Teacher();
        new Student();


        Scanner scanner = new Scanner(System.in);
        ConsoleColors consoleColors = new ConsoleColors();
        int teacherId = 0;
        int studentId = 0;


        info();
        String response = "";
        while (!response.equals("Q")){

            response = scanner.nextLine();
            response = response.toUpperCase().replaceAll("\\s", "");

            switch (response) {
                case ("TEACH") -> {
                    school.addTeacher();
                    ArrayList<Teacher> list_of_teachers = school.getList_of_teachers();
                    if (list_of_teachers != null && !list_of_teachers.isEmpty()) {
                        Teacher teacher = list_of_teachers.get(list_of_teachers.size() - 1);

                        teacherId++;
                        teacher.setId(teacherId);

                        System.out.println("Enter the teacher's name: ");
                        teacher.enterName();

                        System.out.println("Enter the teacher's gender: ");
                        System.out.println("f - Female, m - Male");
                        teacher.enterGender();

                        System.out.println("Enter the teacher's age");
                        System.out.println("(the age can be from 17 to 120 inclusive):");
                        teacher.enterAge(17, 120);

                        System.out.println("Enter the teacher's position: ");
                        teacher.enterPost();

                        System.out.println("Enter the teacher's salary: ");
                        teacher.enterSalary();

                        System.out.println("Enter the teacher's experience: ");
                        teacher.enterExperience();

                        db.setData(school.getList_of_teachers());
                        consoleColors.GREEN_BOLD("Done");
                    }
                }
                case ("STUD") -> {
                    school.addStudent();
                    ArrayList<Student> list_of_students = school.getList_of_students();
                    if (list_of_students != null && !list_of_students.isEmpty()){
                        Student student = list_of_students.get(list_of_students.size() - 1);
                        studentId++;
                        student.setId(studentId);

                        System.out.println("Enter the student's name: ");
                        student.enterName();

                        System.out.println("Enter the student's gender: ");
                        System.out.println("f - Female, m - Male");
                        student.enterGender();

                        System.out.println("Enter the student's age: ");
                        student.enterAge(6, 20);

                        System.out.println("Enter the student's average mark: ");
                        student.enterAvg_mark();

                        System.out.println("Enter the student's grade: ");
                        student.enterGrade();

                        System.out.println("Enter the student's fees: ");
                        student.enterFees();
                        db.setData(school.getList_of_students());
                        consoleColors.GREEN_BOLD("Done");
                    }
                }
                case ("TDATA") -> {

                    if (school.getList_of_teachers() != null && !school.getList_of_teachers().isEmpty()){
                        school.getData("Teacher");
                    }
                    else{
                        consoleColors.YELLOW("It's seems like there are no teachers.");
                    }

                }
                case ("SDATA") -> {
                    if (school.getList_of_students() != null && !school.getList_of_students().isEmpty()){
                        school.getData("Student");
                    }
                    else {
                        consoleColors.YELLOW("It's seems like there are no students.");
                    }
                }
                case ("HELP") -> info();

                case ("Q") -> consoleColors.GREEN_BOLD("Goodbye!");
                case (""), (" "), ("\n") -> {}
                default -> consoleColors.RED("Not a valid response.");

            }
        }

    }
    public static void info(){
        System.out.println();
        System.out.println("-------------------------");
        System.out.println("TEACH - add new teacher");
        System.out.println("STUD - add new student");
        System.out.println("TDATA - get teachers data");
        System.out.println("SDATA - get students data");
        System.out.println("HELP - shows this menu again");
        System.out.println("Q - quit");
        System.out.println("-------------------------");
    }


}
// TODO: delete color things for console, 'cause it's doesn't work for standard windows one.

