package X_ExamPreparations.ExamPrep_03;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_03.E02_Garage.*;
import org.junit.jupiter.api.*;

import java.util.List;

public class GarageTests {

    private static final String GARAGE_TEST_NAME = "Auto";
    private static final int GARAGE_INITIAL_CAPACITY = 3;
    private static final int NEGATIVE_CAPACITY = -1;
    private static final String EMPTY_STRING = " ";

    private static final String CAR_A_BRAND = "Ford";
    private static final String CAR_B_BRAND = "Renault";
    private static final String CAR_C_BRAND = "Skoda";
    private static final String CAR_D_BRAND = "Fiat";

    private static final String CAR_A_COLOR = "Blue";
    private static final String CAR_B_COLOR = "Black";
    private static final String CAR_C_COLOR = "Red";

    private static final int CAR_A_POWER = 150;
    private static final int CAR_B_POWER = 125;
    private static final int CAR_C_POWER = 115;

    private Garage garage;
    private Car carA;
    private Car carB;
    private Car carC;

    @BeforeEach
    public void init(){
        garage = new Garage(GARAGE_TEST_NAME, GARAGE_INITIAL_CAPACITY);
        carA = new Car (CAR_A_BRAND, CAR_A_POWER, CAR_A_COLOR);
        carB = new Car(CAR_B_BRAND, CAR_B_POWER, CAR_B_COLOR);
        garage.addCar(carA);
        garage.addCar(carB);
    }

    @Test
    public void constructorCreatesObjectSuccessfully() {
        garage = new Garage(GARAGE_TEST_NAME, GARAGE_INITIAL_CAPACITY);
    }

    @Test
    public void SetNameMethodThrowsNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> garage.setName(EMPTY_STRING));
    }

    @Test
    public void SetCapacityMethodThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> garage.setCapacity(NEGATIVE_CAPACITY));
    }

    @Test
    public void GetGarageNameReturnsNameSuccessfully() {
        String garageName = garage.getName();
        Assertions.assertEquals(GARAGE_TEST_NAME, garageName);
    }

    @Test
    public void AddCarMethodThrowsIllegalArgumentExceptionNoSpace() {
        garage.addCar(new Car(CAR_D_BRAND, CAR_B_POWER, CAR_C_COLOR));
        carC = new Car(CAR_C_BRAND, CAR_C_POWER, CAR_B_COLOR);
        Assertions.assertThrows(IllegalArgumentException.class, () -> garage.addCar(carC));
    }

    @Test
    public void AddCarMethodThrowsIllegalArgumentExceptionCarExists () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> garage.addCar(new Car(CAR_A_BRAND, CAR_A_POWER, CAR_A_COLOR)));
    }

    @Test
    public void AddCarMethodSuccessfullyAddsCar () {
        int previouslyStoredCarsCount = garage.getCount();
        garage.addCar(new Car(CAR_C_BRAND, CAR_C_POWER, CAR_C_COLOR));
        int currentStoredCarsCount = garage.getCount();
        Assertions.assertEquals(previouslyStoredCarsCount + 1, currentStoredCarsCount);
    }

    @Test
    public void RemoveCarMethodRemovesSuccessfully() {
        boolean result = garage.removeCar(CAR_A_BRAND);
        int currentStoredCarsCount = garage.getCount();
        Assertions.assertTrue(result);
        Assertions.assertEquals(currentStoredCarsCount, garage.getCount());
    }

    @Test
    public void GetCarWithDesiredColorReturnsCarsSuccessfully() {
        garage.addCar(new Car(CAR_D_BRAND, CAR_A_POWER, CAR_A_COLOR));
        List<Car> carsList = garage.getCarsWithDesiredColor(CAR_A_COLOR);
        for (Car car : carsList) {
            Assertions.assertEquals(CAR_A_COLOR, car.getColor());
        }
    }

    @Test
    public void GetMostPowerfulCarReturnsCarSuccessfully() {
        String mostPowerfulBrand = garage.getMostPowerfulCar();
        Assertions.assertEquals(CAR_A_BRAND, carA.getBrand());
    }
}


