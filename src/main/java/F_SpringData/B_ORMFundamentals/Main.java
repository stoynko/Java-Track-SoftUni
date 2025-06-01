package F_SpringData.B_ORMFundamentals;

import F_SpringData.B_ORMFundamentals.entities.*;
import F_SpringData.B_ORMFundamentals.orm.config.*;
import F_SpringData.B_ORMFundamentals.orm.context.*;

import java.lang.reflect.*;
import java.sql.*;
import java.time.*;

import static F_SpringData.B_ORMFundamentals.orm.config.Connector.getConnection;

public class Main {

    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {

        Connector.createConnection("root", "", "orm_basics");
        Connection connection = getConnection();
        EntityManager<User> entityManager = new EntityManager<>(connection);
        //entityManager.createTable(User.class);
        User user1 = new User("vanko01", "Ivan", "Ivanov", "pass", 20, LocalDate.now());
        User user2 = new User("maria92", "Maria", "Petrova", "secure123", 25, LocalDate.now());
        User user3 = new User("george87", "Georgi", "Dimitrov", "qwerty", 30, LocalDate.now());
        User user4 = new User("nika76", "Nikolay", "Stoyanov", "letmein", 22, LocalDate.now());
        User user5 = new User("tanya15", "Tanya", "Hristova", "1234abcd", 28, LocalDate.now());

        entityManager.delete(User.class, 5);
        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.persist(user3);
        entityManager.persist(user4);
        entityManager.persist(user5);
        User firstUser = entityManager.findFirst(User.class);
        firstUser.setUsername("Test Name");
        entityManager.persist(firstUser);
        Iterable users = entityManager.find(User.class);
        for (Object user : users) {
            System.out.println(user);
        }
    }
}