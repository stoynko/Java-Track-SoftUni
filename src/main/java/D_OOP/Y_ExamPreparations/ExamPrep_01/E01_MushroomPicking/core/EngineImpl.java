package D_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.core;

import D_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {

    private Controller controller;
    private BufferedReader reader;

    public EngineImpl(Controller controller) {
        this.controller = controller;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run() {
        while (true) {
            String result;
            try {
                result = processInput();

                if (result.equals(Command.Exit.name())) {
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
            case AddPlace:
                result = addPlace(data);
                break;
            case AddPicker:
                result = addPicker(data);
                break;
            case StartPicking:
                result = startPicking(data);
                break;
            case GetStatistics:
                result = getStatistics();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }

        return result;
    }

    private String addPlace(String[] data) {
        return controller.addPlace(data[0], Arrays.stream(data).skip(1).toArray(String[]::new));
    }

    private String addPicker(String[] data) {
        String placeName = data[0];
        String pickerType = data[1];
        String pickerName = data[2];
        return controller.addPicker(placeName, pickerType, pickerName);
    }

    private String startPicking(String[] data){
        String placeName = data[0];
        return controller.startPicking(placeName);
    }

    private String getStatistics() {
        return controller.getStatistics();
    }
}
