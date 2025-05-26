package F_SpringData.A_DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.*;

public class E04_ChangeTownNameCasing {

/* Write a program that changes all town names to uppercase for a given country.
Print the number of towns that were changed in the format provided in the examples. On the next line print the names that were changed,
separated by a coma and a space. */

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Properties properties = new Properties();
        String user = "root";
        String password = "";
        String userInput = scanner.nextLine();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
        PreparedStatement modifyTownNames = connection.prepareStatement("UPDATE towns SET name = UPPER(name) WHERE country = ?;");
        modifyTownNames.setString(1, userInput);
        int affectedEntries = modifyTownNames.executeUpdate();

        PreparedStatement getTownNames = connection.prepareStatement("SELECT name FROM towns WHERE country = ?");
        getTownNames.setString(1, userInput);
        ResultSet townNames = getTownNames.executeQuery();
        List<String> modifiedTownNames = new ArrayList<>();

        while (townNames.next()) {
            modifiedTownNames.add(townNames.getString("name"));
        }

        if (affectedEntries > 0) {
            System.out.printf("%d town names were affected.\n", affectedEntries);
            System.out.println(modifiedTownNames);
        } else {
            System.out.println("No town names were affected.");
        }
    }
}