package Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.shop;

import Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.vehicle.Vehicle;
import Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.worker.Worker;

public interface Shop {
    void make(Vehicle vehicle, Worker worker);
}
