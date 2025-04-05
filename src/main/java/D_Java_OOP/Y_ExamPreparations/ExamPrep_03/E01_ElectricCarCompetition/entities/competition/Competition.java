package D_Java_OOP.Y_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.competition;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.car.Car;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.destination.Destination;

import java.util.Collection;

public interface Competition {

    void startVoyage(Destination destination, Collection<Car> cars);
}
