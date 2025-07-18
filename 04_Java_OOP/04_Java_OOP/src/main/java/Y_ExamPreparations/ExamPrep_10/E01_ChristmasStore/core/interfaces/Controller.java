package Y_ExamPreparations.ExamPrep_10.E01_ChristmasStore.core.interfaces;

public interface Controller {
   String addDelicacy(String type, String name, double price);
   String addCocktail(String type, String name, int portion, String brand);
   String addBooth(String type, int tableNumber, int capacity);
   String reserveBooth(int numberOfPeople);
   String leaveBooth(int tableNumber);
   String getIncome();
}
