package D_OOP.Y_ExamPreparations.ExamPrep_07.E01_Handball.entities.gameplay;

import D_OOP.Y_ExamPreparations.ExamPrep_07.E01_Handball.entities.team.Team;
import D_OOP.Y_ExamPreparations.ExamPrep_07.E01_Handball.entities.equipment.Equipment;

import java.util.Collection;

public interface Gameplay {
    int allProtection();

    void addTeam(Team team);

    void removeTeam(Team team);

    void addEquipment(Equipment equipment);

    void teamsInGameplay();

    Collection<Team> getTeam();

    Collection<Equipment> getEquipments();

    String getName();


}
