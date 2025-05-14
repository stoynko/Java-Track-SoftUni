package F_SpringData.A_DatabaseAccessWithJDBC;

import java.sql.*;
import java.util.*;

public class E01_GetVillainNames {
/*Write a program that prints on the console all villains’ names and their number of minions.
Get only the villains who have more than 15 minions.
Order them by a number of minions in descending order.*/

    public static void main(String[] args) throws SQLException {


        Scanner scanner = new Scanner(System.in);
        Properties properties = new Properties();
        String user = "root";
        String password = "";
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions", properties);
        System.out.println();
    }
}
