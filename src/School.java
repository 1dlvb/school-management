import java.util.ArrayList;
import java.util.Scanner;

public class School {
    private double revenue;
    private double expenses;
    private ArrayList<Teacher> list_of_teachers = new ArrayList<>();
    private ArrayList<Student> list_of_students = new ArrayList<>();
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
    public void getData(String entity) {
        System.out.println();
        System.out.println(entity.toUpperCase() + "S: ");  // shows a list of all teachers in the console
        if (entity.equalsIgnoreCase("teacher")){
            for (Teacher teacher: this.getList_of_teachers()){
                System.out.println("| " + teacher.getId() + " | " + teacher.getName() + " |");
            }
        } else if (entity.equalsIgnoreCase("student")) {
            for (Student student: this.getList_of_students()){
                System.out.println("| " + student.getId() + " | " + student.getName() + " |");
            }
        }


        System.out.println();
        System.out.printf("Type %s's id to see more information: ", entity.toLowerCase());
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
                        System.out.println(this.getList_of_teachers().get(Integer.parseInt(selected_entity_id) - 1).toString());
                    }
                    else if(entity.equalsIgnoreCase("student")){
                        System.out.println(this.getList_of_students().get(Integer.parseInt(selected_entity_id) - 1).toString());
                    }
                }
            }
            catch (NumberFormatException | IndexOutOfBoundsException e){
                consoleColors.RED("Wrong id!");
            }
        }
    }



}
