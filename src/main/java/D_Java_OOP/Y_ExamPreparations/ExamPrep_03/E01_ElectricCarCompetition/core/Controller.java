package D_Java_OOP.Y_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.core;

public interface Controller {
    String addDestination(String destinationType, String destinationName);
    String addCar(String destinationName, String carBrand, String carModel);
    String reachDestination(String destinationName);
    String getStatistics();
}
