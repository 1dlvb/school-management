import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        School school = new School();
        new Student();
        new Teacher();
        Scanner scanner = new Scanner(System.in);

        int id = 0;


        String response = "";
        while (!response.equals("Q")){
            System.out.println();
            System.out.println("TEACH - add new teacher");
            System.out.println("STUD - add new student");
            System.out.println("TDATA - get teachers data");
            System.out.println("SDATA - get students data");
            System.out.println("Q - quit");

            response = scanner.nextLine();
            response = response.toUpperCase();

            switch (response) {
                case ("TEACH") -> {
                    System.out.println("add new teacher here");
                    school.addTeacher();
                    ArrayList<Teacher> list_of_teachers = school.getList_of_teachers();
                    if (list_of_teachers != null && !list_of_teachers.isEmpty()) {
                        Teacher teacher = list_of_teachers.get(list_of_teachers.size() - 1);

                        id++;
                        teacher.setId(id);

                        System.out.println("Enter the teacher's name: ");
                        teacher.setName(scanner.nextLine());

                        System.out.println("Enter the teacher's gender: ");
                        teacher.setGender(scanner.nextLine());

                        System.out.println("Enter the teacher's age: ");
                        teacher.setAge(Integer.parseInt(scanner.nextLine()));

                        System.out.println("Enter the teacher's salary: ");
                        teacher.setSalary(Double.parseDouble(scanner.nextLine()));

                        System.out.println("Enter the teacher's experience: ");
                        teacher.setExperience(Integer.parseInt(scanner.nextLine()));

                        System.out.println("done");

                    }
                }
                case ("STUD") -> System.out.println("add new student here");
                case ("TDATA") -> {
                    if (school.getList_of_teachers() != null && !school.getList_of_teachers().isEmpty()){
                        System.out.println();
                        System.out.println();
                        System.out.println("TEACHERS: ");
                        for (Teacher teacher: school.getList_of_teachers()){
                            System.out.println(teacher.getId() + " " + teacher.getName());
                        }
                    }
                    else{
                        System.out.println("It's seems like there is no teachers.");
                    }
                }
                case ("SDATA") -> System.out.println("get students data here");
                case ("Q") -> System.out.println("Goodbye!");
                default -> System.out.println("Not a valid response.");
            }
        }

    }
}