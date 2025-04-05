package D_Java_OOP.Y_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.core;

public interface Controller {
    String addDiver(String kind, String diverName);
    String addDivingSite(String siteName, String... seaCreatures);
    String removeDiver(String diverName);
    String startDiving(String siteName);
    String getStatistics();
}
