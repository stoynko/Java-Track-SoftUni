package oknoyts.bookshop_system.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "categories")
public class Category extends BasicId{

    @Basic
    private String name;

    @ManyToMany()
    @JoinTable( name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cateogry_id", referencedColumnName = "id"))
    private List<Book> books;

    public Category() {
        this.books = new ArrayList<>();
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