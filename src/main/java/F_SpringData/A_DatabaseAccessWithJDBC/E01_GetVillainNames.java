package F_SpringData.A_DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.*;

public class E01_GetVillainNames {

/* Write a program that prints on the console all villains’ names and their number of minions.
Get only the villains who have more than 15 minions.
Order them by a number of minions in descending order.*/

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Properties properties = new Properties();
        String user = "root";
        String password = "";
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
        System.out.println();

        PreparedStatement statement = connection.prepareStatement("SELECT v.name, COUNT(*) AS 'number_of_minions'\n" +
                                                                      "FROM minions_villains AS mv\n" +
                                                                      "JOIN minions AS m on mv.minion_id = m.id\n" +
                                                                      "JOIN villains AS v ON mv.villain_id = v.id\n" +
                                                                      "GROUP BY v.name\n" +
                                                                      "HAVING number_of_minions > 15\n" +
                                                                      "ORDER BY number_of_minions DESC;");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String villainName = resultSet.getString("v.name");
            int numberOfMinions = resultSet.getInt("number_of_minions");
            System.out.printf("%s %d\n", villainName, numberOfMinions);
        }
        connection.close();
    }
}
