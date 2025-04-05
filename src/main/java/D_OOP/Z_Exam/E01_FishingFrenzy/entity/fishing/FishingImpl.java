package D_OOP.Z_Exam.E01_FishingFrenzy.entity.fishing;

import D_OOP.Z_Exam.E01_FishingFrenzy.entity.fisherman.*;
import D_OOP.Z_Exam.E01_FishingFrenzy.entity.site.*;

import java.util.*;

public class FishingImpl implements Fishing {

    @Override
    public void startFishing(Site site) {

        Iterator<Fisherman> fishermanIterator = site.getFishermen().iterator();
        Fisherman fisherman = null;

        while (fishermanIterator.hasNext()) {
            fisherman = fishermanIterator.next();

            while (site.getQuota() > 0 && fisherman.getBait() > 0) {
                fisherman.fishing();
                site.reduceQuota();
            }
        }
    }
}
