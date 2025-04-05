package D_Java_OOP.Y_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.destination;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.common.ExceptionMessages;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.car.Car;

import java.util.ArrayList;
import java.util.Collection;

public class BaseDestination implements Destination{

    private String name;
    private int distance;
    private Collection<Car> cars;

    public BaseDestination(String name, int distance) {
        setName(name);
        setDistance(distance);
        this.cars = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.DESTINATION_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setDistance(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException(ExceptionMessages.NEGATIVE_DISTANCE_VALUE);
        }
        this.distance = distance;
    }

    @Override
    public Collection<Car> getCars() {
        return this.cars;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDistance() {
        return this.distance;
    }
}
