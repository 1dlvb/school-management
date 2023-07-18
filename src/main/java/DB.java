import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DB {
    private String username;
    private String password;
    private String connectionUrl;

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
    public  void setData(List<? extends Person> list) throws SQLException {
        Connection conn = connect();
        String sql = "";
        Object entity = list.get(list.size() - 1);
//        System.out.println(entity.toString());

        switch (entity.getClass().getName()){
            case ("Teacher") -> {
                Teacher person = (Teacher) entity;
                sql = "INSERT into teachers (name, gender, age, salary, experience, post) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
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
                PreparedStatement statement = conn.prepareStatement(sql);
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

//        System.out.println(person.getId());
//        System.out.println(person.getName());
//        System.out.println(person.getAge());
//        System.out.println(person.getGender());

    }
}
