package D_OOP.X_ExamPreparations.ExamPrep_03.E02_UnitTesting;

import java.util.*;
import java.util.stream.Collectors;

public class Garage {

    private static final String NO_MORE_SPACE = "No more space in the garage!";
    private static final String INVALID_GARAGE_NAME = "Invalid garage name!";
    private static final String CAR_EXIST = "This car exist in the garage!";
    private static final String INVALID_CAPACITY = "Invalid capacity!";

    private static final int ZERO_CAPACITY = 0;

    private String name;
    private int capacity;
    private final Collection<Car> cars;

    public Garage(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        if (cars.size() >= this.getCapacity()) {
            throw new IllegalArgumentException(NO_MORE_SPACE);
        }
        boolean carExist = this.cars
                .stream()
                .anyMatch(c -> c.getBrand().equals(car.getBrand()));

        if (carExist) {
            throw new IllegalArgumentException(CAR_EXIST);
        }
        cars.add(car);
    }

    public boolean removeCar(String carBrand) {
        Car car = this.cars
                .stream()
                .filter(c -> c.getBrand().equals(carBrand))
                .findFirst()
                .orElse(null);

        return this.cars.remove(car);
    }

    public String getMostPowerfulCar() {
        Car mostPowerfulCar =  cars.stream().max(Comparator.comparing(Car::getPower)).orElse(null);
        assert mostPowerfulCar != null;
        return mostPowerfulCar.getBrand();
    }

    public List<Car> getCarsWithDesiredColor(String color) {
        return cars.stream().filter(c -> c.getColor().equals(color)).collect(Collectors.toList());
    }

    public int getCount() {
        return cars.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(INVALID_GARAGE_NAME);
        }
        this.name = name;
    }

    public void setCapacity(int capacity) {
        if (capacity < ZERO_CAPACITY) {
            throw new IllegalArgumentException(INVALID_CAPACITY);
        }
        this.capacity = capacity;
    }
}
