package OOP.X_ExamPreparations.ExamPrep_08;

import D_OOP.Y_ExamPreparations.ExamPrep_08.E02_CarShop.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class CarShopTests {

    public static final String CAR_A_MODEL = "Skoda Octavia";
    public static final String CAR_B_MODEL = "Skoda Kodiaq ";
    public static final String CAR_C_MODEL = "Skoda Scala";

    public static final int CAR_A_HORSEPOWER = 150;
    public static final int CAR_B_HORSEPOWER = 190;
    public static final int CAR_C_HORSEPOWER = 95;

    public static final double CAR_A_PRICE = 27390.0;
    public static final double CAR_B_PRICE = 38140.0;
    public static final double CAR_C_PRICE = 22740.0;

    public static final int HORSEPOWER_THRESHOLD = 100;

    CarShop carShop;
    Car carA;
    Car carB;
    Car carC;

    @BeforeEach
    public void init() {
        carShop = new CarShop();
        carA = new Car(CAR_A_MODEL, CAR_A_HORSEPOWER, CAR_A_PRICE);
        carB = new Car(CAR_B_MODEL, CAR_B_HORSEPOWER, CAR_B_PRICE);
        carC = new Car(CAR_C_MODEL, CAR_C_HORSEPOWER, CAR_C_PRICE);
        carShop.add(carA);
        carShop.add(carB);
        carShop.add(carC);
    }

    @Test
    public void GetCarsMethodReturnsUnmodifiableCollection() {
        List<Car> collection = carShop.getCars();
        Assertions.assertThrows(UnsupportedOperationException.class, () -> collection.add(carA));
    }

    @Test
    public void GetCountMethodReturnsCorrectAmount() {
        int initialCount = 3;
        Assertions.assertEquals(initialCount, carShop.getCount());
        carShop.remove(carA);
        Assertions.assertEquals(initialCount - 1, carShop.getCount());
        carShop.remove(carB);
        Assertions.assertEquals(initialCount - 2, carShop.getCount());
    }

    @Test
    public void FindAllCarsMethodReturnsCarsWithAboveSetHP() {
        List<Car> filteredCars = carShop.findAllCarsWithMaxHorsePower(100);
        int filteredCarsCount = carShop.getCars().stream().filter(car -> car.getHorsePower() > HORSEPOWER_THRESHOLD).collect(Collectors.toList()).size();
        Assertions.assertEquals(filteredCarsCount, filteredCars.size());
        Assertions.assertTrue(filteredCars.stream().allMatch(car -> car.getHorsePower() > HORSEPOWER_THRESHOLD));
    }

    @Test
    public void AddCarMethodThrowsNullPointerExceptionWhenNull() {
        Assertions.assertThrows(NullPointerException.class, () -> carShop.add(null));
    }

    @Test
    public void GetMostLuxuryCarMethodReturnsCorrectCar() {
        Assertions.assertSame(carB, carShop.getTheMostLuxuryCar());
        carShop.remove(carB);
        Assertions.assertSame(carA, carShop.getTheMostLuxuryCar());
    }

    @Test
    public void FindAllCarsByModelMethodReturnsCollection() {
        carShop.add(new Car(CAR_A_MODEL, 170, 23000.0));
        carShop.add(new Car(CAR_A_MODEL, 160, 22575.0));
        List<Car> filteredCars = carShop.findAllCarByModel(CAR_A_MODEL);
        int filteredCarsCount = carShop.getCars().stream().filter(car -> car.getModel().equals(CAR_A_MODEL)).collect(Collectors.toList()).size();
        Assertions.assertEquals(filteredCarsCount, filteredCars.size());
        Assertions.assertTrue(filteredCars.stream().allMatch(car -> car.getModel().equals(CAR_A_MODEL)));
    }
}

