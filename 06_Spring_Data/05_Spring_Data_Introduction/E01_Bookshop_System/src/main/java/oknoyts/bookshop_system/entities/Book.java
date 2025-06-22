package oknoyts.bookshop_system.entities;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import oknoyts.bookshop_system.entities.enums.*;
import org.hibernate.annotations.*;

import java.math.*;
import java.util.*;

@Entity
@Table(name = "books")
public class Book extends BasicId{


    @Column(length = 50)
    private String title;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Category category;

    @Column(columnDefinition = "TEXT(1000)")
    private String description;

    @Column(name = "edition_type", nullable = true)
    private Enum<EditionType> editionType;

    @Basic
    private BigDecimal price;

    @Basic
    private int copies;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "age_restriction", nullable = false)
    private Enum<AgeRestrictionType> ageGroup;
}
