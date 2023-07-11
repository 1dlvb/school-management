import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        School school = new School();
        new Student();
        new Teacher();
        Scanner scanner = new Scanner(System.in);
        ConsoleColors consoleColors = new ConsoleColors();

        int id = 0;

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

                        id++;
                        teacher.setId(id);

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

                        consoleColors.GREEN_BOLD("Done");
                    }
                }
                case ("STUD") -> System.out.println("add new student here");
                case ("TDATA") -> {

                    if (school.getList_of_teachers() != null && !school.getList_of_teachers().isEmpty()){
                        Teacher teacher = new Teacher();
                        teacher.setEntity("Teacher");
                        teacher.getData();
                    }
                    else{
                        consoleColors.YELLOW("It's seems like there is no teachers.");
                    }

                }
                case ("SDATA") -> System.out.println("get students data here");
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

