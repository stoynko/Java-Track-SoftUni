package F_SpringData.A_DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.*;

public class E03_AddMinion {

/*Write a program that reads information about a minion and its villain and adds it to the database. In case the town of the minion is not in the database, insert it as well.
In case the villain is not present in the database, add him too with the default evilness factor of "evil". Finally, set the new minion to be a servant of the villain.
Print appropriate messages after each operation – see the examples. */

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Properties properties = new Properties();
        String user = "root";
        String password = "";
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        List<String> inputData = processInputData(scanner);
        String minionName = inputData.get(0);
        int minionAge = Integer.parseInt(inputData.get(1));
        String townName = inputData.get(2);
        String villainName = inputData.get(3);

        int townID = getIDFromDB(connection, "towns", townName);

        if (townID == 0) {
            String sqlQuery = "INSERT INTO towns(name) VALUES (?);";
            townID = executeInsertion(connection, sqlQuery, "towns", townName);
            System.out.printf("Town %s was added to the database.\n", townName);
        }

        int villainID = getIDFromDB(connection, "villains", villainName);

        if (villainID == 0) {
            String sqlQuery = "INSERT INTO villains (name, evilness_factor) VALUES (?, 'evil');";
            villainID = executeInsertion(connection, sqlQuery, "villains", villainName);
            System.out.printf("Villain %s was added to the database.\n", villainName);
        }

        String sqlQuery = "INSERT INTO minions (name, age, town_id) VALUES (?, ?, ?);";
        int minionID = executeInsertion(connection, sqlQuery, "minions", minionName, String.valueOf(minionAge), String.valueOf(townID));

        sqlQuery = "INSERT INTO minions_villains (minion_id, villain_id) VALUES (?, ?)";
        int output = executeInsertion(connection, sqlQuery, "minions_villains", String.valueOf(minionID), String.valueOf(villainID));
        System.out.printf("Successfully added %s to be minion of %s.\n", minionName, villainName);
        connection.close();
    }

    private static List<String> processInputData(Scanner scanner) {
        String[] arr = scanner.nextLine().split(":")[1].split(" ");
        String minionName = arr[1].trim();
        int minionAge = Integer.parseInt(arr[2].trim());
        String townName = arr[3].trim();
        String villainName = scanner.nextLine().split(":")[1].trim();
        return List.of(minionName, String.valueOf(minionAge), townName, villainName);
    }

    private static int getIDFromDB(Connection connection, String dbTable, String comparable) throws SQLException {
        PreparedStatement retrievalStatement = connection.prepareStatement("SELECT * FROM " + dbTable);
        ResultSet resultSet = retrievalStatement.executeQuery();
        int resultID = 0;

        while (resultSet.next()) {
            String retrievedName = resultSet.getString("name");
            if (comparable.equals(retrievedName)) {
                resultID = resultSet.getInt("id");
                break;
            }
        }
        return resultID;
    }

    private static int executeInsertion(Connection connection, String sqlQuery, String dbTable, String... data) throws SQLException {
        PreparedStatement insertionStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
        if (data.length == 3 ) {
            insertionStatement.setString(1, data[0]);
            insertionStatement.setInt(2, Integer.parseInt(data[1]));
            insertionStatement.setInt(3, Integer.parseInt(data[2]));
        } else if (data.length == 2) {
            insertionStatement.setInt(1, Integer.parseInt(data[0]));
            insertionStatement.setInt(2, Integer.parseInt(data[1]));
        } else {
            insertionStatement.setString(1, data[0]);
        }

        insertionStatement.executeUpdate();
        ResultSet keys = insertionStatement.getGeneratedKeys();
        if (keys.next()) {
            return keys.getInt(1);
        }
        return 0;
    }
}
