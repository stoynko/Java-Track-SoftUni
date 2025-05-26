package F_SpringData.A_DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.*;

public class L01_AccessingDatabase {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Properties props = new Properties();

        String user = "root";
        String password = "";
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni", props);

        PreparedStatement statement =
                connection.prepareStatement("SELECT w* FROM employees WHERE salary > ?");

        String salaryInput = scanner.nextLine();
        statement.setDouble(1, Double.parseDouble(salaryInput));
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            System.out.printf("%s %s\n", firstName, lastName);
        }
        connection.close();
    }
}
