package D_OOP.X_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.competition;

import D_OOP.X_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.car.Car;
import D_OOP.X_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.destination.Destination;

import java.util.Collection;

public class CompetitionImpl implements Competition {

    @Override
    public void startVoyage(Destination destination, Collection<Car> cars) {
        for (Car car : cars) {
            while (car.getMileage() <  destination.getDistance() && car.getBatteryCapacity() >= 15) {
                car.drive();
                if (car.getMileage() >= destination.getDistance()) {
                    break;
                } else if (car.getBatteryCapacity() == 0) {
                    break;
                }
            }
        }
    }
}
