package F_SpringData.A_DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.*;
import java.util.stream.*;

public class E08_IncreaseAgeStoredProcedure {

/* Create a stored procedure usp_get_older (directly in the database using MySQL Workbench or any other similar tool) that receives a minion_id
and increases the minion’s years by 1. Write a program that uses that stored procedure to increase the age of a minion,
whose id will be given as input from the console. After that print the name and the age of that minion.*/

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();
        String user = "root";
        String password = "";
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
        int minionID = Integer.parseInt(scanner.nextLine());

        PreparedStatement statement = connection.prepareCall("CALL usp_get_older(?);");
        statement.setInt(1, minionID);
        statement.executeUpdate();

        PreparedStatement getStatement = connection.prepareStatement("SELECT name, age FROM minions WHERE id = ?");
        getStatement.setInt(1, minionID);
        ResultSet resultSet = getStatement.executeQuery();
        while (resultSet.next()) {
            String minionName = resultSet.getString("name");
            int minionAge = resultSet.getInt("age");
            System.out.printf("%s %d", minionName, minionAge);
        }
    }
}
