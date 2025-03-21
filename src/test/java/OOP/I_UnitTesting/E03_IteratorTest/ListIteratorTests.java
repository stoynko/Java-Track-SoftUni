package OOP.I_UnitTesting.E03_IteratorTest;

/*You are given a simple class "ListIterator", it should receive the collection (Strings) which it will iterate, through its constructor.
You should store the elements in a List and get them initially through its constructor. If there is a null passed to the constructor,
throw a new OperationNotSupportedException. The class should have three main functions:
    •	Move - should move an internal index position to the next index in the list, the method should return true if it successfully moved and false if there is no next index.
    •	HasNext - should return true if there is a next index and false if the index is already at the last element of the list.
    •	Print - should print the element at the current internal index, calling Print on a collection without elements should throw an appropriate exception with the message "Invalid Operation!". */

import D_OOP.I_UnitTesting.E03_IteratorTest.*;
import org.junit.jupiter.api.*;

import javax.naming.*;

public class ListIteratorTests {

    private static final String[] ELEMENTS_FOR_INIT = new String[]{"a", "b", "c"};
    private ListIterator listIterator;

    @BeforeEach
    public void init() throws OperationNotSupportedException {
        listIterator = new ListIterator(ELEMENTS_FOR_INIT);
    }


    //1. OperationNotSupportedException is thrown if null elements are used for creatio nof the ListIterator
    @Test
    public void OperationNotSupportedExceptionIsThrownIfNullValuesAreFed() throws OperationNotSupportedException {
        Assertions.assertThrows(OperationNotSupportedException.class, () -> new ListIterator(null));
    }

    //2. ListIterator was successfully created
    @Test
    public void ListIteratorIsCreated() throws OperationNotSupportedException {
        listIterator = new ListIterator(ELEMENTS_FOR_INIT);
        Assertions.assertEquals(ELEMENTS_FOR_INIT[0], listIterator.print());
        listIterator.move();
        Assertions.assertEquals(ELEMENTS_FOR_INIT[1], listIterator.print());
        listIterator.move();
        Assertions.assertEquals(ELEMENTS_FOR_INIT[2], listIterator.print());
    }

    //3. hasNext method returns true if there are other elements and false if there aren't
    @Test
    public void HasNextCorrectlyIterates() {
        Assertions.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assertions.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assertions.assertFalse(listIterator.hasNext());
    }

    //4. Move method return true if there are other elements and false if there aren't
    @Test
    public void MoveMethodCorrectlyMoves() {
        Assertions.assertTrue(listIterator.move());
        Assertions.assertTrue(listIterator.move());
        Assertions.assertFalse(listIterator.move());
    }

    //5. IllegalStateException is thrown if there are no elements
    @Test
    public void IllegalStateExceptionisThrownWhenPrintingStructureWithNoElements() throws OperationNotSupportedException {
        String[] emptyArray = new String[0];
        ListIterator listInt = new ListIterator(emptyArray);
        Assertions.assertThrows(IllegalStateException.class, () -> listInt.print());
    }

    //6. Print method correctly returns the element at the current index
    @Test
    public void CorrectlyReturnsTheCurrentElementAtCurrentIndex() {
        listIterator.move();
        String currentElement = listIterator.print();
        Assertions.assertEquals("b", currentElement);
        listIterator.move();
        currentElement = listIterator.print();
        Assertions.assertEquals("c", currentElement);

    }
}
