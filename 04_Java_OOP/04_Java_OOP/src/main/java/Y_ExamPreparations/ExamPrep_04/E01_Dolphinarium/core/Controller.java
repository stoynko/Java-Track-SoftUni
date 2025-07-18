package Y_ExamPreparations.ExamPrep_04.E01_Dolphinarium.core;

public interface Controller {
    String addPool(String poolType, String poolName);
    String buyFood(String foodType);
    String addFoodToPool(String poolName, String foodType);
    String addDolphin(String poolName, String dolphinType, String dolphinName, int energy);
    String feedDolphins(String poolName, String food);
    String playWithDolphins(String poolName);
    String getStatistics();
}
