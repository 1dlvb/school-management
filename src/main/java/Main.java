import io.github.cdimascio.dotenv.Dotenv;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Dotenv dotenv = Dotenv.configure().load();
        String username = dotenv.get("DB_USERNAME");
        String password = dotenv.get("DB_PASSWORD");
        String connectionUrl = dotenv.get("DB_URL");

        //TODO: Add try/catch statement
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
                        String name = teacher.enterName();
                        teacher.setName(name);

                        System.out.println("Enter the teacher's gender: ");
                        System.out.println("f - Female, m - Male");
                        String gender = teacher.enterGender();
                        teacher.setGender(gender);

                        System.out.println("Enter the teacher's age");
                        System.out.println("(the age can be from 17 to 120 inclusive):");
                        int age = teacher.enterAge(17, 120);
                        teacher.setAge(age);

                        System.out.println("Enter the teacher's position: ");
                        String post = teacher.enterPost();
                        teacher.setPost(post);

                        System.out.println("Enter the teacher's salary: ");
                        double salary =  teacher.enterSalary();
                        teacher.setSalary(salary);

                        System.out.println("Enter the teacher's experience: ");
                        int experience = teacher.enterExperience();
                        teacher.setExperience(experience);

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
                        String name = student.enterName();
                        student.setName(name);

                        System.out.println("Enter the student's gender: ");
                        System.out.println("f - Female, m - Male");
                        String gender = student.enterGender();
                        student.setGender(gender);

                        System.out.println("Enter the student's age: ");
                        int age = student.enterAge(6, 20);
                        student.setAge(age);

                        System.out.println("Enter the student's average mark: ");
                        double avg_mark = student.enterAvg_mark();
                        student.setAvg_mark(avg_mark);

                        System.out.println("Enter the student's grade: ");
                        int grade = student.enterGrade();
                        student.setGrade(grade);

                        System.out.println("Enter the student's fees: ");
                        double fees = student.enterFees();
                        student.setFees(fees);
                        student.setTotal_fees(student.getTotal_fees() + fees);

                        db.setData(school.getList_of_students());
                        consoleColors.GREEN_BOLD("Done");
                    }
                }
                case ("TDATA") -> {
                    System.out.println();
                    System.out.println("Type teacher's id to see more information: ");
                    System.out.println("Or type \"exit\" to exit");
                    school.getData("Teacher", db.getDataPreviewFromDB("teachers"));
                }
                case ("SDATA") -> {
                    System.out.println();
                    System.out.println("Type student's id to see more information: ");
                    System.out.println("Or type \"exit\" to exit");
                    school.getData("Student", db.getDataPreviewFromDB("students"));
                }
                case ("EDIT") -> {
                    // TODO: EDIT branch.
                    System.out.println("Select person:");
                    System.out.println("(Teacher or Student)");
                    String person = scanner.nextLine();
                    String field = "";
                    String id = "";
                    Map<String, String> teacher;

                    while (true){
                        if (person.equalsIgnoreCase("Teacher")){
                            System.out.println("Select person's ID:");
                            for(String data: db.getDataPreviewFromDB("teachers")){
                                System.out.println("| " + data.split(" ")[0] + " | " + data.split(" ")[1] + " |");
                            }

                            id = scanner.nextLine();
                            try{
                                teacher = db.getDataByID("teacher", Integer.parseInt(id));
                                if (!teacher.isEmpty()){
                                    System.out.println(
                                            "id: " + teacher.get("id") + "\n" +
                                            "name: " + teacher.get("name") + "\n" +
                                            "gender: " + teacher.get("gender") + "\n" +
                                            "age: " +  teacher.get("age") + " years old\n" +
                                            "salary: " + teacher.get("salary") + "₽\n" +
                                            "post: " + teacher.get("post") + "\n" +
                                            "experience: " + teacher.get("experience") + " years\n"
                                    );
                                }
                                else{
                                    consoleColors.RED("Wrong id");
                                    break;
                                }
                            }catch (Exception e){
                                    consoleColors.RED("Error!");
                                    break;
                            }

                            System.out.println("Select field:");
                            field = scanner.nextLine();
                            field = field.toUpperCase();

                            switch (field){
                                case ("ID") -> System.out.println(teacher.get("id"));
                                case ("NAME") -> System.out.println(teacher.get("name"));
                                case ("GENDER") -> System.out.println(teacher.get("gender"));
                                case ("AGE") -> System.out.println(teacher.get("age"));
                                case ("SALARY") -> System.out.println(teacher.get("salary"));
                                case ("POST") -> System.out.println(teacher.get("post"));
                                case ("EXPERIENCE") -> System.out.println(teacher.get("experience"));
                            }

                            break;
                        } else if (person.equalsIgnoreCase("Student")) {
                            break;
                        }
                        else{
                            consoleColors.YELLOW("It seems there is no such person.");
                            break;
                        }
                    }
                }
                case ("HELP") -> info();

                case ("Q"), ("QUIT") -> consoleColors.GREEN_BOLD("Goodbye!");
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
        System.out.println("EDIT - edit data");
        System.out.println("HELP - shows this menu again");
        System.out.println("Q/QUIT - quit");
        System.out.println("-------------------------");
    }


}
