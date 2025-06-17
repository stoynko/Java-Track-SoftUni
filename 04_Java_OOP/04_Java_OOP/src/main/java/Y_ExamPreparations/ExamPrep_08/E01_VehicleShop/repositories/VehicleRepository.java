package Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.repositories;


import Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.vehicle.*;

import java.util.*;

public class VehicleRepository implements Repository<Vehicle> {

    private Collection<Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public void add(Vehicle model) {
        this.vehicles.add(model);
    }

    @Override
    public boolean remove(Vehicle model) {
        return this.vehicles.remove(model);
    }

    @Override
    public Vehicle findByName(String name) {
        return this.vehicles.stream().filter(vehicle -> vehicle.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Vehicle> getWorkers() {
        return Collections.unmodifiableCollection(this.vehicles);
    }
}
