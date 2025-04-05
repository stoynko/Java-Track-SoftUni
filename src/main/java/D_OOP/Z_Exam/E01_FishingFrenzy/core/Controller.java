package D_OOP.Z_Exam.E01_FishingFrenzy.core;

public interface Controller {
    String addSite(String siteType, String siteName, int quota);
    String addFisherman(String siteName, String fishermanType, String fishermanName);
    String goFishing(String siteName);
    String getStatistics();
}
