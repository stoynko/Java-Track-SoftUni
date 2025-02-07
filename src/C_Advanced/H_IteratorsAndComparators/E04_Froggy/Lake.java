package C_Advanced.H_IteratorsAndComparators.E04_Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {

    private List<Integer> lake;

    public Lake(Integer... elements) {
        this.lake = List.of(elements);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Froggy();
    }

    class Froggy implements Iterator<Integer> {

        boolean evenPrinted = false;
        private int index;

        @Override
        public boolean hasNext() {
            return index < lake.size();
        }

        @Override
        public Integer next() {

            int element = lake.get(index);
            index += 2;

            if (index >= lake.size() && !evenPrinted) {
                index = 1;
                evenPrinted = true;
            }
            return element;

        }
    }
}
