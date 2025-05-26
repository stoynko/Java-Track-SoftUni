package F_SpringData.A_DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.*;
import java.util.stream.*;

public class E07_IncreaseMinionsAge {

/*Read from the console minion IDs, separated by space. Increment the age of those minions by 1 and make their names titles lower case.
Finally, print the names and the ages of all minions that are in the database.*/

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        List<Integer> minionsID = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        Properties properties = new Properties();
        String user = "root";
        String password = "";
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        String parameter = String.join(",", Collections.nCopies(minionsID.size(), "?"));
        PreparedStatement updateStatement = connection.prepareStatement("UPDATE minions SET name = LOWER(name), age = age + 1 " +
                                                                            "WHERE id IN (" + parameter + ");");
        for (int i = 0; i < minionsID.size(); i++) {
            updateStatement.setInt(i + 1, minionsID.get(i));
        }
        updateStatement.executeUpdate();

        PreparedStatement getStatement = connection.prepareStatement("SELECT name, age FROM minions");
        ResultSet resultSet = getStatement.executeQuery();
        while (resultSet.next()) {
            String minionName = resultSet.getString("name");
            int minionAge = resultSet.getInt("age");
            System.out.printf("%s %d\n", minionName, minionAge);
        }
    }
}
