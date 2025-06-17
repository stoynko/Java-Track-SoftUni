import java.sql.*;
import java.util.*;

public class E05_RemoveVillain {

/*Write a program that receives an ID of a villain, deletes him from the database and releases his minions from serving him.
As an output print the name of the villain and the number of minions released.
Make sure all operations go as planned, otherwise do not make any changes to the database. For the output use the format given in the examples.*/

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        Properties properties = new Properties();
        String user = "root";
        String password = "";
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);
        int villainID = Integer.parseInt(scanner.nextLine());
        String villainName = getVillainName(villainID, connection);
        if (villainName.isEmpty()) {
            System.out.println("No such villain was found");
        }
        int minionsForVillain = getMinionsForVillain(villainID, connection);
        connection.setAutoCommit(false);

        try {
            PreparedStatement deleteFromMinionsVillains = connection.prepareStatement("DELETE FROM minions_villains WHERE villain_id = ?");
            deleteFromMinionsVillains.setInt(1, villainID);
            deleteFromMinionsVillains.executeUpdate();
            PreparedStatement deleteVillain = connection.prepareStatement("DELETE FROM villains WHERE id = ?");
            deleteVillain.setInt(1, villainID);
            deleteVillain.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        }
        connection.close();
        System.out.printf("%s was deleted\n", villainName);
        System.out.printf("%d minions released\n", minionsForVillain);
    }

    private static int getMinionsForVillain(int villainID, Connection connection) throws SQLException {
        PreparedStatement getVillainMinions = connection.prepareStatement("SELECT mv.minion_id FROM minions_villains AS mv WHERE mv.villain_id = ?");
        getVillainMinions.setInt(1, villainID);
        ResultSet villainMinions = getVillainMinions.executeQuery();
        List<Integer> minionsIDs = new ArrayList<>();
        while (villainMinions.next()) {
            minionsIDs.add(villainMinions.getInt(1));
        }
        return minionsIDs.size();
    }

    private static String getVillainName(int villainId, Connection connection) throws SQLException {
        PreparedStatement getVillainStatement = connection.prepareStatement("SELECT id, name FROM villains WHERE id = ?");
        getVillainStatement.setInt(1, villainId);
        ResultSet villainResult = getVillainStatement.executeQuery();
        if (!villainResult.next()) {
            return "";
        } else {
            return villainResult.getString("name");
        }
    }
}
