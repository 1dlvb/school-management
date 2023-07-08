import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        School school = new School();
        new Student();
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - add new teacher");
        System.out.println("2 - add new student");
        System.out.println("3 - get teachers data");
        System.out.println("4 - get students data");
        System.out.println("Q - quit");


        String response = "";
        while (!response.equals("Q")){
            response = scanner.next();
            response = response.toUpperCase();

            switch (response) {
                case ("1") -> {
                    System.out.println("add new teacher here");
                    school.addTeacher();
                    ArrayList<Teacher> list_of_teachers = school.getList_of_teachers();
                    if (list_of_teachers != null && !list_of_teachers.isEmpty()) {
                        Teacher teacher = list_of_teachers.get(list_of_teachers.size() - 1);
                        System.out.println(teacher.getName());
                    }
                }
                case ("2") -> System.out.println("add new student here");
                case ("3") -> System.out.println("get teachers data here");
                case ("4") -> System.out.println("get students data here");
                case ("Q") -> System.out.println("Goodbye!");
                default -> System.out.println("Not a valid response.");
            }
        }

        /*
        school.teacher.setId("0001");
        school.teacher.setName("Julia");
        school.teacher.setPost("Teacher");
        school.teacher.setSex("Female");
        school.teacher.setAge(25);
        school.teacher.setSalary(25000);
        school.teacher.setExperience(3);

        System.out.println("id - " + school.teacher.getId());
        System.out.println("name - " + school.teacher.getName());
        System.out.println("post - " + school.teacher.getPost());
        System.out.println("sex - " + school.teacher.getSex());
        System.out.println("age - " + school.teacher.getAge() + " years old");
        System.out.println("salary - " + school.teacher.getSalary() + " rubles");
        System.out.println("experience - " + school.teacher.getExperience() + " years");

        System.out.println("---------------------------------------------");

        school.student.setId("0001");
        school.student.setName("Anastasia");
        school.student.setPost("Student");
        school.student.setSex("Female");
        school.student.setAge(15);
        school.student.setGrade(9);
        school.student.setAvg_mark(17./5);
        school.student.setFees(350.54);
        school.student.setTotal_fees(school.student.getFees() + 500);

        System.out.println("id - " + school.student.getId());
        System.out.println("name - " + school.student.getName());
        System.out.println("post - " + school.student.getPost());
        System.out.println("sex - " + school.student.getSex());
        System.out.println("age - " + school.student.getAge() + " years old");
        System.out.println("grade - " + school.student.getGrade());
        System.out.println("average mark - " + school.student.getAvg_mark());
        System.out.println("fees - " + school.student.getFees());
        System.out.println("total fees - " + school.student.getTotal_fees());

        System.out.println("---------------------------------------------");

        school.setRevenue(150_350.86);
        school.setExpenses(107_876.36);

        System.out.println(school.getRevenue());
        System.out.println(school.getExpenses());
        */
    }
}