package D_InterfacesAndAbstraction.E07_CollectionHierarchy;

import java.util.*;

public abstract class Collection {
    private int maxSize;
    protected List<String> items;

    public Collection() {
        this.maxSize = 100;
        this.items = new ArrayList<>();
    }
}
