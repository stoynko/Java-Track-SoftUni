package D_OOP.D_InterfacesAndAbstraction.E07_CollectionHierarchy;

public class MyListImpl extends Collection implements MyList {

    @Override
    public int getUsed() {
        return super.items.size();
    }

    @Override
    public String remove() {
        if (!super.items.isEmpty()) {
            return super.items.remove(0);
        }
        return null;
    }

    @Override
    public int add(String element) {
        super.items.add(0, element);
        return 0;
    }
}
