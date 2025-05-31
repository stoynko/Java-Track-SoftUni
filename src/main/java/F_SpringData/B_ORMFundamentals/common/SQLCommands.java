package F_SpringData.B_ORMFundamentals.common;

public class SQLCommands {

    public static final String CREATE_DB_STATEMENT = "CREATE DATABASE %s";
    public static final String CREATE_TABLE_STATEMENT = "CREATE TABLE %s (%s)";
    public static final String ALTER_TABLE_STATEMENT = "ALTER TABLE %s";
    public static final String ALTER_TABLE_INSERT_COLUMN = "ADD COLUMN %s";
    public static final String SELECT_INFORMATION_SCHEMA = "SELECT * FROM information_schema.TABLES WHERE TABLES.TABLE_SCHEMA = '%s' AND TABLE_NAME = '%s'";
    public static final String SELECT_COLUMNS_FROM_SCHEMA = "SELECT COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '%s' AND TABLE_NAME = '%s'";
    public static final String INSERT_STATEMENT = "INSERT INTO %s (%s) VALUES (%s)";
    public static final String SELECT_SINGLE_STATEMENT = "SELECT * FROM %s %s";
    public static final String UPDATE_STATEMENT = "UPDATE %s SET %s WHERE id = %d";
}
