package X_ExamPreparations.ExamPrep_06;


import D_Java_OOP.Y_ExamPreparations.ExamPrep_06.E02_ScubaDive.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DivingTests {
    private static final String NAME_VALID = "Alps";
    private static final String NAME_EMPTY = "";
    private static final String NAME_NULL = null;
    private static final int CAPACITY_VALID = 3;
    private static final int CAPACITY_NEGATIVE = -10;
    private static final String DIVER_A_NAME = "John";
    private static final double DIVER_A_CAPACITY = 30.0;
    private static final String DIVER_B_NAME = "Sam";
    private static final double DIVER_B_CAPACITY = 50.0;
    private static final String DIVER_C_NAME = "Mike";
    private static final double DIVER_C_CAPACITY = 35.0;

    Diving diving;
    DeepWaterDiver deepWaterDiverA;
    DeepWaterDiver deepWaterDiverB;
    DeepWaterDiver deepWaterDiverC;

    @BeforeEach
    public void init() {
        diving = new Diving(NAME_VALID, CAPACITY_VALID);
        deepWaterDiverA = new DeepWaterDiver(DIVER_A_NAME, DIVER_A_CAPACITY);
        deepWaterDiverB = new DeepWaterDiver(DIVER_B_NAME, DIVER_B_CAPACITY);
        deepWaterDiverC = new DeepWaterDiver(DIVER_C_NAME, DIVER_C_CAPACITY);
    }


    @Test
    public void SetNameMethodThrowsNullPointerExceptionWhenNameIsInvalid() {
        Assertions.assertThrows(NullPointerException.class, () -> new Diving(NAME_EMPTY, CAPACITY_VALID));
        Assertions.assertThrows(NullPointerException.class, () -> new Diving(NAME_NULL, CAPACITY_VALID));
    }

    @Test
    public void SetCapacityMethodThrowsIllegalArgumentExceptionWhenCapacityIsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Diving(NAME_VALID, CAPACITY_NEGATIVE));
    }

    @Test
    public void GetCountMethodReturnsCorrectNumberOfElements() {
        int initialSize = 0;
        Assertions.assertEquals(initialSize, diving.getCount());
        diving.addDeepWaterDiver(deepWaterDiverA);
        Assertions.assertEquals(initialSize + 1, diving.getCount());
        diving.addDeepWaterDiver(deepWaterDiverB);
        Assertions.assertEquals(initialSize + 2, diving.getCount());
        diving.removeDeepWaterDiver(DIVER_A_NAME);
        Assertions.assertEquals(initialSize + 1, diving.getCount());
    }

    @Test
    public void GetNameMethodReturnsCorrectName() {
        Assertions.assertEquals(NAME_VALID, diving.getName());
    }

    @Test
    public void AddDeepWaterDiverMethodThrowsIllegalArgumentExceptionWhenOverCapacity() {
        diving.addDeepWaterDiver(deepWaterDiverA);
        diving.addDeepWaterDiver(deepWaterDiverB);
        diving.addDeepWaterDiver(deepWaterDiverC);
        DeepWaterDiver diver = new DeepWaterDiver("Zack", 10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> diving.addDeepWaterDiver(diver));
    }

    @Test
    public void AddDeepWaterDiverMethodThrowsIllegalArgumentExceptionWhenDiverExists() {
        diving.addDeepWaterDiver(deepWaterDiverA);
        diving.addDeepWaterDiver(deepWaterDiverB);
        Assertions.assertThrows(IllegalArgumentException.class, () -> diving.addDeepWaterDiver(deepWaterDiverA));
        Assertions.assertThrows(IllegalArgumentException.class, () -> diving.addDeepWaterDiver(deepWaterDiverB));
    }
}