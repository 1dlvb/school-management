abstract public class Person {
    private int id;
    private String name;
    private String gender;
    private int age;
    private String post;

    // Getters

    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public String getGender(){
        return gender;
    }
    public int getAge(){
        return this.age;
    }
    public String getPost(){
        return post;
    }


    // Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setPost(String post){
        this.post = post;
    }

    @Override
    public String toString() {
        return "id=" + id + "\n" +
                "name=" + name + "\n" +
                "gender=" + gender + "\n" +
                "age=" + age + "\n" +
                "post=" + post + "\n";
    }
}

class Teacher extends Person {
    private double salary;
    private int experience;

    //  Getters
    public double getSalary(){
        return salary;
    }
    public int getExperience(){
        return experience;
    }

    //  Setters
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setExperience(int experience){
        this.experience = experience;
    }

    @Override
    public String toString() {
        return super.toString() + "salary=" + salary + "\n" +
                                    "experience=" + experience + "\n";
    }
}

class Student extends Person {
    private int grade;
    private double avg_mark;
    private double fees;
    private double total_fees;

    // Getters
    public int getGrade(){
        return grade;
    }
    public double getAvg_mark(){
        return avg_mark;
    }
    public double getFees(){
        return fees;
    }
    public double getTotal_fees(){
        return total_fees;
    }

    // Setters
    public void setGrade(int grade){
        this.grade = grade;
    }
    public void setAvg_mark(double avg_mark){
        this.avg_mark = avg_mark;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public void setTotal_fees(double total_fees) {
        this.total_fees = total_fees;
    }

    @Override
    public String toString() {
        return  "grade=" + grade + "\n" +
                "avg_mark=" + avg_mark + "\n" +
                "fees=" + fees + "\n" +
                "total_fees=" + total_fees + "\n";
    }
}