package D_OOP.Y_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.destination;

import D_OOP.Y_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.car.Car;

import java.util.Collection;

public interface Destination {

    Collection<Car> getCars();

    String getName();

    int getDistance();
}
