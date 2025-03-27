package D_OOP.X_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.repositories;

import D_OOP.X_ExamPreparations.ExamPrep_06.E01_HarpoonDiving.models.divingSite.*;

import java.util.*;

public class DivingSiteRepository implements Repository<DivingSite> {

    private Collection<DivingSite> sites;

    public DivingSiteRepository() {
        this.sites = new ArrayList<>();
    }

    @Override
    public void add(DivingSite entity) {
        this.sites.add(entity);
    }

    @Override
    public boolean remove(DivingSite entity) {
        return this.sites.remove(entity);
    }

    @Override
    public DivingSite byName(String name) {
        return this.sites.stream().filter(site -> site.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<DivingSite> getCollection() {
        return Collections.unmodifiableCollection(this.sites);
    }
}
