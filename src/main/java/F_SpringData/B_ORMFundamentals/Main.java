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
        EntityManager entityManager = new EntityManager(connection);

        User user1 = new User("Ivan", "pass", 20, LocalDate.now());
        User user2 = new User("Georgi", "pass", 35, LocalDate.of(2019, 10, 15));

        Iterable users = entityManager.find(User.class);
        System.out.println();
    }
}
