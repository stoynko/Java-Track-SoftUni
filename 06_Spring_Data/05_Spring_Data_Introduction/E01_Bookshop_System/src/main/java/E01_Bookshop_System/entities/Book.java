package E01_Bookshop_System.entities;

import E01_Bookshop_System.entities.enums.*;
import jakarta.persistence.*;

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
    @JoinTable(
            name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),            // Book owns the relationship
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id")  // Category is the target
    )
    private Set<Category> category;

    @Column(columnDefinition = "TEXT(1000)")
    private String description;

    @Column(name = "edition_type", nullable = true)
    @Enumerated(value = EnumType.STRING)
    private EditionType editionType;

    @Basic
    private BigDecimal price;

    @Basic
    private int copies;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "age_restriction", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private AgeRestrictionType ageGroup;

    public Book() {
        this.category = new HashSet<>();
    }

    public Book(String title, Author author, Set<Category> categories, EditionType editionType, BigDecimal price, int copies, LocalDate releaseDate, AgeRestrictionType ageGroup) {
        this.title = title;
        this.author = author;
        this.category = categories;
        this.editionType = editionType;
        this.price = price;
        this.copies = copies;
        this.releaseDate = releaseDate;
        this.ageGroup = ageGroup;
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

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setAgeGroup(AgeRestrictionType ageGroup) {
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

    public EditionType getEditionType() {
        return editionType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getCopies() {
        return copies;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AgeRestrictionType getAgeGroup() {
        return ageGroup;
    }
}
