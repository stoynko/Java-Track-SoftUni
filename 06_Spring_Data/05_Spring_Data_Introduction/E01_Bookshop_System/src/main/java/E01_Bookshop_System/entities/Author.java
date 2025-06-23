package E01_Bookshop_System.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "authors")
public class Author extends BaseId {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "author", targetEntity = Book.class)
    private Set<Book> publishedBooks;

    public Author() {
        this.publishedBooks = new HashSet<>();
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPublishedBooks(Set<Book> publishedBooks) {
        this.publishedBooks = publishedBooks;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Book> getPublishedBooks() {
        return publishedBooks;
    }
}
