package D_OOP.X_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.core;

import D_OOP.X_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.common.*;
import D_OOP.X_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.car.*;
import D_OOP.X_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.destination.*;
import D_OOP.X_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.repositories.*;


public class ControllerImpl implements Controller {

    private DestinationRepository destinationRepository = new DestinationRepository();

    @Override
    public String addDestination(String destinationType, String destinationName) {
        Destination destination;
        switch (destinationType) {
            case "Lake":
                destination = new Lake(destinationName);
                break;
            case "Mountain":
                destination = new Mountain(destinationName);
                break;
            case "SeaSide":
                destination = new SeaSide(destinationName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_DESTINATION);
        }
        if (destinationRepository.getCollection().stream().anyMatch(d -> d.getName().equals(destinationName))) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_DESTINATION);
        }
        destinationRepository.add(destination);
        return String.format(ConstantMessages.DESTINATION_ADDED, destinationType, destinationName);
    }

    @Override
    public String addCar(String destinationName, String carBrand, String carModel) {

        Destination destination = destinationRepository.getCollection().stream().filter(d -> d.getName().equals(destinationName)).findFirst().orElse(null);

        if (destination == null) {
            throw new NullPointerException(ExceptionMessages.NON_EXISTING_DESTINATION);
        }

        Car car = null;
        switch (carBrand) {
            case "Tesla":
                car = new Tesla(carModel);
                break;
            case "Hyundai":
                car = new Hyundai(carModel);
                break;
            case "VW":
                car = new VW(carModel);
                break;
            case "Dacia":
                car = new Dacia(carModel);
                break;
            default: throw new IllegalArgumentException(ExceptionMessages.INVALID_CAR);
        }

        if (destination.getCars().stream().anyMatch(c -> c.getModel().equals(carModel))) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_CAR_BRAND_AND_MODEL);
        }

        destination.getCars().add(car);
        return String.format(ConstantMessages.CAR_ADDED, carBrand, carModel);
    }

    @Override
    public String reachDestination(String destinationName) {
        Destination destination = this.destinationRepository.getCollection().stream().filter(d -> d.getName().equals(destinationName)).findFirst().orElse(null);
        int eliminatedContestants = 0;
        if (destination != null) {
            for (Car car : destination.getCars()) {
                while (car.getBatteryCapacity() >= 15 && car.getMileage() < destination.getDistance()) {
                    car.drive();

                    if (car.getMileage() >= destination.getDistance()) {
                        continue;
                    }

                    if (car.getBatteryCapacity() < 15) {
                        eliminatedContestants++;
                        break;
                    }
                }
            }
        }
        return String.format(ConstantMessages.VOYAGE_OVER, destinationName, eliminatedContestants);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        for (Destination destination : destinationRepository.getCollection()) {
            output.append(String.format("Cars that took part in competition to %s:", destination.getName())).append(System.lineSeparator());
            for (Car car : destination.getCars()) {
                output.append(String.format("*%s %s", car.getClass().getSimpleName(), car.getModel())).append(System.lineSeparator());
                output.append(String.format("**Battery capacity: %dkWh.", car.getBatteryCapacity())).append(System.lineSeparator());
                output.append(String.format("**Mileage: %dkm.", car.getMileage())).append(System.lineSeparator());
            }
        }
        return output.toString();
    }
}
