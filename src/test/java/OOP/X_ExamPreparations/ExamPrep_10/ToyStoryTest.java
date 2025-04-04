package OOP.X_ExamPreparations.ExamPrep_10;

import D_OOP.Y_ExamPreparations.ExamPrep_10.E02_ToyStore.*;
import org.junit.jupiter.api.*;

import javax.naming.*;

public class ToyStoryTest {

    public static final String SHELF_A = "A";
    public static final String SHELF_B = "B";
    public static final String SHELF_C = "C";
    public static final String SHELF_D = "D";
    public static final String SHELF_E = "E";
    public static final String SHELF_F = "F";
    public static final String SHELF_G = "G";
    public static final String SHELF_INVALID = "Z";


    public static final String TOY_A_MANUFACTURER = "";
    public static final String TOY_B_TOY_A_MANUFACTURER = "";
    public static final String TOY_C_TOY_A_MANUFACTURER = "";

    public static final String TOY_A_ID = "A1";
    public static final String TOY_B_ID = "B1";
    public static final String TOY_C_ID = "C1";

    public static final Toy NULL_TOY = null;

    ToyStore toyStore;
    Toy toyA;
    Toy toyB;
    Toy toyC;

    @BeforeEach
    public void init() throws OperationNotSupportedException {
        toyStore = new ToyStore();
        toyA = new Toy(TOY_A_MANUFACTURER, TOY_A_ID);
        toyB = new Toy(TOY_B_TOY_A_MANUFACTURER, TOY_B_ID);
        toyC = new Toy(TOY_C_TOY_A_MANUFACTURER, TOY_C_ID);
    }

    @Test
    public void GetToyShelfReturnsUnmodifiableCollection() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> toyStore.getToyShelf().clear());
    }

    @Test
    public void AddToyMethodThrowsIllegalArgumentExceptionWhenShelfDoesNotExist() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> toyStore.addToy(SHELF_INVALID,toyA));
    }

    @Test
    public void AddToyMethodThrowsIllegalArgumentExceptionWhenShelfIsTaken() throws OperationNotSupportedException {
        toyStore.addToy(SHELF_A, toyA);
        Assertions.assertThrows(IllegalArgumentException.class, () -> toyStore.addToy(SHELF_A, toyB));
    }

    @Test
    public void AddToyMethodThrowsOperationNotSupportedExceptionWhenToyExists() throws OperationNotSupportedException {
        toyStore.addToy(SHELF_C, toyA);
        Assertions.assertThrows(OperationNotSupportedException.class, () -> toyStore.addToy(SHELF_B, toyA));
    }

    @Test
    public void AddToyMethodAddsToySuccessfully() throws OperationNotSupportedException {
        toyStore.addToy(SHELF_F, toyC);
        Assertions.assertThrows(IllegalArgumentException.class, () -> toyStore.addToy(SHELF_F, toyA));
        Assertions.assertThrows(OperationNotSupportedException.class, () -> toyStore.addToy(SHELF_A, toyC));
        Toy addedToy = toyStore.getToyShelf().get(SHELF_F);
        Assertions.assertSame(toyC, addedToy);
        Assertions.assertTrue(toyStore.getToyShelf().containsValue(toyC));
    }

    @Test
    public void AddToyMethodReturnsCorrectStringOutput() throws OperationNotSupportedException {
        String expectedOutput = String.format("Toy:%s placed successfully!", toyC.getToyId());
        Assertions.assertEquals(expectedOutput, toyStore.addToy(SHELF_F, toyC));
    }

    @Test
    public void RemoveToyMethodThrowsIllegalArgumentExceptionWhenShelfDoesNotExist() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> toyStore.removeToy(SHELF_INVALID, toyA));
    }

    @Test
    public void RemoveToyMethodThrowsIllegalArgumentExceptionWhenToyOnShelfDoesNotExist() throws OperationNotSupportedException {
        toyStore.addToy(SHELF_A, toyA);
        Assertions.assertThrows(IllegalArgumentException.class, () -> toyStore.removeToy(SHELF_A, toyB));
    }

    @Test
    public void RemoveToyMethodCorrectlyRemovesToyFromShelf() throws OperationNotSupportedException {
        toyStore.addToy(SHELF_B, toyB);
        Assertions.assertTrue(toyStore.getToyShelf().containsValue(toyB));
        toyStore.removeToy(SHELF_B, toyB);
        Assertions.assertFalse(toyStore.getToyShelf().containsValue(toyB));
        Assertions.assertSame(null, toyStore.getToyShelf().get(SHELF_B));
    }

    @Test
    public void RemoveToyMethodReturnsCorrectStringOutput() throws OperationNotSupportedException {
        toyStore.addToy(SHELF_B, toyB);
        String expectedOutput = String.format("Remove toy:%s successfully!", toyB.getToyId());
        Assertions.assertEquals(expectedOutput, toyStore.removeToy(SHELF_B, toyB));
    }
}

