package E01_Bookshop.services;


import E01_Bookshop.entities.enums.*;
import E01_Bookshop.entities.interfaces.*;

import java.io.*;
import java.math.*;
import java.time.*;
import java.util.*;

public interface BookService {

    boolean areBooksImported();
    void seedBooks() throws IOException;
    void printAllBooksAfter(LocalDate date);
    void printAllBooksBy(String firstName, String lastName);
    void printAllBooksForAgeGroup(AgeRestrictionType ageRestrictionType);
    void printAllBooksByEditionTypeAndCopies(EditionType editionType, int copies);
    void findByPriceLessThanOrPriceGreaterThan(BigDecimal lowerBound, BigDecimal upperBound);
    void findByReleaseYearNotEqualTo(int inputYear);
    void findByReleaseDateNotIn(int inputYear);
    void findByReleaseDateBefore(int inputDay, int inputMonth, int inputYear);
    void findByTitleContaining(String param);
    void findByAuthorLastNameStartingWith(String param);
    int countByBookTitleLongerThan(int charCount);
    int countByBookTitleLengthLongerThan(int charCount);
    void printBookInfo(String title);
    void updateBookCopiesWithAmount(String date, long copiesCount);
}