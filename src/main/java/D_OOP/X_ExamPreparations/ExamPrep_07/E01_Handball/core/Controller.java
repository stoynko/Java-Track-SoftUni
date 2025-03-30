package D_OOP.X_ExamPreparations.ExamPrep_07.E01_Handball.core;

public interface Controller {
    String addGameplay(String gameplayType, String gameplayName);
    String addEquipment(String equipmentType);
    String equipmentRequirement(String gameplayName, String equipmentType);
    String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage);
    String playInGameplay(String gameplayName);
    String percentAdvantage(String gameplayName);
    String getStatistics();



}
