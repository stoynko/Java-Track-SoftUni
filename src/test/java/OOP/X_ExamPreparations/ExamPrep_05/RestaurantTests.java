package OOP.X_ExamPreparations.ExamPrep_05;

import D_OOP.X_ExamPreparations.ExamPrep_05.E02_UnitTesting.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class RestaurantTests {

    private static final String RESTAURANT_NAME = "Test";
    private static final String EMPTY_NAME = " ";
    private static final String NULL_NAME = null;
    private static final int RESTAURANT_CAPACITY = 2;
    private static final int NEGATIVE_CAPACITY = -10;


    private static final FullTimeWaiter WAITER_A = new FullTimeWaiter("Ivan", 7);
    private static final FullTimeWaiter WAITER_B = new FullTimeWaiter("Georgi", 5);
    private static final FullTimeWaiter WAITER_C = new FullTimeWaiter("Dimitar", 3);

    private Restaurant restaurant;

    @BeforeEach
    public void init() {
        restaurant = new Restaurant(RESTAURANT_NAME, RESTAURANT_CAPACITY);
    }

    @Test
    public void ConstructorCreatesRestaurant() {
        restaurant = new Restaurant(RESTAURANT_NAME, RESTAURANT_CAPACITY);
    }

    @Test
    public void SetNameMethodCorrectlySetsName() {
        Restaurant secondRestaurant = new Restaurant("Rest", 1);
        Assertions.assertEquals("Rest", secondRestaurant.getName());
    }

    @Test
    public void SetNameThrowsNullPointerExceptionForEmptyName() {
        Assertions.assertThrows(NullPointerException.class, () -> new Restaurant(EMPTY_NAME, 1));
    }

    @Test
    public void SetNameThrowsNullPointerExceptionForNullName() {
        Assertions.assertThrows(NullPointerException.class, () -> new Restaurant(NULL_NAME, 1));
    }

    @Test
    public void SetCapacityThrowsIllegalArgumentExceptionForZeroCapacity() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Restaurant(RESTAURANT_NAME, NEGATIVE_CAPACITY));
    }

    @Test
    public void GetCapacityMethodReturnsCorrectCapacity() {
        Assertions.assertEquals(RESTAURANT_CAPACITY, restaurant.getCapacity());
    }

    @Test
    public void GetNameMethodReturnsCorrectName() {
        Assertions.assertEquals(RESTAURANT_NAME, restaurant.getName());
    }

    @Test
    public void AddWaiterMethodAddsNewWaiterCorrectly() {
        int initialAmountOfWaiters = restaurant.getWaiters().size();
        restaurant.addFullTimeWaiter(WAITER_A);
        Assertions.assertEquals(initialAmountOfWaiters + 1, restaurant.getWaiters().size());
        Assertions.assertTrue(restaurant.getWaiters().contains(WAITER_A));
        Assertions.assertFalse(restaurant.getWaiters().contains(WAITER_B));
        Assertions.assertFalse(restaurant.getWaiters().contains(WAITER_C));
    }

    @Test
    public void AddWaiterMethodThrowsIllegalArgumentExceptionWhenWaiterExists() {
        restaurant.addFullTimeWaiter(WAITER_A);
        Assertions.assertThrows(IllegalArgumentException.class, () -> restaurant.addFullTimeWaiter(WAITER_A));
    }

    @Test
    public void AddWaiterMethodThrowsIllegalArgumentExceptionWhenNoPositionForWaiter() {
        restaurant.addFullTimeWaiter(WAITER_A);
        restaurant.addFullTimeWaiter(WAITER_B);
        Assertions.assertThrows(IllegalArgumentException.class, () -> restaurant.addFullTimeWaiter(WAITER_C));
    }

    @Test
    public void RemoveWaiterMethodCorrectlyRemovesWaiter() {
        restaurant.addFullTimeWaiter(WAITER_A);
        int countOfWaiters = restaurant.getWaiters().size();
        restaurant.removeFullTimeWaiter(WAITER_A.getName());
        Assertions.assertEquals(countOfWaiters - 1, restaurant.getWaiters().size());
        Assertions.assertFalse(restaurant.getWaiters().contains(WAITER_A));
    }

    @Test
    public void GetWaitersMethodReturnsCollectionWithCorrectAmountOfWaiters() {
        List<FullTimeWaiter> testList = new ArrayList<>();
        testList.add(WAITER_A);
        testList.add(WAITER_B);
        restaurant.addFullTimeWaiter(WAITER_A);
        restaurant.addFullTimeWaiter(WAITER_B);
        Collection<FullTimeWaiter> waitersList = restaurant.getWaiters();
        List<FullTimeWaiter> waiters = List.copyOf(waitersList);
        waitersList.add(WAITER_A);
        testList.add(WAITER_B);
        for (int i = 0; i < testList.size() - 1; i++) {
            Assertions.assertEquals(testList.get(i), waiters.get(i));
        }
    }

    @Test
    public void GetCountMethodReturnsCorrectAmountOfWaiters() {
        Assertions.assertEquals(0, restaurant.getCount());
        restaurant.addFullTimeWaiter(WAITER_B);
        restaurant.addFullTimeWaiter(WAITER_C);
        Assertions.assertEquals(2, restaurant.getCount());
    }
}
