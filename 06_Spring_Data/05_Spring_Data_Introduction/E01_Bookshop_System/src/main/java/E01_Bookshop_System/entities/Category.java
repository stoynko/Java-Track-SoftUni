package E01_Bookshop_System.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "categories")
public class Category extends BaseId {

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "category", targetEntity = Book.class)
    private List<Book> books;

    public Category() {
        this.books = new ArrayList<>();
    }

    public Category(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }
}