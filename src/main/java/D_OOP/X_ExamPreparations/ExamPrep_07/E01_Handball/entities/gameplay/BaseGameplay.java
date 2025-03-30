package D_OOP.X_ExamPreparations.ExamPrep_07.E01_Handball.entities.gameplay;

import D_OOP.X_ExamPreparations.ExamPrep_07.E01_Handball.common.*;
import D_OOP.X_ExamPreparations.ExamPrep_07.E01_Handball.entities.equipment.*;
import D_OOP.X_ExamPreparations.ExamPrep_07.E01_Handball.entities.team.*;

import java.util.*;
import java.util.stream.*;

public class BaseGameplay implements Gameplay {

    private String name;
    private int capacity;
    private Collection<Equipment> equipments;
    private Collection<Team> teams;

    public BaseGameplay(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.equipments = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new NullPointerException(ExceptionMessages.GAMEPLAY_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int allProtection() {
        return this.equipments.stream().mapToInt(Equipment::getProtection).sum();
    }

    @Override
    public void addTeam(Team team) {
        this.teams.add(team);
    }

    @Override
    public void removeTeam(Team team) {
        this.teams.remove(team);
    }

    @Override
    public void addEquipment(Equipment equipment) {
        this.equipments.add(equipment);
    }

    @Override
    public void teamsInGameplay() {
        for (Team team : teams) {
            team.play();
        }
    }

    @Override
    public Collection<Team> getTeam() {
        return this.teams;
    }

    @Override
    public Collection<Equipment> getEquipments() {
        return this.equipments;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.name + " " + this.getClass().getSimpleName()).append(System.lineSeparator());
        output.append("Team: ");
        if (!this.teams.isEmpty()) {
            List<String> teamsList = this.teams.stream().map(Team::getName).collect(Collectors.toList());
            String teams = String.join(" ", teamsList);
            output.append(teams);
        } else {
            output.append("none");
        }
        output.append(System.lineSeparator());
        output.append(String.format("Equipment: %d, Protection: %d", this.equipments.size(), this.allProtection()));
        return output.toString().trim();
    }
}
