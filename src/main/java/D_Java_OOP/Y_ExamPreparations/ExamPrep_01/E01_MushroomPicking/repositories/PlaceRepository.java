package D_Java_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.repositories;

import D_Java_OOP.Y_ExamPreparations.ExamPrep_01.E01_MushroomPicking.entities.places.Place;

import java.util.Collection;
import java.util.Collections;

public class PlaceRepository implements Repository<Place> {

    private Collection<Place> places;

    @Override
    public Collection<Place> getCollection() {
        return Collections.unmodifiableCollection(this.places);
    }

    @Override
    public void add(Place entity) {
        this.places.add(entity);
    }

    @Override
    public boolean remove(Place entity) {
        return this.places.remove(entity);
    }

    @Override
    public Place byName(String name) {
        return this.places.stream().filter(place -> place.getName().equals(name)).findFirst().orElse(null);
    }
}
