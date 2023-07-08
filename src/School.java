import java.util.ArrayList;

public class School {
    private double revenue;
    private double expenses;
    private ArrayList<Teacher> list_of_teachers = new ArrayList<>();


//    public void addTeacher(String id, String name, String sex, String post, int age, int experience, double salary){
//        teacher.setId(id);
//        teacher.setName(name);
//        teacher.setSex(sex);
//        teacher.setPost(post);
//        teacher.setAge(age);
//        teacher.setExperience(experience);
//        teacher.setSalary(salary);
//    }


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
