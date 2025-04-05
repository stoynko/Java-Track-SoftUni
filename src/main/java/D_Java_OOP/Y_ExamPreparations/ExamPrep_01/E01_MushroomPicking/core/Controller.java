package D_Java_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.core;

public interface Controller {
    String addPlace(String placeName, String... mushrooms);
    String addPicker(String placeName, String pickerType, String pickerName);
    String startPicking(String placeName);
    String getStatistics();
}
