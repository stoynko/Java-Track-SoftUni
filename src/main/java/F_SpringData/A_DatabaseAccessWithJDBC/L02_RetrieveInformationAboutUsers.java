package F_SpringData.A_DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.*;

public class L02_RetrieveInformationAboutUsers {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Properties props = new Properties();

        String user = "root";
        String password = "";
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);

        PreparedStatement statement =
                connection.prepareStatement("SELECT user_name,\n" +
                                                "CONCAT(first_name, ' ', last_name) AS full_name,\n" +
                                                "COUNT(*) AS played_games\n" +
                                                "FROM users\n" +
                                                "JOIN users_games ON users.id = users_games.user_id\n" +
                                                "WHERE user_name = ?\n" +
                                                "GROUP BY user_name, first_name, last_name");

        String userInput = scanner.nextLine();
        statement.setString(1, userInput);
        ResultSet resultSet = statement.executeQuery();
        if (!resultSet.next()) {
            System.out.println("No such user exists");
        } else {
            do {
                String userName = resultSet.getString("user_name");
                String fullName = resultSet.getString("full_name");
                int gamesPlayed = resultSet.getInt("played_games");
                System.out.printf("User: %s\n", userName);
                System.out.printf("%s has played %d games\n", fullName, gamesPlayed);
            } while (resultSet.next());
        }
        connection.close();
    }
}
