package X_ExamPreparations.ExamPrep_01;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_01.E02_MushroomKingdom.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class MushroomKingdomTests {

    public static final String FIELD_VALID_NAME = "Forest";
    public static final String FIELD_INVALID_NAME = "";
    public static final String FIELD_NULL_NAME = null;
    public static final int FIELD_VALID_CAPACITY = 2;
    public static final int FIELD_INVALID_CAPACITY = -10;

    public static final String EDIBLE_MUSHROOM_NAME = "Chanterelle";
    public static final String EDIBLE_MUSHROOM_FLAVOR = "Fruity";
    public static final String INEDIBLE_MUSHROOM_NAME = "Bitter Bolete";
    public static final String INEDIBLE_MUSHROOM_FLAVOR = "Extremely bitter";
    public static final String POISONOUS_MUSHROOM_NAME = "Webcap";
    public static final String POISONOUS_MUSHROOM_FLAVOR = "Bland";
    public static final boolean EDIBLE_MUSHROOM = true;
    public static final boolean INEDIBLE_MUSHROOM = false;
    public static final int EDIBLE_TOXICITY = 0;
    public static final int INEDIBLE_TOXICITY = 1;
    public static final int POISONOUS_TOXICITY = 20;

    Mushroom mushroomA;
    Mushroom mushroomB;
    Mushroom mushroomC;
    Field field;

    @BeforeEach
    public void init() {
        field = new Field(FIELD_VALID_NAME, FIELD_VALID_CAPACITY);
        mushroomA = new Mushroom(EDIBLE_MUSHROOM_NAME, EDIBLE_MUSHROOM_FLAVOR, EDIBLE_MUSHROOM, EDIBLE_TOXICITY);
        mushroomB = new Mushroom(INEDIBLE_MUSHROOM_NAME, INEDIBLE_MUSHROOM_FLAVOR, INEDIBLE_MUSHROOM, INEDIBLE_TOXICITY);
        mushroomC = new Mushroom(POISONOUS_MUSHROOM_NAME, POISONOUS_MUSHROOM_FLAVOR, INEDIBLE_MUSHROOM, POISONOUS_TOXICITY);
    }

    @Test
    public void SetNameMethodThrowsNullPointerExceptionWhenNameIsInvalid() {
        Assertions.assertThrows(NullPointerException.class, () -> new Field(FIELD_INVALID_NAME, FIELD_VALID_CAPACITY));
    }

    @Test
    public void SetNameMethodThrowsNullPointerExceptionWhenNameIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> new Field(FIELD_NULL_NAME, FIELD_VALID_CAPACITY));
    }

    @Test
    public void SetCapacityMethodThrowsIllegalArgumentExceptionWhenCapacityIsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Field(FIELD_VALID_NAME, FIELD_INVALID_CAPACITY));
    }

    @Test
    public void GetCountMethodReturnsCorrectNumberOfElements() {
        int initialSize = 0;
        Assertions.assertEquals(initialSize, field.getCount());
        field.addMushroom(mushroomA);
        Assertions.assertEquals(initialSize + 1, field.getCount());
        field.addMushroom(mushroomB);
        Assertions.assertEquals(initialSize + 2, field.getCount());
        field.removeMushroom(INEDIBLE_MUSHROOM_NAME);
        Assertions.assertEquals(initialSize + 1, field.getCount());
    }

    @Test
    public void GetNameMethodReturnsCorrectName() {
        Assertions.assertEquals(FIELD_VALID_NAME, field.getName());
    }

    @Test
    public void AddMushroomMethodThrowsIllegalArgumentExceptionWhenOverOrAtCapacity() {
        field.addMushroom(mushroomA);
        field.addMushroom(mushroomB);
        Assertions.assertThrows(IllegalArgumentException.class, () -> field.addMushroom(mushroomC));
    }

    @Test
    public void AddMushroomMethodThrowsIllegalArgumentExceptionWhenMushroomExists() {
        field.addMushroom(mushroomA);
        Assertions.assertThrows(IllegalArgumentException.class, () -> field.addMushroom(new Mushroom("Chanterelle", "Bland", true, 0)));
    }

    @Test
    public void getMostMushroomByNameReturnsTheCorrect() {
        field.addMushroom(mushroomA);
        field.addMushroom(mushroomB);
        Assertions.assertEquals(mushroomA, field.getMushroom(EDIBLE_MUSHROOM_NAME));
        Assertions.assertEquals(mushroomB, field.getMushroom(INEDIBLE_MUSHROOM_NAME));
    }

    @Test
    public void getMostPoisonousMushroomReturnsTheNameCorrect() {
        field.addMushroom(mushroomA);
        field.addMushroom(mushroomC);
        Assertions.assertEquals(POISONOUS_MUSHROOM_NAME, field.getMostPoisonousMushroom());
        field.removeMushroom(POISONOUS_MUSHROOM_NAME);
        field.addMushroom(mushroomB);
        Assertions.assertEquals(INEDIBLE_MUSHROOM_NAME, field.getMostPoisonousMushroom());
    }

    @Test
    public void getInedibleMushroomsReturnsTheCorrectCollection() {
        field.addMushroom(mushroomB);
        field.addMushroom(mushroomC);
        List<Mushroom> inedibleMushrooms = field.getInedibleMushrooms();
        for (Mushroom mushroom : inedibleMushrooms) {
            Assertions.assertEquals(INEDIBLE_MUSHROOM, mushroom.isEdible());
        }
    }

    @Test
    public void getMushroomsByFlavorReturnsTheCorrectCollection() {
        field.addMushroom(mushroomA);
        field.addMushroom(mushroomB);
        List<Mushroom> mushroomsByFlavor = field.getMushroomsByFlavor(EDIBLE_MUSHROOM_FLAVOR);
        for (Mushroom mushroom : mushroomsByFlavor) {
            Assertions.assertEquals(EDIBLE_MUSHROOM_FLAVOR, mushroom.getFlavor());
            Assertions.assertNotEquals(POISONOUS_MUSHROOM_FLAVOR, mushroom.getFlavor());
        }
    }
}
