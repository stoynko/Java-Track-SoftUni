package F_SpringData.B_ORMFundamentals.orm.config;

import java.sql.*;

public class Connector {

    private static final String CONNECTION_PATH = "jdbc:mysql://localhost:3306/%s";
    private static Connection connection;

    private Connector() {
    }

    public static void createConnection(String username, String password, String dbName) throws SQLException {
        connection = DriverManager.getConnection(String.format(CONNECTION_PATH, dbName), username, password);
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