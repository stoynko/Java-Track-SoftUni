package OOP.X_ExamPreparations.ExamPrep_02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import D_OOP.X_ExamPreparations.ExamPrep_02.E02_StuntClimb.Climbing;
import D_OOP.X_ExamPreparations.ExamPrep_02.E02_StuntClimb.RockClimber;

public class ClimbingTests {

    private static final String NAME_VALID = "Alps";
    private static final String NAME_EMPTY = "";
    private static final String NAME_NULL = null;
    private static final int CAPACITY_VALID = 3;
    private static final int CAPACITY_NEGATIVE = -10;
    private static final String ROCK_CLIMBER_A_NAME = "John";
    private static final double ROCK_CLIMBER_A_STRENGTH = 30.0;
    private static final String ROCK_CLIMBER_B_NAME = "Sam";
    private static final double ROCK_CLIMBER_B_STRENGTH = 50.0;
    private static final String ROCK_CLIMBER_C_NAME = "Mike";
    private static final double ROCK_CLIMBER_C_STRENGTH = 35.0;

    Climbing climbing;
    RockClimber rockClimberA;
    RockClimber rockClimberB;
    RockClimber rockClimberC;

    @BeforeEach
    public void init() {
        climbing = new Climbing(NAME_VALID, CAPACITY_VALID);
        rockClimberA = new RockClimber(ROCK_CLIMBER_A_NAME, ROCK_CLIMBER_A_STRENGTH);
        rockClimberB = new RockClimber(ROCK_CLIMBER_B_NAME, ROCK_CLIMBER_B_STRENGTH);
        rockClimberC = new RockClimber(ROCK_CLIMBER_C_NAME, ROCK_CLIMBER_C_STRENGTH);
    }

    @Test
    public void ConstructorCreatesEntity() {

    }

    @Test
    public void SetNameMethodThrowsNullPointerExceptionWhenNameIsInvalid() {
        Assertions.assertThrows(NullPointerException.class, () -> new Climbing(NAME_EMPTY, CAPACITY_VALID));
        Assertions.assertThrows(NullPointerException.class, () -> new Climbing(NAME_NULL, CAPACITY_VALID));
    }

    @Test
    public void SetCapacityMethodThrowsIllegalArgumentExceptionWhenCapacityIsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Climbing(NAME_VALID, CAPACITY_NEGATIVE));
    }

    @Test
    public void GetCountMethodReturnsCorrectNumberOfElements() {
        int initialSize = 0;
        Assertions.assertEquals(initialSize, climbing.getCount());
        climbing.addRockClimber(rockClimberA);
        Assertions.assertEquals(initialSize + 1, climbing.getCount());
        climbing.addRockClimber(rockClimberB);
        Assertions.assertEquals(initialSize + 2, climbing.getCount());
        climbing.removeRockClimber(ROCK_CLIMBER_A_NAME);
        Assertions.assertEquals(initialSize + 1, climbing.getCount());
    }

    @Test
    public void GetCountMethodReturnsCorrectName() {
        Assertions.assertEquals(NAME_VALID, climbing.getName());
    }

    @Test
    public void AddClimberMethodThrowsIllegalArgumentExceptionWhenOverCapacity() {
        climbing.addRockClimber(rockClimberA);
        climbing.addRockClimber(rockClimberB);
        climbing.addRockClimber(rockClimberC);
        RockClimber climber = new RockClimber("Zack", 10.0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> climbing.addRockClimber(climber));
    }

    @Test
    public void AddClimbermethodThrowsIllegalArgumentExceptionWhenClimberExists() {
        climbing.addRockClimber(rockClimberA);
        climbing.addRockClimber(rockClimberB);
        Assertions.assertThrows(IllegalArgumentException.class, () -> climbing.addRockClimber(rockClimberA));
        Assertions.assertThrows(IllegalArgumentException.class, () -> climbing.addRockClimber(rockClimberB));
    }

}
