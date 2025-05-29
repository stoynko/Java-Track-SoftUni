package F_SpringData.B_ORMFundamentals.orm.context;

import F_SpringData.B_ORMFundamentals.common.*;
import F_SpringData.B_ORMFundamentals.orm.core.*;

import java.lang.reflect.*;
import java.sql.*;
import java.time.*;
import java.util.*;

public class EntityManager<E> implements DBcontext<E> {

    private final Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
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
        } else if (field.getType() == String.class) {
            return dbResult.getString(column);
        } else if (field.getType() == LocalDate.class) {
            String date = dbResult.getString(column);
            return LocalDate.parse(date);
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
                entityValues.add("'" + field.get(entity).toString() + "'");
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
