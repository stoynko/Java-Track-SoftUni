package Y_ExamPreparations.ExamPrep_07.E01_Handball.core;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_07.E01_Handball.common.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_07.E01_Handball.entities.equipment.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_07.E01_Handball.entities.gameplay.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_07.E01_Handball.entities.team.*;
import D_Java_OOP.Y_ExamPreparations.ExamPrep_07.E01_Handball.repositories.*;

import java.util.*;

public class ControllerImpl implements Controller {

    private EquipmentRepository equipmentRepository;
    private Collection<Gameplay> gameplays;

    public ControllerImpl() {
        equipmentRepository = new EquipmentRepository();
        this.gameplays = new ArrayList<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        Gameplay gameplay;
        switch (gameplayType) {

            case "Outdoor": gameplay = new Outdoor(gameplayName);
                break;
            case "Indoor": gameplay = new Indoor(gameplayName);
                break;
            default: throw new NullPointerException(ExceptionMessages.INVALID_GAMEPLAY_TYPE);
        }
        this.gameplays.add(gameplay);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        Equipment equipment;
        switch (equipmentType) {
            case "Kneepad": equipment = new Kneepad();
                break;
            case "ElbowPad": equipment = new ElbowPad();
                break;
            default: throw new IllegalArgumentException(ExceptionMessages.INVALID_EQUIPMENT_TYPE);
        }
        this.equipmentRepository.add(equipment);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Gameplay gameplay = this.gameplays.stream().filter(g -> g.getName().equals(gameplayName)).findFirst().orElse(null);
        Equipment equipment = equipmentRepository.findByType(equipmentType);
        if (gameplay != null && equipment != null) {
            gameplay.addEquipment(equipment);
        } else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_EQUIPMENT_FOUND, equipmentType));
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY,equipmentType, gameplayName);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        Gameplay gameplay = this.gameplays.stream().filter(g -> g.getName().equals(gameplayName)).findFirst().orElse(null);
        Team team;
        switch (teamType) {
            case "Bulgaria":
                team = new Bulgaria(teamName, country, advantage);
                break;
            case "Germany": team = new Germany(teamName, country, advantage);
                break;
            default: throw new IllegalArgumentException(ExceptionMessages.INVALID_TEAM_TYPE);
        }
        String gameplayType = gameplay.getClass().getSimpleName();
        if ((teamType.equals("Bulgaria") && !gameplayType.equals("Outdoor")) || (teamType.equals("Germany") && !gameplayType.equals("Indoor"))) {
            return String.format(ConstantMessages.GAMEPLAY_NOT_SUITABLE);
        } else {
            gameplay.addTeam(team);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
        }
    }

    @Override
    public String playInGameplay(String gameplayName) {
        Gameplay gameplay = this.gameplays.stream().filter(g -> g.getName().equals(gameplayName)).findFirst().orElse(null);
        int numberOfTeams = 0;
        if (gameplay != null) {
            gameplay.teamsInGameplay();
            numberOfTeams = gameplay.getTeam().size();
            return String.format(ConstantMessages.TEAMS_PLAYED, numberOfTeams);
        }
        return String.format(ConstantMessages.TEAMS_PLAYED, numberOfTeams);
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        Gameplay gameplay = this.gameplays.stream().filter(g -> g.getName().equals(gameplayName)).findFirst().orElse(null);
        int advantageSum = 0;
        if (gameplay != null) {
            advantageSum = gameplay.getTeam().stream().mapToInt(Team::getAdvantage).sum();
        }
        return String.format(ConstantMessages.ADVANTAGE_GAMEPLAY,gameplayName, advantageSum);
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();

        for (Gameplay gameplay : gameplays) {
            output.append(gameplay);
            output.append(System.lineSeparator());
        }

        return output.toString().trim();
    }
}
