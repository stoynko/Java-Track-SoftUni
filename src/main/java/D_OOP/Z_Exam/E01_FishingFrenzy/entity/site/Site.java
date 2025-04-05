package D_OOP.Z_Exam.E01_FishingFrenzy.entity.site;

import D_OOP.Z_Exam.E01_FishingFrenzy.entity.fisherman.Fisherman;

import java.util.Collection;

public interface Site {
    Collection<Fisherman> getFishermen();
    String getName();
    String getType();
    int getQuota();
    void reduceQuota();
}
