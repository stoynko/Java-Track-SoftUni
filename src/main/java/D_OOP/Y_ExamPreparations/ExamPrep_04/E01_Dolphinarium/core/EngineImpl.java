package D_OOP.Y_ExamPreparations.ExamPrep_04.E01_Dolphinarium.core;

import D_OOP.Y_ExamPreparations.ExamPrep_04.E01_Dolphinarium.common.Command;

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
            case AddPool:
                result = addPool(data);
                break;
            case BuyFood:
                result = buyFood(data);
                break;
            case AddFoodToPool:
                result = addFoodToPool(data);
                break;
            case AddDolphin:
                result = addDolphin(data);
                break;
            case FeedDolphins:
                result = feedDolphins(data);
                break;
            case PlayWithDolphins:
                result = playWithDolphins(data);
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
    private String addPool(String[] data) {
        String poolType = data[0];
        String poolName = data[1];
        return controller.addPool(poolType, poolName);
    }

    private String buyFood(String[] data) {
        String foodType = data[0];
        return controller.buyFood(foodType);
    }

    private String addFoodToPool(String[] data) {
        String poolName = data[0];
        String foodType = data[1];
        return controller.addFoodToPool(poolName, foodType);
    }


    private String addDolphin(String[] data) {
        String poolName = data[0];
        String dolphinType = data[1];
        String dolphinName = data[2];
        int dolphinEnergy = Integer.parseInt(data[3]);
        return controller.addDolphin(poolName, dolphinType, dolphinName, dolphinEnergy);
    }

    private String feedDolphins(String[] data) {
        String poolName = data[0];
        String foodType = data[1];
        return controller.feedDolphins(poolName, foodType);
    }

    private String playWithDolphins(String[] data) {
        String poolName = data[0];
        return controller.playWithDolphins(poolName);
    }

    private String getStatistics() {
        return controller.getStatistics();
    }
}