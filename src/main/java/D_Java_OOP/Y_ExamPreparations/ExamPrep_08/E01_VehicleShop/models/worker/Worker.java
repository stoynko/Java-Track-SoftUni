package D_Java_OOP.Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.worker;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.tool.Tool;

import java.util.Collection;

public interface Worker {
    void working();
    void addTool(Tool tool);
    boolean canWork();
    String getName();
    int getStrength();
    Collection<Tool> getTools();
}
