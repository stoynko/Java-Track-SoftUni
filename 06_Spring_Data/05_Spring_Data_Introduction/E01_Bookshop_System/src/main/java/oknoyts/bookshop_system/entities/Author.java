package oknoyts.bookshop_system.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "authors")
public class Author extends BasicId {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "author", targetEntity = Book.class)
    private List<Book> publishedBooks;

    public Author() {
        this.publishedBooks = new ArrayList<>();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPublishedBooks(List<Book> publishedBooks) {
        this.publishedBooks = publishedBooks;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Book> getPublishedBooks() {
        return publishedBooks;
    }
}
