package orm.config;

import common.*;

import java.sql.*;

public class Connector {

    private static final String ROOT_PATH = "jdbc:mysql://localhost:3306/?serverTimezone=UTC";
    private static final String CONNECTION_PATH = "jdbc:mysql://localhost:3306/%s?serverTimezone=UTC";
    private static Connection connection;

    private Connector() {
    }

    public static void createConnection(String username, String password, String dbName) throws SQLException {
        try {
            connection = DriverManager.getConnection(String.format(CONNECTION_PATH, dbName), username, password);
        } catch (SQLException e) {
            if (e.getErrorCode() == 1049) {
                Connection rootConnection = DriverManager.getConnection(ROOT_PATH, username, password);
                Statement createStatement = rootConnection.createStatement();
                createStatement.executeUpdate((String.format(SQLCommands.CREATE_DB_STATEMENT, dbName)));
                createStatement.close();
                rootConnection.close();
                connection = DriverManager.getConnection(String.format(CONNECTION_PATH, dbName), username, password);
            } else {
                throw e;
            }
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}