package D_Java_OOP.Z_Exam;

import D_Java_OOP.Z_Exam.E02_Aquarium.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class AquariumTests {

    public static final String VALID_NAME = "AquaWorld";
    public static final String VALID_WATER_TYPE = "Freshwater";

    public static final String INVALID_NAME = "";
    public static final String NULL_NAME = null;

    public static final String FISH_A_NAME = "Rainbow Trout";
    public static final String FISH_B_NAME = "Smallmouth Bass";
    public static final String FISH_C_NAME = "Pike";
    public static final String FISH_D_NAME = "Bowfin";

    public static final String FRESHWATER_HABITAT = "Freshwater";
    public static final String LAKE_AND_POND_HABITAT = "Lake";

    public static final int FISH_A_SPEED = 10;
    public static final int FISH_B_SPEED = 7;
    public static final int FISH_C_SPEED = 5;

    Aquarium aquariumFreshWater;
    Fish fishA;
    Fish fishB;
    Fish fishC;
    Fish fishD;


    @BeforeEach
    public void init() {
        aquariumFreshWater = new Aquarium(VALID_NAME, VALID_WATER_TYPE);
        fishA = new Fish(FISH_A_NAME, FRESHWATER_HABITAT, FISH_A_SPEED, false);
        fishB = new Fish(FISH_B_NAME, FRESHWATER_HABITAT, FISH_B_SPEED, true);
        fishC = new Fish(FISH_C_NAME, FRESHWATER_HABITAT, FISH_C_SPEED, true);
        fishD = new Fish(FISH_D_NAME, LAKE_AND_POND_HABITAT, 3, false);
    }

    @Test
    public void SetNameMethodThrowsNullPointerExceptionWhenEmpty() {
        Assertions.assertThrows(NullPointerException.class, () -> new Aquarium(INVALID_NAME, VALID_WATER_TYPE));
    }

    @Test
    public void SetNameMethodThrowsNullPointerExceptionWhenNull() {
        Assertions.assertThrows(NullPointerException.class, () -> new Aquarium(NULL_NAME, VALID_WATER_TYPE));
    }

    @Test
    public void GetNameMethodReturnsTheCorrectValue() {
        Assertions.assertEquals(VALID_NAME, aquariumFreshWater.getName());
    }

    @Test
    public void GetCountMethodReturnsCorrectValue() {
        aquariumFreshWater.addFish(fishA);
        aquariumFreshWater.addFish(fishB);
        aquariumFreshWater.addFish(fishC);
        Assertions.assertEquals(3, aquariumFreshWater.getCount());
    }

    @Test
    public void RemoveFishRemovesCorrectly() {
        aquariumFreshWater.addFish(fishC);
        Assertions.assertTrue(aquariumFreshWater.removeFish(FISH_C_NAME));
        Assertions.assertEquals(0, aquariumFreshWater.getCount());
    }

    @Test
    public void AddFishMethodThrowsIllegalArgumentExceptionWhenHabitatDoestNotMatch() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> aquariumFreshWater.addFish(fishD));
    }

    @Test
    public void AddFishMethodThrowsIllegalArgumentExceptionWhenFishExists() {
        aquariumFreshWater.addFish(fishA);
        Assertions.assertThrows(IllegalArgumentException.class, () -> aquariumFreshWater.addFish(fishA));
        Assertions.assertThrows(IllegalArgumentException.class, () -> aquariumFreshWater.addFish(new Fish(FISH_A_NAME, FRESHWATER_HABITAT, 20, true)));
    }

    @Test
    public void AddFishMethodCorrectlyAddsFish() {
        int initialSize = aquariumFreshWater.getCount();
        aquariumFreshWater.addFish(fishA);
        Assertions.assertEquals(initialSize + 1, aquariumFreshWater.getCount());
        aquariumFreshWater.addFish(fishB);
        Assertions.assertEquals(initialSize + 2, aquariumFreshWater.getCount());
        aquariumFreshWater.removeFish(FISH_A_NAME);
        Assertions.assertEquals(initialSize + 1, aquariumFreshWater.getCount());
    }

    @Test
    public void GetFishReturnsTheCorrectFish() {
        aquariumFreshWater.addFish(fishA);
        Fish filteredFish = aquariumFreshWater.getFish(FISH_A_NAME);
        Assertions.assertSame(filteredFish, aquariumFreshWater.getFish(FISH_A_NAME));
    }

    @Test
    public void GetFishByHabitatMethodListOfFilteredFish() {
        aquariumFreshWater.addFish(fishA);
        aquariumFreshWater.addFish(fishB);
        aquariumFreshWater.addFish(fishC);
        List<Fish> filteredFishList = aquariumFreshWater.getFishByHabitat(FRESHWATER_HABITAT);
        Assertions.assertTrue(filteredFishList.stream().allMatch(fish -> fish.getHabitat().equals(FRESHWATER_HABITAT)));
    }

    @Test
    public void GetFastestFishMethodCorrectValue() {
        aquariumFreshWater.addFish(fishA);
        aquariumFreshWater.addFish(fishB);
        aquariumFreshWater.addFish(fishC);
        Assertions.assertEquals(FISH_A_NAME, aquariumFreshWater.getFastestFish());
        aquariumFreshWater.removeFish(FISH_A_NAME);
        Assertions.assertEquals(FISH_B_NAME, aquariumFreshWater.getFastestFish());
    }

    @Test
    public void GetEndangeredFishesReturnsString() {
        aquariumFreshWater.addFish(fishA);
        aquariumFreshWater.addFish(fishB);
        aquariumFreshWater.addFish(fishC);
        String expectedResult = fishB.getName() + ", " + fishC.getName();
        Assertions.assertEquals(expectedResult, aquariumFreshWater.getEndangeredFishes());
    }
}

