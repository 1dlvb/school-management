import java.util.ArrayList;

public class School {
    private double revenue;
    private double expenses;
    private ArrayList<Teacher> list_of_teachers = new ArrayList<>();


    public void addTeacher(){
        this.list_of_teachers.add(new Teacher());
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

}
