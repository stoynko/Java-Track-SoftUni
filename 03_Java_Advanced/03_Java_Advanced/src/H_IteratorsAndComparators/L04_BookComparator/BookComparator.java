package H_IteratorsAndComparators.L04_BookComparator;

import java.util.*;

public class BookComparator implements Comparator<Book> {


    @Override
    public int compare(Book bookA, Book bookB) {
        int result = bookA.getTitle().compareTo(bookB.getTitle());
        if (result == 0) {
            result = Integer.compare(bookA.getYear(), bookB.getYear());
        }
        return result;
    }
}
