package C_Java_Advanced.H_IteratorsAndComparators.L03_ComparableBook;

import java.util.*;

public class Book implements Comparable<Book>{

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        if (authors.length == 0) {
            this.authors = new ArrayList<>();
        } else {
            this.authors = new ArrayList<>(List.of(authors));
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public int compareTo(Book otherBook) {
        int result = this.getTitle().compareTo(otherBook.getTitle());
        if (result == 0) {
            result = Integer.compare(this.getYear(), otherBook.getYear());
        }
        return result;
    }

    @Override
    public String toString() {
        return this.getTitle().toString();
    }
}