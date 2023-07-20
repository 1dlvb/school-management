import java.sql.*;
import java.util.*;

public class DB {
    private final String username;
    private final String password;
    private final String connectionUrl;

    public DB(String connectionUrl, String username, String password){
        this.connectionUrl = connectionUrl;
        this.username = username;
        this.password = password;
    }
    private Connection connect(){
        try{
            return DriverManager.getConnection(connectionUrl, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // sends entity's data to the database
    public  void setData(List<? extends Person> list) throws SQLException {
        Connection connection = connect();
        String sql;
        Object entity = list.get(list.size() - 1);

        switch (entity.getClass().getName()){
            case ("Teacher") -> {
                Teacher person = (Teacher) entity;
                sql = "INSERT into teachers (name, gender, age, salary, experience, post) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                try{
                    statement.setString(1, person.getName());
                    statement.setString(2, person.getGender());
                    statement.setInt(3, person.getAge());
                    statement.setDouble(4, person.getSalary());
                    statement.setInt(5, person.getExperience());
                    statement.setString(6, person.getPost());

                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0){
                        System.out.println("Success!");
                    }
                    else{
                        System.out.println("Error!");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            case ("Student") -> {
                Student person = (Student) entity;
                sql = "INSERT into students (name, gender, age, grade, average_mark, fees, total_fees) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                try{
                    statement.setString(1, person.getName());
                    statement.setString(2, person.getGender());
                    statement.setInt(3, person.getAge());
                    statement.setInt(4, person.getGrade());
                    statement.setDouble(5, person.getAvg_mark());
                    statement.setDouble(6, person.getFees());
                    statement.setDouble(7, person.getTotal_fees());

                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0){
                        System.out.println("Success!");
                    }
                    else{
                        System.out.println("Error!");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

    // returns entity's data from the database
    public ArrayList<String> getDataPreviewFromDB(String entities) throws SQLException {
        Connection connection = connect();
        ArrayList<String> output = new ArrayList<>();

        String sql = String.format("SELECT * FROM %s", entities.toLowerCase());
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);

            output.add(String.format("%d %s", id, name));
        }
        return output;
    }
    public Map<String, String> getDataByID(String entity, int id) throws SQLException{
        Connection connection = connect();
        Map<String, String> data = new HashMap<>();

        String sql = String.format("SELECT * FROM %s WHERE id='%d'", entity+"s", id);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (entity.equalsIgnoreCase("teacher")){
            while(resultSet.next()){
                data.put("id", String.valueOf(resultSet.getInt(1)));
                data.put("name", resultSet.getString(2));
                data.put("gender", resultSet.getString(3));
                data.put("age", String.valueOf(resultSet.getInt(4)));
                data.put("salary", String.valueOf(resultSet.getDouble(5)));
                data.put("experience", String.valueOf(resultSet.getInt(6)));
                data.put("post", String.valueOf(resultSet.getString(7)));

            }
        } else if (entity.equalsIgnoreCase("student")) {
            while(resultSet.next()){
                data.put("id", String.valueOf(resultSet.getInt(1)));
                data.put("name", resultSet.getString(2));
                data.put("gender", resultSet.getString(3));
                data.put("age", String.valueOf(resultSet.getInt(4)));
                data.put("grade", String.valueOf(resultSet.getInt(5)));
                data.put("average_mark", String.valueOf(resultSet.getDouble(6)));
                data.put("fees", String.valueOf(resultSet.getDouble(7)));
                data.put("total_fees", String.valueOf(resultSet.getDouble(8)));
            }
        }
        return data;
    }
    // returns a list of teachers from database
    public ArrayList<Teacher> setListOfTeachers() throws SQLException {
        Connection connection = connect();
        ArrayList<Teacher> output = new ArrayList<>();

        String sql = "SELECT * FROM teachers";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            Teacher teacher = new  Teacher();
            teacher.setId(resultSet.getInt(1));
            teacher.setName(resultSet.getString(2));
            teacher.setGender(resultSet.getString(3));
            teacher.setAge(resultSet.getInt(4));
            teacher.setSalary(resultSet.getDouble(5));
            teacher.setExperience(resultSet.getInt(6));
            teacher.setPost(resultSet.getString(7));

            output.add(teacher);

        }
        System.out.println(output);
        return output;
    }

    // returns a list of students from database
    public ArrayList<Student> setListOfStudents() throws SQLException {
        Connection connection = connect();
        ArrayList<Student> output = new ArrayList<>();

        String sql = "SELECT * FROM students";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            Student student = new Student();
            student.setId(resultSet.getInt(1));
            student.setName(resultSet.getString(2));
            student.setGender(resultSet.getString(3));
            student.setAge(resultSet.getInt(4));
            student.setGrade(resultSet.getInt(5));
            student.setAvg_mark(resultSet.getDouble(6));
            student.setFees(resultSet.getDouble(7));
            student.setTotal_fees(resultSet.getDouble(8));

            output.add(student);

        }
        System.out.println(output);
        return output;
    }


}

