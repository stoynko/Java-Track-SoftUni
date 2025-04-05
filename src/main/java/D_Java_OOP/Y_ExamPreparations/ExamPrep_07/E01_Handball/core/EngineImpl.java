package D_Java_OOP.Y_ExamPreparations.ExamPrep_07.E01_Handball.core;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_07.E01_Handball.common.Command;

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
            } catch (NullPointerException | IllegalArgumentException | IllegalStateException | IOException e) {
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
            case AddGameplay:
                result = addGameplay(data);
                break;
            case AddTeam:
                result = addTeam(data);
                break;
            case AddEquipment:
                result = addEquipment(data);
                break;
            case EquipmentRequirement:
                result = equipmentRequirement(data);
                break;
            case PlayInGameplay:
                result = playInGameplay(data);
                break;
            case PercentAdvantage:
                result = percentAdvantage(data);
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

    private String addGameplay(String[] data) {
        String gameplayType = data[0];
        String gameplayName = data[1];
        return controller.addGameplay(gameplayType, gameplayName);
    }

    private String addEquipment(String[] data) {
        String equipmentType = data[0];
        return controller.addEquipment(equipmentType);
    }

    private String equipmentRequirement(String[] data) {
        String gameplayName = data[0];
        String equipmentType = data[1];
        return controller.equipmentRequirement(gameplayName, equipmentType);
    }

    private String addTeam(String[] data) {
        String gameplayName = data[0];
        String teamType = data[1];
        String teamName = data[2];
        String country = data[3];
        int advantage = Integer.parseInt(data[4]);
        return controller.addTeam(gameplayName, teamType, teamName, country, advantage);
    }

    private String playInGameplay(String[] data) {
        String gameplayName = data[0];
        return controller.playInGameplay(gameplayName);
    }

    private String percentAdvantage(String[] data) {
        String gameplayName = data[0];
        return controller.percentAdvantage(gameplayName);
    }

    private String getStatistics() {
        return controller.getStatistics();
    }
}
