package OOP.I_UnitTesting.E05_CustomLinkedList;

import D_OOP.I_UnitTesting.E05_CustomLinkedList.*;
import org.junit.jupiter.api.*;

/* You are given a data structure that needs to be tested. Use the Java file CustomLinkedList.java and:
    •	Create Test Classes and Test Methods for all public members that need testing.
    •	Create tests that ensure all methods, getters and setters work correctly.
    •	Use the Assertions.assertThrows(ExpectedException.class, () -> {}); for methods that are expected to throw an
        exception in case wrong input is entered (those tests don’t need to assert messages).
    •	Give meaningful assert messages for failed tests. */

public class CustomLinkedListTests {

        private CustomLinkedList<String> list;

        private static final String ELEMENT_A = "Ivan";
        private static final String ELEMENT_B = "Georgi";
        private static final String ELEMENT_C = "Dimitar";
        private static final String ELEMENT_TO_ADD = "Mariya";
        private static final String ELEMENT_TO_SEARCH_MISSING = "Todor";
        private static final int INVALID_INDEX_BELOW_ZERO = -1;
        private static final int INVALID_INDEX_OVER_COUNT = 100;
        private static int INVALID_INDEX_AT_ELEMENTS_COUNT;

        @BeforeEach
        public void init() {
            list = new CustomLinkedList<>();
            list.add(ELEMENT_A);
            list.add(ELEMENT_B);
            list.add(ELEMENT_C);
            INVALID_INDEX_AT_ELEMENTS_COUNT = list.getCount();
        }

        @Test
        public void AddMethodCorrectlyAddsNewElement() {
            int previousListSize = list.getCount();
            list.add(ELEMENT_TO_ADD);
            int currentListSize = list.getCount();
            int indexOfNewItem = list.indexOf(ELEMENT_TO_ADD);
            Assertions.assertEquals(list.getCount() - 1, indexOfNewItem);
            Assertions.assertEquals(previousListSize + 1, currentListSize);
        }

        @Test
        public void GetMethodThrowsIllegalArgumentExceptionForIndexBelowZero() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> list.get(INVALID_INDEX_BELOW_ZERO));
        }

        @Test
        public void GetMethodThrowsIllegalArgumentExceptionForIndexAboveElementsCount() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> list.get(INVALID_INDEX_OVER_COUNT));
        }

        @Test
        public void GetMethodReturnsTheCorrectElement() {
            String returnedElement = list.get(2);
            Assertions.assertEquals(ELEMENT_C, returnedElement);
        }

        @Test
        public void RemoveAtMethodThrowsIllegalArgumentExceptionForIndexBelowZero() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> list.removeAt(INVALID_INDEX_BELOW_ZERO));
        }

        @Test
        public void RemoveAtMethodThrowsIllegalArgumentExceptionForIndexAboveElementsCount() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> list.removeAt(INVALID_INDEX_OVER_COUNT));
        }

        @Test
        public void RemoveAtMethodThrowsIllegalArgumentExceptionForIndexEqualToElementsCount() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> list.removeAt(INVALID_INDEX_AT_ELEMENTS_COUNT));
        }

        @Test
        public void RemoveAtMethodRemovesTheCorrectElement() {

            String removedElement = list.get(0);
            String nextElement = list.get(1);
            int previousCount = list.getCount();

            list.removeAt(0);

            Assertions.assertNotEquals(removedElement, list.get(0));
            Assertions.assertEquals(previousCount - 1, list.getCount());
            Assertions.assertEquals(nextElement, list.get(0));
        }

        @Test
        public void RemoveMethodRemovesTheCorrectElementAndReturnsIndex() {
            int actualIndex = list.indexOf(ELEMENT_A);
            int foundIndex = list.remove(ELEMENT_A);
            Assertions.assertEquals(actualIndex, foundIndex);
        }

        @Test
        public void RemoveMethodCannotFindElementAndReturns() {
            int result = list.remove(ELEMENT_TO_SEARCH_MISSING);
            Assertions.assertEquals(-1, result);
        }

        @Test
        public void ContainsMethodReturnsCorrectValue() {
            Assertions.assertFalse(list.contains(ELEMENT_TO_SEARCH_MISSING));
            Assertions.assertFalse(list.contains(ELEMENT_TO_ADD));
            Assertions.assertTrue(list.contains(ELEMENT_A));
            Assertions.assertTrue(list.contains(ELEMENT_B));
        }

        @Test
        public void SetMethodThrowsIllegalArgumentExceptionForIndexBelowZero() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> list.set(INVALID_INDEX_BELOW_ZERO, ELEMENT_TO_ADD));
        }


        @Test
        public void SetMethodThrowsIllegalArgumentExceptionForIndexAboveElementsCount() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> list.set(INVALID_INDEX_OVER_COUNT, ELEMENT_TO_ADD));
        }

        @Test
        public void SetMethodCorrectlySetsANewValue() {
            final int INDEX_FOR_REPLACE = 2;
            String replacedElement = list.get(INDEX_FOR_REPLACE);
            list.set(INDEX_FOR_REPLACE, ELEMENT_TO_ADD);
            Assertions.assertEquals(ELEMENT_TO_ADD, list.get(INDEX_FOR_REPLACE));
            Assertions.assertNotEquals(list.get(INDEX_FOR_REPLACE), replacedElement);
            Assertions.assertFalse(list.contains(replacedElement));
        }
    }