package C_Java_Advanced.H_IteratorsAndComparators.L01_Book;

import java.util.*;

public class Main {

/*Create a class Book from the UML diagram below:

Book:
- title: String
- year: int
- authors: List<String>
- setTitle(String)
- setYear(String)
- setAuthors(String…)
+ getTitle(): String
+ getYear(): int
+ getAuthors(): List<String>

You can use only one constructor. There can be no authors, one author, or many authors.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        List<Book> books = new ArrayList<>();

        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);
    }
}
