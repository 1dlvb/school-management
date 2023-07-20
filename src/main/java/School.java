import io.github.cdimascio.dotenv.Dotenv;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class School {

    Dotenv dotenv = Dotenv.configure().load();
    String username = dotenv.get("DB_USERNAME");
    String password = dotenv.get("DB_PASSWORD");
    String connectionUrl = dotenv.get("DB_URL");
    DB db = new DB(connectionUrl, username, password);

    private double revenue;
    private double expenses;
    private ArrayList<Teacher> list_of_teachers;
    {
        try {
            list_of_teachers = db.setListOfTeachers();
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
    private ArrayList<Student> list_of_students;
    {
        try {
            list_of_students = db.setListOfStudents();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    Scanner scanner = new Scanner(System.in);
    ConsoleColors consoleColors = new ConsoleColors();


    public void addTeacher(){
        this.list_of_teachers.add(new Teacher());
    }
    public void addStudent(){
        this.list_of_students.add(new Student());
    }


    // Getters
    public double getRevenue() {
        return revenue;
    }
    public double getExpenses() {
        return expenses;
    }

    public ArrayList<Teacher> getList_of_teachers() {
        return list_of_teachers;
    }
    public ArrayList<Student> getList_of_students() {
        return list_of_students;
    }

    // Setters
    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public void setList_of_teachers(ArrayList<Teacher> list_of_teachers) {
        this.list_of_teachers = list_of_teachers;
    }
    public void setList_of_students(ArrayList<Student> list_of_students){
        this.list_of_students = list_of_students;
    }
    public void getData(String entity, ArrayList<String> data){
        System.out.println();
        if (data.isEmpty()){
            System.out.println("Empty!");
            return;
        }
        System.out.println(entity.toUpperCase() + "S: ");  // shows a list of all teachers in the console
        if (entity.equalsIgnoreCase("teacher")){
            for(String line: data){
                String[] parts = line.split(" ");
                System.out.println("| " + parts[0] + " | " + parts[1] + " |");
            }
        } else if (entity.equalsIgnoreCase("student")) {
            for(String line: data){
                String[] parts = line.split(" ");
                System.out.println("| " + parts[0] + " | " + parts[1] + " |");
            }
        }


        System.out.println();
        System.out.printf("Type %s's id to see more information: \n", entity.toLowerCase());
        System.out.println("Or type \"exit\" to exit");
        String selected_entity_id = "";
        while (!selected_entity_id.equals("exit")){
            try {
                selected_entity_id = scanner.nextLine();
                if (selected_entity_id.equalsIgnoreCase("exit")){
                    consoleColors.GREEN_BOLD("Done");
                    break;
                }
                else {
                    System.out.println();
                    if (entity.equalsIgnoreCase("teacher")){
                        Map<String, String> teacher;
                        teacher = db.getDataByID("teacher", Integer.parseInt(selected_entity_id));
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
                        }else {
                            consoleColors.RED("Wrong id!");
                        }

                    }
                    else if(entity.equalsIgnoreCase("student")){
                        Map<String, String> student;
                        student = db.getDataByID("student", Integer.parseInt(selected_entity_id));
                        if (!student.isEmpty()){
                            System.out.println(
                                    "id: " + student.get("id") + "\n" +
                                    "name: " + student.get("name") + "\n" +
                                    "gender: " + student.get("gender") + "\n" +
                                    "age: " +  student.get("age") + " years old\n" +
                                    "grade: " + student.get("grade") + "\n" +
                                    "average mark: " + student.get("average_mark") + "\n" +
                                    "fees: " + student.get("fees") + "₽\n" +
                                    "total fees: " + student.get("total_fees") + "₽\n"
                            );
                        }else {
                            consoleColors.RED("Wrong id!");
                        }
                    }
                }
            }
            catch (NumberFormatException e){
                consoleColors.RED("Error! It looks like you're trying to enter non-number.");
            }
            catch (SQLException e) {
                consoleColors.RED("Database error! " + e);
            }
        }
    }



}
