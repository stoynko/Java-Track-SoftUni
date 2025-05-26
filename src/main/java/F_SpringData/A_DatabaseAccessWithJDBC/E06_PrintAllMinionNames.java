package F_SpringData.A_DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.*;

public class E06_PrintAllMinionNames {

/*Write a program that prints all minion names from the minion’s table in order first record, last record,
first + 1, last – 1, first + 2, last – 2… first + n, last – n. */

    public static void main(String[] args) throws SQLException {

        Properties properties = new Properties();
        String user = "root";
        String password = "";
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement statement = connection.prepareStatement("SELECT name FROM minions");
        ResultSet minionsData = statement.executeQuery();
        List<String> minionsList = new ArrayList<>();
        while (minionsData.next()) {
            minionsList.add(minionsData.getString("name"));
        }
        List<String> sortedMinions = new ArrayList<>();
        int startIndex = 0;
        int endIndex = minionsList.size();
        while (sortedMinions.size() != minionsList.size()) {
            sortedMinions.add(minionsList.get(startIndex++));
            sortedMinions.add(minionsList.get(--endIndex));
        }

        for (String minionName : sortedMinions) {
            System.out.println(minionName);
        }
    }
}
