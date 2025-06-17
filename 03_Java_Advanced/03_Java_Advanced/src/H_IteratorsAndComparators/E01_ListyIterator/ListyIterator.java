package H_IteratorsAndComparators.E01_ListyIterator;

import java.util.ArrayList;
import java.util.List;

public class ListyIterator {

        private List<String> list;
        private int index;

        public ListyIterator(String... elements) {

            this.list = new ArrayList<>(List.of(elements));
            this.index = 0;
        }

        public boolean hasNext() {
            return this.index < list.size() - 1;
        }

        public boolean move() {

            if (hasNext()) {
                this.index++;
                return true;
            }
            return false;
        }

        public void print() {
            if (list.isEmpty()) {
                throw new IllegalStateException("Invalid Operation!");
            }
            System.out.println(list.get(index));
        }
}
