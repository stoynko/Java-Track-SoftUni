package Z_Exam.E01_FishingFrenzy.core;

import D_Java_OOP.Z_Exam.E01_FishingFrenzy.common.*;
import D_Java_OOP.Z_Exam.E01_FishingFrenzy.entity.fisherman.*;
import D_Java_OOP.Z_Exam.E01_FishingFrenzy.entity.fishing.*;
import D_Java_OOP.Z_Exam.E01_FishingFrenzy.entity.site.*;
import D_Java_OOP.Z_Exam.E01_FishingFrenzy.repository.*;

public class ControllerImpl implements Controller, Z_Exam.E01_FishingFrenzy.core.Controller {

    private Repository<Site> sites;
    private Fishing fishing;

    public ControllerImpl() {
        this.sites = new SiteRepository();
        this.fishing = new FishingImpl();
    }

    @Override
    public String addSite(String siteType, String siteName, int quota) {

        Site site = new SiteImpl(siteName, siteType, quota);

        if (site.getQuota() < 0) {
            throw new IllegalArgumentException(ExceptionMessages.SITE_QUOTA_CANNOT_BE_NEGATIVE);
        }

        if (sites.getCollection().stream().anyMatch(s -> s.getName().equals(siteName))) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_SITE);
        }

        sites.add(site);
        return String.format(ConstantMessages.SITE_ADDED, siteName, siteType);
    }

    @Override
    public String addFisherman(String siteName, String fishermanType, String fishermanName) {
        Fisherman fisherman = null;
        switch (fishermanType) {
            case "AmateurFisherman": fisherman = new AmateurFisherman(fishermanName);
                break;
            case "SkilledFisherman": fisherman = new SkilledFisherman(fishermanName);
                break;
            default: throw new IllegalArgumentException(ExceptionMessages.INVALID_FISHERMAN);
        }
        Site site = this.sites.getCollection().stream().filter(s -> s.getName().equals(siteName)).findFirst().orElse(null);
        if (site.getFishermen().stream().anyMatch(f -> f.getName().equals(fishermanName))) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_FISHERMAN, fishermanName));
        }
        site.getFishermen().add(fisherman);
        return String.format(ConstantMessages.FISHERMAN_ADDED, fishermanType, fishermanName);
    }

    @Override
    public String goFishing(String siteName) {
        Site site = this.sites.getCollection().stream().filter(s -> s.getName().equals(siteName)).findFirst().orElse(null);

        if (site == null) {
            throw new NullPointerException(String.format(ExceptionMessages.NON_EXISTING_SITE, siteName));
        }

        fishing.startFishing(site);

        if (site.getQuota() > 0) {
            return String.format(ConstantMessages.FISHING_SITE, site.getName(), site.getType(), site.getQuota());
        } else {
            return String.format(ConstantMessages.NO_MORE_FISH_ALLOWED, site.getName(), site.getType());
        }
    }

    @Override
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        for (Site site : this.sites.getCollection()) {
            output.append(String.format(ConstantMessages.FINAL_FISHING_SITE_INFO, site.getName(), site.getType())).append(System.lineSeparator());
            for (Fisherman fisherman : site.getFishermen()) {
                if (fisherman.getHarvest() > 0) {
                    output.append(String.format("Name: %s", fisherman.getName())).append(System.lineSeparator());
                    output.append(String.format("Bait left: %d", fisherman.getBait())).append(System.lineSeparator());
                    output.append(String.format("Caught fishes: %d", fisherman.getHarvest())).append(System.lineSeparator());
                }
            }
        }







        return output.toString().trim();
    }
}
