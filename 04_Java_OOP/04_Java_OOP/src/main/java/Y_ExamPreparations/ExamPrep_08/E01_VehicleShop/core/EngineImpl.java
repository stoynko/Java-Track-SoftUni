package Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.core;

import Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {
        this.controller = new ControllerImpl();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals("Exit")) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddWorker:
                result = addWorker(data);
                break;
            case AddVehicle:
                result = addVehicle(data);
                break;
            case AddToolToWorker:
                result = addToolToWorker(data);
                break;
            case MakingVehicle:
                result = makingVehicle(data);
                break;
            case Statistics:
                result = statistics();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }
        return result;
    }

    private String addWorker(String[] data) {
        String type = data[0];
        String workerName = data[1];
        return controller.addWorker(type, workerName);
    }

    private String addVehicle(String[] data) {
        String vehicleName = data[0];
        int strengthRequired = Integer.parseInt(data[1]);
        return controller.addVehicle(vehicleName, strengthRequired);
    }

    private String addToolToWorker(String[] data) {
        String workerName = data[0];
        int power = Integer.parseInt(data[1]);
        return controller.addToolToWorker(workerName, power);
    }

    private String makingVehicle(String[] data) {
        String vehicleName = data[0];
        return controller.makingVehicle(vehicleName);
    }

    private String statistics() {
        return controller.statistics();
    }
}
