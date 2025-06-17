package Z_Exam.E01_FishingFrenzy.repository;

import D_Java_OOP.Z_Exam.E01_FishingFrenzy.entity.site.*;

import java.util.*;

public class SiteRepository implements Repository<Site> {

    private Collection<Site> sites;

    public SiteRepository() {
        this.sites = new ArrayList<>();
    }

    @Override
    public void add(Site entity) {
        this.sites.add(entity);
    }

    @Override
    public boolean remove(Site entity) {
        return this.sites.remove(entity);
    }

    @Override
    public Site byName(String name) {
        return this.sites.stream().filter(site -> site.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Site> getCollection() {
        return Collections.unmodifiableCollection(this.sites);
    }
}
