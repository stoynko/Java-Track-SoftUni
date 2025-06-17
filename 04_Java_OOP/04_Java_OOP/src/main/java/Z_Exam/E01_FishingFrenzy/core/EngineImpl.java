package Z_Exam.E01_FishingFrenzy.core;

import Z_Exam.E01_FishingFrenzy.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {

    private Controller controller;
    private BufferedReader reader;

    public EngineImpl(Controller controller) {
        this.controller = new ControllerImpl();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
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
            case AddSite:
                result = addSite(data);
                break;
            case AddFisherman:
                result = addFisherman(data);
                break;
            case GoFishing:
                result = goFishing(data);
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

    private String addSite(String[] data) {
        String siteType = data[0];
        String siteName = data[1];
        int quota = Integer.parseInt(data[2]);
        return controller.addSite(siteType, siteName, quota);
    }

    private String addFisherman(String[] data) {
        String siteName = data[0];
        String fishermanType = data[1];
        String fishermanName = data[2];
        return controller.addFisherman(siteName, fishermanType, fishermanName);
    }

    private String goFishing(String[] data){
        String siteName = data[0];
        return controller.goFishing(siteName);
    }

    private String getStatistics() {
        return controller.getStatistics();
    }
}
