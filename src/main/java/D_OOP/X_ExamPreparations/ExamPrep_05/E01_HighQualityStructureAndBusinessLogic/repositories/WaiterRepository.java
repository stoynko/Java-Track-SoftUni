package D_OOP.X_ExamPreparations.ExamPrep_05.E01_HighQualityStructureAndBusinessLogic.repositories;
import D_OOP.X_ExamPreparations.ExamPrep_05.E01_HighQualityStructureAndBusinessLogic.models.waiter.*;
import java.util.*;

/*The WaiterRepository class is a repository for Waiters.
Data:
    •	waiters – a collection of Waiters
Behaviour:
    void add(Waiter waiter)
        •	Adds a Waiter to the collection.
        •	Every Waiter is unique in the collection.
            o	It is guaranteed that there will not be a waiter with the same name.
    boolean remove(Waiter waiter)
        •	Removes a Waiter from the collection. Returns true if the deletion was successful.
    Waiter byName(String name)
        •	Returns a Waiter with that name.
        •	If the Waiter is not in the collection, return null.
    Collection<Waiter> getCollection()
        •	Returns an unmodifiable collection of Waiters. */

public class WaiterRepository implements Repository<Waiter> {

    private List<Waiter> waiters;

    public WaiterRepository() {
        this.waiters = new ArrayList<>();
    }

    @Override
    public Collection<Waiter> getCollection() {
        return Collections.unmodifiableCollection(this.waiters);
    }

    @Override
    public void add(Waiter entity) {
        this.waiters.add(entity);
    }

    @Override
    public boolean remove(Waiter entity) {
        return this.waiters.remove(entity);
    }

    @Override
    public Waiter byName(String name) {
        return this.waiters.stream().filter(waiter -> waiter.getName().equals(name)).findFirst().orElse(null);
    }
}
