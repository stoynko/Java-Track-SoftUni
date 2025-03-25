package D_OOP.X_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.repositories;

import D_OOP.X_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.common.ExceptionMessages;
import D_OOP.X_ExamPreparations.ExamPrep_03.E01_ElectricCarCompetition.entities.destination.Destination;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DestinationRepository implements Repository<Destination>{

    private Collection<Destination> destinations;

    public DestinationRepository() {
        this.destinations = new ArrayList<>();
    }

    @Override
    public void add(Destination destination) {
        if (this.destinations.contains(destination)){
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_DESTINATION);
        }
        this.destinations.add(destination);
    }

    @Override
    public boolean remove(Destination destination) {
        return this.destinations.remove(destination);
    }

    @Override
    public Destination byName(String name) {
        return this.destinations.stream().filter(d -> d.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Destination> getCollection() {
        return Collections.unmodifiableCollection(this.destinations);
    }
}
