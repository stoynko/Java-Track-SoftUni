package Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.shop;

import Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.tool.*;
import Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.vehicle.*;
import Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.models.worker.*;

import java.util.*;

public class ShopImpl implements Shop {

    public ShopImpl() {
    }

    @Override
    public void make(Vehicle vehicle, Worker worker) {
        Iterator<Tool> toolIterator = worker.getTools().iterator();
        Tool tool = toolIterator.next();
        while (worker.canWork() && !tool.isUnfit()) {
            worker.working();
            tool.decreasesPower();
            vehicle.making();
            if (tool.isUnfit()) {
                toolIterator.remove();
                if (toolIterator.hasNext()) {
                    tool = toolIterator.next();
                } else {
                    break;
                }
            }
            if (vehicle.reached()) {
                break;
            }
        }
    }
}
