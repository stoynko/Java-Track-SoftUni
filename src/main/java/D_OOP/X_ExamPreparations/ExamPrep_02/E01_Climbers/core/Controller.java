package D_OOP.X_ExamPreparations.ExamPrep_02.E01_Climbers.core;

public interface Controller {
    String addClimber(String type, String climberName);
    String addMountain(String mountainName, String... peaks);
    String removeClimber(String climberName);
    String startClimbing(String mountainName);
    String getStatistics();
}
