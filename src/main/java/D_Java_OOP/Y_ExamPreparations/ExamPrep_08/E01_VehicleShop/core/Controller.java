package D_Java_OOP.Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.core;

public interface Controller {
    String addWorker(String type, String workerName);
    String addVehicle(String vehicleName, int strengthRequired);
    String addToolToWorker(String workerName, int power);
    String makingVehicle(String vehicleName);
    String statistics();
}
