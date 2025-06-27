package E01_Bookshop.services;


import E01_Bookshop.entities.enums.*;

import java.io.*;
import java.math.*;
import java.time.*;

public interface BookService {

    boolean areBooksImported();
    void seedBooks() throws IOException;
    void printAllBooksAfter(LocalDate date);
    void printAllBooksBy(String firstName, String lastName);
    void printAllBooksForAgeGroup(AgeRestrictionType ageRestrictionType);
    void printAllBooksByEditionTypeAndCopies(EditionType editionType, int copies);
    void findByPriceLessThanOrPriceGreaterThan(BigDecimal lowerBound, BigDecimal upperBound);
}
