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
    public void enterName(){
        this.setName(scanner.nextLine());
    }

    // Checks the correctness of the entered gender and sets it for the corresponding object.
    public void enterGender(){
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
                consoleColors.RED("Wrong gender type!");
            }
        }
        this.setGender(gender);
    }

    // Checks the correctness of the entered age and sets it for the corresponding object.
    public void enterAge(int lower_limit, int upper_limit) {
        while (true) {
            try {
                int age = Integer.parseInt(scanner.nextLine());
                if (age < lower_limit || age > upper_limit) {
                    consoleColors.RED(String.format("Attention! The age can be from %d to %d inclusive!", lower_limit, upper_limit));
                }
                else
                {
                    this.setAge(age);
                    break;
                }

            } catch (NumberFormatException e) {
                consoleColors.RED("Invalid data type for age!");
            }
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
    public void enterPost(){
        this.setPost(scanner.nextLine());
    }
    // Checks the correctness of the entered salary and sets it for the teacher object.
    public void enterSalary(){
        while(true){
            try {
                this.setSalary(Double.parseDouble(scanner.nextLine()));
                break;
            }
            catch (NumberFormatException e){
                consoleColors.RED("Invalid data type for salary!");
            }

        }
    }
    public void enterExperience(){
        while (true){
            try{
                int experience = Integer.parseInt(scanner.nextLine());
                if (experience >= this.getAge()){
                    consoleColors.RED("Attention! Experience cannot be greater than or equal to age.");
                }
                else {
                    this.setExperience(experience);
                    break;
                }
            }
            catch (NumberFormatException e){
                consoleColors.RED("Wrong data type for experience!");
            }
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
    public void enterGrade(){
        while(true){
            try {
                grade = Integer.parseInt(scanner.nextLine());
                if (grade >= 1 && grade <= 11){
                    this.setGrade(grade);
                    break;
                }
                else{
                    consoleColors.RED("Attention! The grade must be from 1 to 11 inclusive.");
                }
            }
            catch (NumberFormatException e){
                consoleColors.RED("Wrong data type for grade!");
            }
        }
    }

    public void enterAvg_mark(){
        while (true){
            try {
                avg_mark = Double.parseDouble(scanner.nextLine());
                if (avg_mark < 0 || avg_mark > 5){
                    consoleColors.RED("Attention! Average mark must be from 0 to 5 inclusive!");
                }
                else{
                    this.setAvg_mark(avg_mark);
                    break;
                }
            }
            catch (NumberFormatException e){
                consoleColors.RED("Wrong data type for average mark!");
            }
        }
    }
    public void enterFees(){
        while (true){
            try {
                fees = Double.parseDouble(scanner.nextLine());
                if (fees < 0){
                    consoleColors.RED("Attention! Fees must be greater than or equals to 0.");
                }
                else {
                    this.setFees(fees);
                    this.setTotal_fees(getTotal_fees() + fees);
                    break;
                }
            }
            catch (NumberFormatException e){
                consoleColors.RED("Wrong data type for fees!");
            }
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