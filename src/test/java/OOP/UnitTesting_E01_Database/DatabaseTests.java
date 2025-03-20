package OOP.UnitTesting_E01_Database;

import D_OOP.I_UnitTesting.E01_Database.*;
import org.junit.jupiter.api.*;

import javax.naming.*;

/* You are given a simple class - Database. It stores Integers. Your task is to test the class. Write tests,
so you are sure its methods are working as intended.

Constraints:
    •	Storing array's capacity must be exactly 16 integers.
        o	If the size of the array is not 16 integers long, throw OperationNotSupportedException.
    •	Add operation, should add an element at the next free cell. (just like a stack)
        o	If a passed element is null throw OperationNotSupportedException.
    •	Remove operation, should support only removing an element at the last index. (just like a stack)
        o	If you try to remove an element from an empty Database throw OperationNotSupportedException
    •	Constructors should take integers only, and store them in an array.
    •	The fetch method should return the elements as an array.

Do not forget to test the constructor(s). They are methods too! */

public class DatabaseTests {

    private Database database;
    private static final Integer[] ELEMENTS_FOR_INIT = new Integer[]{1, 2, 3};

    @BeforeEach
    public void init() throws OperationNotSupportedException {
       database = new Database(ELEMENTS_FOR_INIT);
    }

    //1. Successful creation
    @Test
    public void constructorCreatesValidDatabase() throws OperationNotSupportedException {
        Integer[] databaseElements = database.getElements();
        Assertions.assertArrayEquals(ELEMENTS_FOR_INIT, databaseElements);
    }

    //2. OperationNotSupported exception is thrown when database with more than 16 elements is created
    @Test
    public void constructorThrowsOperationNotSupportedExceptionForMoreThanSixteen() throws OperationNotSupportedException {
        Integer[] largerArray = new Integer[17];
        Assertions.assertThrows(OperationNotSupportedException.class, () -> new Database(largerArray));
    }

    //3. OperationNotSupported exception is thrown when database with less than 1 element is created
    @Test
    public void constructorThrowsOperationNotSupportedExceptionForLessThanOne() throws OperationNotSupportedException {
        Integer[] emptyArray = new Integer[0];
        Assertions.assertThrows(OperationNotSupportedException.class, () -> new Database(emptyArray));
    }

    //4. Adds a new element to the last available cell
    @Test
    public void AddsNewElementAtTheCurrentLastIndex() throws OperationNotSupportedException {
        database.add(10);
        Integer[] databaseElements = database.getElements();
        Assertions.assertEquals( 10, databaseElements[databaseElements.length - 1]);
        Assertions.assertNotSame(databaseElements, database.getElements());
    }

    //5. OperationNotSupported exception should be thrown when a null element is added database
    @Test
    public void OperationNotSupportedExceptionIsThrownWhenAddingNullElement() throws OperationNotSupportedException {
        Assertions.assertThrows(OperationNotSupportedException.class, () -> database.add(null));
    }

    // 6. Removes the last element
    @Test
    public void RemovesTheLastElement() throws OperationNotSupportedException {
        Integer[] initialDatabaseElements = database.getElements();
        database.remove();
        Integer[] newDatabaseElements = database.getElements();
        int secondToLast = initialDatabaseElements[initialDatabaseElements.length - 2];
        int newLast = newDatabaseElements[newDatabaseElements.length - 1];
        Assertions.assertEquals(secondToLast, newLast);
        Assertions.assertNotSame(initialDatabaseElements, newDatabaseElements);
    }

    //7. OperationNotSupportedException is thrown whenever the index is outside the array (empty array)
    @Test
    public void OperationNotSupportedExceptionIsThrownWhenRemovingElementFromEmtpyArray() throws OperationNotSupportedException {
        for (int index = 0; index < ELEMENTS_FOR_INIT.length; index++) {
            database.remove();
        }
        Assertions.assertThrows(OperationNotSupportedException.class, () -> database.remove());
    }
}


