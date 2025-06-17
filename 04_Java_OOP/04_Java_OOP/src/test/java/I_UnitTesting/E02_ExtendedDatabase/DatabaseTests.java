package I_UnitTesting.E02_ExtendedDatabase;

import org.junit.jupiter.api.*;

import javax.naming.*;

/*You already have a class - Database. This time it is extended.
There are the following provided methods:  adding, removing, and finding People. In other words, it should store People.
There should be two types of finding methods - first: findById (long id) and the second one: findByUsername (String username).
As you may guess, each person should have its own unique id and unique username. Your task is to test these functions.
Constraints:
The database should have methods:
    •	add
        o	If there are multiple users with this id, throw OperationNotSupportedException.
        o	If negative nor null ids are present, throw OperationNotSupportedException.
    •	remove
        •	findByUsername
            o	If no user is present by this username, throw OperationNotSupportedException.
            o	If the username parameter is null, throw OperationNotSupportedException.
            o	Arguments are all CaseSensitive!
    •	findById
        o	If no user is present by this id, throw OperationNotSupportedException. */

public class DatabaseTests {

    private Database database;

    @BeforeEach
    public void init() throws OperationNotSupportedException {
        Person personA = new Person(1, "Ivan");
        Person personB = new Person(2, "Georgi");
        Person personC = new Person(3, "Dimitar");
        database = new Database(personA, personB, personC);
    }

    // 1. OperationNotSupportedException is thrown if searching with null username
    @Test
    public void OperationNotSupportedExceptionIsThrownIfUsernameIsNull() throws OperationNotSupportedException {
        Assertions.assertThrows(OperationNotSupportedException.class, () -> database.findByUsername(null));
    }

    // 2. OperationNotSupportedException is thrown if there are more than 1 user with this username
    @Test
    public void OperationNotSupportedExceptionIsThrownWhenUsernameIsNotUnique() throws OperationNotSupportedException {
        database.add(new Person(4, "Dimitar"));
        Assertions.assertThrows(OperationNotSupportedException.class, () -> database.findByUsername("Dimitar"));
    }

    // 3. OperationNotSupportedException is thrown if user with this username was not found
    @Test
    public void OperationNotSupportedExceptionIsThrownWhenUserWasNotFoundWithUsername() throws OperationNotSupportedException {
        Assertions.assertThrows(OperationNotSupportedException.class, () -> database.findByUsername("Mariya"));
    }

    //4. User with the specified username was located
    @Test
    public void UserWithUsernameWasFound() throws OperationNotSupportedException {
        Person[] peoplesList = database.getElements();
        Person foundPerson = database.findByUsername("Ivan");
        Assertions.assertEquals(peoplesList[0], foundPerson);
    }

    // 3. OperationNotSupportedException is thrown if user with this id was not found
    @Test
    public void OperationNotSupportedExceptionIsThrownWhenUserWasNotFoundWithID(){
        Assertions.assertThrows(OperationNotSupportedException.class, () -> database.findById(5));
    }

    // 4. OperationNotSupportedException is thrown if there are more than 1 user with this id
    @Test
    public void OperationNotSupportedExceptionIsThrownWhenIdIsNotUnique() throws OperationNotSupportedException {
        database.add(new Person(1, "Mariya"));
        Assertions.assertThrows(OperationNotSupportedException.class, () -> database.findById(1));
    }

    //5. User with the specified id was located
    @Test
    public void UserWithIdWasFound() throws OperationNotSupportedException {
        Person[] peoplesList = database.getElements();
        Person foundPerson = database.findById(1);
        Assertions.assertEquals(peoplesList[0], foundPerson);
    }
}
