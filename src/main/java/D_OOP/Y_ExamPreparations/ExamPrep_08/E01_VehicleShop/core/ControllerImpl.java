package D_OOP.Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.core;

import D_OOP.Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.common.*;
import D_OOP.Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.shop.*;
import D_OOP.Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.tool.*;
import D_OOP.Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.vehicle.*;
import D_OOP.Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.worker.*;
import D_OOP.Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.repositories.*;

import java.util.*;
import java.util.stream.*;

public class ControllerImpl implements Controller {

    private VehicleRepository vehicleRepository;
    private WorkerRepository workerRepository;
    private Shop shop;

    public ControllerImpl() {
        this.vehicleRepository = new VehicleRepository();
        this.workerRepository = new WorkerRepository();
        this.shop = new ShopImpl();
    }

    @Override
    public String addWorker(String type, String workerName) {
        Worker worker;
        switch (type) {
            case "FirstShift": worker = new FirstShift(workerName);
                break;
            case "SecondShift": worker = new SecondShift(workerName);
                break;
            default: throw new IllegalArgumentException(ExceptionMessages.WORKER_TYPE_DOESNT_EXIST);
        }
        this.workerRepository.add(worker);

        return String.format(ConstantMessages.ADDED_WORKER, type, workerName);
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        Vehicle vehicle = new VehicleImpl(vehicleName, strengthRequired);
        this.vehicleRepository.add(vehicle);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        Tool tool = new ToolImpl(power);
        Worker worker = this.workerRepository.getWorkers().stream().filter(w -> w.getName().equals(workerName)).findFirst().orElse(null);
        if (worker == null) {
            throw new IllegalArgumentException("The worker doesn't exist. You cannot add a tool.");
        }
            worker.addTool(tool);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {
        List<Worker> fitToWork = this.workerRepository.getWorkers().stream().filter(worker -> worker.getStrength() > 70).collect(Collectors.toList());
        if (fitToWork.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_WORKER_READY);
        }
        Vehicle vehicle = this.vehicleRepository.getWorkers().stream().filter(v -> v.getName().equals(vehicleName)).findFirst().orElse(null);
        int toolsUsed = 0;

        while (!vehicle.reached()) {
            for (Worker worker : fitToWork) {
                int workerTools = worker.getTools().size();
                shop.make(vehicle, worker);
                toolsUsed += workerTools - worker.getTools().size();
                if (vehicle.reached()) {
                    break;
                }
            }
        }
        StringBuilder output = new StringBuilder();
        output.append(String.format("Vehicle %s is %s. ", vehicle.getName(), vehicle.reached() ? "done" : "not done"));
        output.append(String.format("%d tool/s have been unfit while working on it.", toolsUsed));
        return output.toString().trim();
    }

    @Override
    public String statistics() {
        StringBuilder output = new StringBuilder();
        int readyVehicles = this.vehicleRepository.getWorkers().stream().filter(Vehicle::reached).collect(Collectors.toList()).size();
        output.append(String.format("%d vehicles are ready!", readyVehicles)).append(System.lineSeparator());
        output.append("Info for workers:").append(System.lineSeparator());
        for (Worker worker : this.workerRepository.getWorkers()) {
            output.append(String.format("Name: %s, Strength: %d", worker.getName(), worker.getStrength())).append(System.lineSeparator());
            int toolsLeft = worker.getTools().stream().filter(tool -> !tool.isUnfit()).collect(Collectors.toList()).size();
            output.append(String.format("Tools: %d fit left", toolsLeft)).append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
