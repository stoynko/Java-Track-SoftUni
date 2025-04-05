package D_Java_OOP.X_ExamPreparations.ExamPrep_04;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_04.E02_DolphinsPlay.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class PlayDolphinsTests {

    public static final String DOLPHINARIUM_NAME = "VarnaDolph";
    public static final String DOLPHINARIUM_NEW_NAME = "BurgasDolph";
    public static final int DOLPHINARIUM_CAPACITY = 2;
    public static final int DOLPHINARIUM_INVALID_CAPACITY = -1;

    DolphinsPlay dolphinarium;
    Dolphin dolphinA;
    Dolphin dolphinB;
    Dolphin dolphinC;
    Dolphin dolphinD;

    @BeforeEach
    public void init() {
        dolphinarium = new DolphinsPlay(DOLPHINARIUM_NAME, DOLPHINARIUM_CAPACITY);
        dolphinA = new Dolphin("Common", "Cory", 100);
        dolphinB = new Dolphin("Hourglass", "Hory", 99);
        dolphinC = new Dolphin("Hourglass", "Nory", 101);
        dolphinD = new Dolphin("Common", "Snorry", 102);
        dolphinarium.addDolphin(dolphinA);
    }

    @Test
    public void ConstructorSuccessfullyCreatesEntity() {
        DolphinsPlay dolph = new DolphinsPlay(DOLPHINARIUM_NAME, DOLPHINARIUM_CAPACITY);
    }

    @Test
    public void SetNameMethodSuccessfullySetsTheName() {
        dolphinarium.setName(DOLPHINARIUM_NEW_NAME);
        Assertions.assertEquals(DOLPHINARIUM_NEW_NAME, dolphinarium.getName());
        Assertions.assertNotEquals(DOLPHINARIUM_NAME, dolphinarium.getName());
    }

    @Test
    public void SetCapcityMethodSucessfullySetsCapacity() {
        DolphinsPlay dolph = new DolphinsPlay(DOLPHINARIUM_NAME, DOLPHINARIUM_CAPACITY);
        Assertions.assertEquals(DOLPHINARIUM_CAPACITY, dolph.getCapacity());
    }

    @Test
    public void SetCapcityMethodThrowsIllegalArgumentExceptionForInvalidCapacity() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> dolphinarium.setCapacity(DOLPHINARIUM_INVALID_CAPACITY));
    }

    @Test
    public void GetDolphinsMethodReturnsUnmodifiableCollection() {
        List<Dolphin> dolphinsList = dolphinarium.getDolphins();
        Assertions.assertThrows(UnsupportedOperationException.class, () -> dolphinsList.remove(dolphinA));
    }

    @Test
    public void GetCountMethodReturnsTheCorrectSizeOfTheCollection() {
        Assertions.assertEquals(1, dolphinarium.getCount());
        dolphinarium.addDolphin(new Dolphin("Hourglass", "Hory", 101));
        Assertions.assertEquals(2, dolphinarium.getCount());
    }

    @Test
    public void AddDolphinMethodThrowsIllegalArgumentExceptionWhenNullDolphin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> dolphinarium.addDolphin(null));
    }

    @Test
    public void AddDolphinMethodThrowsIllegalArgumentExceptionWhenOverCapacity() {
        dolphinarium.addDolphin(dolphinB);
        Assertions.assertThrows(IllegalArgumentException.class, () -> dolphinarium.addDolphin(new Dolphin("Humpback", "Humpy", 1)));
    }

    @Test
    public void AddDolphinMethodThrowsIllegalArgumentExceptionWhenDolphinExists() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> dolphinarium.addDolphin(dolphinA));
    }

    @Test
    public void RemoveDolphinMethodSuccessfullyRemoves() {
        dolphinarium.addDolphin(dolphinB);
        int currentSize = dolphinarium.getCount();
        dolphinarium.removeDolphin("Hory");
        Assertions.assertEquals(currentSize - 1, dolphinarium.getCount());
    }

    @Test
    public void GetDolphinWithMaxEnergyMethodReturnsTheCorrectDolphin() {
        dolphinarium.addDolphin(dolphinB);
        Assertions.assertEquals(dolphinA.getName(), dolphinarium.getTheDolphinWithTheMaxEnergy());
        dolphinarium.removeDolphin(dolphinA.getName());
        dolphinarium.addDolphin(dolphinC);
        Assertions.assertEquals(dolphinC.getName(), dolphinarium.getTheDolphinWithTheMaxEnergy());
    }

    @Test
    public void FindAllDolphinsMethodByTypeReturnsCollectionSuccessfully() {
        dolphinarium.setCapacity(10);
        dolphinarium.addDolphin(dolphinB);
        dolphinarium.addDolphin(dolphinC);
        dolphinarium.addDolphin(dolphinD);
        List<Dolphin> commonDolphins = dolphinarium.findAllDolphinsByType("Common");
        for (Dolphin dolphin : commonDolphins) {
            Assertions.assertEquals("Common", dolphin.getType());
        }
        List<Dolphin> hourglassDolphins = dolphinarium.findAllDolphinsByType("Hourglass");
        for (Dolphin dolphin : hourglassDolphins) {
            Assertions.assertEquals("Hourglass", dolphin.getType());
        }
    }
}
