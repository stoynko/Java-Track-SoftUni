package D_OOP.Z_Exam.E01_FishingFrenzy.entity.site;

import D_OOP.Z_Exam.E01_FishingFrenzy.common.*;
import D_OOP.Z_Exam.E01_FishingFrenzy.entity.fisherman.*;

import java.util.*;

public class SiteImpl implements Site {

    private String name;
    private String type;
    private int quota;
    private Collection<Fisherman> fishermen;

    public SiteImpl(String name, String type, int quota) {
        setName(name);
        this.type = type;
        this.quota = quota;
        fishermen = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.SITE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public int getQuota() {
        return this.quota;
    }

    @Override
    public void reduceQuota() {
        this.quota -= 1;
    }

    @Override
    public Collection<Fisherman> getFishermen() {
        return this.fishermen;
    }
}
