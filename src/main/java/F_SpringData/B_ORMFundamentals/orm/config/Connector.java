package F_SpringData.B_ORMFundamentals.orm.config;

import F_SpringData.B_ORMFundamentals.common.*;

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



/*private static final String CONNECTION_PATH = "jdbc:mysql://localhost:3306/%s";
    private static Connector instance;
    private Connection connection;

    private Connector(String username, String password, String dbName) {
        try {
            String path = String.format(CONNECTION_PATH, dbName);
            this.connection = DriverManager.getConnection(path, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("Could not establish connection with " + dbName + " DB.", e);
        }
    }

    public static Connector getInstance(String username, String password, String dbName) {
        if (instance == null) {
            instance = new Connector(username, password, dbName);
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}*/