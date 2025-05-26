package F_SpringData.A_DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.*;

public class E02_GetMinionNames {

/* Write a program that prints on the console all minion names and their age for a given villain id. For the output, use the formats given in the examples.*/

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Properties properties = new Properties();
        String user = "root";
        String password = "";
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement minionsStatement = connection.prepareStatement("SELECT m.name AS 'minion_name', m.age AS 'minion_age'\n" +
                                                                             "FROM minions_villains AS mv\n" +
                                                                             "JOIN minions m on m.id = mv.minion_id\n" +
                                                                             "JOIN villains v on mv.villain_id = v.id\n" +
                                                                             "WHERE v.id = ?;\n");
        PreparedStatement villainStatement = connection.prepareStatement("SELECT v.name AS \"villain_name\"\n" +
                                                                             "FROM villains AS v\n" +
                                                                             "WHERE v.id = ?");
        String userInput = scanner.nextLine();
        minionsStatement.setInt(1, Integer.parseInt(userInput));
        villainStatement.setInt(1, Integer.parseInt(userInput));
        ResultSet resultSetVillain = villainStatement.executeQuery();
        ResultSet resultSetMinions = minionsStatement.executeQuery();

        if (!resultSetVillain.next()) {
            System.out.printf("No villain with ID %s exists in the database.", userInput);
        } else {
            String villainName = resultSetVillain.getString("villain_name");
            System.out.printf("Villain: %s\n", villainName);
            int counter = 0;
            resultSetMinions.next();
            do {
                String minionName = resultSetMinions.getString("minion_name");
                int minionAge = resultSetMinions.getInt("minion_age");
                ++counter;
                System.out.printf("%d. %s %d\n", counter, minionName, minionAge);
            } while (resultSetMinions.next());
        }
        connection.close();
    }
}
