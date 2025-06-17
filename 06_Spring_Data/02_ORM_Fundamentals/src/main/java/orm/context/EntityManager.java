package orm.context;

import common.*;
import jakarta.persistence.*;


import java.lang.reflect.*;
import java.sql.*;
import java.time.*;
import java.util.*;

public class EntityManager<E> implements DBcontext<E> {

    private final Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    public void createTable(Class<E> entity) throws SQLException {
        try {
            String tableName = getTableName(entity);
            String columnDefinitions = getColumnDefinitions(entity);
            String createTableSQL = String.format(SQLCommands.CREATE_TABLE_STATEMENT, tableName, columnDefinitions);
            connection.createStatement().executeUpdate(createTableSQL);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void alterTable(Class<E> entity) throws SQLException {
        String tableName = getTableName(entity);
        List<String> newFields = getNewFieldDefinitions(entity);
        String sqlAlter = getSqlAlterCommand(tableName, newFields);
        connection.prepareStatement(sqlAlter).executeUpdate();
    }

    @Override
    public int delete(Class<E> entity, int id) throws SQLException {
        String tableName = getTableName(entity);
        String sqlWhere = String.format("id = %d", id);
        String sqlDelete = String.format(SQLCommands.DELETE_FROM_TABLE, tableName, sqlWhere);
        return connection.createStatement().executeUpdate(sqlDelete);
    }

    private String getSqlAlterCommand(String tableName, List<String> newFields) {
        StringBuilder sqlCommand = new StringBuilder();
        sqlCommand.append(String.format(SQLCommands.ALTER_TABLE_STATEMENT, tableName)).append(System.lineSeparator());
        Iterator<String> iterator = newFields.iterator();
        while (iterator.hasNext()) {
            String columnDefinition = iterator.next();
            sqlCommand.append(String.format(SQLCommands.ALTER_TABLE_INSERT_COLUMN, columnDefinition));
            if (iterator.hasNext()) {
                sqlCommand.append(",").append(System.lineSeparator());
            }
        }
        return sqlCommand.toString();
    }

    private List<String> getNewFieldDefinitions(Class<E> entity) throws SQLException {
        List<String> existingColumns = getExistingColumns(entity);
        List<String> newFields = new ArrayList<>();
        Arrays.stream(entity.getDeclaredFields()).filter(field -> Arrays.stream(field.getDeclaredAnnotations())
                        .anyMatch(annotation -> annotation.annotationType().equals(Column.class)))
                .forEach(field ->
                {
                    String fieldName = field.getAnnotation(Column.class).name();
                    String fieldType = getSqlTypeForField(field);
                    if (!existingColumns.contains(fieldName)) {
                        newFields.add(fieldName + " " + fieldType);
                    }
                });

        return newFields;
    }

    private List<String> getExistingColumns(Class<E> entity) throws SQLException {
        PreparedStatement getColumnsStatement = connection.prepareStatement(String.format(SQLCommands.SELECT_COLUMNS_FROM_SCHEMA, connection.getCatalog(), getTableName(entity)));
        ResultSet resultSet = getColumnsStatement.executeQuery();
        int i = 0;
        List<String> existingColumns = new ArrayList<>();
        while (resultSet.next()) {
            existingColumns.add(resultSet.getString("COLUMN_NAME"));
        }
        return existingColumns;
    }

    private boolean tableExists(Class<E> entity) throws SQLException {
        String tableName = entity.getAnnotation(Entity.class).name().toLowerCase();
        PreparedStatement checkStatement = connection.prepareStatement(String.format(SQLCommands.SELECT_INFORMATION_SCHEMA,
                connection.getCatalog(),
                tableName));
        ResultSet resultSet = checkStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println(String.format(ExceptionMessages.TABLE_EXISTS, tableName));
        }
        return false;
    }

    private String getColumnDefinitions(Class<E> entity) {
        List<String> columnDefinitions = new ArrayList<>();
        Arrays.stream(entity.getDeclaredFields()).forEach(field -> {
            if (Arrays.stream(field.getDeclaredAnnotations()).anyMatch(annotation -> annotation.annotationType() == Column.class)) {
                String sqlType = getSqlTypeForField(field);
                String columnName = field.getAnnotation(Column.class).name();
                columnDefinitions.add(String.format("%s %s", columnName, sqlType));
            } else if (Arrays.stream(field.getDeclaredAnnotations()).anyMatch(annotation -> annotation.annotationType() == Id.class)) {
                StringBuilder columnDefinition = new StringBuilder("id ");
                String sqlType = getSqlTypeForField(field);
                String addParam = "";
                if (sqlType.equals("INT")) {
                    addParam = " AUTO_INCREMENT";
                }
                columnDefinition.append(sqlType + " PRIMARY KEY" + addParam);
                columnDefinitions.add(columnDefinition.toString());
            }
        });
        return String.join(",", columnDefinitions);
    }

    private String getSqlTypeForField(Field field) {
        if (field.getType() == Integer.class || field.getType() == int.class) {
            return "INT";
        } else if (field.getType() == Double.class) {
            return "DECIMAL(19, 2)";
        } else if (field.getType() == String.class) {
            return "VARCHAR(255)";
        } else if (field.getType() == LocalDate.class) {
            return "DATE";
        } else if (field.getType() == Boolean.class) {
            return "BOOLEAN";
        }
        throw new IllegalArgumentException(String.format(ExceptionMessages.UNSUPPORTED_TYPE, field.getType()));
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        int entityID = getIDValue(entity);
        if (entityID == 0) {
            return insertData(entity);
        }
        return updateData(entity, entityID);
    }

    private boolean insertData(E entity) throws IllegalAccessException, SQLException {

        String tableName = getTableName(entity.getClass());
        List<String> columnNames = getEntityColumns(entity);
        List<String> columnValues = getEntityValues(entity);
        String insertSQL = String.format(SQLCommands.INSERT_STATEMENT, tableName, String.join(", ", columnNames), String.join(", ", columnValues));
        int updatedEntries = connection.prepareStatement(insertSQL).executeUpdate();
        return updatedEntries == 1;
    }

    private boolean updateData(E entity, int entityID) throws IllegalAccessException, SQLException {
        String tableName = getTableName(entity.getClass());
        List<String> columnNames = getEntityColumns(entity);
        List<String> columnValues = getEntityValues(entity);

        List<String> updatedDataPerColumn = new ArrayList<>();
        for (int i = 0; i < columnNames.size(); i++) {
            String formatted = String.format("%s=%s", columnNames.get(i), columnValues.get(i));
            updatedDataPerColumn.add(formatted);
        }

        String updateSQL = String.format(SQLCommands.UPDATE_STATEMENT, tableName, String.join(",", updatedDataPerColumn), entityID);
        int updatedEntries = connection.prepareStatement(updateSQL).executeUpdate();
        return updatedEntries == 1;
    }

    @Override
    public Iterable<E> find(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return find(table, null);
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String tableName = getTableName(table);
        String selectSingleSQL = String.format(SQLCommands.SELECT_SINGLE_STATEMENT,
                tableName,
                where == null ? "" : where);
        ResultSet resultSet = connection.prepareStatement(selectSingleSQL).executeQuery();
        List<E> resultList = new ArrayList<>();
        while (resultSet.next()) {
            resultList.add(mapEntity(table, resultSet));
        }
        return resultList;
    }

    @Override
    public E findFirst(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return findFirst(table, null);
    }

    @Override
    public E findFirst(Class<E> table, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String withLimit = where == null ? "LIMIT 1" : where + " LIMIT 1";
        Iterable<E> result = find(table, withLimit);
        if (!result.iterator().hasNext()) {
            return null;
        } else {
            return result.iterator().next();
        }
    }

    private E mapEntity(Class<E> type, ResultSet dbResult) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        E obj = type.getDeclaredConstructor().newInstance();

        for (Field field : type.getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class) || (field.isAnnotationPresent(Column.class))) {
                obj = mapField(obj, field, dbResult);
            }
        }
        return obj;
    }

    private E mapField(E obj, Field field, ResultSet dbResult) throws IllegalAccessException, SQLException {
        String column = "id";
        if (field.isAnnotationPresent(Column.class)) {
            column = field.getAnnotation(Column.class).name();
        }
        Object dbValue = mapValue(field, column, dbResult);
        field.setAccessible(true);
        field.set(obj, dbValue);
        return obj;
    }

    private Object mapValue(Field field, String column, ResultSet dbResult) throws SQLException {
        if (field.getType() == int.class || field.getType() == Integer.class) {
            return dbResult.getInt(column);
        } else if (field.getType() == Double.class) {
            return dbResult.getDouble(column);
        } else if (field.getType() == String.class) {
            return dbResult.getString(column);
        } else if (field.getType() == LocalDate.class) {
            String date = dbResult.getString(column);
            return LocalDate.parse(date);
        } else if (field.getType() == Boolean.class) {
            return dbResult.getBoolean(column);
        }
        throw new IllegalArgumentException(String.format(ExceptionMessages.UNSUPPORTED_TYPE, field.getType()));
    }

    private int getIDValue(E entity) throws IllegalAccessException {
        List<Field> idFields = Arrays.stream(entity.getClass().getDeclaredFields()).filter(field -> field.isAnnotationPresent(Id.class)).toList();
        if (idFields.size() != 1) {
            throw new IllegalArgumentException(ExceptionMessages.MISSING_INVALID_ENTITY_ID_FIELD);
        }
        Field idField = idFields.get(0);
        idField.setAccessible(true);
        return (int) idField.get(entity);
    }

    private List<String> getEntityValues(E entity) throws IllegalAccessException {
        List<String> entityValues = new ArrayList<>();
        for (Field field : entity.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Column.class)) {
                field.setAccessible(true);
                entityValues.add("'" + field.get(entity) + "'");
            }
        }
        return entityValues;
    }

    private List<String> getEntityColumns(E entity) {
        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class))
                .map(field -> field.getAnnotation(Column.class))
                .map(Column::name).toList();

    }

    private String getTableName(Class<?> clazz) {
        Entity annotation = clazz.getAnnotation(Entity.class);
        if (annotation == null) {
            throw new IllegalArgumentException(ExceptionMessages.MISSING_ENTITY_ANNOTATION);
        }
        return annotation.name();
    }
}
