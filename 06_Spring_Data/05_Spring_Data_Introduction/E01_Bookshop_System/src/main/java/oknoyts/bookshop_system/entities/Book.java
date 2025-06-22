package oknoyts.bookshop_system.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.math.*;
import java.time.*;
import java.util.*;

@Entity
@Table(name = "books")
public class Book extends BaseId {

    @Column(length = 50)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @ManyToMany
    @JoinTable( name = "books_categories",
            joinColumns = @JoinColumn(name = "cateogry_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    private Set<Category> category;

    @Column(columnDefinition = "TEXT(1000)")
    private String description;

    @Column(name = "edition_type", nullable = true)
    @Enumerated(value = EnumType.STRING)
    private EnumType editionType;

    @Basic
    private BigDecimal price;

    @Basic
    private int copies;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "age_restriction", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private EnumType ageGroup;

    public Book() {
        this.category = new HashSet<>();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEditionType(EnumType editionType) {
        this.editionType = editionType;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setAgeGroup(EnumType ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public EnumType getEditionType() {
        return editionType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getCopies() {
        return copies;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public EnumType getAgeGroup() {
        return ageGroup;
    }
}
