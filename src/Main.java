import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        School school = new School();
        new Student();
        new Teacher();
        Scanner scanner = new Scanner(System.in);

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
                        teacher.setName(scanner.nextLine());

                        System.out.println("Enter the teacher's gender: ");
                        System.out.println("f - Female, m - Male");
                        String gender = "";

                        // checking the correctness of gender input
                        while (!gender.equalsIgnoreCase("m") || !gender.equalsIgnoreCase("f")){
                             gender = scanner.nextLine();
                            if (gender.equalsIgnoreCase("m")){
                                gender = "Male";
                                break;
                            } else if (gender.equalsIgnoreCase("f")) {
                                gender = "Female";
                                break;
                            }
                            else{
                                System.out.println(ConsoleColors.RED + "Wrong gender type!");
                                System.out.println(ConsoleColors.RESET);

                            }
                        }

                        teacher.setGender(gender);


                        System.out.println("Enter the teacher's age");
                        System.out.println("(the age can be from 17 to 120 inclusive):");
                        int age = 17;
                        while (true){
                            try {
                                age = Integer.parseInt(scanner.nextLine());
                                if (age < 17 || age >120){
                                    System.out.println(ConsoleColors.RED + "Attention! The age can be from 17 to 120 inclusive!");
                                    System.out.println(ConsoleColors.RESET);

                                }
                                else {
                                    teacher.setAge(age);
                                    break;
                                }

                            }catch (NumberFormatException e){
                                System.out.println(ConsoleColors.RED + "Invalid data type for age!");
                                System.out.println(ConsoleColors.RESET);

                            }
                        }

                        System.out.println("Enter the teacher's position: ");
                        teacher.setPost(scanner.nextLine());

                        System.out.println("Enter the teacher's salary: ");
                        while(true){
                            try {
                                teacher.setSalary(Double.parseDouble(scanner.nextLine()));
                                break;
                            }
                            catch (NumberFormatException e){
                                System.out.println(ConsoleColors.RED + "Invalid data type for salary!");
                                System.out.println(ConsoleColors.RESET);

                            }

                        }

                        System.out.println("Enter the teacher's experience: ");
                        int experience = 0;
                        while (true){
                            experience = Integer.parseInt(scanner.nextLine());
                            if (experience >= age){
                                System.out.println(ConsoleColors.RED + "Attention! Experience cannot be greater than or equal to age.");
                                System.out.println(ConsoleColors.RESET);

                            }
                            else {
                                teacher.setExperience(experience);
                                break;
                            }
                        }

                        System.out.println(ConsoleColors.GREEN_BOLD + "Done");
                        System.out.println(ConsoleColors.RESET);

                    }
                }
                case ("STUD") -> System.out.println("add new student here");
                case ("TDATA") -> {

                    if (school.getList_of_teachers() != null && !school.getList_of_teachers().isEmpty()){
                        System.out.println();
                        System.out.println("TEACHERS: ");  // shows a list of all teachers in the console
                        for (Teacher teacher: school.getList_of_teachers()){
                            System.out.println("| " + teacher.getId() + " | " + teacher.getName() + " |");
                        }
                        System.out.println();
                        System.out.println("Type teacher's id to see more information: ");
                        System.out.println("Or type \"exit\" to exit");
                        String selected_teacher_id = "";

                        while (!selected_teacher_id.equals("exit")){
                            selected_teacher_id = scanner.nextLine();
                            if (selected_teacher_id.equalsIgnoreCase("exit")){
                                System.out.println(ConsoleColors.GREEN_BOLD + "Done");
                                System.out.println(ConsoleColors.RESET);
                                break;
                            }
                            else {
                                System.out.println();
                                System.out.println(school.getList_of_teachers().get(Integer.parseInt(selected_teacher_id) - 1).toString());
                            }

                        }
                    }
                    else{
                        System.out.println(ConsoleColors.YELLOW + "It's seems like there is no teachers.");
                        System.out.println(ConsoleColors.RESET);

                    }

                }
                case ("SDATA") -> System.out.println("get students data here");
                case ("HELP") -> {
                    info();
                }
                case ("Q") -> System.out.println("Goodbye!");
                case (""), (" "), ("\n") -> {}
                default ->{
                    System.out.println(ConsoleColors.RED + "Not a valid response.");
                    System.out.println(ConsoleColors.RESET);
                }
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
    public static class ConsoleColors {
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset

        // Regular Colors
        public static final String RED = "\033[0;31m";     // RED
        public static final String GREEN = "\033[0;32m";   // GREEN
        public static final String YELLOW = "\033[0;33m";  // YELLOW

        // Bold
        public static final String RED_BOLD = "\033[1;31m";    // RED
        public static final String GREEN_BOLD = "\033[1;32m";  // GREEN

        // Underline
        public static final String RED_UNDERLINED = "\033[4;31m";    // RED
        public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW

    }
}