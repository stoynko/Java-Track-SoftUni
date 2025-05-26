package F_SpringData.B_ORMFundamentals.orm.context;

/*  •	boolean persist(E entity) – it will insert or update the entity depending if it is attached to the context
    •	Iterable<E> find(Class<E> table) – returns collection of all entity objects of type E
    •	Iterable<E> find(Class<E> table, String where) – returns collection of all entity objects of type T matching the criteria given in "where"
    •	E findFirst(Class<E> table) – returns the first entity object of type E
    •	E findFirst(Class<E> table, String where) – returns the first entity object of type E matching the criteria given in "where" */

import java.lang.reflect.*;
import java.sql.*;

public interface DBcontext<E> {

    boolean persist(E entity) throws IllegalAccessException, SQLException;
    Iterable<E> find(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    Iterable<E> find(Class<E> table, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    E findFirst (Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
    E findFirst (Class<E> table, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
