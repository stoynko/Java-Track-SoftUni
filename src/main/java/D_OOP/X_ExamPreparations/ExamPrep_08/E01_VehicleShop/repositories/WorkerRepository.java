package D_OOP.X_ExamPreparations.ExamPrep_08.E01_VehicleShop.repositories;

import D_OOP.X_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.worker.*;

import java.util.*;

public class WorkerRepository implements Repository<Worker> {

    private Collection<Worker> workers;

    public WorkerRepository() {
        this.workers = new ArrayList<>();
    }

    @Override
    public void add(Worker model) {
        this.workers.add(model);
    }

    @Override
    public boolean remove(Worker model) {
        return this.workers.remove(model);
    }

    @Override
    public Worker findByName(String name) {
        return this.workers.stream().filter(worker -> worker.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Worker> getWorkers() {
        return Collections.unmodifiableCollection(this.workers);
    }
}
