import java.util.Scanner;

abstract public class Person {
    ConsoleColors consoleColors = new ConsoleColors();
    Scanner scanner = new Scanner(System.in);

    private int id;
    private String name;
    private String gender;
    private int age;

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

    // Enter section
    public String enterName(){
        return scanner.nextLine();
    }

    // Checks the correctness of the entered gender and sets it for the corresponding object.
    public String enterGender() {
        String gender = "";

        // checking the correctness of gender input
        while (true) {
            gender = scanner.nextLine();
            gender = checkGender(gender);

            if (!gender.equalsIgnoreCase("error")) {
                return gender;
            } else {
                consoleColors.RED("Wrong gender type!");
            }

        }
    }

    // Checks the correctness of the entered age and sets it for the corresponding object.
    public int enterAge(int lower_limit, int upper_limit) {
        while (true) {
            String age = scanner.nextLine();
            if (checkAge(age, lower_limit, upper_limit)){
                return Integer.parseInt(age);
            }
            else{
                consoleColors.RED(String.format("Attention! The age can be from %d to %d inclusive! Age must be a numeric value.",
                        lower_limit, upper_limit));
            }

        }
    }

    // methods that checks correctness of entered data.
    //TODO: rework checkGender
    public String checkGender(String gender){
        if (gender.equalsIgnoreCase("m")){
            return "Male";
        } else if (gender.equalsIgnoreCase("f")) {
            return "Female";
        }
        else{
            return "Error";
        }
    }
    public boolean checkAge(String age, int lower_limit, int upper_limit){
        try {
            if (Integer.parseInt(age) < lower_limit || Integer.parseInt(age) > upper_limit) {
                return false;
            }
            else
            {
                return true;
            }

        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "name: " + name + "\n" +
                "gender: " + gender + "\n" +
                "age: " + age + " years old\n";
    }


}

class Teacher extends Person {
    private double salary;
    private int experience;
    private String post;


    //  Getters
    public double getSalary(){
        return salary;
    }
    public int getExperience(){
        return experience;
    }
    public String getPost() {
        return post;
    }

    //  Setters
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setExperience(int experience){
        this.experience = experience;
    }

    public void setPost(String post) {
        this.post = post;
    }

    // Enter section
    public String enterPost(){
        return scanner.nextLine();
    }
    // Checks the correctness of the entered salary and sets it for the teacher object.
    public double enterSalary(){
        while(true){
            String salary = scanner.nextLine();
            if (checkSalary(salary)){
                return Double.parseDouble(salary);
            }
            else {
                consoleColors.RED("Invalid data type for salary!");
            }
        }
    }
    public int enterExperience(){
        while (true){
            String experience = scanner.nextLine();
            if (checkExperience(experience, this.getAge())){
                return Integer.parseInt(experience);
            }
            else {
                consoleColors.RED(String.format("Attention! Experience must be less than or equal to %d years. Experience" +
                        " must be numeric value.", this.getAge() - 12));

            }

        }
    }

    public boolean checkSalary(String salary){
        try {
            if(Double.parseDouble(salary) >= 0){
                return true;
            }
            else {
                return false;
            }
        }
        catch (NumberFormatException e){
            return false;
        }
    }
    public boolean checkExperience(String experience, int age){
        try{
            if (Integer.parseInt(experience) < 0 || age - Integer.parseInt(experience) < 12){
                return false;
            }
            else {
                return true;
            }
        }
        catch (NumberFormatException e){
            return false;
        }
    }
    @Override
    public String toString() {
        return super.toString() +
                "salary: " + salary + "₽\n" +
                "experience: " + experience + " years\n" +
                "post: " + post + "\n";

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

    //enter section
    public int enterGrade(){
        while(true){
            String grade = scanner.nextLine();
            if(checkGrade(grade)){
                return Integer.parseInt(grade);
            }
            else {
                consoleColors.RED("Attention! The grade must be from 1 to 11 inclusive. Grade must be a numeric value.");
            }

        }
    }

    public double enterAvg_mark(){
        while (true){
            String avg_mark = scanner.nextLine();
            if (checkAvg_mark(avg_mark)){
                return Double.parseDouble(avg_mark);
            }
            else {
                consoleColors.RED("Attention! Average mark must be from 0 to 5 inclusive! Average mark must be numeric value.");
            }

        }
    }
    public double enterFees(){
        while (true){
            String fees = scanner.nextLine();
            if (checkFees(fees)){
                return Double.parseDouble(fees);
            }
            else {
                consoleColors.RED("Attention! Fees must be greater than or equals to 0. Fees must be numeric value.");
            }
        }
    }

    // methods that checks correctness of entered data.
    public boolean checkGrade(String grade){
        try {
            if (Integer.parseInt(grade) >= 1 && Integer.parseInt(grade) <= 11){
                return true;
            }
            else{
                return false;
            }
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    public boolean checkAvg_mark(String avg_mark){
        try {
            if (Double.parseDouble(avg_mark) < 0 || Double.parseDouble(avg_mark) > 5){
                return false;
            }
            else{
                return true;
            }
        }
        catch (NumberFormatException e){
            return false;
        }
    }
    public boolean checkFees(String fees){
        try {
            if (Double.parseDouble(fees) < 0){
                return false;
            }
            else {
                return true;
            }
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() +  "grade: " + grade + "\n" +
                "avg_mark: " + avg_mark + "\n" +
                "fees: " + fees + "₽\n" +
                "total_fees: " + total_fees + "₽\n";
    }
}